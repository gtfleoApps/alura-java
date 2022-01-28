public class TestaMetodo {
    public static void main(String[] args) {
        // criando conta
        Conta contaDoPaulo = new Conta();

        // depositando conta
        contaDoPaulo.deposita(50);
        System.out.println(contaDoPaulo.saldo);

        // variavel booleana que guarda o retorno (é opcional)
        boolean conseguiuSacarDaConta;

        // teste com retorno falso
        conseguiuSacarDaConta = contaDoPaulo.saca(60);
        System.out.println(contaDoPaulo.saldo);
        System.out.println(conseguiuSacarDaConta);

        // teste com retorno verdadeiro
        conseguiuSacarDaConta = contaDoPaulo.saca(20);
        System.out.println(conseguiuSacarDaConta);
        System.out.println(contaDoPaulo.saldo);

        // criando conta para testar a transferência
        Conta contaDaMarcela = new Conta();
        contaDaMarcela.deposita(1000);

        // utilizando o retorno booleano diretamente no condicional - retorno falso:
        if (contaDaMarcela.transfere(1350, contaDoPaulo))
            System.out.println("Transferência feita com sucesso.");

        System.out.println("Saldo da conta da Marcela: " + contaDaMarcela.saldo);
        System.out.println("Saldo da conta do Paulo: " + contaDoPaulo.saldo);

        // teste com retorno verdadeiro
        if (contaDaMarcela.transfere(350, contaDoPaulo))
            System.out.println("Transferência feita com sucesso.");

        System.out.println("Saldo da conta da Marcela: " + contaDaMarcela.saldo);
        System.out.println("Saldo da conta do Paulo: " + contaDoPaulo.saldo);

    }
}
