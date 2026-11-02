public class ATIVIDADE03 {
    public static void main(String[] args) {
        mostrarDobro(8);
        mostrarSoma(10, 5);
    }
// Crie os dois métodos aqui
    public static void mostrarDobro(int numero){

        numero = numero * 2;
        System.out.println("o dobro de 8 é: " + numero);
    }
    public static void mostrarSoma(int a, int b){

        System.out.println("Somas de 10 + 5 é " + (a + b));

    }
}
