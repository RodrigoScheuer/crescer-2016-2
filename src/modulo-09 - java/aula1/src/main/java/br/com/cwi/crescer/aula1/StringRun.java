/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author rodrigo.scheuer
 */
public class StringRun {

    public static void main(String[] args) {

        if ("A".compareTo(new String("A")) == 0) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
        
        // scanner
        try (final Scanner scanner = new Scanner(System.in)) {
            
            String palavra;
            System.out.println("Digite uma palavra: ");
            palavra = scanner.nextLine();
            System.out.println("qtd vogais:" + retornaQtdVogais(palavra));
            
            inverterPalavra(palavra);
            System.out.println("\n --Palavra invertida -- \n" + inverterPalavra(palavra));
            
            System.out.println("");
            System.out.println("Estados: ");
            System.out.println(ConcatenaEnum(Estados.values()));
            
            System.out.println("");
            Date data = new Date();
            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
            System.out.println("Data atual: " + dataFormatada);
            
            System.out.println("");
            System.out.println("Insira data de Nascimento: ");
            String dataNascimento = scanner.nextLine();
            
            
            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            Date dataNasc = df.parse(dataNascimento);
            Calendar c = Calendar.getInstance();
            c.setTime(dataNasc);
            System.out.println("Semana da data de nascimento: " + c.getWeeksInWeekYear());

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    public static int retornaQtdVogais(String palavraInserida) {
        int tamanho = palavraInserida.length();
        String palavra = palavraInserida.toUpperCase();
        int cont = 0;
        for (int i = 0; i < tamanho; i++){
            if(palavra.charAt(i) == 'A' || palavra.charAt(i) == 'E' || 
               palavra.charAt(i) == 'I' || palavra.charAt(i) == 'O' ||
               palavra.charAt(i) == 'U' ){
                cont++;
            }
        }

        return cont;
    }
    
    public static String inverterPalavra(String palavra){
        return new StringBuilder(palavra).reverse().toString();
    }
    
    public static String ConcatenaEnum(Estados[] estados){
  
        StringBuffer buffer = new StringBuffer();
        
        for (int i = 0; i < estados.length; i++) {
            buffer.append(estados[i].getNome()).append(", ");
        }
        // deleta ultima virgula...
        buffer.deleteCharAt(buffer.toString().trim().length() - 1);
        
        return buffer.toString();
    }
    
    
}
