package alura.com.br.loja;

import java.math.BigDecimal;

import alura.com.br.loja.orcamento.ItemOrcamento;
import alura.com.br.loja.orcamento.Orcamento;
import alura.com.br.loja.orcamento.OrcamentoProxy;

public class TesteComposicao {

    public void testar() {
        Orcamento antigo = new Orcamento();
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.reprovar();

        // Reaproveitando o orcamento antigo:
        Orcamento novo = new Orcamento();
        novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));

        // Composite-05: Apos implementacao do orcavel:
        novo.adicionarItem(antigo);

        // Proxy-03: Se o valor ja foi recuperado, traz o que estah em memoria (cache):
        OrcamentoProxy proxy = new OrcamentoProxy(novo);
        System.out.println("Novo Orcamento: " + novo.getQuantidadeItens() + " itens = R$ " + proxy.getValor());
        System.out.println("Novo Orcamento: " + novo.getQuantidadeItens() + " itens = R$ " + proxy.getValor());
    }
}
