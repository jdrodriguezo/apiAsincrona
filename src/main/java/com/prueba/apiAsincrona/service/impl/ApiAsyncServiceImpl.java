package com.prueba.apiAsincrona.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.prueba.apiAsincrona.dto.Producto;
import com.prueba.apiAsincrona.service.IApiAsyncService;

@Service
public class ApiAsyncServiceImpl implements IApiAsyncService {

	
	@Override
	@Async("asyncExecutor")
	public CompletableFuture<List<Producto>> asinc1() throws Exception {
		Thread.sleep(2000);
		List<Producto> list = Arrays.asList(new Producto(0,"arroz"),new Producto(1,"aceite"),new Producto(2,"azucar"));
		System.out.println("asinc1");
		return CompletableFuture.completedFuture(list);
	}

	@Override
	@Async("asyncExecutor")
	public CompletableFuture<List<Producto>> asinc2() throws Exception {
		Thread.sleep(2000);
		List<Producto> list = Arrays.asList(new Producto(4,"panela"),new Producto(5,"sal"),new Producto(6,"pollo"));
		System.out.println("asinc2");
		return CompletableFuture.completedFuture(list);
	}

	@Override
	@Async("asyncExecutor")
	public CompletableFuture<List<Producto>> asinc3() throws Exception {
		Thread.sleep(2000);
		List<Producto> list = Arrays.asList(new Producto(7,"pan"),new Producto(8,"gaseosa"),new Producto(9,"papa"));
		System.out.println("asinc3");
		return CompletableFuture.completedFuture(list);
	}

}
