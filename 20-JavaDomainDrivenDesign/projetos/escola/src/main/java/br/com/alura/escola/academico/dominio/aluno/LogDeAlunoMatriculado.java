package br.com.alura.escola.academico.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;

// DDD-03: Ouvinte (listener) de evento AlunoMatriculado
public class LogDeAlunoMatriculado extends Ouvinte {

    // DDD-04: extends Ouvinte
    // public void reageAo(AlunoMatriculado evento) {
    @Override
    public void reageAo(Evento evento) {
        String momentoFormatado = evento.momento()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println(
                String.format(
                        "Aluno com CPF %s matriculado em %s.",
                        // evento.getCpfDoAluno(),
                        ((AlunoMatriculado) evento).getCpfDoAluno(),
                        momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        // Processa apenas se for evento de AlunoMatriculado:
        return evento instanceof AlunoMatriculado;
    }

}
