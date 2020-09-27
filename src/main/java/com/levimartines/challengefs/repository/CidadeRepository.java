package com.levimartines.challengefs.repository;

import com.levimartines.challengefs.domain.Cidade;
import com.levimartines.challengefs.enums.Estado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	List<Cidade> findAllByEstado(Estado estado);
}
