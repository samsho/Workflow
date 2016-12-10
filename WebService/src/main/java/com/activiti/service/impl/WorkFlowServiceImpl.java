package com.activiti.service.impl;

import com.activiti.service.WorkFlowService;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * ClassName: WorkFlowServiceImpl
 * Description:
 * Date: 2016/7/18 21:21
 *
 * @author SAM SHO
 * @version V1.0
 */
@Service(value = "workFlowService")
@Transactional(rollbackFor = Exception.class)
public class WorkFlowServiceImpl implements WorkFlowService {

    @Resource
    private RepositoryService repositoryService;
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private FormService formService;
    @Resource
    private TaskService taskService;
    @Resource
    private HistoryService historyService;

    @Override
    public void deployed(String processName, MultipartFile file) throws IOException {
        repositoryService.createDeployment()
                .name(processName)
                .addZipInputStream(new ZipInputStream(file.getInputStream(), Charsets.UTF_8))
                .deploy();
    }

    @Override
    public List<ProcessDefinition> getProcessDefines() {
        return repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion()
                .desc()
                .list();
    }

    @Override
    public InputStream view(String deploymentId, String resourceName) {
        return repositoryService.getResourceAsStream(deploymentId, resourceName);
    }

    @Override
    public ProcessInstance startProcess(String pdKey, int id, String userName) {
        Map<String, Object> variables = Maps.newHashMap();
        variables.put("inputUser", userName);
        return runtimeService.startProcessInstanceByKey(pdKey, pdKey + "." + id, variables);
    }


}
