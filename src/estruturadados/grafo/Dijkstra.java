package estruturadados.grafo;

import estruturadados.vetor.ListaVetor;

public class Dijkstra<T>{
    private T origem,destino;
    private Grafo<T> grafo;
    private ListaVetor<T> percurso;
    private double menorDistancia;

    public Dijkstra(T origem, T destino, Grafo<T> grafo) {
        this.origem = origem;
        this.destino = destino;
        this.grafo = grafo;
        ListaVetor<VerticeSimples<T>> vertices=grafo.percorreLargura(origem);
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
        double dist[]=new double[vertices.tamanho()];
        boolean fim[]=new boolean[vertices.tamanho()];
        int prev[]=new int[vertices.tamanho()];
        for(int i=0;i<vertices.tamanho();i++){
            dist[i]=Double.MAX_VALUE;
            fim[i]=false;
            prev[i]=-1;
        }
        dist[0]=0.0;
        fim[0]=true;
        int recente=0;
        int target=vertices.busca(grafo.pegaVertice(destino));
        while (!fim[target]){
            double y=Double.MAX_VALUE;
            int indice=-1;
            for(int j=0;j< vertices.tamanho();j++){
               if(j!=recente && !fim[j] && pesos[recente][j]<Double.MAX_VALUE){
                   double rotulo=dist[recente]+pesos[recente][j];
                   if(rotulo<dist[j]){
                       dist[j]=rotulo;
                       prev[j]=recente;
                   }
               }
            }
            for(int i=0;i< vertices.tamanho();i++){
                if(dist[i]<y && !fim[i]){
                    y=dist[i];
                    indice=i;
                }
            }
            recente=indice;
            fim[recente]=true;

        }
        this.menorDistancia=dist[target];
        this.percurso=new ListaVetor<>();
        while (target!=-1){
            this.percurso.adiciona(vertices.busca(target).getElemento(),0);
            target=prev[target];
        }

    }

    public ListaVetor<T> percurso(){
       return percurso;
    }
    public double menorDistancia(){
        return menorDistancia;
    }
}
