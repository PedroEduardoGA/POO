package br.uel.banco;

import java.math.BigDecimal;

public abstract class Tributavel extends ContaBancaria {
	//tem como superclasse a ContaBancaria
	public abstract void calcularTributo(BigDecimal taxaRendimento);
}
