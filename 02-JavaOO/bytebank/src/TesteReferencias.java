public class TesteReferencias {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta();
        primeiraConta.saldo = 50;

        // sem o new, nao se cria outra conta; apenas recebe o endereço de memória
        Conta segundaConta = primeiraConta;

        System.out.println("Saldo Primeira Conta: " + primeiraConta.saldo);
        System.out.println("Saldo Segunda Conta: " + segundaConta.saldo);

        segundaConta.saldo += 100;
        System.out.println("Saldo Primeira Conta: " + primeiraConta.saldo);
        System.out.println("Saldo Segunda Conta: " + segundaConta.saldo);

        if (primeiraConta == segundaConta) {
            System.out.println("Conta 1 = Conta 2");
        }

        Conta terceiraConta = new Conta();

        System.out.println(primeiraConta);
        System.out.println(segundaConta);
        System.out.println(terceiraConta);

        /*
         * Dentro das variáveis primeiraConta, segundaConta e terceiraConta não existe
         * objeto, mas referência a objeto (endereço de memória)
         */
    }
}
