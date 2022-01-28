public class TestaLacos {
    public static void main(String[] args) {

        int cont = 0;
        int total = 0;
        System.out.println(">>> Loop While");
        while (cont <= 10) {
            System.out.print(cont + " ");
            // total = total + cont;
            total += cont;
            // cont = cont + 1;
            // cont += 1;
            ++cont;
        }
        System.out.println("Contador após while: " + cont);
        System.out.println("Somatório total: " + total);

        System.out.println(">>> Loop For");
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(">>> Laços Encadeados");
        for (int mult = 1; mult < 10; mult++) {
            System.out.print("Taboada do " + mult + ": ");
            for (int i = 0; i <= 10; i++) {
                System.out.print((mult * i) + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    break;
                } else {
                    System.out.print("*");
                }

            }
            System.out.println();
        }
    }
}
