package estruturadados.pilha;

import estruturadados.lista.ListaEncadeada;

public class PilhaEncadeada<T> extends ListaEncadeada<T> {
    public PilhaEncadeada() {
        super();
    }
    public void empilhar(T elemento){
        super.adiciona(elemento);
    }
    public T desempilha(){
        T retorno=super.ultimo().getElemento();
        super.remove(retorno);
        return retorno;
    }
    public T topo(){
        return super.ultimo().getElemento();
    }
}
