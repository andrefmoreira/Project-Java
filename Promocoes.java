package exercicio_avaliacao_5;
import java.io.Serializable;

abstract public class Promocoes implements Serializable{
    
    private Data inicio;
    private Data fim;
    
    public Promocoes(Data inicio, Data fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public Data getInicio() {
        return inicio;
    }

    public Data getFim() {
        return fim;
    }

    public void setInicio(Data inicio) {
        this.inicio = inicio;
    }

    public void setFim(Data fim) {
        this.fim = fim;
    }
    
    /**
     * 
     * Does the promotions of the items.
     * 
     * @param total , Total of the purchase
     * @param quantidade , Quantaty of the item we want to buy
     * @param preco , price of the item we want to buy
     * @return 
     */
    abstract public double promo(double total, int quantidade,double preco);

    @Override
    abstract public String toString();

}
