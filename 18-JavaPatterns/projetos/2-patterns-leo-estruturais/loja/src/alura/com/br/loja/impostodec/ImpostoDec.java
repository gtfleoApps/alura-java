package alura.com.br.loja.impostodec;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// Decorator-01: uma composicao de impostos, que permite a
// soma de impostos diferentes, sempre que necessario.
// Eh abstrata para ser usada como classe mae em herancas: 
public abstract class ImpostoDec {

    private ImpostoDec outroImposto;

    // Com dois construtores, permite-se que o outro imposto seja opcional:
    public ImpostoDec() {
    }

    public ImpostoDec(ImpostoDec outroImposto) {
        this.outroImposto = outroImposto;
    }

    // O calculo serah realizado nas classes filhas, de acordo com regras proprias
    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

    // Chama as classes filhas para calculo de cada imposto e depois soma todos:
    public BigDecimal calcular(Orcamento orcamento) {
        BigDecimal valorImposto = realizarCalculo(orcamento);

        // Como o outro imposto eh opcional, deve ser inicializado
        BigDecimal valorOutroImposto = BigDecimal.ZERO;

        if (outroImposto != null) {
            valorOutroImposto = outroImposto.realizarCalculo(orcamento);
        }

        // Somando os impostos:
        return valorImposto.add(valorOutroImposto);

    }
}
