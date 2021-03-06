package br.uel.banco;

import java.math.BigDecimal;

public class ContaInvestimento implements ContaBancaria, Tributavel {
	protected BigDecimal saldo;
	protected String cliente;
	public String numeroConta;

	public ContaInvestimento(String nome,String nRoConta,BigDecimal saldo) {//construtor
		this.cliente=nome;
		this.numeroConta=nRoConta;
		this.saldo=saldo;
	}
	
	public void calcularTributo(BigDecimal taxaRendimento) {
		taxaRendimento=taxaRendimento.divide(BigDecimal.valueOf(100));//divido a taxa 
		BigDecimal adicional,tributo;
		adicional=saldo.multiply(taxaRendimento);//adicional vai receber o valor do saldo multiplicado pela taxa de rendimento
		tributo=adicional.multiply(BigDecimal.valueOf(0.005));//multiplica o lucro por 1%
		System.out.print("\nO tributo do lucro da conta " +this.numeroConta +(" ? de: R$"));
		System.out.print(tributo.toString());
	}

	public void sacar(BigDecimal valor) {
			if(valor.compareTo(BigDecimal.ZERO) < 0)//se valor informador for menor que 0 programa finaliza com uma exce??o
				throw new IllegalArgumentException("Erro, valor informado menor que 0!");
			
			if(saldo.compareTo(valor) == -1)
			{
				System.out.println("Saque n?o autorizado, saldo insuficiente!");
				return;
			}
			
			saldo=saldo.subtract(valor);
			System.out.print("\nSaque autorizado, novo saldo disponivel na conta " +this.numeroConta +(" ? de: R$" ));
			System.out.print(saldo.toString());
	}


	public void depositar(BigDecimal valor) {
		if(valor.compareTo(BigDecimal.ZERO) > 0)//se o valor passado pra sacar eh maior que 0
		{
			saldo=saldo.add(valor);//adiciona o valor depositado na conta
			System.out.println("Deposito realizado com sucesso, novo saldo disponivel na conta " +this.numeroConta +(" ? de: R$"));
			System.out.print(saldo.toString());	
		}
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
