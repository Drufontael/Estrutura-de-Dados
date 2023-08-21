package estruturadados.fila;

import estruturadados.lista.ListaEncadeada;

public class FilaEncadeada<T> extends ListaEncadeada<T> {
    public FilaEncadeada() {
        super();
    }
    public void enfileira(T elemento){
        super.adiciona(elemento);
    }
    public T proximo(){
        return super.primeiro().getElemento();
    }
    public T desenfileira(){
        T retorno=super.primeiro().getElemento();
        super.remove(super.primeiro().getElemento());
        return retorno;
    }
}
