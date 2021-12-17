package exercicio_avaliacao_5;

public class Normal extends Cliente{

    public Normal(String nome, String morada, String email, int telefone, Data data_nascimento) {
        super(nome, morada, email, telefone, data_nascimento);
    }
    
    @Override
    public int transporte(double total){
        return 20;
    }
    
}
