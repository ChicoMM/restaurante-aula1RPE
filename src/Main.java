import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Integer, ItemCardapio> cardapio = new HashMap<>();
    public static void main(String[] args) {
        inicializarCardapio();
        while (true){
            System.out.println("Bem-vindo!");
            System.out.println("1.Fazer pedido\n2.Sair");
            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();
            if (escolha == 2){
                break;
            }
            else if (escolha == 1){
                Pedido pedido = Pedido.fazerPedido(cardapio);
                Pedido.gerarNota(pedido);
            }
        }
    }
    private static void inicializarCardapio(){
        cardapio.put(1, new ItemCardapio("Pizza de mussarela", 60.00));
        cardapio.put(2, new ItemCardapio("Pizza de calabresa", 70.00));
        cardapio.put(3, new ItemCardapio("Pastel de carne",10.00));
        cardapio.put(4, new ItemCardapio("Espetinho de frango",8.00));
        cardapio.put(5, new ItemCardapio("Lata de Coca-cola",6.00));
        cardapio.put(6, new ItemCardapio("Água",3.00));
    };
}