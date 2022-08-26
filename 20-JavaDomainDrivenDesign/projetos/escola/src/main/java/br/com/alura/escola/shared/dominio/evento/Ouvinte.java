package br.com.alura.escola.shared.dominio.evento;

// DDD-04: Representa um Ouvinte de um evento, independente de qual evento seja.
// DDD-06: Shared Kernel - Retira de Academico/Dominio,
// pois agora estah num contexto compartilhado (academico e gameficacao)
public abstract class Ouvinte {

    // Processa o evento
    public void processa(Evento evento) {
        if (this.deveProcessar(evento)) {
            this.reageAo(evento);
        }
    }

    // Cada classe especifica que vai dizer os metodo devem ser processados:
    protected abstract boolean deveProcessar(Evento evento);

    protected abstract void reageAo(Evento evento);

}
