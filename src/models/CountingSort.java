package models;

public class CountingSort {

    public static void sort(int[] dados, int valorMaximo, Metricas metricas) {
        if (dados == null || dados.length == 0) {
            return;
        }

        int[] count = new int[valorMaximo];
        int[] output = new int[dados.length];

        // Contar a frequência de cada elemento
        for (int i = 0; i < dados.length; i++) {
            count[dados[i]]++;
            metricas.incrementarIteracoes(1); // Leitura do vetor de dados
        }

        // Fazer a contagem cumulativa
        for (int i = 1; i < valorMaximo; i++) {
            count[i] += count[i - 1];
            metricas.incrementarIteracoes(1); // Leitura do vetor de contagem
        }

        // Construir o vetor de saída
        for (int i = dados.length - 1; i >= 0; i--) {
            output[count[dados[i]] - 1] = dados[i];
            count[dados[i]]--;
            metricas.incrementarTrocas(1); // Colocando no vetor de saída
            metricas.incrementarIteracoes(1); // Leitura do vetor de dados
        }

        // Copiar o vetor ordenado de volta para o original
        for (int i = 0; i < dados.length; i++) {
            dados[i] = output[i];
            metricas.incrementarTrocas(1); // Copiando de volta
        }
    }
}