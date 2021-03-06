package br.uel.banco;

import java.math.BigDecimal;

public abstract class ContaBancaria {
	protected BigDecimal saldo;
	protected String cliente;
	public String numeroConta;
	
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
			System.out.println("Deposito realizado com sucesso, novo saldo disponivel na conta " +this.numeroConta +(" ? de: R$") +saldo.toString());
		}else
			System.out.println("Impossivel depositar valor menor do que 0!");
	}
	
	public boolean equals(Object o){//reescrita do equals 
		ContaBancaria conta = (ContaBancaria)o;//cast
		return conta.numeroConta.equals(this.numeroConta);//retorna verdade se o numero da conta passado for igual ao numero da conta atual 
	}
}
