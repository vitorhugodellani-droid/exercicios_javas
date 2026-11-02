public class ATIVIDADE05 {
    public static void main(String[] args) {
        double media = calcularMedia(8.0, 6.0);
        boolean aprovado = estaAprovado(media);
        mostrarResultado(media, aprovado);
    }
// Crie os três métodos aqui
    public static double calcularMedia(double a, double b){
        a = (a + b)/2;
        return a;
    }
    public static boolean estaAprovado(double media){
        if (media >=6) {
            System.out.println("Esta Aprovado");
            return true;
        } else {
            System.out.println("Reprovado");
        } return false;

    }
    public static void mostrarResultado(double media, boolean aprovado){
        System.out.println("Media: " + media);
        System.out.println(aprovado);

    }
}
