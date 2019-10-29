package com.fluig.challenge.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fluig.challenge.dto.GastoDTO;
import com.fluig.challenge.entities.enums.MarcaEnum;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String marca;
	private String modelo;
	private Instant data_de_fabricacao;
	private Double media_cidade;
	private Double media_rodovia;

	@Transient
	private Double quantidade_combustivel_gasto;

	@Transient
	private Double valor_gasto_combutivel;

	public Veiculo() {

	}

	public Veiculo(Integer id, String nome, MarcaEnum marca, String modelo, Instant data_de_fabricacao,
			Double media_cidade, Double media_rodovia) {
		super();
		this.id = id;
		this.nome = nome;
		setMarca(marca);
		this.modelo = modelo;
		this.data_de_fabricacao = data_de_fabricacao;
		this.media_cidade = media_cidade;
		this.media_rodovia = media_rodovia;
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

	public MarcaEnum getMarca() {
		return MarcaEnum.valueOff(marca);
	}

	public void setMarca(MarcaEnum marca) {
		this.marca = marca.getName();
	}

	public void setMarca(String marca) {
		this.marca = MarcaEnum.valueOff(marca).name();
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

	public Double getQuantidade_combustivel_gasto() {
		return quantidade_combustivel_gasto;
	}

	public Double getValor_gasto_combutivel() {
		return valor_gasto_combutivel;
	}

	public void calculaTotalCombustivel(GastoDTO gastoDTO) {
		/* quantidade cusbustivel */
		Double total_combustivel_cidade = gastoDTO.getTotal_km_cidade() / this.media_cidade;
		Double total_combustivel_rodovia = gastoDTO.getTotal_km_rodovia()/ this.media_rodovia;

		/* valor gasto combustivel */
		Double total_gasto_cidade = total_combustivel_cidade * gastoDTO.getPreco();
		Double total_gasto_rodovia = total_combustivel_rodovia * gastoDTO.getPreco();

		this.quantidade_combustivel_gasto = total_combustivel_cidade + total_combustivel_rodovia;
		this.valor_gasto_combutivel = total_gasto_cidade + total_gasto_rodovia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
