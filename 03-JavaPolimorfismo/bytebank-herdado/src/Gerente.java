// Gerente eh um funcionario, assina o contrato autenticavel:
public class Gerente extends Funcionario implements Autenticavel{    
    
    // Composição: Gerente tem AutenticacaoUtil
    private AutenticacaoUtil autenticador;


    public Gerente() {
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


    // Reescrita: mesma assinatura do metodo getBonificacao da super classe:
    public double getBonificacao() {
        System.out.println("Aplicado bonificação de Gerente: 5%(funcionario) + salario");
        // return this.getSalario();
        // return super.salario; // super: salario (protected) da super classe
        
        // return super.getBonificacao() + super.getSalario();
        return super.getSalario();
    }

}
