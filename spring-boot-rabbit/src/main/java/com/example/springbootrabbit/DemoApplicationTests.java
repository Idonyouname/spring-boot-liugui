package com.example.springbootrabbit;

import com.example.springbootrabbit.simple.SimpleSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: DemoApplicationTests
 * @Author: liugui
 * @Date: 2019-11-07 19:32
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    SimpleSend simpleSend;

    @Autowired
    SimpleSend simpleSend1;

    @Test
    public void simpleSend() {
        simpleSend.massSend();
        simpleSend1.massSend();
    }
}
