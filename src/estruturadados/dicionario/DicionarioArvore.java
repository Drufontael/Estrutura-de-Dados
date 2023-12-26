package estruturadados.dicionario;


import estruturadados.arvore.ArvoreBiOrdenada;

import java.util.Objects;

public class DicionarioArvore<C extends Comparable,V>{

    private static class ParChaveValor<C extends Comparable,V> implements Comparable<ParChaveValor<C,V>> {
        C chave;
        V valor;

        @Override
        public int compareTo(ParChaveValor<C,V> outroPar) {
            return this.chave.compareTo(outroPar.chave);
        }
        @Override
        public String toString(){
            return "Par: [chave: "+chave+", valor: "+valor+"]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ParChaveValor<?, ?> that = (ParChaveValor<?, ?>) o;

            return Objects.equals(chave, that.chave);
        }

        @Override
        public int hashCode() {
            return chave != null ? chave.hashCode() : 0;
        }
    }
    ArvoreBiOrdenada<ParChaveValor<C,V>> conjunto=new ArvoreBiOrdenada<>();

    public void coloca(C chave, V valor){
        var novoPar=new ParChaveValor<C,V>();
        novoPar.chave=chave;
        novoPar.valor=valor;
        conjunto.adiciona(novoPar);
    }
    public V pega(C chave){
        var par=new ParChaveValor<C,V>();
        par.chave=chave;
        par=conjunto.retonaValor(par);
        return par!=null?par.valor:null;
    }

    public void remove(C chave){
        var par=new ParChaveValor<C,V>();
        par.chave=chave;
        conjunto.remove(par);
    }

    @Override
    public String toString() {
        return "Dicionario:{"+conjunto+"}";
    }
}
