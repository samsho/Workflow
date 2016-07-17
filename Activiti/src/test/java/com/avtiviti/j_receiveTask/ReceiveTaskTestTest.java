package com.avtiviti.j_receiveTask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: ReceiveTaskTestTest
 * Description: 接收活动任务
 * Date: 2016/7/16 9:57
 *
 * @author SAM SHO
 * @version V1.0
 */
public class ReceiveTaskTestTest {
    ReceiveTaskTest receiveTaskTest;
    @Before
    public void setUp() throws Exception {
        receiveTaskTest = new ReceiveTaskTest();
    }

    @Test
    public void testDeploymentProcessDefinition_inputStream() throws Exception {
        receiveTaskTest.deploymentProcessDefinition_inputStream();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        receiveTaskTest.startProcessInstance();
    }

    @Test
    public void testStartProcess() throws Exception {
        receiveTaskTest.startProcess();
    }

    @Test
    public void testQueryProcess() throws Exception {
        receiveTaskTest.queryProcess();
    }

    @Test
    public void testQueryExecution() throws Exception {
        receiveTaskTest.queryExecution();
    }

    @Test
    public void testDeleteProcess() throws Exception {
        receiveTaskTest.deleteProcess();
    }
}