package com.avtiviti.h_parallelGateWay;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: ParallelGateWayTestTest
 * Description:
 * Date: 2016/7/16 9:02
 *
 * @author SAM SHO
 * @version V1.0
 */
public class ParallelGateWayTestTest {
    ParallelGateWayTest parallelGateWayTest;
    @Before
    public void setUp() throws Exception {
        parallelGateWayTest = new ParallelGateWayTest();
    }

    @Test
    public void testDeploymentProcessDefinition_inputStream() throws Exception {
        parallelGateWayTest.deploymentProcessDefinition_inputStream();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        parallelGateWayTest.startProcessInstance();
    }

    @Test
    public void testFindMyPersonalTask() throws Exception {
        parallelGateWayTest.findMyPersonalTask();
    }

    @Test
    public void testCompleteMyPersonalTask() throws Exception {
        parallelGateWayTest.completeMyPersonalTask();
    }
}