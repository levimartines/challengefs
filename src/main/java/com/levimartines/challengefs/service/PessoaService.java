package com.levimartines.challengefs.service;

import com.levimartines.challengefs.domain.Pessoa;
import com.levimartines.challengefs.exceptions.ObjectNotFoundException;
import com.levimartines.challengefs.repository.PessoaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

	private final PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	public List<Pessoa> listPessoas() {
		return pessoaRepository.findAll();
	}

	public Pessoa findById(Long id) {
		return pessoaRepository.findById(id).orElseThrow(
			() -> new ObjectNotFoundException("Objeto nao encontrado."));
	}

	public void delete(Long id) {
		Pessoa pessoa = findById(id);
		pessoaRepository.delete(pessoa);
	}

	public Pessoa save(Pessoa task) {
		return pessoaRepository.save(task);
	}
}
