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

```mermaid
Graph TD
    A[INÍCIO] --&gt; B[Nó 1: resultado = 1];
    B --&gt; C{Nó 2: n &lt; 0?};
    C -- SIM --&gt; D[Nó 3];
    C -- NÃO --&gt; E{Nó 4: i = 1; i &lt;= n?};
    D --&gt; G(Nó 6: return resultado);
    E -- SIM --&gt; F[Nó 5];
    E -- NÃO --&gt; G;
    F --&gt; E; /* Loop */
    G --&gt; H[FIM];

    subgraph Caminhos Independentes
        P1(Caminho 1: 1 -&gt; 2 -&gt; 3 -&gt; 6 (n negativo));
        P2(Caminho 2: 1 -&gt; 2 -&gt; 4 -&gt; 6 (n = 0, sem entrar no loop));
        P3(Caminho 3: 1 -&gt; 2 -&gt; 4 -&gt; 5 -&gt; 4 -&gt; 6 (n &gt; 0, entrando no loop uma vez));
    end

b) CAMINHOS INDEPENDENTES:
- Caminho 1: 1 → 2 → 3 → 6 (n negativo)
- Caminho 2: 1 → 2 → 4 → 6 (n = 0, sem entrar no loop)
- Caminho 3: 1 → 2 → 4 → 5 → 4 → 6 (n > 0, executa loop)
*/