package labprog.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import labprog.models.Produto;
import labprog.models.ProdutoCart;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class CarrinhoController implements Serializable{
	List<ProdutoCart> carrinhoCompras;
	double totalCompra = 0;
	
	public void adicionar(Produto produtoBase) {
		int i = getIndex(produtoBase.getNome());
		if( i > -1) {					//Produto existe na lista
			ProdutoCart produto = copiaPropriedades(produtoBase,carrinhoCompras.get(i).getQuantidade());
			
			if(produto == null) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage("Quantidade maxima atingida!"));
				return;
			}
			carrinhoCompras.set(i, produto);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Adicionado mais uma quantidade!"));
			
		}else {
			ProdutoCart produto = copiaPropriedades(produtoBase,0);
			
			if(produto == null) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage("Quantidade maxima atingida!"));
				return;
			}
			
			carrinhoCompras.add(produto);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Produto adicionado ao carrinho"));
		}
		
		setValorTotal();
	}
	
	public ProdutoCart copiaPropriedades(Produto produtoBase,Integer quantidade) {
		ProdutoCart produto = new ProdutoCart();
		
		produto.setId(produtoBase.getId());
		produto.setNome(produtoBase.getNome());
		produto.setPreco(produtoBase.getPreco());
		produto.setQtdLimite(produtoBase.getQuantidade());
		produto.setQuantidade(quantidade+1);
		produto.setValorTotal(produto.getQuantidade()*produto.getPreco());
		
		if(produto.getQuantidade() > produto.getQtdLimite())
			return null;		//Nao tem mais desse produto em estoque
		
		return produto;
	}
	
	public Integer getIndex(String nome) {					//Retorna o indice do produto caso esteja no carrinho
		for(int i=0; i < carrinhoCompras.size(); i++) {
			if(carrinhoCompras.get(i).getNome().equals(nome))
				return i;
		}
		return -1;
	}

	public void removerCompra(ProdutoCart produto) {
		int i = getIndex(produto.getNome());
		int qtd = carrinhoCompras.get(i).getQuantidade();
		
		if(qtd > 1) {
			carrinhoCompras.get(i).setQuantidade(qtd-1);
			carrinhoCompras.get(i).setValorTotal((qtd-1)*carrinhoCompras.get(i).getPreco());
		}else
			carrinhoCompras.remove(produto);
		
		setValorTotal();
	}
	
	public void setValorTotal() {
		this.totalCompra = 0;
		
		for(ProdutoCart produto : carrinhoCompras)
			this.totalCompra += produto.getValorTotal();
		
	}
	
	public double getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}
	public List<ProdutoCart> getCarrinhoCompras() {
		return carrinhoCompras;
	}

	public void setCarrinhoCompras(List<ProdutoCart> carrinhoCompras) {
		this.carrinhoCompras = carrinhoCompras;
	}
	
	@PostConstruct
	public void init() {
		carrinhoCompras = 
				new ArrayList<ProdutoCart>();
	}
	
}
