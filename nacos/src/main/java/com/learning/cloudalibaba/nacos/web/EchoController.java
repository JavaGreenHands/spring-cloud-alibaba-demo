package com.learning.cloudalibaba.nacos.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 *
 * @author baijie
 * @date 2019-10-15
 */
@RestController
public class EchoController {


    @GetMapping("/get/{string}")
    public String getString(@PathVariable("string") String string){

        return "get String is " +string;

    }

}
