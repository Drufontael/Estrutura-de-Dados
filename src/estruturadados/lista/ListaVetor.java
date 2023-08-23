package estruturadados.lista;

public class ListaVetor<T> extends EstruturaEstatica<T> {

    public ListaVetor(int capacidade){
        super(capacidade);
    }
    public ListaVetor(){
        super();
    }
    public int ultimoIndice(T elemento){
        for(int i=this.tamanho-1;i>=0;i--){
            if(this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }
}
