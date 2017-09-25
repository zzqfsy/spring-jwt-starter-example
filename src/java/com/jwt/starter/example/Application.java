package com.jwt.starter.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zzqan on 2017/9/22.
 */
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        //注册容器生命周期打印日志，便于脚本部署容器
        springApplication.addListeners((ApplicationListener<ApplicationReadyEvent>) event -> logger.warn("jwt-example Application Ready!"));
        springApplication.addListeners((ApplicationListener<ApplicationFailedEvent>) event -> logger.warn("jwt-example Application Failed!"));
        ConfigurableApplicationContext appContext = springApplication.run(args);
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            while(appContext.isActive())
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            logger.warn("jwt-example Context Closed!");
        }));
        appContext.addApplicationListener(event -> {
            if (event instanceof ContextStartedEvent) logger.warn("jwt-example Context Started!");
            else if (event instanceof ContextRefreshedEvent) logger.warn("jwt-example Context Refreshed!");
        });
    }
}
