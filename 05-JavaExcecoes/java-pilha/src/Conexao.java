public class Conexao implements AutoCloseable {
        
    public Conexao() {
        System.out.println("Abrindo conexao");
    }

    public void leDados() {
        System.out.println("Recebendo dados");
        throw new IllegalStateException();
    }

    // Subostituido pelo close(), exigido na interface AutoClosable:
    /* public void fecha() {
        System.out.println("Fechando conexao");
    } */

    @Override
    public void close() {
        System.out.println("Fechando conexao");
        
    }

    
}
