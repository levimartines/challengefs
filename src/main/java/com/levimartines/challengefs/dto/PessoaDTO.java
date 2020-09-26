package com.levimartines.challengefs.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaDTO {

	@NotEmpty
	private String nome;
	@NotEmpty
	@Email
	private String email;

}
