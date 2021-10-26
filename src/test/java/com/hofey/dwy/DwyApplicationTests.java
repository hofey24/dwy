package com.hofey.dwy;

import com.hofey.dwy.demo.plugins.mapstruct.MapStructRestful;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@RunWith(SpringRunner.class)
@SpringBootTest
class DwyApplicationTests {
    @Autowired
    private MapStructRestful mapStructRestful;

    @Test
    void contextLoads() {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ISO_DATE_TIME;//2020-04-08T10:21:34.818
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyyMMddHHMMSS");

        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.BASIC_ISO_DATE;//20200408
        DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ISO_LOCAL_TIME;//10:31:31.142
        DateTimeFormatter dateTimeFormatter5 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;//2020-04-08T10:32:44.436
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(dateTimeFormatter5));



    }
    @Test
    void postEditUser(){
    }
}
