package exercicio_avaliacao_5;

public class Limpeza extends Produtos{
    private int toxicidade;

    public Limpeza(int toxicidade, String identificador, String nome, double preco, int stock) {
        super(identificador, nome, preco, stock);
        this.toxicidade = toxicidade;

    }

    public int getToxicidade() {
        return toxicidade;
    }

    public void setToxicidade(int toxicidade) {
        this.toxicidade = toxicidade;
    }
    
    @Override
    public double Transportar_item(){
        return 0.0;
    }

    @Override
    public String toString() {
        return "Nome do produto: " + super.getNome() + ", Preco do produto: " + super.getPreco() + "€(" + super.getStock() + " stock)" + ", Toxicidade do Produto: " + toxicidade + "\nPromocoes: " + super.getPromo().toString() ;
    } 
    
}
