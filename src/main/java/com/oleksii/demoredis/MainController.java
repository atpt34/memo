package com.oleksii.demoredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    StringRedisTemplate redisTemplate;
//    RedisTemplate<String, String> redisTemplate;

    @GetMapping("/{key}")
    public @ResponseBody String get(@PathVariable String key) {
        System.out.println(key);
        return redisTemplate.opsForValue().get(key);
    }

    @PostMapping("/{key}/{value}")
    public @ResponseBody String set(@PathVariable String key, @PathVariable String value) {
        System.out.println(key);
        return redisTemplate.opsForValue().getAndSet(key, value);
    }


    @PutMapping("/{message}")
    public @ResponseBody String publish(@PathVariable String message) {
        System.out.println(message);
        redisTemplate.convertAndSend("topic", message);
        return message;
    }
}
