import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pedido {

    String nomeCliente;
    ArrayList<ItemCardapio> pedidos;
    Double DinheiroRecebido;

    public Pedido(String nomeCliente, ArrayList<ItemCardapio> pedidos, Double DinheiroRecebido ) {
        this.nomeCliente = nomeCliente;
        this.pedidos = pedidos;
        this.DinheiroRecebido = DinheiroRecebido;
    }

    public static Pedido fazerPedido(Map<Integer, ItemCardapio> cardapio) {
        System.out.println("Digite seu nome:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        ArrayList<ItemCardapio> pedidos = new ArrayList<>();
        int numpedido;
        while(true){
            System.out.println("Digite o número do item que você deseja");
            for (Map.Entry<Integer, ItemCardapio> entry : cardapio.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getNome() + " R$ " + entry.getValue().getPreco());
            }
            System.out.println("Digite 0 para terminar o pedido");
            numpedido = scanner.nextInt();
            if (numpedido == 0){
                break;
            }
            if (cardapio.containsKey(numpedido)) {
                pedidos.add(cardapio.get(numpedido));
            }else{
                System.out.println("Opção inválida!");
            }
        }
        System.out.println("Dinheiro a enviar:");
        Double dinheiro = scanner.nextDouble();
        return new Pedido(nome, pedidos, dinheiro);

    }

    public static void gerarNota(Pedido pedido) {
        DecimalFormat round = new DecimalFormat("#.##");
        Scanner scanner = new Scanner(System.in);
        Double precoTotal = calcularPrecoTotal(pedido.pedidos);
        Double taxaServico = precoTotal * 0.10;
        Double precoFinal = precoTotal + taxaServico;
        while (pedido.DinheiroRecebido < precoFinal){
            System.out.println("Dinheiro enviado insuficiente! Faltaram R$" + round.format(precoFinal-pedido.DinheiroRecebido)  + " . Adicione mais dinheiro!");
            System.out.println("Dinheiro a acrescentar:");
            Double dinheiro = scanner.nextDouble();
            pedido.DinheiroRecebido += dinheiro;
        }
        Double troco = pedido.DinheiroRecebido - precoFinal;
        System.out.println("Pedido final de " + pedido.nomeCliente + ":\n");
        for (ItemCardapio item : pedido.pedidos){
            System.out.println(item.getNome() + " R$ " + item.getPreco());
        }
        System.out.println("\nPreco total: R$ " + round.format(precoTotal));
        System.out.println("Taxa servico: R$ " + round.format(taxaServico));
        System.out.println("Preco final: R$ " + round.format(precoFinal));
        System.out.println("Troco: R$ " + round.format(troco));
        System.out.println("Obrigado por pedir conosco " + pedido.nomeCliente + "!\n");
    }

    public static Double calcularPrecoTotal(ArrayList<ItemCardapio> pedidos) {
        Double total = 0.00;
        for (ItemCardapio item : pedidos){
            total += item.getPreco();
        }
        return total;
    }

}



