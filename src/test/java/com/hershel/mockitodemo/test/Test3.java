package com.hershel.mockitodemo.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class Test3 {

    @Mock
    private List<String> mockList;

    @Mock
    private Map<String, Integer> mockMap;

    @Test
    public void test1() {
        mockList.size();
        //验证 mockList 对象的 size 方法被调用一次。
        verify(mockList).size();
    }

    @Test
    public void test2() {
        mockList.size();
        mockList.size();
        //是否调用两次
        verify(mockList, times(2)).size();
        //最少一次
        verify(mockList, atLeast(1)).size();
        //最多十次
        verify(mockList, atMost(10)).size();
    }

    @Test
    public void test3() {
        //是否没调用
        verify(mockList, never()).size();
    }

    @Test
    public void test4() {
        mockList.size();
        //最少一次
        verify(mockList, atLeastOnce()).size();
        //最多一次
        verify(mockList, atMostOnce()).size();
    }

    /**
     * 测试调用顺序
     */
    @Test
    public void test5() {
        mockList.size();
        mockList.add("add a parameter");
        mockList.clear();

        InOrder inOrder = inOrder(mockList);
        inOrder.verify(mockList).size();
        inOrder.verify(mockList).add("add a parameter");
        inOrder.verify(mockList).clear();

    }

    /**
     * 验证方法异常
     */
    @Test
    public void test6() {
        when(mockMap.get(anyString())).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> mockMap.get("hershel"));
    }

    @Test
    public void test7() {
        //指定返回结果
        when(mockMap.get(anyString())).thenReturn(21);
    }

    @Test
    public void test8() {
        mockList.add("add a parametere");
        //mock对象测试实际并不会影响到对象到内部状态。
        assertEquals(0, mockList.size());
    }


}
