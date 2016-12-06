/*
 * Classe que inicia execução do projeto
 */
package br.com.cwi.redesocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Rodrigo
 */
@SpringBootApplication
public class AppRun {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppRun.class, args);
    }

}
