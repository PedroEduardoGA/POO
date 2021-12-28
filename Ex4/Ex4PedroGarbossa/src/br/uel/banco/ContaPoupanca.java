package br.uel.banco;

import java.math.BigDecimal;

public class ContaPoupanca implements ContaBancaria {
	protected BigDecimal saldo;
	protected String cliente;
	public String numeroConta;
	public int diaRendimento;
	
	public ContaPoupanca(String nome,String nRoConta,BigDecimal saldo) {//construtor
		this.cliente=nome;
		this.numeroConta=nRoConta;
		this.saldo=saldo;
		this.diaRendimento=5;//dia 5 do mes é o dia do rendimento
	}
	
	public void sacar(BigDecimal valor) {
		if(valor.compareTo(BigDecimal.ZERO) < 0)//se valor informador for menor que 0 programa finaliza com uma exceção
			throw new IllegalArgumentException("Erro, valor informado menor que 0!");
		
		if(saldo.compareTo(valor) == -1)
		{
			System.out.println("Saque não autorizado, saldo insuficiente!");
			return;
		}
		
		saldo=saldo.subtract(valor);
		System.out.print("\nSaque autorizado, novo saldo disponivel na conta " +this.numeroConta +(" é de: R$" ));
		System.out.print(saldo.toString());
	}

	public void depositar(BigDecimal valor) {
		if(valor.compareTo(BigDecimal.ZERO) > 0)//se o valor passado pra sacar eh maior que 0
		{
			saldo=saldo.add(valor);//adiciona o valor depositado na conta
			System.out.println("Deposito realizado com sucesso, novo saldo disponivel na conta " +this.numeroConta +(" é de: R$"));
			System.out.print(saldo.toString());	
		}

	}
	
	public void calcularNovoSaldo(int taxaRendimento) {
		double taxa= (double) taxaRendimento/100;
		BigDecimal adicional;
		adicional=saldo.multiply(BigDecimal.valueOf(taxa));//adicional vai receber o valor do saldo multiplicado pela taxa de rendimento
		saldo=saldo.add(adicional);
		System.out.print("\nRendimento atribuido com sucesso, novo saldo da conta " +this.numeroConta +(" é de: R$"));
		System.out.print(saldo.toString());
	}

}
