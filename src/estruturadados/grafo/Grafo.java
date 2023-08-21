package estruturadados.grafo;

import estruturadados.fila.FilaEncadeada;
import estruturadados.vetor.ListaVetor;

public class Grafo<T> {
    private ListaVetor<Vertice> vertices;
    private int quantidadeVertices;

    public Grafo() {
        vertices=new ListaVetor<>();
        quantidadeVertices=0;
    }
    public void adicionaVertice(T elemento){
        vertices.adiciona(new Vertice<>(elemento));
        quantidadeVertices++;
    }
    public void adicionaAresta(T elementoOrigem,T elementoDestino){
        int origem=-1;
        int destino=-1;
        for (int i=0;i<=vertices.tamanho();i++){
            if(vertices.busca(i).getElemento()==elementoOrigem) origem=i;
            if(vertices.busca(i).getElemento()==elementoDestino) destino=i;
            if(origem>=0 && destino>=0) break;
        }
        if(origem>=0 && destino>=0 && origem!=destino){
            Aresta aresta=new Aresta(vertices.busca(origem),vertices.busca(destino));
            vertices.busca(origem).adicionaSaida(aresta);
            vertices.busca(destino).adicionaEntrada(aresta);
        }

    }
    public void adicionaAresta(T elementoOrigem,T elementoDestino,int peso){
        int origem=-1;
        int destino=-1;
        for (int i=0;i<=vertices.tamanho();i++){
            if(vertices.busca(i).getElemento()==elementoOrigem) origem=i;
            if(vertices.busca(i).getElemento()==elementoDestino) destino=i;
        }
        if(origem>=0 && destino>=0 && origem!=destino){
            Aresta aresta=new Aresta(vertices.busca(origem),vertices.busca(destino),peso);
            vertices.busca(origem).adicionaSaida(aresta);
            vertices.busca(destino).adicionaEntrada(aresta);
        }

    }
    public Vertice pegaVertice(T elemento){
        int indice=-1;
        for(int i=0;i<vertices.tamanho();i++){
            if(vertices.busca(i).getElemento()==elemento) indice=i;
        }
        if(indice==-1) return null;
        return vertices.busca(indice);
    }
    public String percorreLargura(T elemento){
        Vertice<T> inicio=pegaVertice(elemento);
        ListaVetor<Vertice<T>> marcados=new ListaVetor<>();
        FilaEncadeada<Vertice<T>> fila=new FilaEncadeada<>();
        marcados.adiciona(inicio);
        fila.enfileira(inicio);
        while (!fila.estaVazia()){
            Vertice<T> vizitado=fila.proximo();
            for (int i=0;i<vizitado.getArestasSaindo().tamanho();i++){
                Vertice<T> proximo=vizitado.getArestasSaindo().busca(i).getVerticeEntra();
                if(!marcados.contem(proximo)) {
                    marcados.adiciona(proximo);
                    fila.enfileira(proximo);
                }
            }
            fila.desenfileira();
        }
        return marcados.toString();

    }
}
