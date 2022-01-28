public class TestePolimorfismo {
    public static void main(String[] args) {
        Gerente g1 = new Gerente();
        g1.setSalario(5000.0);
        
        Diretor d1 = new Diretor();
        d1.setSalario(9000.0);
        
      
        ControleBonificacao controle = new ControleBonificacao();
        System.out.println(controle.getSoma());
        controle.registraBonificacao(g1);
        System.out.println(controle.getSoma());
        controle.registraBonificacao(d1);
        System.out.println(controle.getSoma());
    }
}
