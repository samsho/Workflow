package com.activiti.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

/**
 * 员工经理任务分配
 */
@SuppressWarnings("serial")
@Component
public class ManagerTaskHandler implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        //设置个人任务的办理人
        delegateTask.setAssignee("范冰冰经理人");

    }

}
