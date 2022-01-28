public class SistemaInterno {

    private int senha = 2222;

    public void autenticaSenha(Autenticavel autenticavel) {

        boolean autenticou = autenticavel.autenticaSenha(this.senha);

        if (autenticou) {
            System.out.println("Pode entrar no sistema!");
        } else {
            System.out.println("Não pode entrar no sistema!");
        }

    }
}
