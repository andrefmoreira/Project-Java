package exercicio_avaliacao_5;

import java.io.Serializable;

public class Carro_compras implements Serializable {
    
    private Produtos item;
    private int quantidade;

    public Carro_compras(Produtos item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public Produtos getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setItem(Produtos item) {
        this.item = item;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Quantidade-> " + quantidade + "\nProduto comprado-> " + item + '\n' ;
    }

}
