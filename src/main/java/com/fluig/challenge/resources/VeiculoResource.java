package com.fluig.challenge.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fluig.challenge.dto.VeiculoDTO;
import com.fluig.challenge.entities.Veiculo;
import com.fluig.challenge.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
	@Autowired
	private VeiculoService veiculoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VeiculoDTO>> findAll() {
		return ResponseEntity.ok().body(veiculoService.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody VeiculoDTO veiculoDto) {
		Veiculo veiculo = veiculoService.fromDTO(veiculoDto);
		veiculo = veiculoService.save(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
