package com.avtiviti.b_processDefinition;

import org.junit.Before;
import org.junit.Test;

/**
 * ClassName: ProcessDefinitionTest
 * Description:
 * Date: 2016/7/14 8:18
 *
 * @author SAM SHO
 * @version V1.0
 */
public class ProcessDefinitionTest {
    ProcessDefinition processDefinition;

    @Before
    public void setUp() throws Exception {
        processDefinition = new ProcessDefinition();
    }

    @Test
    public void testDeploymentProcessDefinition_classpath() throws Exception {
        processDefinition.deploymentProcessDefinition_classpath();
    }

    @Test
    public void testDeploymentProcessDefinition_zip() throws Exception {
        processDefinition.deploymentProcessDefinition_zip();
    }

    @Test
    public void testFindProcessDefinition() throws Exception {
        processDefinition.findProcessDefinition();
    }

    @Test
    public void testDeleteProcessDefinition() throws Exception {
        processDefinition.deleteProcessDefinition();
    }

    @Test
    public void testViewPic() throws Exception {
        processDefinition.viewPic();
    }

    @Test
    public void testFindLastVersionProcessDefinition() throws Exception {
        processDefinition.findLastVersionProcessDefinition();
    }

    @Test
    public void testDeleteProcessDefinitionByKey() throws Exception {
        processDefinition.deleteProcessDefinitionByKey();
    }
}