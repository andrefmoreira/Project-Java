package exercicio_avaliacao_5;

import java.util.ArrayList;

abstract public class Produtos {
    
    private String identificador;
    private String nome;
    private double preco;
    private int stock;
    private ArrayList<Promocoes> promo = new ArrayList<>();
    
    public Produtos(String identificador, String nome, double preco, int stock) {
        this.identificador = identificador;
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getStock() {
        return stock;
    }
    
    void add_promo(Promocoes pro){
        promo.add(pro);
    }

    public ArrayList<Promocoes> getPromo() {
        return promo;
    }
    
    abstract public double Transportar_item();
    
    @Override
    abstract public String toString();

}
