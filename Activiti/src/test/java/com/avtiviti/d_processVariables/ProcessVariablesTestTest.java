package com.avtiviti.d_processVariables;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: ProcessVariablesTestTest
 * Description:
 * Date: 2016/7/14 17:03
 *
 * @author SAM SHO
 * @version V1.0
 */
public class ProcessVariablesTestTest {

    ProcessVariablesTest processVariablesTest;

    @Before
    public void setUp() throws Exception {
        processVariablesTest = new ProcessVariablesTest();
    }

    @Test
    public void testDeploymentProcessDefinition_inputStream() throws Exception {
        processVariablesTest.deploymentProcessDefinition_inputStream();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        processVariablesTest.startProcessInstance();
    }

    @Test
    public void testSetVariables() throws Exception {
        processVariablesTest.setVariables();
    }

    @Test
    public void testGetVariables() throws Exception {
        processVariablesTest.getVariables();
    }

    @Test
    public void testSetAndGetVariables() throws Exception {
        processVariablesTest.setAndGetVariables();
    }

    @Test
    public void testCompleteMyPersonalTask() throws Exception {
        processVariablesTest.completeMyPersonalTask();
    }

    @Test
    public void testFindHistoryProcessVariables() throws Exception {
        processVariablesTest.findHistoryProcessVariables();
    }
}