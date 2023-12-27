package estruturadados.dicionario;


import estruturadados.lista.Lista;
import estruturadados.lista.ListaVetor;

import java.util.Arrays;

public class Dicionario<C,V> {

    private static class ParChaveValor<C,V>{
        C chave;
        V valor;

        ParChaveValor(C chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

    }
    private Lista<ParChaveValor<C,V>>[] tabela;
    int TAMANHO=101;

    public Dicionario(){
        tabela=new Lista[TAMANHO];
        for (int i=0;i<TAMANHO;i++){
            tabela[i]=new ListaVetor<ParChaveValor<C,V>>();
        }
    }

    private int calculaIndice(C chave){
        int indice=chave.hashCode()%TAMANHO;
        indice=indice>=0?indice:indice*-1;
        return indice;
    }

    public void coloca(C chave, V valor){
        int indice=calculaIndice(chave);
        Lista<ParChaveValor<C,V>> lista=tabela[indice];

        for (int i=0;i< lista.tamanho();i++){
            if(lista.pega(i).chave.equals(chave)){
                lista.pega(i).valor=valor;
                return;
            }
        }
        lista.adiciona(new ParChaveValor<>(chave,valor));
    }

    public V pega(C chave){
        int indice=calculaIndice(chave);
        Lista<ParChaveValor<C,V>> lista=tabela[indice];
        for (int i=0;i< lista.tamanho();i++){
            if(lista.pega(i).chave.equals(chave)){
                return lista.pega(i).valor;
            }
        }
        return null;
    }
    public void remove(C chave){
        int indice=calculaIndice(chave);
        Lista<ParChaveValor<C,V>> lista=tabela[indice];
        for (int i=0;i< lista.tamanho();i++){
            if(lista.pega(i).chave.equals(chave)){
                lista.remove(i);
            }
        }
    }

    public boolean contemChave(C chave){
        int indice=calculaIndice(chave);
        Lista<ParChaveValor<C,V>> lista=tabela[indice];
        for (int i=0;i<lista.tamanho();i++){
            if(lista.pega(i).chave.equals(chave)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder("Dicionario: {");
        for(int i=0;i<TAMANHO;i++){
            if(tabela[i].estaVazia()) continue;
            for (int j=0;j<tabela[i].tamanho();j++){
                if(j==0 && !str.toString().equals("Dicionario: {")) str.append(",");
                str.append("[chave: ").append(tabela[i].pega(j).chave);
                str.append(", valor: ").append(tabela[i].pega(j).valor).append("]");
                if(j!=tabela[i].tamanho()-1) str.append(",");
            }

        }
        str.append("}");
        return str.toString();
    }
}
