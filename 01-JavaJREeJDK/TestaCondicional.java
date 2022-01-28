public class TestaCondicional {
    public static void main(String[] args) {
        System.out.println("Testando Condicionais");

        int idade = 17;
        int quantasPessoasJuntas = 1;
        boolean paisJuntos = false;

        if (idade == 18)
            System.out.println("Você tem 18 anos.");
        if (idade >= 18) {
            System.out.println("Você é maior de idade.");
            System.out.println("Seja bem vindo(a).");
        } else if (quantasPessoasJuntas > 0) {
            paisJuntos = true;
            System.out.println("Você é menor e está acompanhado(a) de " + quantasPessoasJuntas + " pessoas.");
        } else {
            paisJuntos = false;
            System.out.println("Infelizmente, você não pode entrar.");
        }

        if (!paisJuntos && idade < 18) {
            System.out.println("Você não pode entrar!");
        } else {
            System.out.println("Você pode entrar.");

            if (paisJuntos)
                System.out.println("Seus pais estão juntos.");
        }

        idade = 68;
        boolean ehIdoso = idade >= 65;
        System.out.println(ehIdoso);

    }
}
