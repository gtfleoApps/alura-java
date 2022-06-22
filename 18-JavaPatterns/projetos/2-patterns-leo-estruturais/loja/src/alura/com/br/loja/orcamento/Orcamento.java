package alura.com.br.loja.orcamento;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.situacao.EmAnalise;
import alura.com.br.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento {

    private BigDecimal valor;
    private int quantidadeItens;

    // State-01: situacao eh generico (classe mae), para poder receber qualquer
    // estado especifico (classe filha):
    private SituacaoOrcamento situacao;

    public Orcamento(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
        this.situacao = new EmAnalise();
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public int getQuantidadeItens() {
        return this.quantidadeItens;
    }

    public SituacaoOrcamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    // State-01: Eh em orcamento que se trata estado de orcamento;
    // O calculo depende do estado atual do orcamento:
    public void aplicarDescontoExtra() {
        BigDecimal valorDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDescontoExtra);
    }

    // State-01: Mudando os estados via metodos, elimina-se uso de ifs/elses;
    // Lembre-se, o que transita eh todo o orcamento, nao o estado. Assim,
    // a mudanca de estado, do orcamento enviado, fica a cargo da implementacao
    // de situacao da classe filha (quando nao houver, da classe mae):
    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

}
