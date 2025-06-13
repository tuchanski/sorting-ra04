package models;
import java.util.Random;

public class GeradorDeVetor {

    private int capacidade; // Capacidade do vetor aleatório a ser gerado

    public GeradorDeVetor(int capacidade) {
        this.capacidade = capacidade;
    }

    public int[] gerarVetor() {

        int[] vetor = new int[capacidade];
        Random random = new Random();

        for (int i = 0; i < capacidade; i++) {
            vetor[i] = random.nextInt();
        }

        return vetor;
    }

}
