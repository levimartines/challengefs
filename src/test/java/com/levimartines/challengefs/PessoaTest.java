package com.levimartines.challengefs;

import com.levimartines.challengefs.domain.Pessoa;
import com.levimartines.challengefs.dto.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PessoaTest {

	@Test
	void dtoToPessoa() {
		PessoaDTO dto = new PessoaDTO("Teste Cadastro", "teste@test.com");
		Pessoa pessoa = new Pessoa(dto);
		Assertions.assertEquals(dto.getNome(), pessoa.getNome());
		Assertions.assertEquals(dto.getEmail(), pessoa.getEmail());
	}

}
