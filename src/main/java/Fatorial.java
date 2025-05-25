public class Fatorial {
    public static int calcularFatorial(int n) {
        int resultado = 1;           // Nó 1
        if (n < 0) {                 // Nó 2
            return -1;               // Nó 3
        }
        for (int i = 1; i <= n; i++) { // Nó 4
            resultado *= i;          // Nó 5
        }
        return resultado;            // Nó 6
    }
}

/*
a) GRAFO DE FLUXO DE CONTROLE (CFG):

    [INÍCIO]
       |
    [Nó 1: resultado = 1]
       |
    [Nó 2: n < 0?]
      / \
    SIM  NÃO
    /      \
[Nó 3]    [Nó 4: i = 1; i <= n?]
  |            / \
  |          SIM  NÃO
  |          /      \
  |     [Nó 5]      |
  |         \       |
  |          \-----/
  |           (loop)
  |                 |
  |------------>[Nó 6: return resultado]
                    |
                  [FIM]

b) CAMINHOS INDEPENDENTES:
- Caminho 1: 1 → 2 → 3 → 6 (n negativo)
- Caminho 2: 1 → 2 → 4 → 6 (n = 0, sem entrar no loop)
- Caminho 3: 1 → 2 → 4 → 5 → 4 → 6 (n > 0, executa loop)
*/