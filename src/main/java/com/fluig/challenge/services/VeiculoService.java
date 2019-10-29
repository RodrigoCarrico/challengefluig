package com.fluig.challenge.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fluig.challenge.dto.VeiculoDTO;
import com.fluig.challenge.entities.Veiculo;
import com.fluig.challenge.entities.enums.MarcaEnum;
import com.fluig.challenge.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	VeiculoRepository veiculoRepository;

	public Veiculo fromDTO(VeiculoDTO veiculoDTO) {
		return new Veiculo(veiculoDTO.getId(), veiculoDTO.getNome(),
				MarcaEnum.valueOf(veiculoDTO.getMarca().toUpperCase()), veiculoDTO.getModelo(),
				veiculoDTO.getData_de_fabricacao(), veiculoDTO.getMedia_cidade(), veiculoDTO.getMedia_rodovia());
	}

	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public List<VeiculoDTO> findAll() {
		List<Veiculo> list = veiculoRepository.findAll();
		List<VeiculoDTO> listVeiculoDTO = list.stream().map(v -> new VeiculoDTO(v)).collect(Collectors.toList());
		return listVeiculoDTO;
	}

}
