/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rodrigo.scheuer
 */
public class Run {

    public static void main(String[] args) throws SQLException {

        final String query = "SELECT * FROM PESSOA";
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {

                try (final ResultSet resultSet = statement.executeQuery(query)) {
                    
                    while (resultSet.next()) {
                        final long idPessoa = resultSet.getLong("id_pessoa");
                        final String nmPessoa = resultSet.getString("NM_PESSOA");
                        
                        System.out.format("ID: %s  Nome: %s", idPessoa, nmPessoa);
                    }
                    
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        
        
    }
}
