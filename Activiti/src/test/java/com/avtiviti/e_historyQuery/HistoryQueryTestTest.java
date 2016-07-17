package com.avtiviti.e_historyQuery;

import org.junit.Before;
import org.junit.Test;

/**
 * ClassName: HistoryQueryTestTest
 * Description:
 * Date: 2016/7/15 14:04
 *
 * @author SAM SHO
 * @version V1.0
 */
public class HistoryQueryTestTest {
    HistoryQueryTest historyQueryTest;

    @Before
    public void setUp() throws Exception {
        historyQueryTest = new HistoryQueryTest();
    }

    @Test
    public void testFindHistoryProcessInstance() throws Exception {
        historyQueryTest.findHistoryProcessInstance();
    }

    @Test
    public void testFindHistoryActiviti() throws Exception {
        historyQueryTest.findHistoryActiviti();
    }

    @Test
    public void testFindHistoryTask() throws Exception {
        historyQueryTest.findHistoryTask();
    }

    @Test
    public void testFindHistoryProcessVariables() throws Exception {
        historyQueryTest.findHistoryProcessVariables();
    }
}