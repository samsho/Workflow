package com.avtiviti.a;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: HelloWorldTest
 * Description:
 * Date: 2016/7/13 18:47
 *
 * @author SAM SHO
 * @version V1.0
 */
public class HelloWorldTest {

    HelloWorld helloWorld;
    @Before
    public void setUp() throws Exception {
        helloWorld = new HelloWorld();
    }
    @Test
    public void testDeploymentProcessDefinition() throws Exception {
        helloWorld.deploymentProcessDefinition();
    }

    @Test
    public void testStartProcessInstance() throws Exception {
        helloWorld.startProcessInstance();
    }

    @Test
    public void testFindMyPersonalTask() throws Exception {
        helloWorld.findMyPersonalTask();
    }

    @Test
    public void testCompleteMyPersonalTask() throws Exception {
        helloWorld.completeMyPersonalTask();
    }

}