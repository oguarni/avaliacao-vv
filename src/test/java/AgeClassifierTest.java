import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgeClassifierTest {
    
    private AgeClassifier classifier;
    
    @BeforeEach
    void setUp() {
        classifier = new AgeClassifier();
    }
    
    // RED: Teste escrito primeiro (falha inicialmente)
    @Test
    void testMenorDeIdade() {
        assertEquals("Menor de idade", classifier.classifyAge(0));
        assertEquals("Menor de idade", classifier.classifyAge(10));
        assertEquals("Menor de idade", classifier.classifyAge(17));
    }
    
    // RED: Segundo teste (falha)
    @Test
    void testAdulto() {
        assertEquals("Adulto", classifier.classifyAge(18));
        assertEquals("Adulto", classifier.classifyAge(30));
        assertEquals("Adulto", classifier.classifyAge(64));
    }
    
    // RED: Terceiro teste (falha)
    @Test
    void testIdoso() {
        assertEquals("Idoso", classifier.classifyAge(65));
        assertEquals("Idoso", classifier.classifyAge(80));
        assertEquals("Idoso", classifier.classifyAge(100));
    }
    
    // RED: Teste para validação
    @Test
    void testIdadeNegativa() {
        assertThrows(IllegalArgumentException.class, 
            () -> classifier.classifyAge(-1));
    }
}

/* 
PROCESSO TDD:

1. RED: Escrevi primeiro os testes que definem o comportamento esperado
   - Todos falharam pois a classe ainda não existia

2. GREEN: Implementei o código mínimo para passar nos testes
   - Criei a classe AgeClassifier
   - Implementei o método classifyAge com a lógica necessária

3. REFACTOR: Melhorei o código mantendo os testes passando
   - Extraí validação para método separado (SRP)
   - Organizei condições de forma clara
   - Adicionei comentários explicativos

O TDD guiou o desenvolvimento garantindo:
- Cobertura completa desde o início
- Design focado no comportamento esperado
- Código testável e modular
- Confiança para refatorações futuras
*/