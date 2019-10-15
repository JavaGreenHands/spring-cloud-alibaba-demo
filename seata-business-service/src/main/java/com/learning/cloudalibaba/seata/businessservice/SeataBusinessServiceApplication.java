package com.learning.cloudalibaba.seata.businessservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SeataBusinessServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataBusinessServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @FeignClient(name = "storage-service")
    public interface StorageService {

        @RequestMapping(path = "/storage/{commodityCode}/{count}")
        String storage(@RequestParam("commodityCode") String commodityCode,
                       @RequestParam("count") int count);

    }

    @FeignClient(name = "order-service")
    public interface OrderService {

        @PostMapping(path = "/order")
        String order(@RequestParam("userId") String userId,
                     @RequestParam("commodityCode") String commodityCode,
                     @RequestParam("orderCount") int orderCount);

    }

}
