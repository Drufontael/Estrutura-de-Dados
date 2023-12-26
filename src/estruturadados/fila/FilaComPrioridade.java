package estruturadados.fila;

public class FilaComPrioridade <T> extends Fila<T>{
    public FilaComPrioridade() {
        super();
    }

    public FilaComPrioridade(int tamanho) {
        super(tamanho);
    }

    public void enfileira(T elemento){
        Comparable<T> chave=(Comparable<T>)elemento;
        int i;
        for(i=0;i<this.tamanho;i++){
            if(chave.compareTo(this.elementos[i])<0) break;
        }
        super.adiciona(i,elemento);
    }
}
