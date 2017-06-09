package com.hmt.analytics.unittestdemo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
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
    public void testVerify() {
        VerifyPsw psw = new VerifyPsw();
        assertTrue(psw.verifyValid("1", "1"));
        assertFalse(psw.verifyValid("11", "1"));
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
     * mock 不会走实际的逻辑 只会返回默认值
     */
    @Test
    public void testWhen() {
//        LoginPresent loginPresent = mock(LoginPresent.class);
        LoginPresent loginPresent = new LoginPresent();
        VerifyPsw verifyPsw = mock(VerifyPsw.class);
        log("true === " + verifyPsw.verifyValid("1", "1"));
        log("false === " + verifyPsw.verifyValid("1", "11"));
        loginPresent.setVerifyPsw(verifyPsw);
        loginPresent.login("1", "0");

        when(verifyPsw.verifyValid(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(true);

//        verify(loginPresent).login("1", "0");

//        boolean result = doCallRealMethod().when(verifyPsw).verifyValid("1", "1");
//       when(verifyPsw.verifyValid("0", "1")).thenCallRealMethod();

    }

    /**
     * spy 会走实际的逻辑
     */
    @Test
    public void testSpy() {
        VerifyPsw verifyPsw = spy(VerifyPsw.class);
        log("true === " + verifyPsw.verifyValid("1", "1"));
        log("false === " + verifyPsw.verifyValid("1", "11"));


//        doReturn(true).when(verifyPsw).verifyValid("2", "1");
    }

    public void log(String text) {
        System.out.println("text = " + text);
    }

}