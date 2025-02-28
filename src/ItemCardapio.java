public class ItemCardapio {
    private String nome;
    private Double preco;

    public ItemCardapio(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public Double getPreco() {
        return preco;
    }
}
