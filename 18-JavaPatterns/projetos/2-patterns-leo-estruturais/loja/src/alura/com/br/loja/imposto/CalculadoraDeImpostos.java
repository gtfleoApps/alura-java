package alura.com.br.loja.imposto;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// Strategy-03: Retorna o imposto calculado, independentemente de qual for (pois estah acoplado aa interface).
// Assim, se surgirem novos impostos, a Calculadora nao precisa ser alterada!
public class CalculadoraDeImpostos {
    public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
        return imposto.calcular(orcamento);
    }
}
