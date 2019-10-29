package com.fluig.challenge.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fluig.challenge.entities.Veiculo;
import com.fluig.challenge.entities.enums.MarcaEnum;
import com.fluig.challenge.repositories.VeiculoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Override
	public void run(String... args) throws Exception {

		Veiculo v1 = null;
		Veiculo v2 = null;
		Veiculo v3 = null;
		
		/*data formato  ISO 8601 */
		v1 = new Veiculo(null, "Chevete", MarcaEnum.CHEVROLET, "1.6 SE", Instant.parse("1989-09-01T00:00:00Z"), 6.6, 7d);
		v2 = new Veiculo(null, "Gol", MarcaEnum.VOLKSWAGEN, "GTI 1.6", Instant.parse("1995-09-01T00:00:00Z"), 8.5, 9d);
		v3 = new Veiculo(null, "Ka", MarcaEnum.FORD, "1.4", Instant.parse("2000-10-01T00:00:00Z"), 11.5d, 13.5d);

		veiculoRepository.saveAll(Arrays.asList(v1, v2, v3));

	}

}
