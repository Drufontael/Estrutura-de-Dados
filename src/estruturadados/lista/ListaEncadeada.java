package estruturadados.lista;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultima;
    private int tamanho=0;

    public void adiciona(T elemento){
        No<T> celula=new No<>(elemento);
        if(this.tamanho==0){
            this.inicio = celula;
        }else {
            this.ultima.setProximo(celula);
        }
        this.ultima=celula;
        tamanho++;
    }

    public void limpa(){
        for(No<T> atual=this.inicio;atual!=null;){
            No<T> proximo=atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual=proximo;
        }
        this.tamanho=0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        if (this.tamanho==0) return "[]";
        No<T> atual=this.inicio;
        final StringBuilder sb = new StringBuilder("[");
        sb.append(atual.getElemento());
        while (atual.getProximo()!=null){
            atual=atual.getProximo();
            sb.append(',').append(atual.getElemento());
        }
        sb.append(']');
        return sb.toString();
    }
/*public String toString() {
        if (this.tamanho==0) return "[]";
        No<T> atual=this.inicio;
        final StringBuilder sb = new StringBuilder("ListaEncadeada{");
        sb.append("[").append(atual);
        while (atual.getProximo()!=null){
            atual=atual.getProximo();
            sb.append(',').append(atual);
        }
        sb.append(']');
        return sb.toString();
    }*/
}
