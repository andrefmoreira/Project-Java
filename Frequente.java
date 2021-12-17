package exercicio_avaliacao_5;

public class Frequente extends Cliente {

    public Frequente(String nome, String morada, String email, int telefone, Data data_nascimento) {
        super(nome, morada, email, telefone, data_nascimento);
    }
   
    @Override
    public int transporte(double total){
        if(total > 40)
             return 0;
        else{
            return 15;
        }
    }
}
