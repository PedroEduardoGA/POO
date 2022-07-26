package labprog.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import labprog.models.Produto;
import labprog.models.ProdutoDAO;

@SuppressWarnings("serial")
@Named
@ViewScoped			//A classe é "destruida" apos fechar a pagina que interage com ela
public class ProdutoController implements Serializable{
	
	private Produto produto;
	private List<Produto> listaProdutos;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public void buscarPorNome() {
		ProdutoDAO prodDao = new ProdutoDAO();
		
		this.listaProdutos = 
				prodDao.buscar(this.produto.getNome());
	}
	
	public void remover(Produto produto) {
		
		long id = produto.getId();
		ProdutoDAO prodDao = new ProdutoDAO();
		prodDao.excluir(id);
		listaProdutos.remove(produto);
	}
	
	public void alterar(Produto produto) {
		
		ProdutoDAO prodDao = new ProdutoDAO();
		prodDao.alterar(produto);
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Produto foi alterado com sucesso"));
		
	}
	
	public void adicionar() {
		ProdutoDAO prodDao = new ProdutoDAO();
		prodDao.inserir(this.produto);
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Produto inserido com sucesso"));
	}
	
	
	@PostConstruct
	public void init() {
		produto = new Produto();
	}
}
