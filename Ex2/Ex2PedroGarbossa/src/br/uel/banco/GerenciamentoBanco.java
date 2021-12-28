package br.uel.banco;

import java.util.Scanner;

public class GerenciamentoBanco {

	public static void main(String[] args) {
		Scanner menu = new Scanner (System.in);
		
		int opcao = -1,posicao,idade,i=0,atendido=0;
		String nome;
		
		
		Agencia agencia1604= new Agencia();
		
		while(opcao!=0) {
			
			System.out.print("\nO que deseja fazer?\n");
			System.out.print("1- Entra na Fila\n");
			System.out.print("2- Desistir da Fila\n");
			System.out.print("3- Atender Cliente\n");
			System.out.print("4- Buscar Posição\n");
			System.out.print("5- Imprimir\n");
	
			System.out.print("Tecle 0 para Sair\n");
			opcao = menu.nextInt();
			
			if(opcao==1) {
				Fila usuarioNovo = new Fila();
				
				System.out.println("Digite o nome da pessoa:");
				menu.nextLine();
				nome=menu.nextLine();
				usuarioNovo.setNome(nome);
				
				System.out.println("Digite a hora de chegada do(a) " +(nome) +(" :"));
				usuarioNovo.setHora(menu.nextLine());
				
				System.out.println("Digite a idade do(a) " +(nome) +(" :"));
				idade=menu.nextInt();
				usuarioNovo.setIdade(idade);
				
				System.out.println("Digite o serviço do(a) " +(nome) +(" :"));
				menu.nextLine();
				usuarioNovo.setServico(menu.nextLine());
				
				if(idade < 65)
					agencia1604.getFilaAgencia().add(usuarioNovo);//adiciona o usuario novo na lista
				else
					agencia1604.getFilaPreferencial().add(usuarioNovo);//se a pessoa for mais velha q 65 anos vai pra fila preferencial
			}
			
			if(opcao==2) {
				System.out.println("Digite o nome do(a) desisente:");
				menu.nextLine();
				nome=menu.nextLine();
				
				System.out.println("Digite a idade do(a) " +(nome) +(" :"));
				idade=menu.nextInt();
				
				if(idade < 65)
					posicao=agencia1604.posicaoUser(agencia1604.getFilaAgencia(), nome);
				else
					posicao=agencia1604.posicaoUser(agencia1604.getFilaPreferencial(), nome);
				
				if(posicao == -1) {
					System.out.println("Pessoa: " +nome +(" não esta na fila!"));
					break;
				}
				
				if(idade < 65)
					agencia1604.getFilaAgencia().remove(posicao);//removera o usuario que estiver na posicao da fila
				else
					agencia1604.getFilaPreferencial().remove(posicao);
				
				System.out.println(""+nome +(" foi removido da fila!"));
			}
			
			if(opcao==3) {	
				while(atendido != 1) {//se alguma pessoa for atendida vai sair do laço
					
					if(i==0)//i intercal entre 0 e 1 para saber qnd atender algm de qual fila
					{
						if(agencia1604.getFilaPreferencial().isEmpty()) {
							System.out.println("Fila prefencial esta vazia!");
							i++;
						}else
							{
								System.out.println(agencia1604.getFilaPreferencial().get(0).getNome() +(" foi atendido na fila preferencial!"));
								System.out.println("idade: " +agencia1604.getFilaPreferencial().get(0).getIdade());
								System.out.println("Hora de chegada: " +agencia1604.getFilaPreferencial().get(0).getHora());
								System.out.println("serviço realizado: " +agencia1604.getFilaPreferencial().get(0).getServico());
								agencia1604.getFilaPreferencial().remove(0);
								i++;
								atendido=1;
							}
					}else
						{
							if(agencia1604.getFilaAgencia().isEmpty()) {
								System.out.println("Fila normal esta vazia!");
								i--;
							}else
								{
									System.out.println(agencia1604.getFilaAgencia().get(0).getNome() +(" foi atendido na fila normal!"));
									System.out.println("idade: " +agencia1604.getFilaAgencia().get(0).getIdade());
									System.out.println("Hora de chegada: " +agencia1604.getFilaAgencia().get(0).getHora());
									System.out.println("serviço realizado: " +agencia1604.getFilaAgencia().get(0).getServico());
									agencia1604.getFilaAgencia().remove(0);
									i--;
									atendido=1;
								}
						}//final if do i	
				}//final while se usuario foi ou nao atendido
				atendido=0;
			}
			
			if(opcao==4) {//retorna a posicao da pessoa nome
				System.out.println("Digite o nome do(a) usuario que deseja buscar:");
				menu.nextLine();
				nome=menu.nextLine();
				
				posicao=agencia1604.posicaoUser(agencia1604.getFilaAgencia(), nome);
				if(posicao == -1)
					posicao=agencia1604.posicaoUser(agencia1604.getFilaPreferencial(), nome);
				
				if(posicao == -1) {
					System.out.println("Pessoa: " +nome +("não esta em nenhuma das filas!"));
					break;
				}
					
				System.out.println(""+nome +(" esta no ") +(posicao+1) +("º lugar da fila!"));
			}
			
			if(opcao==5) {//escreve as filas
				System.out.println("Fila normal:");
				agencia1604.escritaFila(agencia1604.getFilaAgencia());
				System.out.println("\nFila preferencial:");
				agencia1604.escritaFila(agencia1604.getFilaPreferencial());
			}
			
			if(opcao > 5 || opcao < 0)
				System.out.println("Opção Inválida!");
			
			if(opcao==0) {
				System.out.println("Menu encerrado!");
				menu.close();
				break;
			}	
		}
		System.out.println("Programa finalizado, Até logo!");

	}

}
