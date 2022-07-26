package labprog.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import labprog.services.ConnectionFactory;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void inserir(Produto produto){
		
		String sql = 
				"INSERT INTO produto (NOME, PRECO, QUANTIDADE) VALUES (?,?,?)";
		
		//prepared statement -> consulta parametrizada
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setString(1, produto.getNome());
			prstate.setDouble(2, produto.getPreco());
			prstate.setInt(3, produto.getQuantidade());
			
			prstate.execute();
			
			prstate.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}	
	}
	
	public List<Produto> buscar(String nome){
		
		String sql = 
				"SELECT * FROM produto WHERE NOME LIKE UPPER(?)";
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		//prepared statement -> consulta parametrizada
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setString(1, new String("%"+nome+"%").toUpperCase());
					
			ResultSet resultado = 
					prstate.executeQuery();
			
			while (resultado.next()){
				Produto produto = new Produto();
				produto.setId(resultado.getLong("ID"));
				produto.setNome(resultado.getString("NOME"));
				produto.setQuantidade(Integer.valueOf(resultado.getString("QUANTIDADE")));
				produto.setPreco(Double.valueOf(resultado.getString("PRECO")));
				
				produtos.add(produto);
			}
			resultado.close();
			prstate.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return produtos;
		
	}
	
	public Produto buscarPorId(Long id){
		
		String sql = 
				"SELECT * FROM produto WHERE ID = ?";
		
		Produto produto = new Produto();
		
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setLong(1, id);
					
			ResultSet resultado = 
					prstate.executeQuery();
			
			resultado.next();
			
			
			produto.setId(resultado.getLong("ID"));
			produto.setNome(resultado.getString("NOME"));
			produto.setQuantidade(Integer.valueOf(resultado.getString("QUANTIDADE")));
			produto.setPreco(Double.valueOf(resultado.getString("PRECO")));
			
			resultado.close();
			prstate.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return produto;
	}
	
	public void alterar(Produto produto){
		
		String sql = 
				"UPDATE produto SET NOME=?, QUANTIDADE=?, PRECO=? WHERE ID=?";
		
		//prepared statement -> consulta parametrizada
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setString(1, produto.getNome());
			prstate.setInt(2, produto.getQuantidade());
			prstate.setDouble(3, produto.getPreco());
			prstate.setLong(4, produto.getId());
			
			prstate.execute();
			
			prstate.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
				
		
	}
	
	public void excluir(Long id){
		
		String sql = "DELETE FROM produto WHERE ID=?";
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setLong(1, id);
			prstate.execute();
			
			prstate.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
				
		
	}
}
