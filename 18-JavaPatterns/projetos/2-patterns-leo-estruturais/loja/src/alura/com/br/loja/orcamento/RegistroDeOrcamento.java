package alura.com.br.loja.orcamento;

import java.util.Map;

import alura.com.br.loja.DomainException;
import alura.com.br.loja.http.HttpAdapter;

public class RegistroDeOrcamento {

    // Adapter-02: Recebe como parametro um atributo adaptador, do tipo interface
    // (flexivel)
    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) {
        if (!orcamento.isFinalizado()) {
            throw new DomainException("Orcamento nao finalizado!");
        }

        String url = "http://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getQuantidadeItens());
        http.post(url, dados);
    }

}
