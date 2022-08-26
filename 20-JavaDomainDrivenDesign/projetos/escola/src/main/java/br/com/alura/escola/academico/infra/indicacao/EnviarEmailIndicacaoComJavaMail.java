package br.com.alura.escola.academico.infra.indicacao;

import br.com.alura.escola.academico.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.academico.dominio.aluno.Aluno;

// Classe-12: Implementacao da interface de aplicacao
public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno indicado) {
        String email = indicado.getEmail();
        String msg = "Seja bem vindo(a) à Alura, " + indicado.getNome() + "!";
        // logica de envio de email com a lib Java Mail
    }

}
