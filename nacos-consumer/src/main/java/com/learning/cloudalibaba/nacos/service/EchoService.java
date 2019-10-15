package com.learning.cloudalibaba.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 调用服务
 *
 * @author baijie
 * @date 2019-10-15
 */
@FeignClient(name = "provider")
public interface EchoService {

    @GetMapping(value = "/get/{string}")
    String getStr(@PathVariable("string") String str);
}
