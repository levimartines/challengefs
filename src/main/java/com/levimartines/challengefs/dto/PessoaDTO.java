package com.levimartines.challengefs.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

	@NotEmpty
	private String nome;
	@NotEmpty
	@Email
	private String email;

}
