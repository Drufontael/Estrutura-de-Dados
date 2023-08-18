package ordenacao;

public class Ordenar {
    public static void quick(int[] vetor){
        quick(vetor,0, vetor.length-1);

    }
    private static void quick(int[] vetor,int esquerda,int direita){

        if(direita>esquerda){
            int pivo = divide(vetor, esquerda, direita);
            quick(vetor, esquerda, pivo-1);
            quick(vetor, pivo + 1, direita);
        }


    }

    private static int divide(int[] vetor, int esquerda, int direita) {
        int pivo=vetor[esquerda];
        int i=esquerda+1;
        int j=direita;
        while (i<=j){
            while (i<=j && pivo>=vetor[i]){
                i++;
            }
            while (i<=j && pivo<vetor[j]){
                j--;
            }
            if(i<j){
                int aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                /*i++;
                j--;*/
            }
        }
        vetor[esquerda]=vetor[j];
        vetor[j]=pivo;
        return j;
    }
}
