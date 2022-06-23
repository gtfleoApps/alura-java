package alura.com.br.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import alura.com.br.loja.desconto.CalculadoraDeDescontos;
import alura.com.br.loja.imposto.CalculadoraDeImpostos;
import alura.com.br.loja.imposto.ICMS;
import alura.com.br.loja.imposto.ISS;
import alura.com.br.loja.orcamento.ItemOrcamento;
import alura.com.br.loja.orcamento.Orcamento;
import alura.com.br.loja.pedido.GeraPedido;
import alura.com.br.loja.pedido.GeraPedidoHandler;
import alura.com.br.loja.pedido.acao.EnviarEmailPedido;
import alura.com.br.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class TesteMain {
    public static void main(String[] args) {

        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        System.out.println(orcamento);
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        System.out.println(orcamento);
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        System.out.println(orcamento);

        orcamento.aprovar();
        // orcamento.reprovar();
        System.out.println(orcamento);
        orcamento.finalizar();
        System.out.println(orcamento);

        // Strategy-04: Executando o calculo de acordo com o tipo de implementacao
        // desejada (Strategy-02):
        CalculadoraDeImpostos calculadoraDeImpostos = new CalculadoraDeImpostos();
        System.out.println(calculadoraDeImpostos.calcular(orcamento, new ICMS()));
        System.out.println(calculadoraDeImpostos.calcular(orcamento, new ISS()));

        // ChainOfResponsability-04: Executtando o calculo dos descontos
        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();
        System.out.println(calculadoraDeDescontos.calcular(orcamento));

        // --- State-04: Mudando estado e fazendo calculos de descontos extras:
        System.out.println(orcamento.getSituacao());

        // Command Handler: Separando dados e execucao:
        String clientePedido = "Leo Guerra";
        BigDecimal valorPedido = orcamento.getValor();
        int quantidadeItemPedido = orcamento.getQuantidadeItens();

        GeraPedido gerador = new GeraPedido(clientePedido, valorPedido, quantidadeItemPedido);

        // Observer-04: Agora, basta-se incluir/retirar acoes aqui (desde que cada acao
        // implemente a interface):
        GeraPedidoHandler handler = new GeraPedidoHandler(
                Arrays.asList(
                        new SalvarPedidoNoBancoDeDados(),
                        new EnviarEmailPedido()));

        handler.executar(gerador);
        // --- State-04: Fim

        // Adapter: Executando teste de API
        // TesteAdapter testeAdapter = new TesteAdapter();
        // testeAdapter.testar();

        // Decorator: Executando soma de impostos
        TesteDecorator testeDecorator = new TesteDecorator();
        testeDecorator.testar();

        // Decorator: Executando soma de impostos
        TesteComposicao testeComposicao = new TesteComposicao();
        testeComposicao.testar();
    }
}
