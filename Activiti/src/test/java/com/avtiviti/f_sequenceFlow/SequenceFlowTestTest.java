package com.avtiviti.f_sequenceFlow;

import org.junit.Before;
import org.junit.Test;

/**
 * ClassName: SequenceFlowTestTest
 * Description:
 * Date: 2016/7/15 14:38
 *
 * @author SAM SHO
 * @version V1.0
 */
public class SequenceFlowTestTest {
    SequenceFlowTest sequenceFlowTest;

    @Before
    public void setUp() throws Exception {
        sequenceFlowTest = new SequenceFlowTest();
    }

    @Test
    public void testDeploymentProcessDefinition_inputStream() throws Exception {
        sequenceFlowTest.deploymentProcessDefinition_inputStream();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        sequenceFlowTest.startProcessInstance();
    }

    @Test
    public void testFindMyPersonalTask() throws Exception {
        sequenceFlowTest.findMyPersonalTask();
    }

    @Test
    public void testCompleteMyPersonalTask() throws Exception {
        sequenceFlowTest.completeMyPersonalTask();
    }
}