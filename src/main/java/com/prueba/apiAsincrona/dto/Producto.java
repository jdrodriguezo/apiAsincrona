package com.prueba.apiAsincrona.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Producto {

	private Integer id;
	private String nombre;
}
