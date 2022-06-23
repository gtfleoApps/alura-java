package alura.com.br.loja.impostodec;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// Decorator-02: Implementando o calculo do imposto
public class ISSDec extends ImpostoDec {

    // Com dois construtores, permite-se que o outro imposto seja opcional:
    public ISSDec() {
    }

    public ISSDec(ImpostoDec outroImposto) {
        super(outroImposto);
    }

    public BigDecimal realizarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.06"));
    }

}
