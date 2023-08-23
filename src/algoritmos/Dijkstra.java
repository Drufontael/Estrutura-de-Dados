package algoritmos;

import estruturadados.grafo.Grafo;
import estruturadados.grafo.Vertice;
import estruturadados.lista.ListaVetor;

public class Dijkstra<T>{
    private final T destino;
    private final Grafo<T> grafo;
    private final ListaVetor<T> percurso;
    private double menorDistancia;
    private double[][] matrizPesos;
    private final double[] distancia;
    private final boolean[] rotuloFinal;
    private final int[] previo;


    public Dijkstra(T origem, T destino, Grafo<T> grafo) {
        this.destino = destino;
        this.grafo = grafo;
        ListaVetor<Vertice<T>> vertices=grafo.percorreLargura(origem);
        setMatrizPesos(vertices);
        distancia=new double[vertices.tamanho()];
        rotuloFinal=new boolean[vertices.tamanho()];
        previo=new int[vertices.tamanho()];
        for(int i=0;i<vertices.tamanho();i++){
            distancia[i]=Double.MAX_VALUE;
            rotuloFinal[i]=false;
            previo[i]=-1;
        }
        menorDistancia(vertices);
        int target=vertices.pega(grafo.pegaVertice(destino));
        this.percurso=new ListaVetor<>();
        while (target!=-1){
            this.percurso.adiciona(0,vertices.pega(target).getElemento());
            target=previo[target];
        }

    }
    public void setMatrizPesos(ListaVetor<Vertice<T>> vertices){
        double[][] pesos=new double[vertices.tamanho()][vertices.tamanho()];
        for (int i=0;i<vertices.tamanho();i++){
            for (int j=0;j<vertices.tamanho();j++){
                if(vertices.pega(i).equals(vertices.pega(j))) pesos[i][j]=0.0;
                else if(grafo.existeAresta(vertices.pega(i).getElemento(),vertices.pega(j).getElemento())){
                    pesos[i][j]=vertices.pega(i).pegaAresta(vertices.pega(i).getElemento(),
                            vertices.pega(j).getElemento()).getPeso();
                }else{
                    pesos [i][j]=Double.MAX_VALUE;
                }
            }
        }
        this.matrizPesos=pesos;

    }

    public double getMenorDistancia() {
        return menorDistancia;
    }

    public ListaVetor<T> percurso(){
       return percurso;
    }
    public void menorDistancia(ListaVetor<Vertice<T>> vertices){
        distancia[0]=0.0;
        rotuloFinal[0]=true;
        int recente = 0;
        int target=vertices.pega(grafo.pegaVertice(destino));
        while (!rotuloFinal[target]){
            double y=Double.MAX_VALUE;
            int indice=-1;
            for(int j=0;j< vertices.tamanho();j++){
                if(j!= recente && !rotuloFinal[j] && this.matrizPesos[recente][j]<Double.MAX_VALUE){
                    double rotulo=distancia[recente]+this.matrizPesos[recente][j];
                    if(rotulo<distancia[j]){
                        distancia[j]=rotulo;
                        previo[j]= recente;
                    }
                }
            }
            for(int i=0;i< vertices.tamanho();i++){
                if(distancia[i]<y && !rotuloFinal[i]){
                    y=distancia[i];
                    indice=i;
                }
            }
            recente =indice;
            rotuloFinal[recente]=true;

        }
        this.menorDistancia=distancia[target];

    }
    public static<T> ListaVetor<T> percursoMenor(Grafo<T> grafo,T pontoA, T pontoB){
        Dijkstra<T> dijkstra=new Dijkstra<>(pontoA,pontoB,grafo);
        return dijkstra.percurso();
    }
    public static<T> double distanciaMenor(Grafo<T> grafo,T pontoA, T pontoB){
        Dijkstra<T> dijkstra=new Dijkstra<>(pontoA,pontoB,grafo);
        return dijkstra.getMenorDistancia();
    }

}
