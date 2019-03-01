package com.clark.springpj.controller;

import com.clark.springpj.mq.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ClarkRao
 * @date 2019/2/28 15:26
 * @description:
 */
@RestController
public class IndexController {

    @Autowired
    private SenderService senderService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @GetMapping("/send/{message}")
    public String index(@PathVariable String message) {
        senderService.sendMessage(message);
        return "success";
    }

    @GetMapping("/redis/{message}")
    public String redis(@PathVariable String message) {
       redisTemplate.opsForValue().set("clark",message);
        return "success";
    }

    @GetMapping("/redis/get")
    public String redisget() {
        Object ryt =  redisTemplate.opsForValue().get("ryt");
        return ryt.toString();
    }
}
