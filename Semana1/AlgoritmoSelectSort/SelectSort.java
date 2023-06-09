package AlgoritmoSelectSort;

public class SelectSort {
    //INTENTAR
    public static void selectionSort(int[] array){
        int min;
        int indice;
        for (int i = 0; i < array.length - 1; i++) {
            indice = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[indice]) {
                    indice = j;
                }
            }
            min = array[indice];
            array[indice] = array[i];
            array[i] = min;
        }
    }

    public static void main(String a[]){
        int[] array = {4, 2, 3, 7};
        System.out.println("Antes de hacer Selection Sort");
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();

        selectionSort(array);

        System.out.println("Despues de hacer Selection Sort");
        for(int i : array){
            System.out.print(i+" ");
        }
    }
}
