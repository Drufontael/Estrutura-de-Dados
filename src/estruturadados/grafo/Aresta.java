package estruturadados.grafo;

public class Aresta<T> {
    private Vertice<T> verticeSai;
    private Vertice<T> verticeEntra;
    private int peso;

    public Aresta(Vertice<T> verticeSai, Vertice<T> verticeEntra) {
        this.verticeSai = verticeSai;
        this.verticeEntra = verticeEntra;
        this.peso= 0;
    }

    public Aresta(Vertice<T> verticeSai, Vertice<T> verticeEntra, int peso) {
        this.verticeSai = verticeSai;
        this.verticeEntra = verticeEntra;
        this.peso = peso;
    }

    public Vertice<T> getVerticeSai() {
        return verticeSai;
    }

    public void setVerticeSai(Vertice<T> verticeSai) {
        this.verticeSai = verticeSai;
    }

    public Vertice<T> getVerticeEntra() {
        return verticeEntra;
    }

    public void setVerticeEntra(Vertice<T> verticeEntra) {
        this.verticeEntra = verticeEntra;
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
        sb.append(verticeSai.getElemento()).append("---");
        sb.append(peso).append("-->");
        sb.append(verticeEntra.getElemento());
        return sb.toString();
    }
}
