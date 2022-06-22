package alura.com.br.loja.imposto;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// Strategy - 01: Interface para uso na classe de implementacao:
public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
