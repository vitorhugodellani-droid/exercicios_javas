import java.util.Scanner;

public class ATIVIDADE07 {

    static int totalVendas = 0;
    static int totalProdutos = 0;

    static double faturamento = 0;
    static double totalDescontos = 0;
    static double somaSubtotais = 0;
    static double maiorVenda = 0;

    static String clienteMaiorVenda = "";

    // Calcula o subtotal da venda
    public static double Subtotal(double preco, int quantidade) {
        return preco * quantidade;
    }

    // Calcula o desconto conforme o valor da compra
    public static double DescontoFaixa(double subtotal) {
        if (subtotal >= 500) {
            return subtotal * 0.15;
        } else if (subtotal >= 200) {
            return subtotal * 0.10;
        } else if (subtotal >= 100) {
            return subtotal * 0.05;
        } else {
            return 0;
        }
    }

    // Calcula o desconto adicional para clientes VIP
    public static double DescontoVIP(double subtotal, boolean vip) {
        if (vip) {
            return subtotal * 0.05;
        }
        return 0;
    }

    // Calcula o desconto adicional do PIX
    public static double DescontoPIX(double valor, boolean pix) {
        if (pix) {
            return valor * 0.03;
        }
        return 0;
    }

    // Atualiza os dados do relatório
    public static void Relatorio(
            String cliente,
            int quantidade,
            double subtotal,
            double total,
            double desconto
    ) {
        totalVendas++;
        totalProdutos += quantidade;

        faturamento += total;
        totalDescontos += desconto;
        somaSubtotais += subtotal;

        if (total > maiorVenda) {
            maiorVenda = total;
            clienteMaiorVenda = cliente;
        }
    }

    // Registra uma venda
    public static void Venda(Scanner entrada) {

        System.out.println("\n****** NOVA VENDA ******");

        System.out.print("Nome do cliente: ");
        String cliente = entrada.nextLine();

        System.out.print("Nome do produto: ");
        String produto = entrada.nextLine();

        System.out.print("Preco unitario: ");
        double preco = entrada.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = entrada.nextInt();

        if (preco <= 0 || quantidade <= 0) {
            System.out.println("Venda invalida! Preco e quantidade devem ser maiores que zero.");
            entrada.nextLine();
            return;
        }

        System.out.print("Cliente VIP? (1 - Sim / 2 - Nao): ");
        int opcaoVIP = entrada.nextInt();

        if (opcaoVIP != 1 && opcaoVIP != 2) {
            System.out.println("Opcao VIP invalida! Venda cancelada.");
            entrada.nextLine();
            return;
        }

        System.out.print("Pagamento por PIX? (1 - Sim / 2 - Nao): ");
        int opcaoPIX = entrada.nextInt();

        if (opcaoPIX != 1 && opcaoPIX != 2) {
            System.out.println("Opcao de pagamento invalida! Venda cancelada.");
            entrada.nextLine();
            return;
        }

        boolean vip = opcaoVIP == 1;
        boolean pix = opcaoPIX == 1;

        double subtotal = Subtotal(preco, quantidade);

        double descontoFaixa = DescontoFaixa(subtotal);

        double descontoVIP = DescontoVIP(subtotal, vip);

        double valorAposDescontos = subtotal - descontoFaixa - descontoVIP;

        double descontoPIX = DescontoPIX(valorAposDescontos, pix);

        double descontoTotal = descontoFaixa + descontoVIP + descontoPIX;

        double total = subtotal - descontoTotal;

        // Atualiza o relatório somente depois de validar a venda
        Relatorio(
                cliente, quantidade, subtotal, total, descontoTotal
        );

        System.out.println("****** RECIBO ******");
        System.out.println("Cliente: " + cliente);
        System.out.println("Produto: " + produto);
        System.out.println("Quantidade: " + quantidade);

        System.out.printf("Subtotal: R$ %.2f%n", subtotal);
        System.out.printf("Desconto por faixa: R$ %.2f%n", descontoFaixa);
        System.out.printf("Desconto VIP: R$ %.2f%n", descontoVIP);
        System.out.printf("Desconto PIX: R$ %.2f%n", descontoPIX);
        System.out.printf("Desconto total: R$ %.2f%n", descontoTotal);
        System.out.printf("Total a pagar: R$ %.2f%n", total);

        entrada.nextLine();
    }

    public static void Relatorio() {

        System.out.println("****** RELATORIO DE VENDAS ******");

        System.out.println("Total de vendas: " + totalVendas);
        System.out.println("Quantidade de produtos vendidos: " + totalProdutos);

        System.out.printf("Faturamento: R$ %.2f%n", faturamento);
        System.out.printf("Total de descontos: R$ %.2f%n", totalDescontos);

        if (totalVendas > 0) {

            double ticketMedio = faturamento / totalVendas;

            double mediaProdutos = (double) totalProdutos / totalVendas;

            double percentualDescontos = (totalDescontos / somaSubtotais) * 100;

            System.out.printf("Ticket medio: R$ %.2f%n", ticketMedio);
            System.out.printf("Media de produtos por venda: %.2f%n", mediaProdutos);
            System.out.printf("Percentual de descontos: %.2f%%%n", percentualDescontos);

            System.out.printf("Maior venda: R$ %.2f%n", maiorVenda);
            System.out.println("Cliente da maior venda: " + clienteMaiorVenda);

        } else {
            System.out.println("Nenhuma venda registrada.");
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("****** SISTEMA DE VENDAS ******");
            System.out.println("1 - Registrar venda");
            System.out.println("2 - Mostrar relatorio");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    Venda(entrada);
                    break;

                case 2:
                    Relatorio();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        entrada.close();
    }
}
