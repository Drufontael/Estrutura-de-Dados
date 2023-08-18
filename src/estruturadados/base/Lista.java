package estruturadados.base;

public interface Lista<T> {
    public void adiciona(T elemento);
    public void remove(T elemento);
    public int tamanho();
    public boolean estaVazia();
    public boolean contem(T elemento);
}
