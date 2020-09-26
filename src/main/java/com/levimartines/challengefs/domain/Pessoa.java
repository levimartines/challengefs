package com.levimartines.challengefs.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PESSOA")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PES_ID")
	private Long id;

	@Column(name = "PES_NOME")
	private String nome;

	@Column(name = "PES_EMAIL")
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
	@Cascade(CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();

	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
}


