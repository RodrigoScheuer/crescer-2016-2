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
public class MeuStringUtil {

    public static void main(String[] args) {

        try (final Scanner scanner = new Scanner(System.in)) {
            int opcao = 0;
            String frase;
            do {
                
                System.out.println("");
                System.out.println("Informe uma frase ou palavra: ");
                frase = scanner.nextLine();
                // se frase vazia não entra em nenhum caso
                if (verificaSeStringVazia(frase)) {
                    opcao = 0;
                }
                
                System.out.println("");
                System.out.println("1 - Contar quantidade de vogais");
                System.out.println("2 - Inverter frase");
                System.out.println("3 - Indentificar palindromo");
                System.out.println("9 - sair");
                System.out.print("\n Digite a opção desejada: ");
                opcao = scanner.nextInt();
                // se opcao invalida não entra em nenhum caso
                if (opcao < 1 || opcao > 3 && opcao != 9) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 1: {
                        System.out.println("");
                        System.out.println(retornaQtdVogais(frase) + " vogais nessa frase.");
                        break;
                    }
                    case 2: {
                        System.out.println("");
                        System.out.println("Frase invertida: " + inverterPalavra(frase));
                        break;
                    }
                    case 3: {
                        System.out.println("");
                        indentificaPalindromo(frase);
                        break;
                    }
                }

            } while (opcao != 9);
            /*
             System.out.println("");
             System.out.println("Estados: ");
             System.out.println(ConcatenaEnum(Estados.values()));
             */

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    public static int retornaQtdVogais(String palavraInserida) {
        int tamanho = palavraInserida.length();
        String palavra = palavraInserida.toUpperCase();
        int cont = 0;
        for (int i = 0; i < tamanho; i++) {
            if (palavra.charAt(i) == 'A' || palavra.charAt(i) == 'E'
                    || palavra.charAt(i) == 'I' || palavra.charAt(i) == 'O'
                    || palavra.charAt(i) == 'U') {
                cont++;
            }
        }

        return cont;
    }

    public static String inverterPalavra(String palavra) {
        return new StringBuilder(palavra).reverse().toString();
    }

    public static String ConcatenaEnum(Estados[] estados) {

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < estados.length; i++) {
            buffer.append(estados[i].getNome()).append(", ");
        }
        // deleta ultima virgula...
        buffer.deleteCharAt(buffer.toString().trim().length() - 1);

        return buffer.toString();
    }

    private static boolean verificaSeStringVazia(String frase) {

        if (frase == null || frase.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static void indentificaPalindromo(String frase) {
        String fraseSemEspaco = frase.replaceAll(" ", "");
        String palavraInvertida = inverterPalavra(fraseSemEspaco);
        if(palavraInvertida.equals(fraseSemEspaco)){
            System.out.println("");
            System.out.println("A palavra "+frase+ " é um PALINDROMO");
        }else{
            System.out.println("");
            System.out.println("A palavra "+frase+ " NÃO é um PALINDROMO");;
        }
    }

}
