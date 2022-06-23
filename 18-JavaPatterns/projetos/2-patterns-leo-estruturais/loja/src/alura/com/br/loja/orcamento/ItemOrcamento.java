package alura.com.br.loja.orcamento;

import java.math.BigDecimal;

// Composite-01: Separando itens que pode existir no orcamento, numa classe separada:
// Composite-04: Implementa interface orcavel
public class ItemOrcamento implements Orcavel {
    private BigDecimal valor;

    public ItemOrcamento(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }

}
