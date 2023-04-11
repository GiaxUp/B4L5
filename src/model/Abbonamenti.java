package model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.enum_abbonamenti;

public class Abbonamenti extends Cards {

	@Enumerated(EnumType.STRING)
	private enum_abbonamenti durata_abbonamento;

}
