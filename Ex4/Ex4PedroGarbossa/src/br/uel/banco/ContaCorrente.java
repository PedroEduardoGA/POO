package br.uel.banco;

import java.math.BigDecimal;

public class ContaCorrente implements ContaBancaria {
	protected BigDecimal saldo;
	protected String cliente;
	public String numeroConta;
	BigDecimal limite;
	
	public ContaCorrente(String nome,String nRoConta,BigDecimal saldo,BigDecimal limit) {//construtor
		this.cliente=nome;
		this.numeroConta=nRoConta;
		this.saldo=saldo;
		this.limite=limit;
	}
	
	public void sacar(BigDecimal valor) {
		saldo=saldo.subtract(valor);//subtrai o valor sacado da conta
		BigDecimal limitNeg= limite.negate();//limitNeg vai receber o valor do limite da conta negativado
		if(saldo.compareTo(limitNeg) == 1) {//se for igual 1 quer dizer q o limite negativado ? maior que o saldo
			System.out.print("\nSaque autorizado, novo saldo disponivel na conta " +this.numeroConta +(" ? de: R$"));
			System.out.print(saldo.toString());
		}else
			saldo=saldo.add(valor);
	}

	public void depositar(BigDecimal valor) {
		if(valor.compareTo(BigDecimal.ZERO) > 0)//se o valor passado pra sacar eh maior que 0
		{
			saldo=saldo.add(valor);//adiciona o valor depositado na conta
			System.out.println("Deposito realizado com sucesso, novo saldo disponivel na conta " +this.numeroConta +(" ? de: R$"));
			System.out.print(saldo.toString());	
		}
	}

}
