package br.uel.banco;
import java.util.ArrayList;

public class Agencia {
	public int numeroAgencia;
	private ArrayList<Fila> filaAgencia = new ArrayList<Fila>();
	private ArrayList<Fila> filaPreferencial = new ArrayList<Fila>();
	
	public int getNumeroAgencia() {
		return numeroAgencia;
	}
	
	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
	public ArrayList<Fila> getFilaAgencia() {
		return filaAgencia;
	}
	
	public void setFilaAgencia(ArrayList<Fila> fila) {
		filaAgencia = fila;
	}
	
	public ArrayList<Fila> getFilaPreferencial() {
		return filaPreferencial;
	}
	
	public int posicaoUser(ArrayList<Fila> filaDaAgencia, String nomeDele) {
		String nomeUser;
			
		for(int i = 0; i < filaDaAgencia.size(); i++)
		{
			nomeUser=filaDaAgencia.get(i).getNome();
			if(nomeUser.equals(nomeDele)) {//se o nome da posicao i for igual ao nome passado como parametro retorna a posicao
				return i;
			}
		}
		
		return -1;
	}
	
	public void escritaFila(ArrayList<Fila> filaDaAgencia) {
		
		for(int i = 0; i < filaDaAgencia.size(); i++)
			System.out.printf(" - %s",filaDaAgencia.get(i).getNome());
	}

}
