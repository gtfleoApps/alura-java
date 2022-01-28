/* 
Funcionario recebeu a palavra abstract porque nao eh interessante criar um funcionario (concreto) sem uma funcao/cargo, 
mas usar funcionario como uma ideia, uma abstracao, por conta da heranca.
Dessa forma, nao se pode mais criar um objeto concreto funcionario, ou seja, essa classe nao pode ser instanciada.
 */
public abstract class Funcionario {

    private String nome;
    private String cpf;
    protected double salario; // protected: publico para classes filhas

    public Funcionario() {

    }

    // metodo sem corpo, nao ha implementacao na super classe (necessario para o polimorfismo)
    public abstract double getBonificacao();
    // public double getBonificacao() {
    //     System.out.println("Aplicado bonificação de Funcionario: 5%");

    //     return this.salario * 0.05;
    // }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
