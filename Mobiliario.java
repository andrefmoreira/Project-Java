package exercicio_avaliacao_5;

public class Mobiliario extends Produtos{
    private double peso;
    private double dimensao;

    public Mobiliario(double peso, double dimensao, String identificador, String nome, double preco, int stock) {
        super(identificador, nome, preco, stock);
        this.peso = peso;
        this.dimensao = dimensao;

    }

    public double getPeso() {
        return peso;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }
    
    @Override
    public double Transportar_item(){
        if(peso > 15.0)
            return 10.0;
        else
            return 0.0;
    }
    
    
    @Override
    public String toString() {
        return "Nome do produto: " + super.getNome() + ", Preco do produto: " + super.getPreco() + "€(" + super.getStock() + " stock)" + ", Peso do Produto: " + peso + ", Dimensao do produto: " + dimensao + "\nPromocoes:" + super.getPromo().toString() ;
    }
}
