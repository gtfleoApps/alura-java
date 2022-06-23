package alura.com.br.loja;

import java.math.BigDecimal;

import alura.com.br.loja.http.HttpClient;
import alura.com.br.loja.orcamento.ItemOrcamento;
import alura.com.br.loja.orcamento.Orcamento;
import alura.com.br.loja.orcamento.RegistroDeOrcamento;

public class TesteAdapter {

    public void testar() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(BigDecimal.TEN));
        orcamento.aprovar();
        orcamento.finalizar();

        // Adapter-04: Passa para o registro de orcamento a implementacao do adapter.
        // Assim, caso necessario alteracao, basta implementar outra classe do tipo
        // HttpClient:
        RegistroDeOrcamento registro = new RegistroDeOrcamento(new HttpClient());
        registro.registrar(orcamento);
    }

}
