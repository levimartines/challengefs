package com.levimartines.challengefs.enums;

import lombok.Getter;

@Getter
public enum Estado {
	SP(0), MG(1), BH(2);

	private final Integer id;

	Estado(Integer id) {
		this.id = id;
	}

}
