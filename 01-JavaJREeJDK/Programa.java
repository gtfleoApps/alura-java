public class Programa {

    public static void main(String[] args) {
        System.out.println("olá mundo");

        int idade;
        idade = 5;
        System.out.println("Minha idade é de " + idade + " anos.");

        double salario;
        salario = 7123.40 + 0.01;
        System.out.println("Meu salário é de R$" + salario);

        int divisao1 = 5 / 2;
        System.out.println("Divisão1: " + divisao1);
        
        double divisao2 = 5 / 2;
        System.out.println("Divisão2: " + divisao2);
        
        double divisao3 = 5.0 / 2;
        System.out.println("Divisão3: " + divisao3);
        
        int valorInt = (int) salario;
        System.out.println("Divisão3: " + valorInt);

        long numeroGrande = 321321321321L;
        short valorPequeno = 2131;
        byte b = 127;
        float pontoFlutuante = 3.14f;
    }

    /*
    Operadores aritméticos:
        + para Soma
        - para Subtração
        * para Multiplicação
        / para Divisão
    */

}
