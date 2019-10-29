package com.fluig.challenge.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fluig.challenge.dto.GastoDTO;
import com.fluig.challenge.dto.VeiculoGastoDTO;
import com.fluig.challenge.entities.Veiculo;
import com.fluig.challenge.repositories.VeiculoRepository;

@Service
public class GastoService {
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	public List<VeiculoGastoDTO> getListVeiculosTotalGasto(GastoDTO gastoDTO) {
		List<Veiculo> list = veiculoRepository.findAll();
		List<VeiculoGastoDTO> listDto = new ArrayList<>();
		for (Veiculo veiculo : list) {
			veiculo.calculaTotalCombustivel(gastoDTO);
			listDto.add(new VeiculoGastoDTO(veiculo));
		}
		return listDto;
	}

}
