package estruturadados.lista;

import estruturadados.base.Lista;

public class ListaEncadeada<T> implements Lista<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho=0;

    public void adiciona(T elemento){
        No<T> celula=new No<>(elemento);
        if(this.tamanho==0){
            this.primeiro = celula;
        }else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo =celula;
        tamanho++;
    }

    public No<T> primeiro() {
        return primeiro;
    }

    public No<T> ultimo() {
        return ultimo;
    }

    @Override
    public void remove(T elemento) {
        No<T> apaga=this.primeiro;
        No<T> anterior=null;
        if(primeiro.getElemento().equals(elemento)){
            this.primeiro = primeiro.getProximo();
            apaga.setElemento(null);
            apaga.setProximo(null);
        }else
        {
            while (!apaga.getElemento().equals(elemento)) {
                anterior = apaga;
                apaga = apaga.getProximo();
                if (apaga==null){
                    tamanho++;
                    break;
                }
            }
            if(apaga!=null){
                anterior.setProximo(apaga.getProximo());
                apaga.setProximo(null);
                apaga.setElemento(null);
                if (anterior.getProximo() == null) this.ultimo = anterior;
            }
        }
        tamanho--;


    }


    @Override
    public boolean estaVazia() {
        return tamanho==0;
    }

    @Override
    public boolean contem(T elemento) {
        if(this.primeiro.getElemento().equals(elemento)) return true;
        No<T> atual=this.primeiro;
        while (atual.getProximo()!=null){
            if(atual.getProximo().equals(elemento)) return true;
            atual=atual.getProximo();
        }
        return false;
    }

    public void limpa(){
        for(No<T> atual = this.primeiro; atual!=null;){
            No<T> proximo=atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual=proximo;
        }
        this.tamanho=0;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        if (this.tamanho==0) return "[]";
        No<T> atual=this.primeiro;
        final StringBuilder sb = new StringBuilder("[");
        sb.append(atual.getElemento());
        while (atual.getProximo()!=null){
            atual=atual.getProximo();
            sb.append(',').append(atual.getElemento());
        }
        sb.append(']');
        return sb.toString();
    }
/*public String toString() {
        if (this.tamanho==0) return "[]";
        No<T> atual=this.inicio;
        final StringBuilder sb = new StringBuilder("ListaEncadeada{");
        sb.append("[").append(atual);
        while (atual.getProximo()!=null){
            atual=atual.getProximo();
            sb.append(',').append(atual);
        }
        sb.append(']');
        return sb.toString();
    }*/
}
