package br.uel.banco;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;
public class Principal {

	public static void main(String[] args) {
		Scanner menu = new Scanner (System.in);
		int opcao,subopcao=-1,rendimento;
		String nome,nroConta;
		double saldo,limit,value;
		
		ArrayList<ContaCorrente> cc = new ArrayList<ContaCorrente>();
		ArrayList<ContaPoupanca> cp = new ArrayList<ContaPoupanca>();
		ArrayList<ContaInvestimento> ci = new ArrayList<ContaInvestimento>();
		
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
				System.out.println("Informe o saldo inicial:");
				saldo=menu.nextDouble();
				
				if(subopcao==0) {
					ContaPoupanca poupanca = new ContaPoupanca(nome,nroConta,BigDecimal.valueOf(saldo));
					cp.add(poupanca);
				}
				
				if(subopcao==1) {
					System.out.println("Informe o limite da conta:");
					limit=menu.nextDouble();
					ContaCorrente corrente = new ContaCorrente(nome,nroConta,BigDecimal.valueOf(saldo),BigDecimal.valueOf(limit));
					cc.add(corrente);
				}
				
				if(subopcao==2) {
					ContaInvestimento investimento = new ContaInvestimento(nome,nroConta,BigDecimal.valueOf(saldo));
					ci.add(investimento);
				}
			}
			
			if(opcao==2) {
				System.out.println("Qual tipo da conta? Digite 0 para poupanca, 1 para corrente ou 2 para investimento!");
				subopcao=menu.nextInt();
				
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe o valor que deseja sacar:");
				value=menu.nextDouble();
				
				if(subopcao==0) {
					for(int i = 0; i < cp.size(); i++)
					{
						if(cp.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
							cp.get(i).sacar(BigDecimal.valueOf(value));
						}
					}
				}
				
				if(subopcao==1) {
						for(int i = 0; i < cc.size(); i++)
						{
							if(cc.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
								cc.get(i).sacar(BigDecimal.valueOf(value));
							}
						}
				}
				
				if(subopcao==2) {
					for(int i = 0; i < ci.size(); i++)
					{
						if(ci.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
							ci.get(i).sacar(BigDecimal.valueOf(value));
						}
					}
				}
			}
			
			if(opcao==3) {
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe a taxa de rendimento:");
				rendimento=menu.nextInt();
				for(int i = 0; i < cp.size(); i++)
				{
					if(cp.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
						cp.get(i).calcularNovoSaldo(rendimento);
					}
				}
			}
			
			if(opcao==4) {
				System.out.println("Qual tipo da conta? Digite 0 para poupanca, 1 para corrente ou 2 para investimento!");
				subopcao=menu.nextInt();
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe o valor que deseja depositar:");
				value = menu.nextDouble();
				if(subopcao==0)
				{
					for(int i = 0; i < cp.size(); i++)
					{
						if(cp.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
							cp.get(i).depositar(BigDecimal.valueOf(value));
						}
					}	
				}
				
				if(subopcao==1) {
					for(int i = 0; i < cc.size(); i++)
					{
						if(cc.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
							cc.get(i).depositar(BigDecimal.valueOf(value));
						}
					}
				}
				
				if(subopcao==2) {
					for(int i = 0; i < ci.size(); i++)
					{
						if(ci.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
							ci.get(i).depositar(BigDecimal.valueOf(value));
						}
					}
				}
			}
			
			if(opcao==5) {
				System.out.println("Qual tipo da conta? Digite 0 para poupanca, 1 para corrente ou 2 para investimento!");
				subopcao=menu.nextInt();
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
	
				if(subopcao==0)
				{
					for(int i = 0; i < cp.size(); i++)
					{
						if(cp.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
							System.out.print("\nSaldo disponivel na conta " +(cp.get(i).numeroConta));
							System.out.print(" ? de R$" +cp.get(i).saldo);
						}
					}	
				}
				
				if(subopcao==1) {
					for(int i = 0; i < cc.size(); i++)
					{
						if(cc.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
							System.out.print("\nSaldo disponivel na conta " +(cc.get(i).numeroConta));
							System.out.print(" ? de R$" +cc.get(i).saldo);
						}
					}
				}
				
				if(subopcao==2) {
					for(int i = 0; i < ci.size(); i++)
					{
						if(ci.get(i).numeroConta.equals(nroConta)) {//compara o n? da conta com o n? passado
							System.out.print("\nSaldo disponivel na conta " +(ci.get(i).numeroConta));
							System.out.print(" ? de R$" +ci.get(i).saldo);
						}
					}
				}
			}
			
			if(opcao == 6) {
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe a taxa de rendimento:");
				rendimento=menu.nextInt();
				for(int i = 0; i < ci.size(); i++)
				{
					if(ci.get(i).numeroConta.equals(nroConta))//compara o n? da conta com o n? passado
						ci.get(i).calcularTributo(BigDecimal.valueOf(rendimento));
				}
			}
			
			if(opcao == 7) {
				System.out.println("Informe o numero da conta:");
				menu.nextLine();
				nroConta=menu.nextLine();
				System.out.println("Informe a taxa de rendimento:");
				rendimento=menu.nextInt();
				for(int i = 0; i < ci.size(); i++)
				{
					if(ci.get(i).numeroConta.equals(nroConta))//compara o n? da conta com o n? passado
						ci.get(i).calcularTaxaAdministracao(rendimento);
				}
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
