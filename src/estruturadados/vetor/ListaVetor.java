package estruturadados.vetor;

import estruturadados.base.EstruturaEstatica;

public class ListaVetor<T> extends EstruturaEstatica<T> {

    public ListaVetor(int capacidade){
        super(capacidade);
    }

    public ListaVetor(){
        super();
    }

    public void adiciona(T elemento) {
      super.adiciona(elemento);
    }

    public void adiciona(T elemento, int posicao){
        super.adiciona(elemento,posicao);

    }





    public T busca(int posicao){
        return super.busca(posicao);
    }

    public int busca(T elemento){

        return super.busca(elemento);
    }

    public boolean contem(T elemento){
        return this.busca(elemento) > -1;
    }

    public int ultimoIndice(T elemento){
        for(int i=this.tamanho-1;i>=0;i--){
            if(this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public void remove(T elemento){
        super.remove(elemento);
    }
    public void remove(int posicao){
        super.remove(posicao);
    }

    public void limpa(){
        this.elementos = (T[]) new Object[this.elementos.length];
    }
}
