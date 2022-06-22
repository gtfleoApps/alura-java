package alura.com.br.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import alura.com.br.loja.desconto.CalculadoraDeDescontos;
import alura.com.br.loja.imposto.CalculadoraDeImpostos;
import alura.com.br.loja.imposto.ICMS;
import alura.com.br.loja.imposto.ISS;
import alura.com.br.loja.orcamento.Orcamento;
import alura.com.br.loja.pedido.GeraPedido;
import alura.com.br.loja.pedido.GeraPedidoHandler;
import alura.com.br.loja.pedido.acao.EnviarEmailPedido;
import alura.com.br.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class Teste {
    public static void main(String[] args) {
        Orcamento o1 = new Orcamento(new BigDecimal("1000"), 5);
        Orcamento o2 = new Orcamento(new BigDecimal("1000"), 10);
        Orcamento o3 = new Orcamento(new BigDecimal("100"), 5);
        Orcamento o4 = new Orcamento(new BigDecimal("100"), 10);
        o2.aprovar();
        o3.reprovar();
        o4.aprovar();
        o4.finalizar();

        Orcamento orcamento = o4;

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
    }
}
