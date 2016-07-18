package com.activiti.service.impl;

import com.activiti.dao.BaseDao;
import com.activiti.entity.LogEntity;
import com.activiti.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: LogServiceImpl
 * Description:
 * Date: 2016/5/13 23:12
 *
 * @author SAM SHO
 * @version V1.0
 */
@Service(value = "logService")
public class LogServiceImpl extends AbstractServiceImpl<LogEntity> implements LogService {


    @Resource
    private BaseDao<LogEntity> baseDao;

    @Override
    public BaseDao<LogEntity> getDAO() {
        return baseDao;
    }
}
