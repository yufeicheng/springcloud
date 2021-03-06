package cyf.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
//启用服务注册与发现
@EnableDiscoveryClient
//启用feign进行远程调用,Feign是一个声明式Web Service客户端。使用Feign能让编写Web Service客户端更加简单, 它的使用方法是定义一个接口，然后在上面添加注解，
// 同时也支持JAX-RS标准的注解。Feign也支持可拔插式的编码器和解码器。
// Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。
@EnableFeignClients
//用于连接 hytrix-dashboard,否则监控时显示Unable to connect to Command Metric Stream.
//监控之前要访问consumer接口一次，否则monitor 会一直处于loading...
@EnableCircuitBreaker
public class ConsumerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConsumerApplication.class, args);
	}
}
