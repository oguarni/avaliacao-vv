public class AgeClassifier {
    
    // Interface segregation principle - contrato claro
    public String classifyAge(int idade) {
        validateAge(idade);
        
        if (idade <= 17) {
            return "Menor de idade";
        } else if (idade <= 64) {
            return "Adulto";
        } else {
            return "Idoso";
        }
    }
    
    // Single Responsibility - validação separada
    private void validateAge(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa");
        }
    }
}
