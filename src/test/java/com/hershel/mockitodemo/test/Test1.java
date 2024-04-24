package com.hershel.mockitodemo.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class Test1 {

    @Test
    public void test1() {
        //通过 Mockito 类的静态方法 mock 来创建 Mock 对象
        List<String> mockList = Mockito.mock(ArrayList.class);
    }

    @Test
    public void test2() {
        List<String> mockList = mock(ArrayList.class);
    }


}
