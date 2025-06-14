package models;

public class MergeSort {

    public static int[] merge(int[] dadosDesordenados) {

        if (dadosDesordenados.length <= 1) {
            return dadosDesordenados;
        }

        int meio = dadosDesordenados.length / 2;

        int[] esquerda = new int[meio];
        int[] direita = new int[dadosDesordenados.length - meio];

        for (int i = 0; i < meio; i++) {
            esquerda[i] = dadosDesordenados[i];
        }

        for (int i = meio; i < dadosDesordenados.length; i++) {
            direita[i - meio] = dadosDesordenados[i];
        }

        esquerda = merge(esquerda);
        direita = merge(direita);

        return mesclar(esquerda, direita);

    }

    private static int[] mesclar(int[] esquerda, int[] direita) {
        int[] merged = new int[esquerda.length + direita.length];
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                merged[k++] = esquerda[i++];
            } else {
                merged[k++] = direita[j++];
            }
        }

        while (i < esquerda.length) {
            merged[k++] = esquerda[i++];
        }

        while (j < direita.length) {
            merged[k++] = direita[j++];
        }

        return merged;
    }


}
