import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FatorialTest {
    
    // Caminho 1: n < 0
    @Test
    void testNumeroNegativo() {
        assertEquals(-1, Fatorial.calcularFatorial(-1));
        assertEquals(-1, Fatorial.calcularFatorial(-5));
    }
    
    // Caminho 2: n = 0 (não entra no loop)
    @Test
    void testFatorialZero() {
        assertEquals(1, Fatorial.calcularFatorial(0));
    }
    
    // Caminho 3: n > 0 (executa loop)
    @Test
    void testFatorialPositivo() {
        assertEquals(1, Fatorial.calcularFatorial(1));
        assertEquals(2, Fatorial.calcularFatorial(2));
        assertEquals(6, Fatorial.calcularFatorial(3));
        assertEquals(24, Fatorial.calcularFatorial(4));
        assertEquals(120, Fatorial.calcularFatorial(5));
    }
    
    // Teste adicional para verificar comportamento do loop
    @Test
    void testLoopExecution() {
        // Verifica se o loop executa corretamente para diferentes valores
        int[] inputs = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 6, 24, 120};
        
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected[i], Fatorial.calcularFatorial(inputs[i]),
                "Fatorial de " + inputs[i] + " deve ser " + expected[i]);
        }
    }
}

/*
ANÁLISE DE COBERTURA:
- testNumeroNegativo(): Cobre o Caminho 1 (condição n < 0 verdadeira)
- testFatorialZero(): Cobre o Caminho 2 (n = 0, loop não executa)
- testFatorialPositivo(): Cobre o Caminho 3 (n > 0, loop executa)

Todos os nós e arestas do grafo são exercitados pelos testes,
garantindo 100% de cobertura de caminhos.
*/