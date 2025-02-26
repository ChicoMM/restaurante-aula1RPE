import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pedido {

    String nomeCliente;
    ArrayList<Integer> pedidos;

    public Pedido(String nomeCliente, ArrayList<Integer> pedidos ){
        this.nomeCliente = nomeCliente;
        this.pedidos = pedidos;
    }

    public static void fazerPedido(String[] opcoes, int[] precos) {
        System.out.println("Digite seu nome:");
        Scanner scannome = new Scanner(System.in);
        String nome = scannome.nextLine();
        Scanner scanpedido = new Scanner(System.in);
        ArrayList<Integer> pedidos = new ArrayList<>();
        int numpedido;
        do {
            for (int i = 0; i < opcoes.length; i++) {
                System.out.println(i + 1 + ". " + opcoes[i] + " R$ " + precos[i]);
            }
            numpedido = scannome.nextInt();
            pedidos.add(numpedido);
        } while (numpedido != 0);
        Pedido pedido = new Pedido(nome, pedidos);
        gerarNota(pedido,precos);
    }
    public static void gerarNota(Pedido pedido, int[] precos) {
        Nota nota = new Nota(pedido);
    }
    }


