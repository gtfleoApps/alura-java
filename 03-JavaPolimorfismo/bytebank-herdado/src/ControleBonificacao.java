public class ControleBonificacao {
    private double soma;
    
    // Polimorfismo:
    // Método genérico: Variável de super classe (Funcionario) aceita também objeto específico de sub classe (Funcionario, Gerente ou Diretor):
    public void registraBonificacao(Funcionario funcionario) { 
        double bonificacao = funcionario.getBonificacao(); // aqui se utiliza o metodo do objeto especifico (nao da classe mae)
        this.soma = this.soma + bonificacao;
    }

    public double getSoma() {
        return soma;
    }
}
