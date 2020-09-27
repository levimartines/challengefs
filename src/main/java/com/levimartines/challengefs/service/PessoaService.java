package com.levimartines.challengefs.service;

import com.levimartines.challengefs.domain.Pessoa;
import com.levimartines.challengefs.dto.PessoaDTO;
import com.levimartines.challengefs.exceptions.ObjectNotFoundException;
import com.levimartines.challengefs.repository.PessoaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

	private final PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Transactional(readOnly = true)
	public List<Pessoa> listPessoas() {
		return pessoaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Pessoa findById(Long id) {
		return pessoaRepository.findById(id).orElseThrow(
			() -> new ObjectNotFoundException("Objeto nao encontrado."));
	}

	public void delete(Long id) {
		Pessoa pessoa = findById(id);
		pessoaRepository.delete(pessoa);
	}

	public Pessoa saveDto(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa(dto);
		return pessoaRepository.save(pessoa);
	}

	public Pessoa update(PessoaDTO dto, Long pessoaId) {
		Pessoa pessoa = findById(pessoaId);
		pessoa.setNome(dto.getNome());
		pessoa.setEmail(dto.getEmail());
		return pessoaRepository.save(pessoa);
	}
}
