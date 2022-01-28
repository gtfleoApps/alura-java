public class TesteFuncionario {

    public static void main(String[] args) {
        Funcionario nico = new Gerente();
        nico.setNome("Nico da Silva");
        nico.setCpf("111222333-44");
        nico.setSalario(2600.00);

        System.out.println(nico.getNome());
        System.out.println(nico.getBonificacao());

        // Teste Gerente:
        Gerente g1 = new Gerente();
        g1.setNome("Leo");
        g1.setCpf("333444000-11");
        g1.setSalario(5000.00);
        // g1.setSenha(1234);
        
        System.out.println(g1.getNome());
        System.out.println(g1.getCpf());
        System.out.println(g1.getSalario());

        // boolean autenticou = g1.autenticaSenha(1235);
        // System.out.println(autenticou);

        System.out.println(g1.getBonificacao());
    }
}