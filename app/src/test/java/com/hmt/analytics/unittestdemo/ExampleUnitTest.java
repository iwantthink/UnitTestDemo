package com.hmt.analytics.unittestdemo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
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
    public void testMock() {
        List mockedList = mock(List.class);
        mockedList.add("one");
//        mockedList.add("one");
        mockedList.clear();
        verify(mockedList, times(2)).add("one");//验证调用次数
        verify(mockedList, atLeast(1)).add("one");//最小
        verify(mockedList, atMost(2)).add("one");//最多
        verify(mockedList, never()).add("two");//从不
        verify(mockedList).add(Mockito.anyString());//表示任意参数 调用一次就行
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