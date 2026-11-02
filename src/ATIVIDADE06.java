import java.util.Scanner;

public class ATIVIDADE06 {

    public static void Cabecalho() {
        System.out.println("****** LOJA JAVA ******");
    }
    public static double calcularSubtotal(double preco, int quantidade) {
        return preco * quantidade;
    }

    public static double calcularDesconto(double subtotal) {
        if (subtotal >= 200) {
            return subtotal * 0.10;
        }
        return 0;
    }

    public static double calcularTotal(double subtotal, double desconto) {
        return subtotal - desconto;
    }

    public static void mostrarRecibo(String cliente, String produto,
                                     int quantidade, double subtotal, double desconto, double total) {

        System.out.println();
        System.out.println("****** RECIBO ******");
        System.out.println("Cliente: " + cliente);
        System.out.println("Produto: " + produto);
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Subtotal: R$ %.2f%n", subtotal);
        System.out.printf("Desconto: R$ %.2f%n", desconto);
        System.out.printf("Total: R$ %.2f%n", total);
    }

    // DICA 6 - Realizar uma venda
    public static void realizarVenda(Scanner sc) {

        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Nome do produto: ");
        String produto = sc.nextLine();

        System.out.print("Preco do produto: ");
        double preco = sc.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        double subtotal = calcularSubtotal(preco, quantidade);
        double desconto = calcularDesconto(subtotal);
        double total = calcularTotal(subtotal, desconto);

        mostrarRecibo(cliente, produto, quantidade,
                subtotal, desconto, total);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cabecalho();

        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {

            realizarVenda(sc);

            System.out.print("Deseja registrar outra venda? (s/n): ");
            continuar = sc.nextLine();
        }

    }
}
