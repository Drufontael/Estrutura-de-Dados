package estruturadados.grafo;

import estruturadados.fila.FilaEncadeada;
import estruturadados.vetor.ListaVetor;

public class Digrafo<T> {
    private ListaVetor<VerticeDigrafo> vertices;
    private int quantidadeVertices;

    public Digrafo() {
        vertices=new ListaVetor<>();
        quantidadeVertices=0;
    }
    public void adicionaVertice(T elemento){
        vertices.adiciona(new VerticeDigrafo<>(elemento));
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
            ArestaDirecionada arestaDirecionada =new ArestaDirecionada(vertices.busca(origem),vertices.busca(destino));
            vertices.busca(origem).adicionaSaida(arestaDirecionada);
            vertices.busca(destino).adicionaEntrada(arestaDirecionada);
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
            ArestaDirecionada arestaDirecionada =new ArestaDirecionada(vertices.busca(origem),vertices.busca(destino),peso);
            vertices.busca(origem).adicionaSaida(arestaDirecionada);
            vertices.busca(destino).adicionaEntrada(arestaDirecionada);
        }

    }
    public VerticeDigrafo pegaVertice(T elemento){
        int indice=-1;
        for(int i=0;i<vertices.tamanho();i++){
            if(vertices.busca(i).getElemento()==elemento) indice=i;
        }
        if(indice==-1) return null;
        return vertices.busca(indice);
    }
    public String percorreLargura(T elemento){
        VerticeDigrafo<T> inicio=pegaVertice(elemento);
        ListaVetor<VerticeDigrafo<T>> marcados=new ListaVetor<>();
        FilaEncadeada<VerticeDigrafo<T>> fila=new FilaEncadeada<>();
        marcados.adiciona(inicio);
        fila.enfileira(inicio);
        while (!fila.estaVazia()){
            VerticeDigrafo<T> vizitado=fila.proximo();
            for (int i=0;i<vizitado.getArestasSaindo().tamanho();i++){
                VerticeDigrafo<T> proximo=vizitado.getArestasSaindo().busca(i).getVerticeEntra();
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
