public class TestaContaSemCliente {
    public static void main(String[] args) {
        Conta contaDaMarcela = new Conta();
        System.out.println(contaDaMarcela.getSaldo());
        System.out.println(contaDaMarcela.titular); // null

        /*
         * Erro: nao possui referencia entre conta e cliente!
         * contaDaMarcela.titular.nome = "Marcela";
         */

        // Criando a referencia (composição de objeto):
        contaDaMarcela.titular = new Cliente();
        contaDaMarcela.titular.nome = "Marcela";
        System.out.println(contaDaMarcela.titular.nome);
    }
}
