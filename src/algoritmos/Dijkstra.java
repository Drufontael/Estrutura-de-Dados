package algoritmos;

import estruturadados.grafo.Grafo;
import estruturadados.grafo.VerticeSimples;
import estruturadados.vetor.ListaVetor;

public class Dijkstra<T>{
    private T origem,destino;
    private Grafo<T> grafo;
    private ListaVetor<T> percurso;
    private double menorDistancia;
    private double[][] matrizPesos;
    private double distancia[];
    private boolean rotuloFinal[];
    private int previo[];
    private int recente;


    public Dijkstra(T origem, T destino, Grafo<T> grafo) {
        this.origem = origem;
        this.destino = destino;
        this.grafo = grafo;
        ListaVetor<VerticeSimples<T>> vertices=grafo.percorreLargura(origem);
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
        int target=vertices.busca(grafo.pegaVertice(destino));
        this.percurso=new ListaVetor<>();
        while (target!=-1){
            this.percurso.adiciona(vertices.busca(target).getElemento(),0);
            target=previo[target];
        }

    }
    public void setMatrizPesos(ListaVetor<VerticeSimples<T>> vertices){
        double[][] pesos=new double[vertices.tamanho()][vertices.tamanho()];
        for (int i=0;i<vertices.tamanho();i++){
            for (int j=0;j<vertices.tamanho();j++){
                if(vertices.busca(i).equals(vertices.busca(j))) pesos[i][j]=0.0;
                else if(grafo.existeAresta(vertices.busca(i).getElemento(),vertices.busca(j).getElemento())){
                    pesos[i][j]=vertices.busca(i).pegaAresta(vertices.busca(i).getElemento(),
                            vertices.busca(j).getElemento()).getPeso();
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
    public double menorDistancia(ListaVetor<VerticeSimples<T>> vertices){
        distancia[0]=0.0;
        rotuloFinal[0]=true;
        recente=0;
        int target=vertices.busca(grafo.pegaVertice(destino));
        while (!rotuloFinal[target]){
            double y=Double.MAX_VALUE;
            int indice=-1;
            for(int j=0;j< vertices.tamanho();j++){
                if(j!=recente && !rotuloFinal[j] && this.matrizPesos[recente][j]<Double.MAX_VALUE){
                    double rotulo=distancia[recente]+this.matrizPesos[recente][j];
                    if(rotulo<distancia[j]){
                        distancia[j]=rotulo;
                        previo[j]=recente;
                    }
                }
            }
            for(int i=0;i< vertices.tamanho();i++){
                if(distancia[i]<y && !rotuloFinal[i]){
                    y=distancia[i];
                    indice=i;
                }
            }
            recente=indice;
            rotuloFinal[recente]=true;

        }
        this.menorDistancia=distancia[target];

        return menorDistancia;
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
