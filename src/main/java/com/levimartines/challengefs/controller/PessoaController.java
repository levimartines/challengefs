package com.levimartines.challengefs.controller;

import com.levimartines.challengefs.dto.PessoaDTO;
import com.levimartines.challengefs.service.PessoaService;
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

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@GetMapping
	public ResponseEntity<?> listTasks() {
		return ResponseEntity.ok(pessoaService.listPessoas());
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody PessoaDTO dto) {
		return ResponseEntity.ok(pessoaService.save(dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable("id") Long pessoaId) {
		pessoaService.delete(pessoaId);
		return ResponseEntity.noContent().build();
	}

}
