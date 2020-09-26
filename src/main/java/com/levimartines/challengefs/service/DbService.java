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
		Pessoa p1 = new Pessoa("Levi Martines", "levi@levi.com");
		Pessoa p2 = new Pessoa("Lorem Ipsum", "lorem@ipsum.com");
		Pessoa p3 = new Pessoa("Mussum Ipsum", "cacilds@mussum.com");
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));

		Cidade cidade = new Cidade(null, "Sorocaba", Estado.SAO_PAULO);
		Cidade cidade2 = new Cidade(null, "São Paulo", Estado.SAO_PAULO);
		Cidade cidade3 = new Cidade(null, "Belo Horizonte", Estado.MINAS_GERAIS);
		Cidade cidade4 = new Cidade(null, "Uberlândia", Estado.MINAS_GERAIS);
		Cidade cidade5 = new Cidade(null, "Salvador", Estado.BAHIA);
		cidadeRepository.saveAll(Arrays.asList(cidade, cidade2, cidade3, cidade4, cidade5));

		Endereco end = new Endereco(null, p1.getId(), "R: Sao Paulo",
			"123", "Sem complemento",
			"Jd. SP", cidade2, "18051-313");
		Endereco end2 = new Endereco(null, p1.getId(), "Av Sao Paulo II",
			"83", "Apto. 3", "Jd. Sampa", cidade2, "18021-314");

		Endereco end3 = new Endereco(null, p1.getId(), "R: Sorocaba.",
			"1", "Casa de esquina", "Sorocity", cidade, "18055-923");

		Endereco end4 = new Endereco(null, p2.getId(), "R: Belo Horizonte",
			"1024", "", "BH", cidade3, "18011-314");

		Endereco end5 = new Endereco(null, p2.getId(), "R: Uberlandia",
			"562", "Casa do fundo", "Uberlandia", cidade4, "14046-111");

		Endereco end6 = new Endereco(null, p3.getId(), "R: Salvador",
			"324", null, "Salvador Denovo", cidade5, "11111-111");
		endRepository.saveAll(Arrays.asList(end, end2, end3, end4, end5, end6));
	}
}
