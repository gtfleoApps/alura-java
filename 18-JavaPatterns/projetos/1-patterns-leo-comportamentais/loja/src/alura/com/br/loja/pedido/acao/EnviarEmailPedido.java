package alura.com.br.loja.pedido.acao;

import alura.com.br.loja.pedido.Pedido;

// Observer-03: Essa classe eh a observer e implementa a interface de acao:
public class EnviarEmailPedido implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Enviando email do pedido ao usuário!");

    }

}
