public class PalindromeChecker {
    // Versão com defeito - não trata casos especiais
    public static boolean isPalindromeDefective(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    
    // Versão corrigida seguindo SRP (Single Responsibility Principle)
    public static boolean isPalindrome(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String não pode ser null");
        }
        
        // Normaliza: remove espaços e converte para minúsculas
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0;
        int right = normalized.length() - 1;
        
        while (left < right) {
            if (normalized.charAt(left++) != normalized.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}