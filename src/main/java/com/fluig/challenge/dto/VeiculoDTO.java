package com.fluig.challenge.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fluig.challenge.entities.Veiculo;
import com.fluig.challenge.entities.enums.MarcaEnum;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String marca;
	private String modelo;
	private Instant data_de_fabricacao;
	private Double media_cidade;
	private Double media_rodovia;

	public VeiculoDTO() {
	}

	public VeiculoDTO(Integer id, String nome, String marca, String modelo, Instant data_de_fabricacao,
			Double media_cidade, Double media_rodovia) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.data_de_fabricacao = data_de_fabricacao;
		this.media_cidade = media_cidade;
		this.media_rodovia = media_rodovia;
	}

	public VeiculoDTO(Veiculo veiculo) {
		super();
		this.id = veiculo.getId();
		this.nome = veiculo.getNome();
		setMarca(veiculo.getMarca());
		this.modelo = veiculo.getModelo();
		this.data_de_fabricacao = veiculo.getData_de_fabricacao();
		this.media_cidade = veiculo.getMedia_cidade();
		this.media_rodovia = veiculo.getMedia_rodovia();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setMarca(MarcaEnum marca) {
		this.marca = marca.name();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Instant getData_de_fabricacao() {
		return data_de_fabricacao;
	}

	public void setData_de_fabricacao(Instant data_de_fabricacao) {
		this.data_de_fabricacao = data_de_fabricacao;
	}

	public Double getMedia_cidade() {
		return media_cidade;
	}

	public void setMedia_cidade(Double media_cidade) {
		this.media_cidade = media_cidade;
	}

	public Double getMedia_rodovia() {
		return media_rodovia;
	}

	public void setMedia_rodovia(Double media_rodovia) {
		this.media_rodovia = media_rodovia;
	}

}
