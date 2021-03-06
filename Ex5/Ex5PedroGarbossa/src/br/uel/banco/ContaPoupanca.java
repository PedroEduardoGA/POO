package br.uel.banco;

import java.math.BigDecimal;

public class ContaPoupanca extends ContaBancaria {
	public int diaRendimento;

	public ContaPoupanca(String nome,String nRoConta,int diaRendimento) {
		this.cliente=nome;
		this.numeroConta=nRoConta;
		this.diaRendimento=diaRendimento;
		this.saldo=BigDecimal.valueOf(0);
	}
	
	public int getDiaRendimento() {
		return diaRendimento;
	}

	public void setDiaRendimento(int diaRendimento) {
		this.diaRendimento = diaRendimento;
	}

	public void calcularNovoSaldo(int taxaRendimento) {
		double taxa= (double) taxaRendimento/100;
		BigDecimal adicional;
		adicional=saldo.multiply(BigDecimal.valueOf(taxa));//adicional vai receber o valor do saldo multiplicado pela taxa de rendimento
		saldo=saldo.add(adicional);
		System.out.print("\nRendimento atribuido com sucesso, novo saldo da conta " +this.numeroConta +(" ? de: R$"));
		System.out.print(saldo.toString());
	}

}
