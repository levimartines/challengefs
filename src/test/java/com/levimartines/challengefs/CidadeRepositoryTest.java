package com.levimartines.challengefs;

import com.levimartines.challengefs.domain.Cidade;
import com.levimartines.challengefs.enums.Estado;
import com.levimartines.challengefs.repository.CidadeRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CidadeRepositoryTest {

	@Autowired
	private CidadeRepository repository;

	@Test
	void findAllCidadesByEstado() {
		List<Cidade> cidades = repository.findAllByEstado(Estado.SP);
		Assertions.assertTrue(cidades.size() > 0);
	}

}
