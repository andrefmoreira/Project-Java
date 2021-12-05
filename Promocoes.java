package exercicio_avaliacao_5;

abstract public class Promocoes {
    
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

    abstract public double promo(double total, int quantidade,double preco);

    @Override
    abstract public String toString();

}
