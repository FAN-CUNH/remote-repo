package com.fch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @packageName com.fch.controller
 * @ClassName ParamController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/25 11:23
 * @Version 1.0
 */
@Slf4j
@Controller
public class ParamController {
    @GetMapping("/param")
    @ResponseBody
    public Map<String, Object> testParam(@RequestParam(value = "file", required = false) MultipartFile file) {
        Map<String, Object> map = new HashMap<>(16);
        log.info("入参: {}", file);
        map.put("file", file);
        return map;
    }
}
