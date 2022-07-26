package labprog.models;

public class ProdutoCart extends Produto{
	
	Double valorTotal;
	Integer qtdLimite;
	
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQtdLimite() {
		return qtdLimite;
	}
	public void setQtdLimite(Integer qtdLimite) {
		this.qtdLimite = qtdLimite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public boolean equals(Object obj) {
		ProdutoCart tht = (ProdutoCart)obj;
		return this.id.equals(tht.id);
	}
}
