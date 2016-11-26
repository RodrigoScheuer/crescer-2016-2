/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class MeuFileUtils {

    public static void main(String a[]) throws IOException {

        try (final Scanner scanner = new Scanner(System.in)) {

            System.out.println("Digite o comando desejado: ");
            String comando = scanner.next();

            if (comando.equalsIgnoreCase("mk")) {
                System.out.println("Criando arquivo... \n");
                System.out.println("Exemplo: \"aula2.txt\" \n");

                System.out.println("Digite o nome do arquivo: ");
                String nome = scanner.next();
                criarArquivo(nome);
            }
            if (comando.equalsIgnoreCase("rm")) {
                System.out.println("Excluindo arquivo... \n");
                System.out.println("Exemplo: \"aula2.txt\" \n");

                System.out.println("Digite o nome do arquivo: ");
                String nome = scanner.next();
                excluirArquivo(nome);
            }
            if (comando.equalsIgnoreCase("ls")) {
                System.out.println("\n Procurando arquivo(s)");
                System.out.println("Digite o nome do arquivo: ");
                String nome = scanner.next();
                procurar(nome);
            }
            if (comando.equalsIgnoreCase("mv")) {
                System.out.println("Digite o nome do arquivo a ser movido: ");
                String nome = scanner.next();
                System.out.println("Digite o nome do arquivo receptor: ");
                String novoNome = scanner.next();

                moverArquivo(nome, novoNome);
            }
        }
    }

    private static void criarArquivo(String nome) {

        try {
            final File file = new File(nome);

            if (file.exists()) {
                System.out.println("Arquivo já existe...");
                System.out.println(file.getAbsolutePath());
            } else {
                file.createNewFile();
                System.out.println("\n Arquivo Criado com Sucesso!!!");
            }

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    private static void excluirArquivo(String nome) {

        try {
            final File file = new File(nome);
            if (file.exists()) {
                new File(nome).delete();
                System.out.println("\n Arquivo " +nome+ " Deletado...");
            } else {
                System.out.println("\n Arquivo/diretorio não encontrado.");
            }

        } catch (Exception e) {

        }

    }

    private static void procurar(String nome) {

        try {
            final String path;

            final File file = new File(nome);
            
            if (file.isDirectory()) {
                System.out.println("\n Arquivos do diretório: \n");
                final File[] list = new File(nome).listFiles();

                if (list.length > 0) {
                    for (int i = 0; i < list.length; i++) {
                        System.out.println(list[i]);
                    }
                }
            }
            
            if (file.isFile()) {
                path = "C:\\Users\\Rodrigo\\GitHub\\src\\modulo-09 - java\\" + nome;
                System.out.println("\n diretório do arquivo: " + path);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void moverArquivo(String nome, String novoNome) throws FileNotFoundException, IOException {
    
        final File file = new File(nome);
        final File file2 = new File(novoNome);
        
        if(file.isDirectory() || file2.isDirectory())
            System.out.println("\n Arquivo inválido!!!");
        
        if (file.isFile() && file2.isFile()) {
           
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(file2);
        
        // buffer para transportar os dados
        byte[] buffer = new byte[1024];
        int length;
        
        // enquanto tiver dados para ler..
        while((length = in.read(buffer)) > 0 ){
            // escreve no novo arquivo
            out.write(buffer, 0 , length);
        }
            System.out.println("\n Arquivo movido com sucesso... \n");
        in.close();
        out.close();
        
        //apaga o arquivo antigo
        excluirArquivo(nome);
        
        }else{
            System.out.println("");
        }
    }
}
