package exercicio_avaliacao_5;
import java.io.Serializable;
import java.util.ArrayList;

public class Compra implements Serializable{
    
    private double total;
    private Data data;
    private ArrayList<Carro_compras> carro = new ArrayList<>();

    public Compra(double total, Data data) {
        this.total = total;
        this.data = data;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setProduto(ArrayList<Carro_compras> carro) {
        this.carro = carro;
    }

    public double getTotal() {
        return total;
    }

    public Data getData() {
        return data;
    }

    public ArrayList<Carro_compras> getCarro() {
        return carro;
    }
     
    
    
    void realiza_compra(Carro_compras c){
        
        if(c.getItem().getStock() >= c.getQuantidade()){
                c.getItem().setStock(c.getItem().getStock() - c.getQuantidade());
                carro.add(c);
                total += c.getItem().getPreco() * c.getQuantidade();
        }
        else{
                System.out.println("Não existe stock sufeciente!");
         
        }
    }
    
    void add_total(double pagamento){
       total += pagamento;
    }

    @Override
    public String toString() {
        return "Preco total: " + total + "€\nData da compra: " + data + "\nProdutos Comprados: " + carro.toString() ;
    }
    
    
    
}
