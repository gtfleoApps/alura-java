package br.com.alura.escola.academico.dominio.aluno;

// Classe-09:
// Representa o dominio de cifrar senha (um servico de dominio).
// A implementacao estah na camada de infra.
public interface CifradorDeSenha {

    String cifrarSenha(String senha);

    boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
/*
 * As nossas regras de negócio devem ficar nas entidades e VOs, mas nem sempre
 * isso faz sentido. Quando precisamos executar alguma ação que não faça parte
 * de nenhuma entidade nem de um VO, podemos utilizar uma classe Service.
 */