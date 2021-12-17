package exercicio_avaliacao_5;

import java.io.Serializable;

public class Data implements Serializable {

    private final int dia,mes,ano;
    
    
    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
    
    @Override
    public String toString(){
        //Da print a data em extenso.
        String[] stringArray1 = {"Janeiro","fevereiro","Marco","Abril","Maio","Junho","julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        return dia + " de " + stringArray1[mes-1] + " de " + ano;
    }
    
    
    boolean verifica_data(int dia , int mes , int ano){
        
        boolean ano_bissexto = ((ano % 4 == 0) && (ano % 100 != 0) || (ano % 400 == 0));
        
        if((0 < mes && mes <= 12) != true){ //verifica se o mes esta entre 0 e 12.
            System.out.printf("Erro, mes nao existe.\n");
            return false;       
        }
        
        if( ano < 0){ //verifica se o ano e positivo, estamos a trabalhar com anos de 0 ate ao limite do int.
            System.out.printf("Erro, ano nao existe.\n");
            return false;               
        }
            
        
        if(ano_bissexto && mes == 2){ //Se for um ano bissexto e for fevereiro temos 29 dias.
                if(dia > 29 || dia <= 0){
                    System.out.printf("Erro, dia nao existe.\n");
                    return false;
                }
        }
        else if(ano_bissexto == false && mes == 2){ //caso nao seja ano bissexto temos 28 dias em fevereiro
                if(dia > 28 || dia <= 0){
                    System.out.printf("Erro, dia nao existe.\n");
                    return false;
                }          
        }
        //A partir de Agosto os meses parees e impares trocam o numero de dias que cada um tem.
        if( mes <= 7){ 
            if(mes % 2 != 0){
                if(dia > 31 || dia <= 0){
                    System.out.printf("Erro, dia nao existe.\n");
                    return false;
                }
            }

            if(mes % 2 == 0 && mes != 2){
                if(dia > 31 || dia <= 0){
                    System.out.printf("Erro, dia nao existe.\n");
                    return false;
                }
             }
        }
        //Chegou a agosto troca os dias.
        else{
            if(mes % 2 == 0){
                if(dia > 31 || dia <= 0){
                    System.out.printf("Erro, dia nao existe.\n");
                    return false;
                }
            }

            if(mes % 2 != 0){
                if(dia > 30 || dia <= 0){
                    System.out.printf("Erro, dia nao existe.\n");
                    return false;
                }
             }
        }
        
        return true;
    }
    
    
  }
