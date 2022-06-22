package alura.com.br.loja.desconto;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// ChainOfResponsability-01: Heranca serah usada para controle
public abstract class Desconto {

    protected Desconto proximoDesconto;

    // Ao se instanciar um desconto, deve-se passar o proximo para a cadeia de
    // verificacao:
    public Desconto(Desconto proximoDesconto) {
        this.proximoDesconto = proximoDesconto;
    }

    // TemplateMethod-01: calcular eh o metodo modelo que faz parte do processo,
    // mas outra parte ele delega. Ou seja, a classe mae retira das filhas
    // a estrutura central da logica que seria comum a ambas, mas solicita
    // que as filhas implementem suas logicas especificas:
    public BigDecimal calcular(Orcamento orcamento) {
        if (deveAplicar(orcamento)) {
            // ChainOfResponsability: Se esse desconto for aplicado,
            // interrompe a cadeia aqui:
            return efetuarCalculo(orcamento);
        }

        // ChainOfResponsability: Se o desconto nao foi aplicado, verifica o
        // proximo na cadeia montada:
        return proximoDesconto.calcular(orcamento);
    }

    // abastract Indica que as classes filhas deverão implementar os metodos:
    protected abstract boolean deveAplicar(Orcamento orcamento);

    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);
}
