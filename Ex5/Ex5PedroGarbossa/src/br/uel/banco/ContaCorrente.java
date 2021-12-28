package br.uel.banco;

import java.math.BigDecimal;

public class ContaCorrente extends ContaBancaria {
	BigDecimal limite;
	
	public ContaCorrente(String nome,String nRoConta,BigDecimal limit) {//construtor
		this.cliente=nome;
		this.numeroConta=nRoConta;
		this.limite=limit;
		this.saldo=BigDecimal.valueOf(0);
	}
	
	public void sacarCorrente(BigDecimal valor) {
		saldo=saldo.subtract(valor);//subtrai o valor sacado da conta
		BigDecimal limitNeg= limite.negate();//limitNeg vai receber o valor do limite da conta negativado
		if(saldo.compareTo(limitNeg) == 1) {//se for igual 1 quer dizer q o limite negativado é maior que o saldo
			System.out.print("\nSaque autorizado, novo saldo disponivel na conta " +this.numeroConta +(" é de: R$"));
			System.out.print(saldo.toString());
		}else
			{
				System.out.print("Saque negado, supera o limite da conta!");
				saldo=saldo.add(valor);
			}
			
	}
}
