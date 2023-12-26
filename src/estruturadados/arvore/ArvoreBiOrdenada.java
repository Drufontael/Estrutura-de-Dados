package estruturadados.arvore;

import estruturadados.lista.Lista;
import estruturadados.lista.ListaVetor;

/**
 * Estrutura de arvore binaria de elementos únicos ordenados
 *
 * @param <T>
 */

public class ArvoreBiOrdenada<T extends Comparable> {
    private Elemento<T> raiz;
    private int tamanho;

    public ArvoreBiOrdenada() {
        tamanho = 0;
    }

    public ArvoreBiOrdenada(Elemento<T> raiz) {
        this.raiz = raiz;
        tamanho = 0;
    }

    public Elemento getRaiz() {
        return raiz;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void adiciona(T valor) {
        Elemento<T> novoElemento = new Elemento<>(valor);
        if (raiz == null) {
            raiz = novoElemento;
            tamanho += 1;
        } else {
                desceElemento(raiz, novoElemento);
        }

    }
    public T retonaValor(T valor){
        Elemento<T> procurado=raiz;
        while(procurado.getValor().compareTo(valor)!=0){
            if(procurado.getValor().compareTo(valor)<0){
                procurado=procurado.getDireita()!=null?procurado.getDireita():null;
                if(procurado==null) return null;
            }else{
                procurado=procurado.getEsquerda()!=null?procurado.getEsquerda():null;
                if(procurado==null) return null;
            }
        }
        return procurado.getValor();
    }


    public void remove(T valor){
        Elemento<T> procurado=raiz;
        while(procurado!=null && !procurado.getValor().equals(valor)){
            if(procurado.getValor().compareTo(valor)<0){
                procurado=procurado.getDireita();
                if(procurado==null) return;
            }else{
                procurado=procurado.getEsquerda();
                if(procurado==null) return;
            }
        }
        Elemento<T> substituto=proximoDireito(procurado);
        if(substituto==null) substituto=proximoEsquerda(procurado);
        Elemento<T> pai=raizAcima(procurado.getValor());
        Elemento<T> paiSubstituto=raizAcima(substituto!=null?substituto.getValor():null);
        if(substituto==null){
            if(pai.getDireita().getValor().equals(valor)){
                pai.setDireita(null);
            }else pai.setEsquerda(null);
        }else{

            if(paiSubstituto.getDireita().equals(substituto)){
                paiSubstituto.setDireita(null);
            }else paiSubstituto.setEsquerda(null);
            if(pai.getDireita().getValor().equals(valor)){
                pai.setDireita(substituto);
            }else pai.setEsquerda(substituto);
            substituto.setEsquerda(procurado.getEsquerda());
            substituto.setDireita(procurado.getDireita());
            tamanho-=1;

        }

    }
    public Lista<T> paraLista() {
        Lista<T> retorno = new ListaVetor<>();
        return emOrdem(raiz, retorno);
    }
    public void limpa(){
        limpa(raiz);
    }
    public T primeiro(){
        Elemento<T> busca=raiz;
        while(busca.getEsquerda()!=null){
            busca=busca.getEsquerda();
        }
        return busca.getValor();
    }
    public T ultimo(){
        Elemento<T> busca=raiz;
        while (busca.getDireita()!=null){
            busca=busca.getDireita();
        }
        return busca.getValor();
    }

    @Override
    public String toString() {
        Lista<T> impArvore = paraLista();
        return impArvore.toString();
    }



    // ***** METODOS AUXILIARES*****

    private void desceElemento(Elemento<T> raiz, Elemento<T> novoElemento) {
        if (novoElemento.getValor().compareTo(raiz.getValor()) > 0) {
            if (raiz.getDireita() == null) {
                raiz.setDireita(novoElemento);
                tamanho += 1;
            } else {
                desceElemento(raiz.getDireita(), novoElemento);
            }
        } else if(novoElemento.getValor().compareTo(raiz.getValor())<0){
            if (raiz.getEsquerda() == null) {
                raiz.setEsquerda(novoElemento);
                tamanho += 1;
            } else {
                desceElemento(raiz.getEsquerda(), novoElemento);
            }
        } else {
            novoElemento.setDireita(raiz.getDireita());
            novoElemento.setEsquerda(raiz.getEsquerda());
            Elemento<T> raizAcima=raizAcima(raiz.getValor());
            if(raizAcima!=null){
                if (raizAcima.getValor().compareTo(novoElemento.getValor()) > 0) {
                    raizAcima.setEsquerda(novoElemento);
                } else raizAcima.setDireita(novoElemento);
            }

        }
    }



    private Lista<T> emOrdem(Elemento<T> elementoAtual, Lista<T> retorno) {

        if (elementoAtual != null) {
            emOrdem(elementoAtual.getEsquerda(), retorno);
            retorno.adiciona(elementoAtual.getValor());
            emOrdem(elementoAtual.getDireita(), retorno);
        }
        return retorno;
    }




    private void limpa(Elemento<T> elementoAtual) {
        if (elementoAtual != null) {
            limpa(elementoAtual.getEsquerda());
            limpa(elementoAtual.getDireita());
            Elemento<T> apagar=raizAcima(elementoAtual.getValor());
            if(apagar==null){
                raiz=null;
            }
            else if(apagar.getValor().compareTo(elementoAtual.getValor())>0){
                apagar.setEsquerda(null);
            }else{
                apagar.setDireita(null);
            }

            tamanho-=1;
        }

    }

    private boolean eRaiz(T valor) {
        if (raiz == null) return false;
        return raiz.getValor().equals(valor);
    }

    private Elemento<T> raizAcima(T valor) {
        if(valor==null) return null;
        return retornaRaizAcima(valor, this.raiz);
    }

    private Elemento<T> retornaRaizAcima(T valor, Elemento<T> raiz) {
        if (!eRaiz(valor)) {
            if (raiz.getValor().compareTo(valor) > 0) {
                if (raiz.getEsquerda() == null) return null;
                if (raiz.getEsquerda().getValor().equals(valor)) {
                    return raiz;
                } else return retornaRaizAcima(valor, raiz.getEsquerda());
            } else {
                if (raiz.getDireita() == null) return null;
                if (raiz.getDireita().getValor().equals(valor)) {
                    return raiz;
                } else return retornaRaizAcima(valor, raiz.getDireita());
            }
        }
        return null;
    }

    private Elemento<T> proximoDireito(Elemento<T> elemento){
        if(elemento==null) return null;
        if(elemento.getDireita()==null) return null;
        Elemento<T> encontrado=elemento.getDireita();
        while (encontrado.getEsquerda()!=null){
            encontrado=encontrado.getEsquerda();
        }
        return encontrado;
    }
    private Elemento<T> proximoEsquerda(Elemento<T> elemento){
        if(elemento==null) return null;
        if(elemento.getEsquerda()==null) return null;
        Elemento<T> encontrado=elemento.getEsquerda();
        while (encontrado.getDireita()!=null){
            encontrado=encontrado.getDireita();
        }
        return encontrado;
    }


}
