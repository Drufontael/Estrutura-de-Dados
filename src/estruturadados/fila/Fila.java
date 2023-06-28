package estruturadados.fila;

import estruturadados.base.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica<T> {
    public Fila(){
        super();
    }
    public Fila(int tamanho){
        super(tamanho);
    }
    public void enfileira(T elemento){
        super.adiciona(elemento);
    }
    public T proximo(){
        if(this.estaVazia()) return null;
        return this.elementos[0];
    }
    public T desenfileira(){
        if(this.estaVazia()) return null;
        T retorno=this.elementos[0];
        super.remove(0);
        return retorno;
    }
}
