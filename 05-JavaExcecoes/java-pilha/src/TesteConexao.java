public class TesteConexao {
    public static void main(String[] args) {
        
        
        /* 
        Conexao con = null;
        try {
            con = new Conexao();
            con.leDados();
            //  con.fecha();
        } catch (Exception e) {
            System.out.println("Deu erro na conexao");
            //  con.fecha();
        } finally { // executa sempre, tendo excecao ou nao
            con.close();
        }
        */
        
        
        //-------------------------------------------------------------
        
        // try-with-resources: Essa implementacao substitui o bloco try e o bloco finally acima
        try (Conexao conexao = new Conexao()){ // necessita implementacao do metodo close em Conexao.java
            conexao.leDados();
        } catch (Exception e) {
            System.out.println("Deu erro na conexao");
        }
        
    }
}
