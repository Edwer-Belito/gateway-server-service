package com.example.gateway;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.netty.http.client.HttpClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerGatewayApplication {

	@Bean
	public HttpClient httpClient() {
		return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	}
	
//	@Bean
//	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
//		
//		return builder.routes()
//				.route(p -> p 
//					.path("/dummy-client2/saludo")
//					.uri("http://localhost:7080")) // http://localhost:7080/dummy-client2/saludo
//				.route(p -> p 
//						.path("/saludo")
//						.filters(f -> f.prefixPath("/dummy-client2"))
//						.uri("http://localhost:7080")) // http://localhost:7080/dummy-client2/saludo
//				.route(p -> p 
//						.path("/xxx")
//						.filters(f -> f.setPath("/dummy-client2/saludo")
//								.addRequestHeader("xxxxxxxxx", "ggggggggggggggg")
//								.addResponseHeader("wwwwwwwwwwww", "aaaaaaaaaaaaa")
//								.addRequestParameter("rtyrtyrty", "hfghfhfgh")
//								)
//						.uri("http://localhost:7080")) // http://localhost:7080/dummy-client2/saludo
//				
//				.build();
//		
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServerGatewayApplication.class, args);
	}

}
