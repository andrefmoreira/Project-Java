package exercicio_avaliacao_5;

abstract public class Cliente {
    
    private String nome;
    private String morada;
    private String email;
    private int telefone;
    private Data data_nascimento;

    public Cliente(String nome, String morada, String email, int telefone, Data data_nascimento ) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    
    public String getEmail() {
        return email;
    }

    public int getTelefone() {
        return telefone;
    }

    public Data getData_nascimento() {
        return data_nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setData_nascimento(Data data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + ", Morada: " + morada + ", Email: " + email + ", Telefone: " + telefone + ", Data de nascimento: " + data_nascimento;
    }
    
    abstract public int transporte(double total);
        
    
}
