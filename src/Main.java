import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] opcoes = {"Pizza","Pastel","Espetinho"};
        int[] precos = {70, 10, 8};
        while (true){
            System.out.println("1.Fazer pedido\n2.Sair");
            Scanner scanesc = new Scanner(System.in);
            int esc = scanesc.nextInt();
            if (esc == 2){
                break;
            }
            else if (esc == 1){
                Pedido.fazerPedido(opcoes, precos);
            }
        }
    }
}