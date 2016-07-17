package com.avtiviti.g_exclusiveGateWay;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: ExclusiveGateWayTestTest
 * Description:
 * Date: 2016/7/15 16:01
 *
 * @author SAM SHO
 * @version V1.0
 */
public class ExclusiveGateWayTestTest {
    ExclusiveGateWayTest exclusiveGateWayTest ;
    @Before
    public void setUp() throws Exception {
        exclusiveGateWayTest = new ExclusiveGateWayTest();
    }

    @Test
    public void testDeploymentProcessDefinition_inputStream() throws Exception {
        exclusiveGateWayTest.deploymentProcessDefinition_inputStream();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        exclusiveGateWayTest.startProcessInstance();
    }

    @Test
    public void testFindMyPersonalTask() throws Exception {
        exclusiveGateWayTest.findMyPersonalTask();
    }

    @Test
    public void testCompleteMyPersonalTask() throws Exception {
        exclusiveGateWayTest.completeMyPersonalTask();
    }
}