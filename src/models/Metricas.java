package models;

public class Metricas {
    private long iteracoes;
    private long trocas;
    private long tempoExecucao; // Em milissegundos

    public void reset() {
        this.iteracoes = 0;
        this.trocas = 0;
        this.tempoExecucao = 0;
    }

    public void incrementarIteracoes(long quantidade) {
        this.iteracoes += quantidade;
    }

    public void incrementarTrocas(long quantidade) {
        this.trocas += quantidade;
    }

    public long getIteracoes() { return iteracoes; }
    public long getTrocas() { return trocas; }
    public long getTempoExecucao() { return tempoExecucao; }
    public void setTempoExecucao(long tempoExecucao) { this.tempoExecucao = tempoExecucao; }
}