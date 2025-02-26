import java.util.ArrayList;

public class Nota {
    String nomeCliente;
    ArrayList<Integer> pedidos;
    Float precoTotal;

    public Nota(Pedido pedido){
        this.nomeCliente = pedido.nomeCliente;
        this.pedidos = pedido.pedidos;
        this.precoTotal = calcularPreco(pedido.pedidos);
    }
    public float calcularPreco(){

    }
}
