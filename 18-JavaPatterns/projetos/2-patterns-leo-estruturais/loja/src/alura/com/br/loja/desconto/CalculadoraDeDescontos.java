package alura.com.br.loja.desconto;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// ChainOfResponsability-03: Implementacao da Calculadora, utiliando cadeia de descontos (ChainOfResponsability-02):
public class CalculadoraDeDescontos {

    public BigDecimal calcular(Orcamento orcamento) {
        // Tipo como sendo Desconto (classe mae, mas instacias de descontos com proximos
        // descontos)
        Desconto desconto = new DescontoOrcamentoQuantidadeItens(
                new DescontoOrcamentoValor(
                        new SemDesconto()));
        return desconto.calcular(orcamento);
    }
}
