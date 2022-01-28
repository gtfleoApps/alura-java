public class CriaConta {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta();
        primeiraConta.saldo = 200;

        Conta segundaConta = new Conta();
        segundaConta.saldo = 300;

        System.out.println("Saldo da Primeira Conta: R$" + primeiraConta.saldo);
        System.out.println("Saldo da Segunda Conta: R$" + segundaConta.saldo);

        // trabalhando com valores padrão:
        System.out.println("Agencia da Primeira Conta (default): " + primeiraConta.agencia);
        System.out.println("Numero da Primeira Conta (default): " + primeiraConta.numero);

        segundaConta.agencia = 123;
        segundaConta.numero = 456;
        System.out.println("Agencia da Segunda Conta: " + segundaConta.agencia);
        System.out.println("Numero da Segunda Conta: " + segundaConta.numero);

    }
}
