package estruturadados.grafo;

public class ArestaDirecionada<T> {
    private VerticeDigrafo<T> verticeDigrafoSai;
    private VerticeDigrafo<T> verticeDigrafoEntra;
    private int peso;

    public ArestaDirecionada(VerticeDigrafo<T> verticeDigrafoSai, VerticeDigrafo<T> verticeDigrafoEntra) {
        this.verticeDigrafoSai = verticeDigrafoSai;
        this.verticeDigrafoEntra = verticeDigrafoEntra;
        this.peso= 0;
    }

    public ArestaDirecionada(VerticeDigrafo<T> verticeDigrafoSai, VerticeDigrafo<T> verticeDigrafoEntra, int peso) {
        this.verticeDigrafoSai = verticeDigrafoSai;
        this.verticeDigrafoEntra = verticeDigrafoEntra;
        this.peso = peso;
    }

    public VerticeDigrafo<T> getVerticeSai() {
        return verticeDigrafoSai;
    }

    public void setVerticeSai(VerticeDigrafo<T> verticeDigrafoSai) {
        this.verticeDigrafoSai = verticeDigrafoSai;
    }

    public VerticeDigrafo<T> getVerticeEntra() {
        return verticeDigrafoEntra;
    }

    public void setVerticeEntra(VerticeDigrafo<T> verticeDigrafoEntra) {
        this.verticeDigrafoEntra = verticeDigrafoEntra;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(verticeDigrafoSai.getElemento()).append("---");
        sb.append(peso).append("-->");
        sb.append(verticeDigrafoEntra.getElemento());
        return sb.toString();
    }
}
