package exercicio_avaliacao_5;

public class Pague_menos extends Promocoes{

    public Pague_menos( Data inicio, Data fim ) {
        super(inicio, fim );
    }

    @Override
    public double promo(double total, int quantidade,double preco){
        double promo = 1;
        double valor_retirado = 0;
                
        for(int i = 0 ; i < quantidade; i++){
            
            if(promo > 0.5){
                valor_retirado += preco * (1 - promo);
                promo = promo - 0.05;
            }
            else{
                total = total * 0.5;
                return total;
            }
        }

        return valor_retirado;

    }
    
    @Override
    public String toString() {
        return "Promocao: Pague menos, " + "Inicio: " + super.getInicio() + ", Fim: " + super.getFim();
    }
}
