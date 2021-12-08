package exercicio_avaliacao_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Supermercados implements Serializable {
    
    ArrayList<Promocoes> promocoes = new ArrayList<>();
    ArrayList<Compra> compras = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Produtos> p = new ArrayList<>();
    
    
    public Supermercados() {
    }
    
    void add_produtos(Produtos prod){
            p.add(prod);
    }
    
    void add_promocoes(Promocoes promo){
        promocoes.add(promo);
    }
    
    void add_compra(Compra compra){
        compras.add(compra);
        
    }
        
    void add_clientes(Cliente cliente){
        clientes.add(cliente);
    }
    
    /**
     * Allows us to ask the user for an int and, check if the value given is correct.
     * @return returns, int given by the user
     */
    int ler_inteiro(){
        
        int n;
        System.out.printf("Digite o numero:");
        try{
                
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
            
        }
        //Se o valor for um valor causar um erro, ira ser avisado ao usuario que o valor nao e valido.
        catch (java.util.InputMismatchException e){
            return -1;
        }
        
    return n;
    }
    
    
    
    /**
     * Allows us to receive a string from the user and, check if the string is valid.
     * @return returns, string given by the user.
     */
    String ler_texto(){ 
         
        String str;  
         
        try{
                
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
            
        }
        //Se o valor for um valor causar um erro, ira ser avisado ao usuario que o valor nao e valido.
        catch (java.util.InputMismatchException e){
            System.out.printf("Valor Introduzido nao e valido.");
            return null;
        }
        
    return str;
    }
    
    /**
     * Allows us to receive a Data from the user and, check if the Data is valid.
     * @return return, Data given by user.
     */
    String[] le_data(){
        
        int erro;
        String data;
        String[] dias;
        
        do{
            
            erro = 0;
            System.out.printf("Data:(dd/mm/aa) ");
            data = ler_texto();
            dias = data.split("/"); //Permite separar a data para obter [DIA,MES,ANO]
            
            if(dias.length == 0){   
                System.out.println("Data fornecida deve ser do tipo DIA/MES/ANO..."); 
                data = null;
                Arrays.fill(dias,null);
                erro++;
            }
            else if(erro == 0 && (dias[0].equals(data) || dias.length != 3)  ){ //Verifica se a data fornecida é do tipo DIA/MES/ANO
                System.out.println("Data fornecida deve ser do tipo DIA/MES/ANO..."); 
                data = null;
                Arrays.fill(dias,null);
                erro++;         
            }
            
            if(erro == 0){
                try{
                    Integer.parseInt(dias[0]); //Verificar se o valor que foi fornecido e possivel converter para um inteiro.
                    Integer.parseInt(dias[1]);
                    Integer.parseInt(dias[2]);
                }
                catch (java.lang.NumberFormatException e){
                    data = null;
                    System.out.println("A data fornecida nao e valida!"); //Nao e possivel converter para inteiro, e avisado o usuario.
                }
            }
            
        }while(data == null);        
        
        return dias;
        
    }
    
    /**
     * Allows us to check if one Data is after another.
     * 
     * @param d First Data for the verification.
     * @param d1 Second Data for the verification. 
     * @return true if first Data is after second Data , false if first Data is before second Data.
     */
    boolean data_verifica(Data d, Data d1){
        boolean return_statement = false;
        
        if(d.getAno() > d1.getAno())
            return_statement = true;
        else if(d.getAno() == d1.getAno() && d.getMes() > d1.getMes())
            return_statement = true;
        else if(d.getAno() == d1.getAno() && d.getMes() == d1.getMes() && d.getDia() >= d1.getDia())
            return_statement = true;
        
        return return_statement;
    }
    
    
    
    /**
     * Prints all the purchases made in the current Data.
     * 
     * @param d Gives us the current Data to check if the purchases are made before this Data.
     */
    void mostrar_compras(Data d){
        int check_compra = 0;
        
        for(Compra c: compras){
            if(data_verifica(d , c.getData()) && !(c.getCarro().isEmpty())){
                System.out.println(c.toString());
                check_compra++;
           }
        }
        
        if(check_compra == 0)
            System.out.println("Ainda nao foram realizadas compras.");   
    }
 
    /**
     * Checks if the Client exists.
     * @param texto email of the the Client
     * @return returns , Client after being found.
     */
    Cliente existe(String texto){
        
        int encontrado = 0;
        Cliente c = null;

        while(encontrado == 0){
            
            texto = ler_texto();
            
            for(Cliente cli : clientes){
                if((cli.getEmail()).toLowerCase().equals(texto.toLowerCase())){
                    cli.toString();
                    encontrado += 1;
                    c = cli;
                    }
                }
        if(encontrado == 0)
            System.out.println("Nao existe nenhum cliente com esse email.\nQual o seu email?");
          
        }
       return c;  
    }
    
    /**
     * Checks if the promotion is valid in the current Data.
     * 
     * @param promo Promotion that is going to be checked.
     * @param d Data that the promotion is going to be checked in.
     * @return True if the promotion is valid in this data, False if the promotion is not valid in the given Data.
     * 
     */
    boolean verifica_promo(Promocoes promo,Data d){
        
        boolean valido = false;
        
        if(d.getAno() < promo.getFim().getAno())
            valido = data_verifica(d,promo.getInicio());
      
        if(d.getMes() < promo.getFim().getAno() && d.getAno() == promo.getFim().getAno())
            valido = true;

        else if(d.getMes() == promo.getFim().getMes() && d.getAno() == promo.getFim().getAno() && d.getDia() <= promo.getFim().getDia())
            valido = true;         

    return valido;
    }
    
    
    /**
     * Does the first part of the menu.
     * 
     * @param s Receives the Supermarket class.
     * @param p Receives the ArrayList products.
     * @param compra Receives the Purchases.
     * @param i Receives the index of the product we want to acess in the arraylist products.
     * 
     * @return returns, the quantity of the product that the user wants to buy.
     */
    
    int menu_compra1(Supermercados s , ArrayList<Produtos> p , Compra compra , int i){
        int encontrado = 0;
        int quantidade;
        
        do{
            
        System.out.println("\nQual a quantidade que deseja comprar deste produto?");
        quantidade = ler_inteiro();
        
        if(quantidade < 0)
            System.out.println("Valor Inserido e Invalido.");
        
        }while(quantidade < 0);

        for(Carro_compras carrinho : compra.getCarro()){
            
            if(p.get(i) == carrinho.getItem()){
                if(carrinho.getItem().getStock() < quantidade){
                    encontrado++;
                    System.out.println("Nao existe stock sufeciente!");
                }else{
                 carrinho.setQuantidade(carrinho.getQuantidade() + quantidade);
                 compra.add_total(p.get(i).getPreco() * quantidade);
                 encontrado++;
                }
            }        
        }
        if(encontrado == 0){
            Carro_compras c1 = new Carro_compras(p.get(i) , quantidade);
            compra.realiza_compra(c1);
        }       

    return quantidade;
    }



    /**
     * Second part of the menu.
     * 
     * @param p Arraylist of products.
     * @param compra Purchases.
     * @param quantidade Quantity of the product.
     * @param s Supermarket class.
     * @param d Current Data.
     * @param cli Client that is making the purchase.
     * 
     * @return Value to check if the purchase was finished or not.
     */

    int menu_compra2(ArrayList<Produtos> p , Compra compra , int quantidade , Supermercados s , Data d , Cliente cli){
        for(Produtos prod : p){
            int encontrado = 0;
            for(Carro_compras carrinho : compra.getCarro()){
                
                if(prod == carrinho.getItem()){
                    quantidade = carrinho.getQuantidade();
                    compra.setTotal(compra.getTotal() + prod.Transportar_item());
                    encontrado ++;
                }
                
            }
                for(Promocoes promo: prod.getPromo()){
                    if(s.verifica_promo(promo,d) && encontrado != 0){
                       compra.setTotal(compra.getTotal() - (promo.promo(compra.getTotal(), quantidade, prod.getPreco())));
              }
            }
        }

        compra.setTotal(compra.getTotal() + cli.transporte(compra.getTotal()));
        if(!(compra.getCarro().isEmpty()))
            System.out.println("Compra realizada com sucesso!!\nPreco da compra com portes:" + compra.getTotal() + "€");
        
        s.add_compra(compra);
        int fazer_compra = -1;   
    return fazer_compra;
    }
    
    
    
    
    
    /**
     * Allows user to make the choice between the numbers that are on the screen.
     * 
     * @param i Max value that can be choosen.
     * @param s Supermarket class.
     * 
     * @return the choice that was made.
     */
    int fazer_escolha(int i , Supermercados s){
        int escolha = 0;
        while(!(escolha > 0 && escolha < i)){
            escolha = s.ler_inteiro();
            if(!(escolha > 0 && escolha < i))
                System.out.println("Escolha uma das opcoes mostradas.");
        }
    return escolha;   
    }
    
    
    void eliminar_produto(Produtos prod , Compra c ){
        int i = 0 ,indice = 0;
        double preco ;
        
        for(Carro_compras carrinho : c.getCarro()){
            
            if(carrinho.getItem().equals(prod)){
                indice = i;
                carrinho.getItem().setStock((carrinho.getItem().getStock() + carrinho.getQuantidade()));
                preco = (carrinho.getItem().getPreco() * carrinho.getQuantidade());
                c.setTotal(c.getTotal() - preco);
            }
            i++;
        }
        
        c.getCarro().remove(indice);
    }
    
    /**
     * All the menu.
     * 
     * @param d Current Data.
     * @param cli Client that's making the purchase.
     * @param dias Stores the day,month,year when we want to change current Data.
     * @param s Supermarket class.
     */
    void menu(Data d , Cliente cli , String[] dias , Supermercados s){
        int escolha , escolha4;
          do{
            int fazer_compra = 0;
            
            System.out.println("\nO que deseja fazer?\n\n1 - Fazer uma compra\n2 - Verificar todas as compras realizadas.\n3 - Mudar data\n4 - Terminar o programa.\n\n");
            escolha = fazer_escolha(5,s);
            
            switch(escolha){
                case(1):
                    
                    String escolha2;
                    int escolha3 = 0 , quantidade , indice;
                    
                    for(Produtos prod: p)
                        System.out.printf(prod.toString() + "\n\n");

                    Compra compra = new Compra(0,d);

                    while(fazer_compra == 0){
                        indice = -1;
                        escolha3 = 0;
                        
                        while(indice == -1){
                            
                            System.out.println("\nDigite o nome do produto que deseja comprar: ");
                            escolha2 = ler_texto();
                            
                            for(int x = 0; x < p.size() ; x++){
                                if(escolha2.toLowerCase().equals(p.get(x).getNome().toLowerCase()))
                                    indice = x;
                            }
                            
                            if(indice == -1)
                                System.out.println("Nao exsite nenhum produto com esse nome.");
                        }
                        
                        quantidade = s.menu_compra1(s , p , compra , indice);
                        while(escolha3 != -1){
                            System.out.println("Deseja comprar mais produtos?\n\n1->Sim\n2->Nao\n");
                            escolha3 = fazer_escolha(3,s);

                            if(escolha3 == 1){

                                for(Produtos prod: p)
                                    System.out.printf(prod.toString() + "\n\n");
                                escolha3 = -1;
                            }
                            
                            if(escolha3 == 2){

                                System.out.println("Deseja:\n1-> Eliminar produtos do carrinho\n2-> Finalizar compra\n");
                                escolha3 = fazer_escolha(3,s);

                                if(escolha3 == 1){

                                    System.out.println("\n1 ->Eliminar um produto\n2 ->Eliminar todos os produtos\n");
                                    escolha4 = fazer_escolha(3,s);

                                    if(escolha4 == 1){

                                        System.out.println("Qual produto deseja eliminar?\n");

                                        for(Carro_compras carrinho : compra.getCarro()){
                                            System.out.println(carrinho.getItem().toString() + "\n\n");
                                        }

                                        System.out.println("\nDigite o nome do produto que deseja eliminar: ");
                                        escolha2 = ler_texto();

                                        for(int x = 0; x < p.size() ; x++){
                                            if(escolha2.toLowerCase().equals(p.get(x).getNome().toLowerCase()))
                                                eliminar_produto(p.get(x) , compra);
                                           }

                                        System.out.println("Produto eliminado com sucesso!");
                                    }else{
                                        compra.getCarro().clear();
                                    }
                                }
                                else{
                                    fazer_compra = menu_compra2(p , compra , quantidade , s , d , cli);
                                    escolha3 = -1;
                                }
                              }
                            }
                        }
                      break;
                case(2):
                        
                    s.mostrar_compras(d);
                    break;

                case(3):
                    //pedir e verificar a data ate que uma data correta seja fornecida.
                    do{
                        dias = s.le_data();  
                    }while(d.verifica_data(Integer.parseInt(dias[0]),Integer.parseInt(dias[1]),Integer.parseInt(dias[2])) == false);

                    d = new Data(Integer.parseInt(dias[0]),Integer.parseInt(dias[1]),Integer.parseInt(dias[2])); //Tornar valores fornecidos pela data em inteiros.
                    System.out.println(d.toString() + "\n");
                    
                    break;
                case(4):
                    break;
            }    
    
        }while(escolha != 4);
    }    
    
    
    /**
     * Reads the file.
     * 
     * @param myObj Receives the File that is going to read.
     */
    void ler_ficheiro(File myObj){
        try {
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
    }

    @Override
    public String toString() {
        return  "Promocoes = " + promocoes.toString() + 
                "; Clientes = " + clientes.toString() + 
                "; Produtos = " + p.toString() +
                "; Clientes = " + clientes.toString();        
    }

    
    /**
     * Writes object into the file.
     * 
     * @param serObj Object received.
     * @param f File that is going to be written into.
     */
    void WriteObjectToFile(Object serObj , File f) {
 
        try {
 
            FileOutputStream fileOut = new FileOutputStream(f);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch(IOException ex){
           System.out.println("Erro a escrever para o ficheiro.");
        }
    
    }         
}


