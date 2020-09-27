package com.levimartines.challengefs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.levimartines.challengefs.domain.Pessoa;
import com.levimartines.challengefs.dto.PessoaDTO;
import com.levimartines.challengefs.exceptions.ObjectNotFoundException;
import com.levimartines.challengefs.service.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PessoaServiceTest {

	@Autowired
	private PessoaService service;

	@Test
	@Order(1)
	void findById() {
		Pessoa pessoa = service.findById(1L);
		assertEquals(1L, pessoa.getId());
	}

	@Test
	@Order(2)
	void pessoaNotFound() {
		Pessoa pessoa = null;
		try {
			pessoa = service.findById(0L);
		} catch (RuntimeException e) {
			assertTrue(e instanceof ObjectNotFoundException);
			assertEquals("Objeto nao encontrado.", e.getMessage());
		}
		Assertions.assertNull(pessoa);
	}

	@Test
	@Order(3)
	void update() {
		PessoaDTO dto = new PessoaDTO("Updated Name", "null@null.com");
		service.update(dto, 2L);

		Pessoa pessoa = service.findById(2L);
		assertEquals(pessoa.getNome(), "Updated Name");
	}

	@Test
	@Order(4)
	void save() {
		PessoaDTO dto = new PessoaDTO("Pessoa Teste", "pessoa@test.com");
		Pessoa pessoa = service.saveDto(dto);
		assertNotNull(pessoa.getId());
	}

	@Test
	@Order(5)
	void saveEmailDuplicado() {
		PessoaDTO dto = new PessoaDTO("Teste testado", "levi@levi.com");
		Exception exception = assertThrows(DataIntegrityViolationException.class, () -> {
			service.saveDto(dto);
		});
		assertNotNull(exception);
	}

	@Test
	@Order(6)
	void delete() {
		Pessoa pessoa = service.findById(3L);
		Assertions.assertNotNull(pessoa);
		service.delete(3L);
		Exception e = assertThrows(RuntimeException.class, () -> {
			service.findById(3L);
		});
		assertTrue(e instanceof ObjectNotFoundException);
		assertEquals("Objeto nao encontrado.", e.getMessage());
	}
}
