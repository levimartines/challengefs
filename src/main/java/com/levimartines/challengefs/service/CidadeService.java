package com.levimartines.challengefs.service;

import com.levimartines.challengefs.domain.Cidade;
import com.levimartines.challengefs.enums.Estado;
import com.levimartines.challengefs.repository.CidadeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeService {

	private final CidadeRepository repository;

	public CidadeService(CidadeRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public List<String> findAllByEstado(Estado estado) {
		return repository.findAllByEstado(estado).stream().map(Cidade::getNome)
			.collect(Collectors.toList());
	}
}
