import matplotlib.pyplot as plt

# Os dados aqui foram obtidos através do programa principal, criado em Java.

# Tamanho dos vetores
tamanhos = [1000, 10000, 100000, 500000, 1000000]

# Tempo (ms)
merge_tempo = [0.6, 1.0, 13.6, 74.8, 140.4]
counting_tempo = [5.4, 3.2, 2.2, 7.2, 16.6]

# Iterações
merge_iter = [8722.4, 120458.2, 1536281.4, 8836864.6, 18674178.6]
counting_iter = [1002000, 1020000, 1200000, 2000000, 3000000]

# Trocas/Movimentos
merge_trocas = [19952, 267232, 3337856, 18951424, 39902848]
counting_trocas = [2000, 20000, 200000, 1000000, 2000000]

def plot_graph(y_merge, y_counting, ylabel, title):
    plt.figure(figsize=(8,5))
    plt.plot(tamanhos, y_merge, marker='o', label='Merge Sort')
    plt.plot(tamanhos, y_counting, marker='s', label='Counting Sort')
    plt.xlabel('Tamanho do Vetor')
    plt.ylabel(ylabel)
    plt.title(title)
    plt.legend()
    plt.grid(True)
    plt.tight_layout()
    plt.show()

plot_graph(merge_tempo, counting_tempo, 'Tempo (ms)', 'Tempo de Execução vs Tamanho do Vetor')
plot_graph(merge_iter, counting_iter, 'Iterações', 'Iterações vs Tamanho do Vetor')
plot_graph(merge_trocas, counting_trocas, 'Trocas / Movimentos', 'Trocas/Movimentos vs Tamanho do Vetor')
