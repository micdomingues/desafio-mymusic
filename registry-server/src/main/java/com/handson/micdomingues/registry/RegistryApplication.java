package com.handson.micdomingues.registry;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RegistryApplication.class)
				.web(WebApplicationType.SERVLET)
				.run(args);

	}

	@Component
	class DiscoveryClientExample implements CommandLineRunner {

		@Autowired
		private DiscoveryClient discoveryClient;

		@Override
		public void run(String... strings) throws Exception {
			discoveryClient.getInstances("musica-service").forEach((ServiceInstance s) -> {
				System.out.println("Musica Service running - MICHAELL");
				System.out.println(ToStringBuilder.reflectionToString(s));
			});
			discoveryClient.getInstances("playlist-service").forEach((ServiceInstance s) -> {
				System.out.println("Playlist Service running - MICHAELL");
				System.out.println(ToStringBuilder.reflectionToString(s));
			});
		}
	}
}
