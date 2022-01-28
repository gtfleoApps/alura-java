// Enum é muito útil para definir constantes (estados de botões, estações do ano, status de pedidos, etc.)
public enum Prioridade {

    MIN(1),NORMAL(5),MAX(9);

    private int valor;

    Prioridade(int valorPrioridade) {
        this.valor = valorPrioridade;
    }

    public int getValor() {
        return this.valor;
    }
}
