package com.app.raghu.config;

import java.util.UUID;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

//@Configuration
public class MyRouteConfig {

	//@Bean
	public RouteLocator configureRoutes(RouteLocatorBuilder builder) {

		return builder.routes()

				.route("cartId", r -> r.path("/cart/**")
						.filters(f->
						f.addRequestHeader("MyToken", "Basic "+UUID.randomUUID().toString())
						.addResponseHeader("Service-Mode", "Active")
						)
						
						.uri("lb://CART-SERVICE"))
				.route("orderId", r -> r.path("/order/**").uri("lb://ORDER-SERVICE")).build();
	}

}
