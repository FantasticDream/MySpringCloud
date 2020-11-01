package pers.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
 *   @创建人  zc
 *   @创建时间 2020/11/2 2:24
 *   @包名: pers.zc
 *   @描述：
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class MyZullServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyZullServerApplication.class, args);
    }
}
