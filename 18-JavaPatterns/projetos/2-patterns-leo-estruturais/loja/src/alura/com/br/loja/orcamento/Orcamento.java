package alura.com.br.loja.orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import alura.com.br.loja.orcamento.situacao.EmAnalise;
import alura.com.br.loja.orcamento.situacao.Finalizado;
import alura.com.br.loja.orcamento.situacao.SituacaoOrcamento;

// Composite-04: Implementa orcavel
public class Orcamento implements Orcavel {

    private BigDecimal valor;
    // private int quantidadeItens;

    // Composite-02: Incluindo os itens do orcamento:
    // private List<ItemOrcamento> itens;

    // Composite-04: Substitui item orcamento por qualquer orcavel
    // (podendo agora ser item ou orcamento):
    private List<Orcavel> itens;

    // State-01: situacao eh generico (classe mae), para poder receber qualquer
    // estado especifico (classe filha):
    private SituacaoOrcamento situacao;

    // Composite-02: Construtor anterior:
    // public Orcamento(BigDecimal valor, int quantidadeItens) {
    // this.valor = valor;
    // this.quantidadeItens = quantidadeItens;
    // this.situacao = new EmAnalise();
    // }
    // Composite-02: Refazimento do construtor:
    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.itens = new ArrayList<>();
        this.situacao = new EmAnalise();
    }

    @Override
    public BigDecimal getValor() {
        // Proxy-02: Simulando um tempo de resposta com Thread:
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this.valor;
    }

    public int getQuantidadeItens() {
        // Composite-02: quantidade de itens anterior
        // return this.quantidadeItens;
        // Composite-02: quantidade de itens eh o tamanho do array:
        return this.itens.size();
    }

    public SituacaoOrcamento getSituacao() {
        return this.situacao;
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

    public boolean isFinalizado() {
        return this.situacao instanceof Finalizado;
    }

    // Composite-02: Adicionando itens
    // Composite-04: Substitui item orcamento por qualquer orcavel
    public void adicionarItem(Orcavel item) {
        this.itens.add(item);
        this.valor = this.valor.add(item.getValor());
    }

}
