package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoController {

    // Estabelecendo a conexao para acionar a DAO:
    private ProdutoDAO produtoDao;

    public ProdutoController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.produtoDao = new ProdutoDAO(connection);
    }

    public void deletar(Integer id) {
        this.produtoDao.deletar(id);
    }

    public void salvar(Produto produto) {
        this.produtoDao.salvar(produto);
    }

    public List<Produto> listar() {        
        return this.produtoDao.listar();
    }

    public void alterar(String nome, String descricao, Integer id) {
        this.produtoDao.alterar(nome, descricao, id);
    }
}
