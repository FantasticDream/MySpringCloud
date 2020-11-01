package pers.zc;

/*
 *   @创建人  zc
 *   @创建时间 2020/11/2 2:01
 *   @包名: pers.zc
 *   @描述：
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyEurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(MyEurekaServer.class, args);
    }
}
