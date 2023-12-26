package estruturadados.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEncadeada<T> implements Lista<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho = 0;

    @Override
    public void adiciona(T elemento) {
        No<T> celula = new No<>(elemento);
        if (this.tamanho == 0) {
            this.primeiro = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        tamanho++;
    }

    @Override
    public void adiciona(int indice, T elemento) {
        No<T> atual = this.primeiro;
        No<T> novoNo = new No<>(elemento);
        if (indice == 0) {
            novoNo.setProximo(this.primeiro);
            this.primeiro = novoNo;
        } else if (indice >= tamanho) {
            this.ultimo.setProximo(novoNo);
            this.ultimo = novoNo;
        } else {
            for (int i = 1; i < indice; i++) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        this.tamanho++;
    }

    @Override
    public int pega(T elemento) {
        if(primeiro.getElemento().equals(elemento)){
            return 0;
        }else if(ultimo.getElemento().equals(elemento)){
            return tamanho-1;
        }else{
            No<T> atual=this.primeiro;
            for (int i=0;i<tamanho;i++){
                atual=atual.getProximo();
                if(atual.getElemento().equals(elemento)) return i;
            }
        }
        return -1;
    }

    @Override
    public T pega(int indice) {
        No<T> atual = this.primeiro;
        //No<T> novoNo = new No<>(elemento);
        if (indice == 0) {
            return primeiro.getElemento();
        } else if (indice == tamanho-1) {
            return ultimo.getElemento();
        } else {
            for (int i = 0; i < indice; i++) {
                atual = atual.getProximo();
                if(atual==null) throw new IllegalArgumentException("Indice invalido");
            }
            return atual.getElemento();
        }
    }

    @Override
    public void remove(int indice) {
        T remover=this.pega(indice);
        remove(remover);
        this.tamanho--;

    }

    public No<T> primeiro() {
        return primeiro;
    }

    public No<T> ultimo() {
        return ultimo;
    }

    @Override
    public void remove(T elemento) {
        No<T> apaga = this.primeiro;
        No<T> anterior = null;
        if (primeiro.getElemento().equals(elemento)) {
            this.primeiro = primeiro.getProximo();
            apaga.setElemento(null);
            apaga.setProximo(null);
        } else {
            while (!apaga.getElemento().equals(elemento)) {
                anterior = apaga;
                apaga = apaga.getProximo();
                if (apaga == null) {
                    tamanho++;
                    break;
                }
            }
            if (apaga != null) {
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
        return tamanho == 0;
    }

    @Override
    public boolean contem(T elemento) {
        if (this.primeiro.getElemento().equals(elemento)) return true;
        No<T> atual = this.primeiro;
        while (atual.getProximo() != null) {
            if (atual.getProximo().equals(elemento)) return true;
            atual = atual.getProximo();
        }
        return false;
    }

    public void limpa() {
        for (No<T> atual = this.primeiro; atual != null; ) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }
        this.tamanho = 0;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) return "[]";
        No<T> atual = this.primeiro;
        final StringBuilder sb = new StringBuilder("[");
        sb.append(atual.getElemento());
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
            sb.append(',').append(atual.getElemento());
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new Iterator<T>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < tamanho;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return pega(indice++);
            }
        };
    }
}
