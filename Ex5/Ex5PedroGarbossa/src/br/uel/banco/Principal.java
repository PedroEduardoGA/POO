package br.uel.banco;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

public abstract class Principal {

	public static void main(String[] args) {
		Scanner menu = new Scanner (System.in);
		int opcao,subopcao=-1,rendimento,indice;
		String nome,nroConta;
		double limit,value;
		
		ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();
		
		System.out.println("========Bem vindo ao P.O.O Bank!========");
		do{
			System.out.println("\nO que deseja fazer?");
			System.out.println("1- Cadastrar nova conta");
			System.out.println("2- Sacar um valor da conta");
			System.out.println("3- Atualizar conta com o rendimento");
			System.out.println("4- Depositar na conta");
			System.out.println("5- Mostrar saldo da conta");
			System.out.println("6- Calcular os tributos da conta");
			System.out.println("7- Calcular taxa da conta");
			System.out.println("Tecle 0 para Sair");
			opcao = menu.nextInt();
			
			if(opcao==1) {
				System.out.println("Qual tipo de conta deseja adicionar? Digite 0 para poupanca, 1 para corrente ou 2 para investimento!");
				subopcao=menu.nextInt();
				
				System.out.println("Informe o nome do cliente:");
				menu.nextLine();
				nome=menu.nextLine();
				System.out.println("Informe o numero da conta:");
				nroConta=menu.nextLine();
				
				if(subopcao==0) {
					System.out.println("Informe o dia do rendimento:");
					rendimento=menu.nextInt();
					ContaBancaria conta = new ContaPoupanca(nome,nroConta, rendimento);
					((ContaPoupanca)conta).setDiaRendimento(rendimento);//cast
					contas.add(conta);
				}
				
				if(subopcao==1) {
					System.out.println("Informe o limite da conta:");
					limit=menu.nextDouble();
					ContaBancaria conta = new ContaCorrente(nome,nroConta,BigDecimal.valueOf(limit));
					contas.add(conta);
				}
				
				if(subopcao==2) {
					ContaBancaria conta = new ContaInvestimento(nome,nroConta);
					contas.add(conta);
				}
			}
			
			if(opcao==2) {
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe o valor que deseja sacar:");
				value=menu.nextDouble();
				ContaBancaria conta = new ContaCorrente(null, nroConta, null);//crio uma conta "temporaria"
				
				indice= contas.indexOf(conta);//percorro a lista das contas buscando a conta que possuir aquele numero
				if(indice != -1) {
					conta=contas.get(indice);
					if (conta instanceof ContaCorrente) {//se a conta pega com aquele numero ? uma instancia de conta corrente
						((ContaCorrente) conta).sacarCorrente(BigDecimal.valueOf(value));
					}else
						contas.get(indice).sacar(BigDecimal.valueOf(value));
					}else
							System.out.println("Conta inexistente!");
			}
					
			if(opcao==3) {
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe a taxa de rendimento:");
				rendimento=menu.nextInt();
				ContaBancaria conta= new ContaPoupanca(null, nroConta, 0);//crio uma conta "temporaria"
				
				indice= contas.indexOf(conta);//percorro a lista das contas buscando o indice da conta que possuir aquele numero
				if(indice != -1) {
					conta=contas.get(indice);
					if (conta instanceof ContaPoupanca) {//se a conta pega com aquele indice ? uma instancia de conta poupanca
						((ContaPoupanca) conta).calcularNovoSaldo(rendimento);			
					}else
						System.out.println("Conta: " +nroConta +(" n?o ? do tipo conta Poupanca!"));
				}else
					System.out.println("Conta inexistente!");
			}
			
			if(opcao==4) {
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe o valor que deseja depositar:");
				value = menu.nextDouble();
				ContaBancaria conta= new ContaCorrente(null, nroConta, null);//crio uma conta "temporaria"
				
				indice= contas.indexOf(conta);//percorro a lista das contas buscando o indice da conta que possuir aquele numero
				if(indice != -1) {
					contas.get(indice).depositar(BigDecimal.valueOf(value));
				}else
					System.out.println("Conta inexistente!");
			}
			
			if(opcao==5) {
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				ContaBancaria conta= new ContaCorrente(null, nroConta, null);//crio uma conta "temporaria"
	
				indice= contas.indexOf(conta);//percorro a lista das contas buscando o indice da conta que possuir aquele numero
				if(indice != -1) {
					System.out.print("\nSaldo disponivel na conta " +contas.get(indice).numeroConta);
					System.out.print(" ? de R$" +contas.get(indice).saldo);
				}else
					System.out.println("Conta inexistente!");
			}
			
			if(opcao == 6) {
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe a taxa de rendimento:");
				rendimento=menu.nextInt();
				ContaBancaria conta= new ContaInvestimento(null, nroConta);//ContaBancaria();
				//conta.numeroConta=nroConta;
				
				indice= contas.indexOf(conta);//percorro a lista das contas buscando o indice da conta que possuir aquele numero
				if(indice != -1) {
					conta=contas.get(indice);
					if (conta instanceof ContaInvestimento) {//se a conta pega com aquele indice ? uma instancia de conta investimento
						((ContaInvestimento) conta).calcularTributo(BigDecimal.valueOf(rendimento));			
					}else
						System.out.println("Conta: " +nroConta +(" n?o ? do tipo conta Investimento!"));
				}else
					System.out.println("Conta inexistente!");
			}
			
			if(opcao == 7) {
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe a taxa de rendimento:");
				rendimento=menu.nextInt();
				ContaBancaria conta= new ContaInvestimento(null, nroConta);//crio uma conta "temporaria"
				
				indice= contas.indexOf(conta);//percorro a lista das contas buscando o indice da conta que possuir aquele numero
				if(indice != -1) {
					conta=contas.get(indice);
					if (conta instanceof ContaInvestimento) {//se a conta pega com aquele indice ? uma instancia de conta investimento
						((ContaInvestimento) conta).calcularTaxaAdministracao(rendimento);			
					}else
						System.out.println("Conta: " +nroConta +(" n?o ? do tipo conta Investimento!"));
				}else
					System.out.println("Conta inexistente!");
			}
			
			if(opcao > 7 || opcao < 0)
				System.out.println("Op??o Inv?lida!");
			
			if(opcao==0) {
				System.out.println("Menu encerrado!");
				menu.close();
			}	
		}while(opcao!=0);
		System.out.println("Atendimento finalizado, o P.O.O Bank agradece sua prefer?ncia!");
	}

}
