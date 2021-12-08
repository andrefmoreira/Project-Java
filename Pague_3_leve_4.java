package exercicio_avaliacao_5;

public class Pague_3_leve_4 extends Promocoes{

    public Pague_3_leve_4(Data inicio, Data fim) {
        super(inicio, fim);
    }
    
    
    @Override
    public double promo(double total,int quantidade, double preco){
        
        double preco_descontado = 0;
        
        while(quantidade - 4 >= 0){
            quantidade = quantidade - 4; 
            preco_descontado += preco;
        }
        
        return preco_descontado; 
    }   

    @Override
    public String toString() {
        return "Promocao: Pague 3 leve 4, " + "Inicio: " + super.getInicio() + ", Fim: " + super.getFim();
    }
    
}
