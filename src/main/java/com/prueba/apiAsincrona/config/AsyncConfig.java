package com.prueba.apiAsincrona.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
	
	@Bean(name = "asyncExecutor")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(8); // MINIMO DE HILOS QUE SE VAN A USAR EN ESTA APLICACION 
		executor.setMaxPoolSize(16); // MAXIMO DE HILOS
		executor.setQueueCapacity(100); // MAXIMO DE HILOS QUE PUEDEN SER CREADOS EN TOTAL PERO QUE ESTAN A LA ESPERA PARA SER ATENTIDOS
		executor.setThreadNamePrefix("AsyncThread-"); // NOMBRE QUE SE LE PUEDE PONER AL HILO QUE ESTAS CREANDO
		executor.initialize();
		return executor;
	}

}
