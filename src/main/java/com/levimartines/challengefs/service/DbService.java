package com.levimartines.challengefs.service;

import com.levimartines.challengefs.domain.Cidade;
import com.levimartines.challengefs.domain.Endereco;
import com.levimartines.challengefs.domain.Pessoa;
import com.levimartines.challengefs.enums.Estado;
import com.levimartines.challengefs.repository.CidadeRepository;
import com.levimartines.challengefs.repository.EnderecoRepository;
import com.levimartines.challengefs.repository.PessoaRepository;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Service
public class DbService {

	private final EnderecoRepository endRepository;
	private final CidadeRepository cidadeRepository;
	private final PessoaRepository pessoaRepository;

	public void instantiateTestDatabase() {
		Pessoa p1 = new Pessoa("Levi Martines");
		Pessoa p2 = new Pessoa("Lorem Ipsum");
		Pessoa p3 = new Pessoa("Mussum Ipsum");
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));

		Cidade cidade = new Cidade(null, "Sorocaba", Estado.SAO_PAULO);
		Cidade cidade2 = new Cidade(null, "São Paulo", Estado.SAO_PAULO);
		Cidade cidade3 = new Cidade(null, "Belo Horizonte", Estado.MINAS_GERAIS);
		Cidade cidade4 = new Cidade(null, "Uberlândia", Estado.MINAS_GERAIS);
		Cidade cidade5 = new Cidade(null, "Salvador", Estado.BAHIA);
		cidadeRepository.saveAll(Arrays.asList(cidade, cidade2, cidade3, cidade4, cidade5));

		Endereco end = new Endereco(null, p1.getId(), "R: Sao Paulo",
			"123", "Sem complemento",
			"Jd. SP", cidade);
		Endereco end2 = new Endereco(null, p1.getId(), "Av Sao Paulo II",
			"83", "Apto. 3", "Jd. Campos de SP", cidade);

		Endereco end3 = new Endereco(null, p1.getId(), "R: Sorocaba.",
			"1", "Casa de esquina", "Bairro das Pedras", cidade2);

		Endereco end4 = new Endereco(null, p2.getId(), "R: Belo Horizonte",
			"1024", "", "Jd. dos Morros", cidade3);

		Endereco end5 = new Endereco(null, p2.getId(), "R: Uberlandia",
			"562", "Casa do fundo", "Bairro de Uberlandia", cidade4);

		Endereco end6 = new Endereco(null, p3.getId(), "R: Salvador",
			"324", null, "Carnaval", cidade5);
		endRepository.saveAll(Arrays.asList(end, end2, end3, end4, end5, end6));
	}
}
