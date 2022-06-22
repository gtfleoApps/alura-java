package alura.com.br.loja.desconto;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// ChainOfResponsability-02: Classe filha com a implementacao do desconto
public class DescontoOrcamentoValor extends Desconto {
    // Construtor da classe filha com o proximoDesconto:
    public DescontoOrcamentoValor(Desconto proximoDesconto) {
        super(proximoDesconto);
    }

    // TemplateMethod-02: A classe filha deve implementar os métodos abstratos da
    // classe mãe, mas quem usa/chama eh a classe mae, que possui a logica:
    @Override
    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
    }
}
