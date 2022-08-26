package br.com.alura.escola.shared.dominio.evento;

import java.time.LocalDateTime;
import java.util.Map;

// DDD-02: Representa um Evento - tudo o que for generico de eventos, fica nessa interface
// DDD-06: Shared Kernel - Retira de Academico/Dominio,
// pois agora estah num contexto compartilhado (academico e gameficacao)
public interface Evento {

    // metodo momento retorna localDateTime (quando o evento aconteceu):
    LocalDateTime momento();

    // DDD-07: Metodo do Enum que retorna o tipo de evento:
    TipoDeEvento tipo();

    // DDD-08: Metodo que retorna informacoes do Aluno:
    Map<String, Object> informacoes();

}
