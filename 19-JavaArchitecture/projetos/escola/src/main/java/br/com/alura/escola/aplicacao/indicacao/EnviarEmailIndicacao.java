package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.dominio.aluno.Aluno;

// Classe-11: Inteface de aplicao (entre dominio e infra)
// O disparo do email, jah seria uma implementacao de infra, devido a protocolos, tecnologia, etc.
// Enviar email eh algo da aplicacao, nao do dominio de negocio.
public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);
}
