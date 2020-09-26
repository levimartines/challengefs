package com.levimartines.challengefs.controller;

import com.levimartines.challengefs.domain.Endereco;
import com.levimartines.challengefs.domain.Pessoa;
import com.levimartines.challengefs.dto.PessoaDTO;
import com.levimartines.challengefs.service.EnderecoService;
import com.levimartines.challengefs.service.PessoaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pessoas")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {

	private final PessoaService pessoaService;
	private final EnderecoService enderecoService;

	public PessoaController(PessoaService pessoaService,
		EnderecoService enderecoService) {
		this.pessoaService = pessoaService;
		this.enderecoService = enderecoService;
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		return ResponseEntity.ok(pessoaService.listPessoas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable("id") Long pessoaId) {
		return ResponseEntity.ok(pessoaService.findById(pessoaId));
	}

	@GetMapping("/{id}/enderecos")
	public ResponseEntity<List<Endereco>> findAllEnderecosByPessoaId(
		@PathVariable("id") Long pessoaId) {
		return ResponseEntity.ok(enderecoService.findAllByPessoaId(pessoaId));
	}


	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody @Valid PessoaDTO dto) {
		return ResponseEntity.ok(pessoaService.save(dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long pessoaId) {
		pessoaService.delete(pessoaId);
		return ResponseEntity.noContent().build();
	}

}
