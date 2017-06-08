package com.hmt.analytics.unittestdemo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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

    /**
     * mockito 测试是否调用
     */
    @Test
    public void testWhen() {
//        LoginPresent loginPresent = mock(LoginPresent.class);
        LoginPresent loginPresent = new LoginPresent();
        VerifyPsw verifyPsw = mock(VerifyPsw.class);
        loginPresent.setVerifyPsw(verifyPsw);
        loginPresent.login("1", "0");
        when(verifyPsw.verifyValid(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(true);
//        verify(loginPresent).login("1", "0");
        verify(verifyPsw).verifyValid("1", "0");
    }


}