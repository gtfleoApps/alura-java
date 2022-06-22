package alura.com.br.loja;

// Usado para lancar excessoes de mudancas de estado de orcamento, etc.
public class DomainException extends RuntimeException {

    public DomainException(String mensagem) {
        super(mensagem);
    }
}
