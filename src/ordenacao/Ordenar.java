package ordenacao;

public class Ordenar {
    /**
     * Ordenador de vetor com o algoritmo quick-sort.
     * Este metodo não aceita tipos primitivos, portanto deve se usar as classes wrappers para encapsular os primitivos
     * para usar o metodo.
     */
    public static <T extends Comparable> void quick(T[] vetor){
        quick(vetor,0, vetor.length-1);

    }
    private static <T extends Comparable> void quick(T[] vetor, int esquerda, int direita){

        if(direita>esquerda){
            int pivo = divide(vetor, esquerda, direita);
            quick(vetor, esquerda, pivo-1);
            quick(vetor, pivo + 1, direita);
        }


    }

    private static <T extends Comparable> int divide(T[] vetor, int esquerda, int direita) {
        T pivo=vetor[esquerda];
        int i=esquerda+1;
        int j=direita;
        while (i<=j){
            while (i<=j && pivo.compareTo(vetor[i])>=0){
                i++;
            }
            while (i<=j && pivo.compareTo(vetor[j])<0){
                j--;
            }
            if(i<j){
                T aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;

            }
        }
        vetor[esquerda]=vetor[j];
        vetor[j]=pivo;
        return j;
    }
}
