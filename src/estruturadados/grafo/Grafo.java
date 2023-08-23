package estruturadados.grafo;

import estruturadados.fila.FilaEncadeada;
import estruturadados.lista.ListaVetor;

public class Grafo<T> {
    private ListaVetor<Vertice<T>> vertices;
    private ListaVetor<Aresta<T>> arestas;

    public Grafo() {
        vertices=new ListaVetor<>();
        arestas=new ListaVetor<>();
    }
    public void adicionaVertice(T elemento){

        if(pegaVertice(elemento)==null){
            vertices.adiciona(new Vertice<>(elemento));
        }
    }
    public void adicionaAresta(T elemento1, T elemento2){
        if(!existeAresta(elemento1,elemento2)){
            this.pegaVertice(elemento1).adicionaArestaSimples(pegaVertice(elemento1),pegaVertice(elemento2));
            this.pegaVertice(elemento2).adicionaArestaSimples(pegaVertice(elemento2),pegaVertice(elemento1));
            arestas.adiciona(new Aresta<>(pegaVertice(elemento1),pegaVertice(elemento2)));
        }
    }
    public void adicionaAresta(T elemento1, T elemento2,double peso){
        if(!existeAresta(elemento1,elemento2,peso)){
            this.pegaVertice(elemento1).adicionaArestaSimples(pegaVertice(elemento1),pegaVertice(elemento2),peso);
            this.pegaVertice(elemento2).adicionaArestaSimples(pegaVertice(elemento2),pegaVertice(elemento1),peso);
            arestas.adiciona(new Aresta<>(pegaVertice(elemento1),pegaVertice(elemento2),peso));
        }
    }

    public boolean existeAresta(T elemento1, T elemento2) {
        if(pegaVertice(elemento1)==null || pegaVertice(elemento2)==null) return false;
        return pegaVertice(elemento1).pegaAresta(elemento1,elemento2)!=null;
    }
    public boolean existeAresta(T elemento1, T elemento2, double peso) {
        if(pegaVertice(elemento1)==null || pegaVertice(elemento2)==null) return false;
        return pegaVertice(elemento1).pegaAresta(elemento1,elemento2,peso)!=null;
    }

    public Vertice<T> pegaVertice(T elemento){
        for (int i=0;i< vertices.tamanho();i++){
            if (vertices.pega(i).getElemento().equals(elemento)) return vertices.pega(i);
        }
        return null;
    }

    public ListaVetor<Vertice<T>> percorreLargura(T elemento){
        Vertice<T> inicial=pegaVertice(elemento);
        ListaVetor<Vertice<T>> marcados=new ListaVetor<>();
        FilaEncadeada<Vertice<T>> fila=new FilaEncadeada<>();
        marcados.adiciona(inicial);
        fila.enfileira(inicial);

        while (!fila.estaVazia()){
            Vertice<T> vizitado=fila.proximo();
            for (int i=0;i<vizitado.getArestas().tamanho();i++){
                Vertice<T> proximo=vizitado.getArestas().pega(i).getVertice2();
                if(!marcados.contem(proximo)){
                    fila.enfileira(proximo);
                    marcados.adiciona(proximo);
                }
            }
            fila.desenfileira();

        }
        return marcados;
    }

    public ListaVetor<Vertice<T>> getVertices() {
        return vertices;
    }

    public ListaVetor<Aresta<T>> getArestas() {
        return arestas;
    }
}
