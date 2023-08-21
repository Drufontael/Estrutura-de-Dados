package estruturadados.grafo;

import estruturadados.vetor.ListaVetor;

public class Vertice<T> {
    private T elemento;
    private ListaVetor<Aresta<T>> arestasSaindo;
    private ListaVetor<Aresta<T>> arestasEntrando;

    public Vertice(T elemento) {
        this.elemento = elemento;
        arestasSaindo= new ListaVetor<Aresta<T>>();
        arestasEntrando= new ListaVetor<Aresta<T>>();
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public ListaVetor<Aresta<T>> getArestasSaindo() {
        return arestasSaindo;
    }

    public void setArestasSaindo(ListaVetor<Aresta<T>> arestasSaindo) {
        this.arestasSaindo = arestasSaindo;
    }

    public ListaVetor<Aresta<T>> getArestasEntrando() {
        return arestasEntrando;
    }

    public void setArestasEntrando(ListaVetor<Aresta<T>> arestasEntrando) {
        this.arestasEntrando = arestasEntrando;
    }

    public void adicionaSaida(Aresta<T> aresta) {
        if(arestasSaindo.busca(aresta)<0){
            arestasSaindo.adiciona(aresta);
        }

    }

    public void adicionaEntrada(Aresta<T> aresta) {
        if(arestasEntrando.busca(aresta)<0){
            arestasEntrando.adiciona(aresta);
        }
    }

    @Override
    public String toString() {

        return ""+this.elemento;
    }
}
