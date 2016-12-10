package com.activiti.service;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ClassName: WorkFlowService
 * Description:
 * Date: 2016/7/18 21:21
 *
 * @author SAM SHO
 * @version V1.0
 */
public interface WorkFlowService {

    void deployed(String processName, MultipartFile file) throws IOException;

    List<ProcessDefinition> getProcessDefines();

    InputStream view(String deploymentId, String resourceName);

    ProcessInstance startProcess(String pdKey, int id, String userName);
}
