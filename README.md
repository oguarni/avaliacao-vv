# Avaliação de Verificação e Validação de Software

**Aluno:** Gabriel Felipe Guarnieri  
**Data:** 24/5/2025  
**Disciplina:** Verificação e Validação de Software

## Estrutura do Projeto

```
src/
├── main/
│   └── java/
│       ├── AgeClassifier.java
│       ├── Fatorial.java
│       └── PalindromeChecker.java
└── test/
    └── java/
        ├── AgeClassifierTest.java
        ├── FatorialTest.java
        └── PalindromeCheckerTest.java
```

---

## PARTE 1: QUESTÕES TEÓRICAS

### Questão 1: Conceitos Fundamentais

#### a) Diferença entre Erro, Defeito e Falha

**Erro (Error):** Ação humana incorreta durante o desenvolvimento do software. É o engano cometido pelo desenvolvedor.

```java
// ERRO: Desenvolvedor esqueceu de validar divisão por zero
public double dividir(double a, double b) {
    return a / b;  // Erro humano: não validou b == 0
}
```

**Defeito (Defect/Bug):** O código incorreto resultante do erro. É a materialização do erro no código.

```java
// DEFEITO: Código sem validação presente no sistema
public double dividir(double a, double b) {
    return a / b;  // Defeito: falta tratamento para b == 0
}
```

**Falha (Failure):** Manifestação observável quando o defeito é executado. É o comportamento indevido percebido pelo usuário.

```java
// FALHA: ArithmeticException ao executar dividir(10, 0)
// Mensagem: "/ by zero" - comportamento incorreto observado
```

#### b) Diferença entre Teste Funcional e Estrutural

- **Teste Funcional (Caixa Preta):** 
  - Valida o comportamento sem conhecer a implementação interna
  - Foca em entradas e saídas conforme requisitos
  - Perspectiva do usuário final

- **Teste Estrutural (Caixa Branca):**
  - Analisa o código-fonte e estrutura interna
  - Valida caminhos de execução, condições e cobertura
  - Perspectiva do desenvolvedor

#### c) Particionamento por Classes de Equivalência

Técnica que agrupa entradas com comportamento similar, reduzindo o número de casos de teste necessários sem comprometer a cobertura.

**Exemplo - Sistema Bancário (Saque):**
- **Classe 1:** Valores inválidos (≤ 0)
- **Classe 2:** Valores válidos dentro do saldo (1 a saldo disponível)  
- **Classe 3:** Valores acima do saldo (> saldo disponível)

### Questão 2: Análise de Valor Limite

**Sistema de Votação - Casos de Teste:**

| Entrada | Saída Esperada |
|---------|----------------|
| (15, true) | "Voto proibido" |
| (16, true) | "Voto facultativo" |
| (17, true) | "Voto facultativo" |
| (18, true) | "Voto obrigatório" |
| (70, true) | "Voto obrigatório" |
| (71, true) | "Voto facultativo" |
| (18, false) | "Voto facultativo" |
| (50, false) | "Voto facultativo" |

### Questão 3: Classes de Equivalência para IdadeUtils

**Classes de Equivalência Válidas:**
- **CE1:** idade < 0 → "Inválido"
- **CE2:** 0 ≤ idade < 18 → "Menor de idade"
- **CE3:** 18 ≤ idade < 65 → "Adulto"
- **CE4:** idade ≥ 65 → "Idoso"

**Classes Inválidas:**
- **CE5:** entrada não numérica (se método aceitasse String)

**Casos de Teste Representativos:**
1. idade = -5 → "Inválido"
2. idade = 10 → "Menor de idade"
3. idade = 25 → "Adulto"
4. idade = 70 → "Idoso"

---

## PARTE 2: IMPLEMENTAÇÃO PRÁTICA

### Questão 4: PalindromeChecker com JUnit

#### Análise do Defeito

A versão com defeito não trata adequadamente:
- Strings com espaços
- Diferenças entre maiúsculas e minúsculas
- Valores null

#### Processo de Correção

1. **Identificação:** Testes revelaram falhas em casos com espaços e case-sensitivity
2. **Correção:** Implementação de normalização (remover espaços, converter para minúsculas)
3. **Validação:** Todos os testes passam após correção

```java
// Versão corrigida seguindo SRP
public static boolean isPalindrome(String str) {
    if (str == null) {
        throw new IllegalArgumentException("String não pode ser null");
    }
    
    String normalized = str.replaceAll("\\s+", "").toLowerCase();
    // ... resto da implementação
}
```

### Questão 5: TDD para classifyAge

#### Processo TDD Aplicado

1. **RED (Teste Primeiro):**
   ```java
   @Test
   void testMenorDeIdade() {
       assertEquals("Menor de idade", classifier.classifyAge(10));
   }
   ```
   - Teste falha pois classe não existe

2. **GREEN (Implementação Mínima):**
   ```java
   public String classifyAge(int idade) {
       if (idade <= 17) return "Menor de idade";
       // ...
   }
   ```
   - Código mínimo para passar no teste

3. **REFACTOR (Melhoria):**
   - Extrair validação para método separado (SRP)
   - Melhorar estrutura condicional
   - Adicionar documentação

#### Princípios SOLID Aplicados

- **SRP:** Validação de idade separada da classificação
- **OCP:** Fácil adicionar novas categorias sem modificar código existente
- **DIP:** Poderia aceitar interface para diferentes estratégias de classificação

### Questão 6: Análise de Grafo de Fluxo de Controle

#### a) Grafo de Fluxo de Controle (CFG)

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
```

#### b) Caminhos Independentes

1. **Caminho 1:** 1 → 2 → 3 → 6 (n negativo)
2. **Caminho 2:** 1 → 2 → 4 → 6 (n = 0, sem entrar no loop)
3. **Caminho 3:** 1 → 2 → 4 → 5 → 4 → 6 (n > 0, executa loop)

#### Análise de Cobertura

Os testes implementados garantem 100% de cobertura:
- `testNumeroNegativo()`: Cobre Caminho 1
- `testFatorialZero()`: Cobre Caminho 2  
- `testFatorialPositivo()`: Cobre Caminho 3

---

## Como Executar os Testes

### Com Maven:
```bash
mvn clean test
```

### Com Gradle:
```bash
gradle test
```

### Com IDE:
- IntelliJ IDEA: Clique direito na pasta `test` → "Run All Tests"
- Eclipse: Clique direito no projeto → "Run As" → "JUnit Test"

---

## Conclusões

Este projeto demonstra a aplicação prática de conceitos fundamentais de testes de software:

1. **Terminologia Clara:** Compreensão das diferenças entre erro, defeito e falha
2. **Metodologias Complementares:** Uso adequado de testes caixa preta e branca
3. **Técnicas de Otimização:** Aplicação de classes de equivalência e valor limite
4. **TDD na Prática:** Desenvolvimento guiado por testes com ciclo Red-Green-Refactor
5. **Princípios SOLID:** Código testável e manutenível
6. **Análise de Cobertura:** Garantia de testes completos através de CFG

As implementações seguem as melhores práticas da indústria, resultando em código robusto, testável e de fácil manutenção.
