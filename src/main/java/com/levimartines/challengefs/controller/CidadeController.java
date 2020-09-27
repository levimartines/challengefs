package com.levimartines.challengefs.controller;

import com.levimartines.challengefs.enums.Estado;
import com.levimartines.challengefs.service.CidadeService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cidades")
@CrossOrigin(origins = "http://localhost:4200")
public class CidadeController {

	private final CidadeService service;

	public CidadeController(CidadeService cidadeService) {
		this.service = cidadeService;
	}

	@GetMapping("/{estado}")
	public ResponseEntity<List<String>> findById(@PathVariable("estado") Estado estado) {
		return ResponseEntity.ok(service.findAllByEstado(estado));
	}

}
