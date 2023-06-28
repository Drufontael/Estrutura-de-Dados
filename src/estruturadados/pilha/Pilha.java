package estruturadados.pilha;

import estruturadados.base.EstruturaEstatica;

public class Pilha<T> extends EstruturaEstatica<T> {
    public Pilha(){
        super();
    }
    public Pilha(int tamanho){
        super(tamanho);
    }
    public void empilhar(T elemento){
        super.adiciona(elemento);
    }
    public T desempilha(){
        if(this.estaVazia()) return null;
        return this.elementos[--this.tamanho];
    }
    public T topo(){
        if(this.estaVazia()) return null;
        return this.elementos[this.tamanho-1];
    }
}
