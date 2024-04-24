package com.hershel.mockitodemo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

@SpringBootTest
public class Test4 {

    //使用spy会影响对象内部状态
    private List<String> mockList = spy(ArrayList.class);

    @Test
    public void test1() {
        mockList.add("add a parameter");
        assertEquals(1, mockList.size());
    }


}
