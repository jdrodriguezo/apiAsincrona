package com.prueba.apiAsincrona.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.apiAsincrona.dto.Producto;
import com.prueba.apiAsincrona.service.IApiService;

@Service
public class ApiService implements IApiService {

	@Override
	public List<Producto> noAsinc1() throws Exception {
		Thread.sleep(2000);
		return Arrays.asList(new Producto(0,"arroz"),new Producto(1,"aceite"),new Producto(2,"azucar"));
	}

	@Override
	public List<Producto> noAsinc2() throws Exception {
		Thread.sleep(2000);
		return Arrays.asList(new Producto(4,"panela"),new Producto(5,"sal"),new Producto(6,"pollo"));
	}

	@Override
	public List<Producto> noAsinc3() throws Exception {
		Thread.sleep(2000);
		return Arrays.asList(new Producto(7,"pan"),new Producto(8,"gaseosa"),new Producto(9,"papa"));
	}

}
