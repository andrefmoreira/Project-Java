package exercicio_avaliacao_5;
import java.util.ArrayList;

public class Exercicio_avaliacao_5 {
       
    
    public static void main(String[] args) {
        
        ArrayList<Produtos> p = new ArrayList<>(); 
        Supermercados s = new Supermercados();
        String dias[] = null;
        
        Data d = new Data(1,1,1);
        Data d1 = new Data(1,1,1000);
        Data d2 = new Data(12,10,2021);
        Data d3 = new Data(10,10,2021);
        String email = null;

        Cliente cli; 
        
        s.add_clientes(new Frequente("Andre","rua escura","email@hotmail.com",911122222,d));
        s.add_clientes(new Frequente("Asdrubalino","rua dos santos","asdrubalino@gmail.com",963963963,d3));
        s.add_clientes(new Frequente("Joao","rua da luz","mais@hotmail.com",912123456,d));
        s.add_clientes(new Frequente("Joana","rua do escuro","menos@gmail.com",98888888,d2));
        s.add_clientes(new Frequente("Super Mario","BeanBean Kingdom","supermario@hotmail.com",911111111,d1));
        
        s.add_clientes(new Normal("Diogo","rua clara","p@gmail.com",923422234,d1));
        s.add_clientes(new Normal("Maria","Rua dos cleridos","gmail@gmail.com",919999222,d2));
        s.add_clientes(new Normal("Alesdresia","rua dos demonios","j@hotmail.com",986862321,d3));
        s.add_clientes(new Normal("Toad","Reino Cogumelo","cogumelo@gmail.com",954213211,d));
        s.add_clientes(new Normal("Bowser","Reino dos Koopas","bowser@hotmail.com",923111898,d2));
        
        
        System.out.println("Iniciando login.....");  
        System.out.println("Qual o seu email: ");       

        cli = s.existe(email);    
        
        System.out.println("\nBem Vindo " + cli.getNome() + "..." );                        
       
        Alimentares a = new Alimentares(120,15,"aaaaaaa","Queijo da Serra",5.0,30);
        Limpeza l = new Limpeza(105,"aaaaaaa","Limpa-tudo",7.0,15);   
        Mobiliario m = new Mobiliario(17.3,13.2,"aaaaa","Armario",25.0,5);
        
        p.add(a);
        p.add(l);
        p.add(m);
        
        a.add_promo(new Pague_3_leve_4(d3,d2));
        a.add_promo(new Pague_menos(d,d1));    
        
        s.menu(p , d , cli , dias , s);
        
        System.out.println("\nMuito obrigado por comprar com o Continente!!!\nAté Breve....");
    }
}
    
