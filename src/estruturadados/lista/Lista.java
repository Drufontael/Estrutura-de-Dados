package estruturadados.lista;

public interface Lista<T> {
    void adiciona(T elemento);
    void adiciona(int indice, T elemento);
    int pega(T elemento);
    T pega(int indice);
    void remove(int indice);
    void remove(T elemento);
    int tamanho();
    boolean estaVazia();
    boolean contem(T elemento);
}
