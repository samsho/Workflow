package com.activiti.service;


import com.activiti.entity.ActUser;

/**
 * ClassName: LogService
 * Description:
 * Date: 2016/5/13 23:11
 *
 * @author SAM SHO
 * @version V1.0
 */
public interface UserService extends BaseService<ActUser> {

    ActUser isExist(String username, String password);
}
