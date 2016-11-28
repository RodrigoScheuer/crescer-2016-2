/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class MeuSqlUtils {

    public static void main(String[] args) throws IOException {
        String arquivo;

        try (final Scanner scanner = new Scanner(System.in)) {

            System.out.println("Digite o arquivo para leitura:");
            arquivo = scanner.nextLine();

            executarSQL(arquivo);
        }
    }

    private static boolean accept(final File pathname) {
        return pathname.getName().contains(".sql");
    }

    public static void executarSQL(String arquivo) throws IOException {

        final File file = new File(arquivo);
        String ddl = "";

        if (file.exists()) {

            if (accept(file)) {

                try (
                        final Reader reader = new FileReader(arquivo);
                        final BufferedReader bufferReader = new BufferedReader(reader);) {

                    Object[] ar = bufferReader.lines().toArray();

                    for (Object ar1 : ar) {
                        ddl += ar1;
                    }

                    if (ddl.contains("SELECT")) {

                        try (
                                final Connection connection = ConnectionUtils.getConnection();
                                final Statement statement = connection.createStatement();) {
                            try (final ResultSet resultSet = statement.executeQuery(ddl)) {

                                System.out.println("\n Executando consulta.... \n");
                                System.out.println("ID \t Nome");
                                while (resultSet.next()) {
                                    final long idPessoa = resultSet.getLong("ID_PESSOA");
                                    final String nmPessoa = resultSet.getString("NM_PESSOA");

                                    System.out.format("%s \t %s \n", idPessoa, nmPessoa);
                                }

                            } catch (final SQLException e) {
                                System.err.format("SQLException: %s", e);
                            }

                        } catch (final SQLException e) {
                            System.err.format("SQLException: %s", e);
                        }

                    } else {

                        try (final Connection connection = ConnectionUtils.getConnection()) {
                            try (final Statement statement = connection.createStatement()) {
                                System.out.println("\n Executando comandos... \n");
                                
                                statement.executeUpdate(ddl);
                                
                                System.out.println("\n Executado com sucesso!!! \n");

                            } catch (final SQLException e) {
                                System.err.format("Não foi possivel executar esse comando \n SQLException: %s", e);
                            }

                        } catch (SQLException e) {
                            System.err.format("SQLException: %s", e);
                        }
                    }
                    
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void ImportarArquivo(){
    
    }
    
    public static void ExportarArquivo(){
    
    }
    
}
