package alura.com.br.loja.desconto;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// ChainOfResponsability-02: Classe filha com a implementacao de quando nao houver desconto (fim da cadeia)
public class SemDesconto extends Desconto {

    // Nao recebe mais proximo desconto e quebra a cadeia:
    public SemDesconto() {
        super(null);
    }

    // TemplateMethod-02: A classe filha deve implementar os métodos abstratos da
    // classe mãe, mas quem usa/chama eh a classe mae, que possui a logica:
    @Override
    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return true;
    }

}
