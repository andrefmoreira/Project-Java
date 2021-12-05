package exercicio_avaliacao_5;

public class Alimentares extends Produtos{
    
    private int calorias;
    private int gordura_percentagem;

    public Alimentares(int calorias, int gordura_percentagem, String identificador, String nome, double preco, int stock) {
        super(identificador, nome, preco, stock);
        this.calorias = calorias;
        this.gordura_percentagem = gordura_percentagem;

    }

    public int getCalorias() {
        return calorias;
    }

    public int getGordura_percentagem() {
        return gordura_percentagem;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public void setGordura_percentagem(int gordura_percentagem) {
        this.gordura_percentagem = gordura_percentagem;
    }
    
    
    @Override
    public double Transportar_item(){
        return 0.0;
    }
    
    @Override
    public String toString() {
        return "Nome do produto: " + super.getNome() + ", Preco do produto: " + super.getPreco() + "€(" + super.getStock() + " stock)" + ", Calorias do Produto: " + calorias + ", Percentagem de gordura do Produto: " + gordura_percentagem + "\nPromocoes:" + super.getPromo().toString();
    }
    
}
