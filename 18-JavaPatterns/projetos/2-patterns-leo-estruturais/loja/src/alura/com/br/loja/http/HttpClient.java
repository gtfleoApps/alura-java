package alura.com.br.loja.http;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

// Adapter-03: Implementacao da interface do adapter:
public class HttpClient implements HttpAdapter {

    @Override
    public void post(String url, Map<String, Object> dados) {
        // Disparar requisicao usando API do java:
        try {
            URL urlDaApi = new URL(url);
            URLConnection connection = urlDaApi.openConnection();
            connection.connect();
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException("Erro ao enviar requisicao HTTP", e);
        }

    }

}
