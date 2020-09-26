package com.levimartines.challengefs.service;

import com.levimartines.challengefs.domain.Endereco;
import com.levimartines.challengefs.repository.EnderecoRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

	private final EnderecoRepository enderecoRepository;

	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	@Transactional(readOnly = true)
	public List<Endereco> findAllByPessoaId(Long pessoaId) {
		return enderecoRepository.findAllByPessoa(pessoaId);
	}
}
