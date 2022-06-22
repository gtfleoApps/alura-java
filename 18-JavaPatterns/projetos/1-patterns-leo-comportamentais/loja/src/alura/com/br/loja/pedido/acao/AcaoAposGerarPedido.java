package alura.com.br.loja.pedido.acao;

import alura.com.br.loja.pedido.Pedido;

// Observer-02: Interface para execucao de acoes do handler
public interface AcaoAposGerarPedido {

    public void executarAcao(Pedido pedido);
}
