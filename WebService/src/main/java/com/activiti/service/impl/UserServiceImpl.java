package com.activiti.service.impl;

import com.activiti.dao.BaseDao;
import com.activiti.entity.ActUser;
import com.activiti.service.UserService;
import com.google.common.collect.Lists;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: LeaveBillServiceImpl
 * Description:
 * Date: 2016/7/18 21:17
 *
 * @author SAM SHO
 * @version V1.0
 */
@Service(value = "userService")
public class UserServiceImpl extends AbstractServiceImpl<ActUser> implements UserService {
    @Resource
    private BaseDao<ActUser> baseDao;

    @Override
    public BaseDao<ActUser> getDAO() {
        return baseDao;
    }

    /**
     * 验证用户是否存在
     *
     * @param username
     * @param password
     * @return
     */
    public ActUser isExist(String username, String password) {
        List<Criterion> conditions = Lists.newArrayList();
        conditions.add(Restrictions.eq("username", username));
        conditions.add(Restrictions.eq("password", password));
        List<ActUser> users = this.getList(-1, -1, conditions, null);
        return users.isEmpty() ? null : users.get(0);
    }
}
