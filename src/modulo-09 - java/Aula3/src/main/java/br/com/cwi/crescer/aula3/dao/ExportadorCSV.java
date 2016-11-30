/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class ExportadorCSV {

    private static boolean acceptCSV(final File pathname) {
        return pathname.getName().contains(".csv");
    }

    public static void exportarArquivo(String dados) {

        try (final Scanner scanner = new Scanner(System.in)) {
            String arquivo;

            System.out.println("\n Exportando arquivo... \n");
            System.out.println("Digite o arquivo .csv de destino: ");
            arquivo = scanner.nextLine();

            final File file = new File(arquivo);
            if (file.exists()) {

                if (acceptCSV(file)) {

                    try (
                            final Writer writer = new FileWriter(arquivo, true);
                            final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
                        
                        String[] inf = dados.split(";");

                        for (int i = 0; i < inf.length; i++) {
                            bufferedWriter.newLine();
                            bufferedWriter.append(inf[i]);
                        }

                        bufferedWriter.flush();
                        System.out.println("\n Dados armazenados com sucesso... \n");

                    } catch (IOException e) {
                        System.out.println(e);
                    }

                } else {
                    System.out.println("\n Arquivo incompatível");
                }
            } else {
                System.out.println("\n Arquivo não existe!!");
            }
        }
    }

}
