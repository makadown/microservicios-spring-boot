package com.mario.springcloud.msvc.items.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class LoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new ServiceInstanceListSupplier() {

            @Override
            public String getServiceId() {
                return "msvc-products"; // Nombre lógico del servicio
            }

            @Override
            public Flux<List<ServiceInstance>> get() {
                // Obtén las instancias desde una propiedad
                String[] instances = System.getProperty("msvc-products.instances", "http://localhost:8001,http://localhost:9001")
                        .split(",");
                List<ServiceInstance> serviceInstances = Stream.of(instances)
                        .map(url -> {
                            String[] parts = url.replace("http://", "").split(":");
                            return new DefaultServiceInstance(
                                    "instance-" + parts[1], // ID único para cada instancia
                                    "msvc-products",       // Nombre lógico del servicio
                                    parts[0],               // Host
                                    Integer.parseInt(parts[1]), // Puerto
                                    false                  // SSL habilitado (true si usas HTTPS)
                            );
                        }).collect(Collectors.toList());
                return Flux.just(serviceInstances);
            }
        };
    }
}