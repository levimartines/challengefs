package com.levimartines.challengefs.enums;

import lombok.Getter;

@Getter
public enum Estado {
	SAO_PAULO(0), MINAS_GERAIS(1), BAHIA(2);

	private final Integer id;

	Estado(Integer id) {
		this.id = id;
	}

	public static Estado toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Estado x : Estado.values()) {
			if (cod.equals(x.getId())) {
				return x;
			}
		}
		return null;
	}
}
