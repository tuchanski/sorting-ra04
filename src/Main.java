import models.*;
import java.util.Random;

public class Main {

    private static double calcularMediaManualmente(long[] valores) {
        if (valores == null || valores.length == 0) {
            return 0.0;
        }
        double soma = 0;
        for (long valor : valores) {
            soma += valor;
        }
        return soma / valores.length;
    }

    public static int[] copiarVetorManualmente(int[] vetorOriginal) {
        if (vetorOriginal == null) {
            return null;
        }
        int[] copia = new int[vetorOriginal.length];
        for (int i = 0; i < vetorOriginal.length; i++) {
            copia[i] = vetorOriginal[i];
        }
        return copia;
    }

    public static void main(String[] args) {
        // Configurações do Teste
        int[] tamanhos = {1_000, 10_000, 100_000, 500_000, 1_000_000};
        int numRodadas = 5;
        int valorMaximo = 1_000_001; // Valor máximo para os números aleatórios [0, valorMaximo-1]

        GeradorDeVetor gerador = new GeradorDeVetor();
        Random randomSeedGenerator = new Random();

        for (int tamanho : tamanhos) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Análise para Vetores de Tamanho: " + String.format("%,d", tamanho));
            System.out.println("---------------------------------------------------------");

            // Referencia de métricas
            long[] temposMerge = new long[numRodadas];
            long[] iteracoesMerge = new long[numRodadas];
            long[] trocasMerge = new long[numRodadas];

            long[] temposCounting = new long[numRodadas];
            long[] iteracoesCounting = new long[numRodadas];
            long[] trocasCounting = new long[numRodadas];

            for (int i = 0; i < numRodadas; i++) {
                long seed = randomSeedGenerator.nextLong();
                int[] vetorOriginal = gerador.gerarVetor(tamanho, valorMaximo, seed);

                // Teste com Merge Sort
                int[] vetorParaMerge = copiarVetorManualmente(vetorOriginal);
                Metricas metricasMerge = new Metricas();
                long startTime = System.currentTimeMillis();
                MergeSort.sort(vetorParaMerge, metricasMerge);
                long endTime = System.currentTimeMillis();

                metricasMerge.setTempoExecucao(endTime - startTime);
                temposMerge[i] = metricasMerge.getTempoExecucao();
                iteracoesMerge[i] = metricasMerge.getIteracoes();
                trocasMerge[i] = metricasMerge.getTrocas();

                // Teste com Counting Sort
                int[] vetorParaCounting = copiarVetorManualmente(vetorOriginal);
                Metricas metricasCounting = new Metricas();
                startTime = System.currentTimeMillis();
                CountingSort.sort(vetorParaCounting, valorMaximo, metricasCounting);
                endTime = System.currentTimeMillis();

                metricasCounting.setTempoExecucao(endTime - startTime);
                temposCounting[i] = metricasCounting.getTempoExecucao();
                iteracoesCounting[i] = metricasCounting.getIteracoes();
                trocasCounting[i] = metricasCounting.getTrocas();
            }

            System.out.println("Resultados (Média de " + numRodadas + " rodadas):\n");
            System.out.println("---------------------------------------------------------");
            System.out.println("Métrica   | Merge Sort      | Counting Sort ");
            System.out.println("---------------------------------------------------------");
            System.out.printf("Tempo (ms) | %-20.2f |      %-20.2f \n", calcularMediaManualmente(temposMerge), calcularMediaManualmente(temposCounting));
            System.out.printf("Iterações  | %-20.2f |      %-20.2f \n", calcularMediaManualmente(iteracoesMerge), calcularMediaManualmente(iteracoesCounting));
            System.out.printf("Trocas/Mov | %-20.2f |      %-20.2f \n", calcularMediaManualmente(trocasMerge), calcularMediaManualmente(trocasCounting));
            System.out.println("---------------------------------------------------------");
            System.out.println();
        }
    }
}