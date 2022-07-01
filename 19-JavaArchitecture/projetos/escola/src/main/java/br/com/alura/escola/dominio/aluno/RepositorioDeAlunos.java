package br.com.alura.escola.dominio.aluno;

import java.util.List;

// Classe-06:
// Representa o contrato (metodos) para serem usados (implementados) na camada de infraestrutura
// Indica "o que" precisa ser feito, não o "como"
public interface RepositorioDeAlunos {

    // Metodo que ira salvar no bd (com nomenclatura de negocio)
    void matricular(Aluno aluno);

    Aluno buscarPorCpf(Cpf cpf);

    List<Aluno> listarTodosAlunosMatriculados();

}
