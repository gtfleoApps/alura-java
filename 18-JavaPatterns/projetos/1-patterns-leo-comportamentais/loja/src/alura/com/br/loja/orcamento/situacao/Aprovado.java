package alura.com.br.loja.orcamento.situacao;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// State-03: Implementa o que eh especifico do estado Aprovado:
public class Aprovado extends SituacaoOrcamento {

    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.02"));
    }

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }

    @Override
    public String toString() {
        return "Aprovado";
    }

}
