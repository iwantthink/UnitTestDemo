package com.hmt.analytics.unittestdemo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Calculator mCalculator;

    /**
     * 如果一个方法被before 修饰过了，
     * 那么在每个测试方法调用之前，
     * 这个方法都会得到调用
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * expected 需要手动抛出一个exception , 自动抛出的也会报错
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDivide() {
        mCalculator.divide(1, 0);
    }


    @Test
    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
        assertEquals("wrong number", 4, 2 + 2);
    }

    @Test
    public void testMock() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
//       verify(mockedList).add("two");
        verify(mockedList).clear();
    }

    @Test
    @Ignore("not implemented yet")
    public void testMock2() {
        ArrayList mockedList = mock(ArrayList.class);
        when(mockedList.get(0)).thenReturn("1");
        String str = (String) mockedList.get(0);
        verify(mockedList).get(0);
    }


}