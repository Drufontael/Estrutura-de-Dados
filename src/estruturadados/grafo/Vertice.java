package estruturadados.grafo;

import estruturadados.lista.ListaVetor;

public class Vertice<T> {
    private T elemento;
    private ListaVetor<Aresta<T>> arestas;

    public Vertice(T elemento) {
        this.elemento = elemento;
        arestas=new ListaVetor<>();
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public ListaVetor<Aresta<T>> getArestas() {
        return arestas;
    }

    public void setArestas(ListaVetor<Aresta<T>> arestas) {
        this.arestas = arestas;
    }
    public Aresta<T> pegaAresta(T elemento1, T elemento2){
        Vertice<T> ele1=new Vertice<>(elemento1);
        Vertice<T> ele2=new Vertice<>(elemento2);
        Aresta<T> teste=new Aresta<>(ele1,ele2);
        for(int i=0;i< arestas.tamanho();i++){
            //if(arestas.busca(i).equals(teste)) return arestas.busca(i);
            if((arestas.pega(i).getVertice1().getElemento().equals(elemento1) &&
                    arestas.pega(i).getVertice2().getElemento().equals(elemento2))||
                    (arestas.pega(i).getVertice1().getElemento().equals(elemento2) &&
                            arestas.pega(i).getVertice2().getElemento().equals(elemento1))) {
                return arestas.pega(i);
            }
        }
        return null;
    }
    public Aresta<T> pegaAresta(T elemento1, T elemento2, double peso){
        Vertice<T> ele1=new Vertice<>(elemento1);
        Vertice<T> ele2=new Vertice<>(elemento2);
        Aresta<T> teste=new Aresta<>(ele1,ele2,peso);
        for(int i=0;i< arestas.tamanho();i++){
            if(arestas.pega(i).equals(teste)) return arestas.pega(i);
            /*if((arestas.busca(i).getVertice1().getElemento().equals(elemento1) &&
                    arestas.busca(i).getVertice2().getElemento().equals(elemento2))||
                    (arestas.busca(i).getVertice1().getElemento().equals(elemento2) &&
                            arestas.busca(i).getVertice2().getElemento().equals(elemento1))){
                return arestas.busca(i);
            }*/
        }
        return null;
    }

    public void adicionaArestaSimples(Vertice<T> vertice1, Vertice<T> vertice2) {
        if(pegaAresta(vertice1.getElemento(),vertice2.getElemento())==null){
            arestas.adiciona(new Aresta<>(vertice1,vertice2));
        }
    }
    public void adicionaArestaSimples(Vertice<T> vertice1, Vertice<T> vertice2, double peso) {
        if(pegaAresta(vertice1.getElemento(),vertice2.getElemento(),peso)==null){
            arestas.adiciona(new Aresta<>(vertice1,vertice2,peso));
        }
    }

    @Override
    public String toString() {

        return elemento.toString();
    }
}
