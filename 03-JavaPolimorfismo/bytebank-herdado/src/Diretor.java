public class Diretor extends Funcionario implements Autenticavel{

    // Composição: Diretor tem AutenticacaoUtil
    private AutenticacaoUtil autenticador;


    public Diretor() {
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

    public double getBonificacao() {
        System.out.println("Aplicado bonificação de Diretor: 5%(funcionario) + 10mil");

        // return super.getBonificacao() + 10000.00;
        return 10000.0;
    }
    
}
