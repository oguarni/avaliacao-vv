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

a) GRAFO DE FLUXO DE CONTROLE (CFG):

```mermaid
Graph TD
    A[INÍCIO] --> B[Nó 1: resultado = 1];
    B --> C{Nó 2: n < 0?};
    C -- SIM --> D[Nó 3];
    C -- NÃO --> E{Nó 4: i = 1; i <= n?};
    D --> G(Nó 6: return resultado);
    E -- SIM --> F[Nó 5];
    E -- NÃO --> G;
    F --> E; /* Loop */
    G --> H[FIM];

    subgraph Caminhos Independentes
        P1(Caminho 1: 1 -> 2 -> 3 -> 6 (n negativo));
        P2(Caminho 2: 1 -> 2 -> 4 -> 6 (n = 0, sem entrar no loop));
        P3(Caminho 3: 1 -> 2 -> 4 -> 5 -> 4 -> 6 (n > 0, entrando no loop uma vez));
    end

b) CAMINHOS INDEPENDENTES:
- Caminho 1: 1 → 2 → 3 → 6 (n negativo)
- Caminho 2: 1 → 2 → 4 → 6 (n = 0, sem entrar no loop)
- Caminho 3: 1 → 2 → 4 → 5 → 4 → 6 (n > 0, executa loop)
*/
