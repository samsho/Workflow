package com.avtiviti.k_personalTask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: PersonalTaskTest
 * Description:
 * Date: 2016/7/17 9:19
 *
 * @author SAM SHO
 * @version V1.0
 */
public class PersonalTaskTest {
    PersonalTask personalTask;

    @Before
    public void setUp() throws Exception {
        personalTask = new PersonalTask();
    }

    @Test
    public void testDeploymentProcessDefinition_inputStream() throws Exception {
        personalTask.deploymentProcessDefinition_inputStream();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        personalTask.startProcessInstance();
    }

    @Test
    public void testFindMyPersonalTask() throws Exception {
        personalTask.findMyPersonalTask();
    }

    @Test
    public void testCompleteMyPersonalTask() throws Exception {
        personalTask.completeMyPersonalTask();
    }
}