package com.hofey.dwy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class DwyApplicationTests {

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

}
