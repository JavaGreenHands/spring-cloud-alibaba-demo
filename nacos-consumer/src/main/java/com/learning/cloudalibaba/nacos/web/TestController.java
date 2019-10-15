package com.learning.cloudalibaba.nacos.web;

import com.learning.cloudalibaba.nacos.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 测试controller
 *
 * @author baijie
 * @date 2019-10-15
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/echo-rest/{string}")
    public String rest(@PathVariable("string") String string){

        String result = restTemplate.getForObject("http://provider/get/" + string, String.class);
        return "from rest get response...."+result;
    }

    @GetMapping(value = "/echo-feign/{string}")
    public String feign(@PathVariable("string") String string){

        String str = echoService.getStr(string);
        return "from feign get response...."+str;
    }

}
