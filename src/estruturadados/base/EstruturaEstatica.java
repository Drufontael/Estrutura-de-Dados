package estruturadados.base;

import java.util.Arrays;

public class EstruturaEstatica<T> implements Lista<T>{
    protected int tamanho;
    protected T[] elementos;

    public EstruturaEstatica(int capacidade){
        this.elementos=(T[]) new Object[capacidade];
        this.tamanho=0;
    }

    public EstruturaEstatica(){
        this(10);
    }

    public void adiciona(T elemento) {
        this.aumentaCapacidade();
        this.elementos[this.tamanho]=elemento;
        this.tamanho++;
    }

    protected void adiciona(T elemento, int posicao){
        aumentaCapacidade();
        if(!(posicao>=0 && posicao<=this.tamanho)){
            throw new IllegalArgumentException("Posição invalida!");
        }
        for (int i=this.tamanho;i>posicao;i--){
            this.elementos[i]=this.elementos[i-1];
        }
        this.tamanho++;
        this.elementos[posicao]=elemento;

    }

    private void aumentaCapacidade(){
        if(this.tamanho==this.elementos.length){
            T[] novosElementos=(T[]) new Object[this.tamanho*2];
            System.arraycopy(this.elementos, 0, novosElementos, 0, this.tamanho);
            this.elementos=novosElementos;
        }
    }
    public T busca(int posicao){
        if(!(posicao>=0 && posicao<this.tamanho)){
            throw new IllegalArgumentException("Posição invalida!");
        }
        return this.elementos[posicao];
    }

    public int busca(T elemento){
        for(int i=0;i<this.tamanho;i++){
            if(this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public int tamanho(){
        return this.tamanho;
    }

    public void remove(T elemento){
        int indice=this.busca(elemento);
        remove(indice);
    }
    public void remove(int posicao){
        if(!(posicao>=0 && posicao<this.tamanho)){
            throw new IllegalArgumentException("Posição invalida!");
        }
        for(int i=posicao;i<this.tamanho-1;i++){
            this.elementos[i]=this.elementos[i+1];
        }
        this.tamanho--;
    }

    public boolean estaVazia(){
        return this.tamanho==0;
    }

    @Override
    public boolean contem(T elemento) {
        if(this.busca(elemento)>=0) return true;
        return false;
    }

    public void limpa(){
        this.elementos = (T[]) new Object[this.elementos.length];
    }
    public Object[] paraVetor(){
        return Arrays.copyOf(elementos,tamanho);
    }
    public T[] paraVetor(T[] vetor){
        return (T[])Arrays.copyOf(elementos,tamanho,vetor.getClass());//(T[]) new Object[this.tamanho];

    }
    public void ordena(){
        Arrays.sort(elementos);
    }

    @Override
    public String toString() {
        StringBuilder s=new StringBuilder();
        s.append("[");
        for (int i=0;i<this.tamanho;i++){
            s.append(elementos[i]);
            if(i<this.tamanho-1) s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

}
