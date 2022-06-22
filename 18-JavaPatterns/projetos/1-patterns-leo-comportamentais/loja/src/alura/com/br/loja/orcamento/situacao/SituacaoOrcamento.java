package alura.com.br.loja.orcamento.situacao;

import java.math.BigDecimal;

import alura.com.br.loja.DomainException;
import alura.com.br.loja.orcamento.Orcamento;

// State-02: Classe mae, a ser utilizada pelas classes filhas de cada estado;
// Possui todos os possiveis metodos de mudancas de estado e calculo, mas 
// apenas lancando execessoes genericas e valores padroes. Eh nas classes filhas,
//  que se encontram as devidas implementacoes, de acordo com seu proprio controle 
// de mudanca de estado.
public abstract class SituacaoOrcamento {

    // Retorno padrao para o calculo de desconto extra:
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    // Excessoes padroes para mudanca de estados:
    public void aprovar(Orcamento orcamento) {
        throw new DomainException("Orcamento nao pode ser aprovado!");
    }

    public void reprovar(Orcamento orcamento) {
        throw new DomainException("Orcamento nao pode ser reprovado!");
    }

    public void finalizar(Orcamento orcamento) {
        throw new DomainException("Orcamento nao pode ser finalizado!");
    }

}
