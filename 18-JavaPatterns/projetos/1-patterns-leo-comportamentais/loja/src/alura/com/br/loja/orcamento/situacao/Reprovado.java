package alura.com.br.loja.orcamento.situacao;

import alura.com.br.loja.orcamento.Orcamento;

// State-03: Implementa o que eh especifico do estado Reprovado:
public class Reprovado extends SituacaoOrcamento {

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }

    @Override
    public String toString() {
        return "Reprovado";
    }

}
