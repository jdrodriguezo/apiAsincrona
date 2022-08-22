package com.prueba.apiAsincrona.service;

import java.util.List;

import com.prueba.apiAsincrona.dto.Producto;

public interface IApiService {
	public List<Producto> noAsinc1() throws Exception;
	public List<Producto> noAsinc2() throws Exception;
	public List<Producto> noAsinc3() throws Exception;
}
