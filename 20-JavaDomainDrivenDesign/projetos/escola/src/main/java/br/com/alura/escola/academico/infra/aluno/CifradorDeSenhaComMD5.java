package br.com.alura.escola.academico.infra.aluno;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.alura.escola.academico.dominio.aluno.CifradorDeSenha;

// Classe-10: Implementacao de cifrar senhas na camada de infra
// Implementacao do Service
public class CifradorDeSenhaComMD5 implements CifradorDeSenha {

    @Override
    public String cifrarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash: " + e);
        }
        return null;
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return senhaCifrada.equals(cifrarSenha(senha));
    }

}
