public class Administrador extends Funcionario implements Autenticavel{
    
    // Composição: Administrador tem AutenticacaoUtil
    private AutenticacaoUtil autenticador;


    public Administrador() {
        this.autenticador = new AutenticacaoUtil();
    }


    @Override
    public boolean autenticaSenha(int senha) {
        return this.autenticador.autenticaSenha(senha);
    }

    @Override
    public void setSenha(int senha) {
        this.autenticador.setSenha(senha);
    }


    @Override
    public double getBonificacao() {
        return 50;
    }
}
