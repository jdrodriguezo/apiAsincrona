package com.prueba.apiAsincrona.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.apiAsincrona.dto.Producto;
import com.prueba.apiAsincrona.service.IApiAsyncService;
import com.prueba.apiAsincrona.service.IApiService;

@RestController
public class ApiAsincronaController {

	@Autowired
	IApiService iApiService;
	
	@Autowired
	IApiAsyncService iApiAsyncService;

	@GetMapping("/noAsync")
	public ResponseEntity<?> noAsinc() throws Exception{
		List<Producto> list1 = iApiService.noAsinc1();
		List<Producto> list2 = iApiService.noAsinc2();
		List<Producto> list3 = iApiService.noAsinc3();		

		List<Producto> list4 = Stream.of(list1,list2,list3).flatMap(Collection::stream).toList();
		return ResponseEntity.ok(list4);		
	}

	@GetMapping("/async")
	public ResponseEntity<?> asinc() throws Exception{

		System.out.println("inicio");
		CompletableFuture<List<Producto>> c1 = iApiAsyncService.asinc1();
		System.out.println("c1");
		CompletableFuture<List<Producto>> c2 = iApiAsyncService.asinc2();
		System.out.println("c2");
		CompletableFuture<List<Producto>> c3 = iApiAsyncService.asinc3();
		System.out.println("c3");

		
		List<CompletableFuture<List<Producto>>> lc = Arrays.asList(c1, c2, c3);
		
		System.out.println("CompletableFuture");

		//CompletableFuture.allOf(c1, c2, c3).join();
		//CompletableFuture.allOf(lc.toArray(new CompletableFuture[lc.size()])).join();
		lc.stream().map(CompletableFuture::join).toList();
		List<Producto> p = new ArrayList<>();
		lc.stream().map(t -> {
			try {
				return p.addAll(t.get());
			} catch (Exception e) {
			} return null;
		}).toList();
		return ResponseEntity.ok(p);		
	}
}
