package com.levimartines.challengefs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "ENDERECO")
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	@Id
	@Column(name = "END_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "PES_COD")
	private Long pessoa;

	@Column(name = "END_LOGRADOURO")
	private String logradouro;

	@Column(name = "END_NUMERO")
	private String numero;

	@Column(name = "END_COMPLEMENTO")
	private String complemento;

	@Column(name = "END_BAIRRO")
	private String bairro;

	@ManyToOne
	@JoinColumn(name = "CID_COD")
	private Cidade cidade;

}
