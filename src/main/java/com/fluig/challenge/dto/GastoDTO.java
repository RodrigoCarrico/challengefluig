package com.fluig.challenge.dto;

import java.io.Serializable;

public class GastoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Double preco;
	private Double total_km_cidade;
	private Double total_km_rodovia;

	public GastoDTO() {
	}

	public GastoDTO(Double preco, Double total_km_cidade, Double total_km_rodovia) {
		super();
		this.preco = preco;
		this.total_km_cidade = total_km_cidade;
		this.total_km_rodovia = total_km_rodovia;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getTotal_km_cidade() {
		return total_km_cidade;
	}

	public void setTotal_km_cidade(Double total_km_cidade) {
		this.total_km_cidade = total_km_cidade;
	}

	public Double getTotal_km_rodovia() {
		return total_km_rodovia;
	}

	public void setTotal_km_rodovia(Double total_km_rodovia) {
		this.total_km_rodovia = total_km_rodovia;
	}
}
