public class TesteSacaNegativo {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.deposita(100);

        // isso está proibido (atributo privado):
        // conta.saldo = conta.saldo - 101;
        // System.out.println(conta.saldo);

        System.out.println(conta.saca(101));
        System.out.println(conta.getSaldo());
    }

}
