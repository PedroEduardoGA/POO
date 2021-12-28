package br.uel.banco;

import java.math.BigDecimal;

public interface Tributavel {
	public void calcularTributo(BigDecimal taxaRendimento);
}
