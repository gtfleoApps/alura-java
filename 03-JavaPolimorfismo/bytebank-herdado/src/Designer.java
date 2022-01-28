public class Designer extends Funcionario {

    public double getBonificacao() {
        System.out.println("Aplicado bonificação de Diretor: 5%(funcionario) + 10mil");

        // return super.getBonificacao() + 10000.00;
        return 50.0;
    }
    
}
