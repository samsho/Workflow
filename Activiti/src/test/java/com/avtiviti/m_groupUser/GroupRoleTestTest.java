package com.avtiviti.m_groupUser;

import org.junit.Before;
import org.junit.Test;

/**
 * ClassName: GroupRoleTestTest
 * Description:
 * Date: 2016/7/18 9:34
 *
 * @author SAM SHO
 * @version V1.0
 */
public class GroupRoleTestTest {

    GroupRoleTest groupRoleTest;

    @Before
    public void setUp() throws Exception {
        groupRoleTest = new GroupRoleTest();
    }

    @Test
    public void testDeploymentProcessDefinition_inputStream() throws Exception {
        groupRoleTest.deploymentProcessDefinition_inputStream();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        groupRoleTest.startProcessInstance();
    }

    @Test
    public void testFindMyPersonalTask() throws Exception {
        groupRoleTest.findMyPersonalTask();
    }

    @Test
    public void testFindMyGroupTask() throws Exception {
        groupRoleTest.findMyGroupTask();
    }

    @Test
    public void testCompleteMyPersonalTask() throws Exception {
        groupRoleTest.completeMyPersonalTask();
    }

    @Test
    public void testFindRunPersonTask() throws Exception {
        groupRoleTest.findRunPersonTask();
    }

    @Test
    public void testFindHistoryPersonTask() throws Exception {
        groupRoleTest.findHistoryPersonTask();
    }

    @Test
    public void testClaim() throws Exception {
        groupRoleTest.claim();
    }

    @Test
    public void testSetAssigee() throws Exception {
        groupRoleTest.setAssigee();
    }

    @Test
    public void testDelete() throws Exception {
        groupRoleTest.delete();
    }
}