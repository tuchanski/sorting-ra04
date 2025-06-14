package models;

import java.util.Random;

public class GeradorDeVetor {

    public int[] gerarVetor(int capacidade, int valorMaximo, long seed) {
        int[] vetor = new int[capacidade];
        Random random = new Random(seed);

        for (int i = 0; i < capacidade; i++) {
            vetor[i] = random.nextInt(valorMaximo);
        }
        return vetor;
    }
}