package br.uel.banco;

import java.math.BigDecimal;

public class ContaInvestimento extends Tributavel {
	//tem como superclasse a Tributavel e por causa da tributavel consegue "ligar" com a classe ContaBancaria
	public ContaInvestimento(String nome,String nRoConta) {//construtor
		this.cliente=nome;
		this.numeroConta=nRoConta;
		this.saldo=BigDecimal.valueOf(0);
	}
	
	public void calcularTributo(BigDecimal taxaRendimento) {
		taxaRendimento=taxaRendimento.divide(BigDecimal.valueOf(100));//divido a taxa 
		BigDecimal adicional,tributo;
		adicional=saldo.multiply(taxaRendimento);//adicional vai receber o valor do saldo multiplicado pela taxa de rendimento
		tributo=adicional.multiply(BigDecimal.valueOf(0.005));//multiplica o lucro por 1%
		System.out.print("\nO tributo do lucro da conta " +this.numeroConta +(" ? de: R$"));
		System.out.print(tributo.toString());
	}
	
	public void calcularNovoSaldo(int taxaRendimento) {
		double taxa= (double) taxaRendimento/100;
		BigDecimal adicional;
		adicional=saldo.multiply(BigDecimal.valueOf(taxa));//adicional vai receber o valor do saldo multiplicado pela taxa de rendimento
		saldo=saldo.add(adicional);
		System.out.print("\nRendimento atribuido com sucesso, novo saldo da conta " +this.numeroConta +(" ? de: R$"));
		System.out.print(saldo.toString());
	}
	
	public void calcularTaxaAdministracao(int taxaRendimento) {
		double taxa= (double) taxaRendimento/100;
		BigDecimal adicional,taxaAdm;
		adicional=saldo.multiply(BigDecimal.valueOf(taxa));//adicional vai receber o valor do saldo multiplicado pela taxa de rendimento
		taxaAdm=adicional.multiply(BigDecimal.valueOf(0.01));//multiplica o lucro por 1%
		System.out.print("\nA taxa de rendimento da conta " +this.numeroConta +(" ? de: R$"));
		System.out.print(taxaAdm.toString());
	}

}
