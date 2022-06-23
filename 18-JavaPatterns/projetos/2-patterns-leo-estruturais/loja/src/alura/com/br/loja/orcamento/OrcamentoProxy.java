package alura.com.br.loja.orcamento;

import java.math.BigDecimal;

// Proxy-01: inteceptacao de requisicao para orcamento
public class OrcamentoProxy extends Orcamento {
    // informacao a ficar em cache/memoria:
    private BigDecimal valor;
    private Orcamento orcamento;

    public OrcamentoProxy(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    // Proxy-01: intercepta o getValor de orcamento, para trazer o valor de memoria:
    @Override
    public BigDecimal getValor() {
        if (valor == null) {
            this.valor = orcamento.getValor();
        }
        return this.valor;
    }

}
