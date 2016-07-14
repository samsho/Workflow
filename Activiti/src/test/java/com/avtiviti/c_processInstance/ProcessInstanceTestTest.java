package com.avtiviti.c_processInstance;

import org.junit.Before;
import org.junit.Test;

/**
 * ClassName: ProcessInstanceTestTest
 * Description:
 * Date: 2016/7/14 14:35
 *
 * @author SAM SHO
 * @version V1.0
 */
public class ProcessInstanceTestTest {

    ProcessInstanceTest processInstanceTest;
    @Before
    public void setUp() throws Exception {
        processInstanceTest = new ProcessInstanceTest();
    }

    @Test
    public void testDeploymentProcessDefinition_zip() throws Exception {
        processInstanceTest.deploymentProcessDefinition_zip();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        processInstanceTest.startProcessInstance();
    }

    @Test
    public void testFindMyPersonalTask() throws Exception {
        processInstanceTest.findMyPersonalTask();
    }

    @Test
    public void testCompleteMyPersonalTask() throws Exception {
        processInstanceTest.completeMyPersonalTask();
    }

    @Test
    public void testIsProcessEnd() throws Exception {
        processInstanceTest.isProcessEnd();
    }

    @Test
    public void testFindHistoryTask() throws Exception {
        processInstanceTest.findHistoryTask();
    }

    @Test
    public void testFindHistoryProcessInstance() throws Exception {
        processInstanceTest.findHistoryProcessInstance();
    }
}