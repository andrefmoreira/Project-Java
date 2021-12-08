package exercicio_avaliacao_5;
import java.io.*;


public class Exercicio_avaliacao_5 {
       
    
    public static void main(String[] args) {

        Supermercados s = new Supermercados();

        File fileProdutos = new File("produtos.txt");
        File fileClientes = new File("clientes.txt");
        File filePromocoes = new File("promocoes.txt");
        File fileSupermercados = new File("Supermercados.obj");

        Cliente cli = null;

        if(!fileSupermercados.exists()){
            s.ler_ficheiro_produtos(fileProdutos);
            s.ler_ficheiro_promocoes(filePromocoes);
            s.ler_ficheiro_clientes(fileClientes);
            System.out.println("Iniciando login.....");
            System.out.println("Qual o seu email: ");
            String email = s.ler_texto();
            cli = s.existe(email);
        } else{
            Supermercados s1 = s.ReadObjectToFile(fileSupermercados);
            System.out.println("Iniciando login.....");
            System.out.println("Qual o seu email: ");
            String email = s1.ler_texto();
            cli = s1.existe(email);
            s = s1;
        }

        System.out.println("\nBem Vindo " + cli.getNome() + "..." );
        s.menu(cli , s);
        try {

            FileOutputStream fileOut = new FileOutputStream(fileSupermercados);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(s);
            objectOut.close();
            System.out.println("The Object  was successfully written to a file");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch(IOException ex){
            System.out.println(ex);
        }
        System.out.println("\nMuito obrigado por comprar com o Continente!!!\nAté Breve....");
    }
}
    
