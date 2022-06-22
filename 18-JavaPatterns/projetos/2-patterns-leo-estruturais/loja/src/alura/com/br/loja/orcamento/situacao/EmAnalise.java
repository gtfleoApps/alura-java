package alura.com.br.loja.orcamento.situacao;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.Orcamento;

// State-03: Implementa o que eh especifico do estado Em Analise:
public class EmAnalise extends SituacaoOrcamento {

    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public void aprovar(Orcamento orcamento) {
        orcamento.setSituacao(new Aprovado());
    }

    @Override
    public void reprovar(Orcamento orcamento) {
        orcamento.setSituacao(new Reprovado());
    }

    @Override
    public String toString() {
        return "Em Analise";
    }

}
