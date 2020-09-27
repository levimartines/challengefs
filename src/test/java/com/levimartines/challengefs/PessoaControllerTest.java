package com.levimartines.challengefs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.levimartines.challengefs.domain.Endereco;
import com.levimartines.challengefs.domain.Pessoa;
import com.levimartines.challengefs.dto.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class PessoaControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(1)
	void getAllPessoasRetorna200() {
		ResponseEntity<Pessoa[]> responseEntity = restTemplate
			.getForEntity("/api/pessoas", Pessoa[].class);
		assertNotNull(responseEntity.getBody());
		assertTrue(responseEntity.getBody().length > 0);
		assertEquals(200, responseEntity.getStatusCode().value());
	}

	@Test
	@Order(2)
	void findByIdRetorna200() {
		ResponseEntity<Pessoa> responseEntity = restTemplate
			.getForEntity("/api/pessoas/1", Pessoa.class);
		assertNotNull(responseEntity.getBody());
		assertEquals(1L, responseEntity.getBody().getId());
		assertEquals(200, responseEntity.getStatusCode().value());
	}

	@Test
	@Order(3)
	void finAllEnderecosRetorna200() {
		ResponseEntity<Endereco[]> responseEntity = restTemplate
			.getForEntity("/api/pessoas/1/enderecos", Endereco[].class);
		assertNotNull(responseEntity.getBody());
		assertTrue(responseEntity.getBody().length > 0);
		assertEquals(200, responseEntity.getStatusCode().value());
	}

	@Test
	@Order(4)
	void notFoundRetorna404() {
		ResponseEntity<Pessoa> responseEntity = restTemplate
			.getForEntity("/api/pessoas/0", Pessoa.class);
		Assertions.assertNull(responseEntity.getBody());
		Assertions.assertEquals(404, responseEntity.getStatusCode().value());
	}

	@Test
	@Order(5)
	void updateRetorna200() {
		PessoaDTO dto = new PessoaDTO("Teste Put", "put@put.com");
		ResponseEntity<Pessoa> responseEntity = restTemplate
			.exchange("/api/pessoas/3", HttpMethod.PUT, new HttpEntity<>(dto), Pessoa.class);
		assertNotNull(responseEntity.getBody());
		assertEquals("Teste Put", responseEntity.getBody().getNome());
		assertEquals(200, responseEntity.getStatusCode().value());
	}

	@Test
	@Order(6)
	void postRetorna200() {
		PessoaDTO dto = new PessoaDTO("Teste Post", "save@save.com");
		ResponseEntity<Pessoa> responseEntity = restTemplate
			.postForEntity("/api/pessoas", dto, Pessoa.class);
		assertNotNull(responseEntity.getBody());
		assertEquals("Teste Post", responseEntity.getBody().getNome());
		assertEquals(200, responseEntity.getStatusCode().value());
	}
}
