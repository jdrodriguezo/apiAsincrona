package com.prueba.apiAsincrona.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.prueba.apiAsincrona.dto.Producto;

public interface IApiAsyncService {
	public CompletableFuture<List<Producto>> asinc1() throws Exception;
	public CompletableFuture<List<Producto>> asinc2() throws Exception;
	public CompletableFuture<List<Producto>> asinc3() throws Exception;
}
