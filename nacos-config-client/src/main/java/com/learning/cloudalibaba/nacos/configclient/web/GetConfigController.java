package com.learning.cloudalibaba.nacos.configclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baijie
 * @date 2019-10-15
 */
@RestController
public class GetConfigController {

    @Value("${config}")
    private String string;

    @GetMapping("/config")
    public String getConfig(){
        return string;
    }
}
