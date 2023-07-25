package com.fch.controller;

import com.fch.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * @packageName com.fch.controller
 * @ClassName PersonController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/25 16:38
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {
    @PostMapping
    public Person testStringToPet(Person person) {
        log.info("person = {}", person);
        return person;
    }
}
