package com.avtiviti.k_personalTask02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: PersonalTask2Test
 * Description:
 * Date: 2016/7/17 15:37
 *
 * @author SAM SHO
 * @version V1.0
 */
public class PersonalTask2Test {

    PersonalTask2 personalTask2;

    @Before
    public void setUp() throws Exception {
        personalTask2 = new PersonalTask2();
    }

    @Test
    public void testDeploymentProcessDefinition_inputStream() throws Exception {
        personalTask2.deploymentProcessDefinition_inputStream();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        personalTask2.startProcessInstance();
    }

    @Test
    public void testFindMyPersonalTask() throws Exception {
        personalTask2.findMyPersonalTask();
    }

    @Test
    public void testCompleteMyPersonalTask() throws Exception {
        personalTask2.completeMyPersonalTask();
    }

    @Test
    public void testSetAssigneeTask() throws Exception {
        personalTask2.setAssigneeTask();
    }
}