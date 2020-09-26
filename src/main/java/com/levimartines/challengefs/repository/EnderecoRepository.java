package com.levimartines.challengefs.repository;

import com.levimartines.challengefs.domain.Endereco;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findAllByPessoa(Long pessoaId);
}
