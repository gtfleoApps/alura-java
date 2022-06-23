package alura.com.br.loja.impostodec;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// Decorator-03: Retorna a soma do calculo de mais de imposto(s)
public class CalculadoraDeImpostosDec {
    public BigDecimal calcular(Orcamento orcamento, ImpostoDec imposto) {
        return imposto.calcular(orcamento);
    }
}
