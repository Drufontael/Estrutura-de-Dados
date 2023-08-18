package estruturadados.arvore;
public class Elemento<T extends Comparable>{
    private T valor;
    private Elemento<T> esquerda;
    private Elemento<T> direita;


    public Elemento(T valor) {
        this.valor = valor;
        esquerda=null;
        direita=null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Elemento getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Elemento esquerda) {
        this.esquerda = esquerda;
    }

    public Elemento getDireita() {
        return direita;
    }

    public void setDireita(Elemento direita) {
        this.direita = direita;
    }


}
