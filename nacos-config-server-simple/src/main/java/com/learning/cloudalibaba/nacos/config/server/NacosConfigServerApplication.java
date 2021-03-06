package com.learning.cloudalibaba.nacos.config.server;

import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;

@SpringBootApplication
public class NacosConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigServerApplication.class, args);
    }

    @Component
    class SampleRunner implements ApplicationRunner {

        @Value("${user.name}")
        String userName;

        @Value("${user.age:25}")
        int userAge;

//        @Autowired
//        private NacosConfigManager nacosConfigManager;
//
        @Override
        public void run(ApplicationArguments args) throws Exception {}
//            System.out.println(
//                    String.format("Initial username=%s, userAge=%d", userName, userAge));
//
//            nacosConfigManager.getConfigService().addListener(
//                    "nacos-config-example.properties", "DEFAULT_GROUP", new Listener() {
//
//                        /**
//                         * Callback with latest config data.
//                         *
//                         * For example, config data in Nacos is:
//                         *
//                         * user.name=Nacos user.age=25
//                         * @param configInfo latest config data for specific dataId in Nacos
//                         * server
//                         */
//                        @Override
//                        public void receiveConfigInfo(String configInfo) {
//                            Properties properties = new Properties();
//                            try {
//                                properties.load(new StringReader(configInfo));
//                            }
//                            catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println("config changed: " + properties);
//                        }
//
//                        @Override
//                        public Executor getExecutor() {
//                            return null;
//                        }
//                    });
//        }
//
//    }
//
//    @RestController
//    @RefreshScope
//    class SampleController {
//
//        @Value("${user.name}")
//        String userName;
//
//        @Value("${user.age:25}")
//        Integer age;
//
//        @Autowired
//        private NacosConfigManager nacosConfigManager;
//
//        @RequestMapping("/user")
//        public String simple() {
//            return "Hello Nacos Config!" + "Hello " + userName + " " + age + "!"
//                    + nacosConfigManager.getConfigService();
//        }
    }
}