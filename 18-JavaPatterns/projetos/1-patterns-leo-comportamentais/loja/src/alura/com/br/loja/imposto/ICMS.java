package alura.com.br.loja.imposto;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// Strategy-02: Implementando o calculo do imposto
public class ICMS implements Imposto {

    public BigDecimal calcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

}
