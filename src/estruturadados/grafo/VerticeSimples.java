package estruturadados.grafo;

import estruturadados.vetor.ListaVetor;

public class VerticeSimples<T> {
    private T elemento;
    private ListaVetor<ArestaSimples<T>> arestas;

    public VerticeSimples(T elemento) {
        this.elemento = elemento;
        arestas=new ListaVetor<>();
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public ListaVetor<ArestaSimples<T>> getArestas() {
        return arestas;
    }

    public void setArestas(ListaVetor<ArestaSimples<T>> arestas) {
        this.arestas = arestas;
    }
    public ArestaSimples<T> pegaAresta(T elemento1, T elemento2){
        for(int i=0;i< arestas.tamanho();i++){
            if((arestas.busca(i).getVertice1().getElemento().equals(elemento1) &&
                    arestas.busca(i).getVertice2().getElemento().equals(elemento2))||
                    (arestas.busca(i).getVertice1().getElemento().equals(elemento2) &&
                            arestas.busca(i).getVertice2().getElemento().equals(elemento1))){
                return arestas.busca(i);
            }
        }
        return null;
    }

    public void adicionaArestaSimples(VerticeSimples<T> vertice1,VerticeSimples<T> vertice2) {
        if(pegaAresta(vertice1.getElemento(),vertice2.getElemento())==null){
            arestas.adiciona(new ArestaSimples<>(vertice1,vertice2));
        }
    }

    @Override
    public String toString() {

        return elemento.toString();
    }
}
