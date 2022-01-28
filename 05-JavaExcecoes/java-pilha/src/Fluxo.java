public class Fluxo {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
            metodo1();
        } catch (ArithmeticException | NullPointerException | MinhaException ex) {
            String msg = ex.getMessage();
            System.out.println("Exception " + msg);
            ex.printStackTrace();
        } /* catch (Exception e) {
            e.printStackTrace();
        } */
        System.out.println("Fim Teste Metodos.");

        try {
            TestaContaComExcecaoChecked();
        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println("Exception " + msg);
            e.printStackTrace();
        }
        System.out.println("Fim Teste Conta.");
        
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        metodo2();
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2");
        /* for(int i = 1; i <= 5; i++) {
            System.out.println(i);

            // try {
            //     int a = i / 0;
            // } catch (ArithmeticException ex) {
            //     System.out.println("ArithmeticException:" + ex.getMessage());
            // }

            Conta c = null;
            c.deposita();
        } */

        /* ArithmeticException ex = new ArithmeticException("Ocorreu um erro!");
        throw ex; // throw soh funciona com exception */
        // throw new ArithmeticException("Ocorreu um erro!"); // formato mais comum !!!

        throw new MinhaException("Ocorreu um erro!");

        // System.out.println("Fim do metodo2");
    }

    public static void TestaContaComExcecaoChecked() throws MinhaExceptionChecked {
        Conta c = new Conta();
        c.deposita();
    }
}