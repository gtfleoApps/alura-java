package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}

	public Produto buscarPorId(Long id) {
		// busca pela chave da tabela:
		return em.find(Produto.class, id);
	}

	public List<Produto> buscarTodos() {
		// No JPQL nao se usa o nome da tabela, mas o nome da entidade (classe);
		// p foi o alias dado para Produto, ou seja, carrega o objeto Produto (entidade
		// inteira e seus atributos).
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}

	public List<Produto> buscarPorNomeDaCategoria(String nome) {
		// Join automatico por conta da definicao em Produto:
		// @ManyToOne
		// private Categoria categoria;
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class) // retorna da classe objeto do tipo Produto
				.setParameter("nome", nome)
				.getResultList();
	}

	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class) // retorna da classe objeto do tipo BigDecimal (preço)
				.setParameter("nome", nome)
				.getSingleResult();
	}

}
