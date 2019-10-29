package com.fluig.challenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fluig.challenge.dto.GastoDTO;
import com.fluig.challenge.dto.VeiculoGastoDTO;
import com.fluig.challenge.services.GastoService;

@RestController
@RequestMapping(value = "/gastos")
public class GastoResource {
	@Autowired
	private GastoService gastoService;

	@PostMapping
	public ResponseEntity<List<VeiculoGastoDTO>> gastoCombustivel(@RequestBody GastoDTO gastoDTO) {
		return ResponseEntity.ok().body(gastoService.getListVeiculosTotalGasto(gastoDTO));
	}

}
