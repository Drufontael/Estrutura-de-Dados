package estruturadados.grafo;

public class ArestaSimples<T> {
    private VerticeSimples<T> vertice1;
    private VerticeSimples<T> vertice2;
    private double peso;

    public ArestaSimples(VerticeSimples<T> vertice1, VerticeSimples<T> vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.peso=0.0;
    }

    public ArestaSimples(VerticeSimples<T> vertice1, VerticeSimples<T> vertice2, double peso) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.peso = peso;
    }

    public VerticeSimples<T> getVertice1() {
        return vertice1;
    }

    public void setVertice1(VerticeSimples<T> vertice1) {
        this.vertice1 = vertice1;
    }

    public VerticeSimples<T> getVertice2() {
        return vertice2;
    }

    public void setVertice2(VerticeSimples<T> vertice2) {
        this.vertice2 = vertice2;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ArestaSimples<?> that)) return false;

        if (Double.compare(getPeso(), that.getPeso()) != 0) return false;
        if(this.vertice1!=null && this.vertice2!=null){
            if(this.vertice1.equals(that.vertice1) && this.vertice2.equals(that.vertice2)) return true;
            if(this.vertice1.equals(that.vertice2) && this.vertice2.equals(that.vertice1)) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getVertice1() != null ? getVertice1().hashCode() : 0;
        result = 31 * result + (getVertice2() != null ? getVertice2().hashCode() : 0);
        temp = Double.doubleToLongBits(getPeso());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArestaSimples{");
        sb.append("(").append(vertice1.getElemento());
        sb.append("<--").append(peso);
        sb.append("-->").append(vertice2.getElemento());
        sb.append(')');
        return sb.toString();
    }
}
