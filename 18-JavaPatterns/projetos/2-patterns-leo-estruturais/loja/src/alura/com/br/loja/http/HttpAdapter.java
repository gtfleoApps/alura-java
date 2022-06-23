package alura.com.br.loja.http;

import java.util.Map;

// Adapter-01: A interface eh o adaptador de Http
public interface HttpAdapter {

    void post(String url, Map<String, Object> dados);

}
