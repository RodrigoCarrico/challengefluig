package com.fluig.challenge.entities.enums;

public enum MarcaEnum {
	FORD("ford"), VOLKSWAGEN("volkswagen"), CHEVROLET("chevrolet"), HIUNDAI("hiundai"), NISSAN("nissan");

	private String name;

	public String getName() {
		return name;
	}

	private MarcaEnum(String name) {
		this.name = name;
	}

	public static MarcaEnum valueOff(String name) {
		for (MarcaEnum n : MarcaEnum.values()) {
			if (n.getName().equals(name)) {
				return n;
			}
		}
		throw new IllegalArgumentException("Marca inválida..." );
	}

}
