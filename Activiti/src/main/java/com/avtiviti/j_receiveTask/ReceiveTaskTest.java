package com.avtiviti.j_receiveTask;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;

import java.io.InputStream;
import java.util.List;

/**
 * ClassName: ReceiveTaskTestTest
 * Description: 接收活动任务
 * Date: 2016/7/16 9:57
 *
 * @author SAM SHO
 * @version V1.0
 */
public class ReceiveTaskTest {

    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 部署流程定义（从inputStream）
     */
    public void deploymentProcessDefinition_inputStream() {
        InputStream inputStreamBpmn = this.getClass().getClassLoader().getResourceAsStream("docs/bpmn/receiveTask.bpmn");
        InputStream inputStreamPng = this.getClass().getClassLoader().getResourceAsStream("docs/bpmn/receiveTask.png");
        Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                .createDeployment()//创建一个部署对象
                .name("接收活动任务")//添加部署的名称
                .addInputStream("receiveTask.bpmn", inputStreamBpmn)//
                .addInputStream("receiveTask.png", inputStreamPng)//
                .deploy();//完成部署
        System.out.println("部署ID：" + deployment.getId());//77501
        System.out.println("部署名称：" + deployment.getName());//接收活动任务
    }

    /**
     * 启动流程实例
     */
    public void startProcess() {
        String processDefinitionKey = "receiveTask";
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
        System.out.println(processInstance);//80001
    }

    /**
     * 查询 ProcessInstance
     */
    public void queryProcess() {
        String deploymentId = "77501";
        String processInstanceId = "80001";
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()// act_ru_execution
//                .deploymentId(deploymentId)
                .processInstanceId(processInstanceId)
                .singleResult();
        System.out.println(processInstance);

    }

    /**
     * 查询 Execution
     * Execution <= ProcessInstance
     * act_ru_execution表中Execution只有一条数据，但是 ProcessInstance 有>=1条数据(并行网关)
     */
    public void queryExecution() {
        String executionId = "80001";
        String processInstanceId = "80001";
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Execution execution = runtimeService.createExecutionQuery()
                .executionId(executionId)
//                .processInstanceId(processInstanceId)
                .singleResult();
        System.out.println(execution);

    }


    /**
     * 启动流程实例+设置流程变量+获取流程变量+向后执行一步
     * 向后执行一步，task表没有数据，执行对象不会结束
     * 向后推移，不需要手动执行，机器自动执行
     */
    public void startProcessInstance() {
        //流程定义的key
        String processDefinitionKey = "receiveTask";
        ProcessInstance pi = processEngine.getRuntimeService()//与正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
        System.out.println("流程实例ID:" + pi.getId());//流程实例ID    101
        System.out.println("流程定义ID:" + pi.getProcessDefinitionId());//流程定义ID   helloworld:1:4

        /**查询执行对象ID 执行对象 <= 流程对象*/
        Execution execution1 = processEngine.getRuntimeService()//
                .createExecutionQuery()//创建执行对象查询
                .processInstanceId(pi.getId())//使用流程实例ID查询
                .activityId("receivetask1")//当前活动的id，对应receiveTask.bpmn文件中的活动节点id的属性值
                .singleResult();

        /**使用流程变量设置当日销售额，用来传递业务参数*/
        processEngine.getRuntimeService()//
                .setVariable(execution1.getId(), "汇总当日销售额", 21000);

        /**向后执行一步，如果流程处于等待状态，使得流程继续执行*/
        processEngine.getRuntimeService()
                .signal(execution1.getId());

        /**查询执行对象ID*/
        Execution execution2 = processEngine.getRuntimeService()//
                .createExecutionQuery()//创建执行对象查询
                .processInstanceId(pi.getId())//使用流程实例ID查询
                .activityId("receivetask2")//当前活动的id，对应receiveTask.bpmn文件中的活动节点id的属性值
                .singleResult();

        /**从流程变量中获取汇总当日销售额的值*/
        Integer value = (Integer) processEngine.getRuntimeService()//
                .getVariable(execution2.getId(), "汇总当日销售额");
        System.out.println("给老板发送短信：金额是：" + value);

        /**向后执行一步，如果流程处于等待状态，使得流程继续执行*/
        processEngine.getRuntimeService()
                .signal(execution2.getId());

    }

    /**
     * 清除数据
     */
    public void deleteProcess() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        for (Deployment deployment : list) {
            repositoryService.deleteDeployment(deployment.getId(), true);
        }
    }
}
