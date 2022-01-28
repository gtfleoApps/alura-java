public class Conta {
    private double saldo;
    int agencia = 42; // valor padrão definido
    int numero;
    Cliente titular;

    // void: nao ha retorno
    public void deposita(double valor) {
        // this: refere ao atributo de um (único) objeto criado usando a classe Conta;
        // ou seja, a uma conta específica.
        this.saldo += valor;
    }

    // retorno booleano
    public boolean saca(double valor) {
        // verifica se ha dinheiro suficiente na conta
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true; // return para a execução do método (else desnecessário)
        } else {
            return false;
        }
    }

    // retorno booleano
    public boolean transfere(double valor, Conta contaDestino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.deposita(valor);
            return true;
        }
        return false;
    }

    // get
    public double getSaldo() {
        return this.saldo;
    }
}
