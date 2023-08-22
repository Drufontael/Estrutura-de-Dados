package estruturadados.grafo;

import estruturadados.vetor.ListaVetor;

public class VerticeDigrafo<T> {
    private T elemento;
    private ListaVetor<ArestaDirecionada<T>> arestasSaindo;
    private ListaVetor<ArestaDirecionada<T>> arestasEntrando;

    public VerticeDigrafo(T elemento) {
        this.elemento = elemento;
        arestasSaindo= new ListaVetor<ArestaDirecionada<T>>();
        arestasEntrando= new ListaVetor<ArestaDirecionada<T>>();
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public ListaVetor<ArestaDirecionada<T>> getArestasSaindo() {
        return arestasSaindo;
    }

    public void setArestasSaindo(ListaVetor<ArestaDirecionada<T>> arestasSaindo) {
        this.arestasSaindo = arestasSaindo;
    }

    public ListaVetor<ArestaDirecionada<T>> getArestasEntrando() {
        return arestasEntrando;
    }

    public void setArestasEntrando(ListaVetor<ArestaDirecionada<T>> arestasEntrando) {
        this.arestasEntrando = arestasEntrando;
    }

    public void adicionaSaida(ArestaDirecionada<T> arestaDirecionada) {
        if(arestasSaindo.busca(arestaDirecionada)<0){
            arestasSaindo.adiciona(arestaDirecionada);
        }

    }

    public void adicionaEntrada(ArestaDirecionada<T> arestaDirecionada) {
        if(arestasEntrando.busca(arestaDirecionada)<0){
            arestasEntrando.adiciona(arestaDirecionada);
        }
    }

    @Override
    public String toString() {

        return ""+this.elemento;
    }
}
