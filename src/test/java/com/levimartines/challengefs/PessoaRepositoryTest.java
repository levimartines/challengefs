package com.levimartines.challengefs;

import com.levimartines.challengefs.domain.Pessoa;
import com.levimartines.challengefs.repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PessoaRepositoryTest {

	@Autowired
	private PessoaRepository repository;

	@Test
	void savePessoa() {
		Pessoa pessoa = new Pessoa("Teste Cadastro", "teste@test.com");
		repository.save(pessoa);
		Assertions.assertNotNull(pessoa.getId());
	}

}
