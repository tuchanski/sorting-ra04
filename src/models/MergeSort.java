package models;

public class MergeSort {

    public static void sort(int[] dados, Metricas metricas) {
        if (dados == null || dados.length == 0) {
            return;
        }
        mergeSort(dados, 0, dados.length - 1, metricas);
    }

    private static void mergeSort(int[] dados, int inicio, int fim, Metricas metricas) {
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;
            mergeSort(dados, inicio, meio, metricas);
            mergeSort(dados, meio + 1, fim, metricas);
            mesclar(dados, inicio, meio, fim, metricas);
        }
    }

    private static void mesclar(int[] dados, int inicio, int meio, int fim, Metricas metricas) {
        // Criar arrays temporários
        int[] esquerda = new int[meio - inicio + 1];
        int[] direita = new int[fim - meio];

        // Copiar dados para os arrays temporários
        for (int i = 0; i < esquerda.length; i++) {
            esquerda[i] = dados[inicio + i];
            metricas.incrementarTrocas(1);
        }
        for (int j = 0; j < direita.length; j++) {
            direita[j] = dados[meio + 1 + j];
            metricas.incrementarTrocas(1);
        }

        // Índices para percorrer os arrays
        int i = 0, j = 0;
        int k = inicio;

        // Mesclar os arrays temporários de volta em 'dados'
        while (i < esquerda.length && j < direita.length) {
            metricas.incrementarIteracoes(1); // Cada comparação é uma iteração
            if (esquerda[i] <= direita[j]) {
                dados[k] = esquerda[i];
                i++;
            } else {
                dados[k] = direita[j];
                j++;
            }
            metricas.incrementarTrocas(1); // Cada elemento inserido de volta conta como troca/movimento
            k++;
        }

        // Copiar elementos restantes da esquerda, se houver
        while (i < esquerda.length) {
            dados[k] = esquerda[i];
            metricas.incrementarTrocas(1);
            i++;
            k++;
        }

        // Copiar elementos restantes da direita, se houver
        while (j < direita.length) {
            dados[k] = direita[j];
            metricas.incrementarTrocas(1);
            j++;
            k++;
        }
    }
}