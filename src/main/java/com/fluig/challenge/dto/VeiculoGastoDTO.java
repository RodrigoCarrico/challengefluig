package com.fluig.challenge.dto;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.fluig.challenge.entities.Veiculo;
import com.fluig.challenge.utils.Util;

public class VeiculoGastoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String marca;
	private String modelo;
	private Integer ano;
	private Double quantidade_combustivel_gasto;
	private Double valor_total_gasto_combustivel;

	public VeiculoGastoDTO() {

	}

	public VeiculoGastoDTO(Veiculo veiculo) {
		this.nome = veiculo.getNome();
		this.marca = veiculo.getMarca().name();
		this.modelo = veiculo.getModelo();
		setAno(veiculo.getData_de_fabricacao());
		this.quantidade_combustivel_gasto = veiculo.getQuantidade_combustivel_gasto();
		this.valor_total_gasto_combustivel = veiculo.getValor_gasto_combutivel();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Instant date) {
		this.ano = Util.formatDataAno(date);
	}

	public Double getQuantidade_combustivel_gasto() {
		return Util.format3CasasDecimais(quantidade_combustivel_gasto);
	}

	public void setQuantidade_combustivel_gasto(Double quantidade_combustivel_gasto) {
		this.quantidade_combustivel_gasto = quantidade_combustivel_gasto;
	}

	public Double getValor_total_gasto_combustivel() {
		return Util.format3CasasDecimais(valor_total_gasto_combustivel);
	}

	public void setValor_total_gasto_combustivel(Double valor_total_gasto_combustivel) {
		this.valor_total_gasto_combustivel = valor_total_gasto_combustivel;
	}

}
