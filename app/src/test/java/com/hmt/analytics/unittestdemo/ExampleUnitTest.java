package com.hmt.analytics.unittestdemo;

import com.hmt.analytics.common.CommonUtil;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMock() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        Mockito.verify(mockedList).add("one");
//        Mockito.verify(mockedList).add("two");
        Mockito.verify(mockedList).clear();
    }

    @Test
    public void testMock2() {
        ArrayList mockedList = mock(ArrayList.class);
        Mockito.when(mockedList.get(0)).thenReturn("1");
        String str = (String) mockedList.get(0);
        Mockito.verify(mockedList).get(0);
    }

    @Test
    public void commonUtilsTest() {
        CommonUtil commonUtil = Mockito.mock(CommonUtil.class);

    }
}