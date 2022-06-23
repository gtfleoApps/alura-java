package alura.com.br.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import alura.com.br.loja.orcamento.ItemOrcamento;
import alura.com.br.loja.orcamento.Orcamento;
import alura.com.br.loja.pedido.acao.AcaoAposGerarPedido;

// Command Handler-02: Realiza a execucao do comando de geracao de pedido:
public class GeraPedidoHandler {

    // Observer-01: Evita que cada nova acao a ser executada, tenha que ser
    // implementada no handler:
    private List<AcaoAposGerarPedido> acoes;

    // injecao de dependencias para servicos de infra:
    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void executar(GeraPedido geraPedido) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(geraPedido.getValorOrcamento()));
        Pedido pedido = new Pedido(geraPedido.getCliente(), LocalDateTime.now(), orcamento);

        // utilizacao dos servicos de infra:

        // Observer-01: Onde se dispara o evento para classes observer/listener;
        // Executa cada acao especifica da lista de acoes,
        // nao sendo mais necessario realizar implementacoes nesse codigo,
        // em caso de inclusao ou exclusao de acoes de pedido (classes observer).
        acoes.forEach(acao -> acao.executarAcao(pedido));
    }

}
