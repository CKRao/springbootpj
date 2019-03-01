package com.clark.springpj;

import com.clark.springpj.mq.SenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringPjApplicationTests {
    @Autowired
    public SenderService senderService;

    @Test
    public void send() {
        for (int i = 0; i < 6; i++) {
            senderService.send();
        }
    }


    @Test
    public void contextLoads() {
    }

}
