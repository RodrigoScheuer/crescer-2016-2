/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class MeuCalendarioUtil {

    public static void main(String[] args) {

        try (final Scanner scanner = new Scanner(System.in)) {
            int opcao = 0;
            String data;
            do {
                data = "";
                System.out.println("");
                System.out.println("Informe uma data: ");
                data = scanner.nextLine();

                System.out.println("");
                System.out.println("1 - Retornar dia da semana de nascimento");
                System.out.println("2 - Retornar tempo decorrido até a data atual");
                System.out.println("9 - sair");
                System.out.print("\n Digite a opção desejada: ");
                opcao = scanner.nextInt();
                // se opcao invalida não entra em nenhum caso
                if (opcao < 1 || opcao > 2 && opcao != 9) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 1: {
                        System.out.println("");
                        buscarSemanaDeNascimento(data);
                        break;
                    }
                    case 2: {
                        System.out.println("");
                        calcularTempoDecorrido(data);
                        break;
                    }
                }

            } while (opcao != 9);

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    public static void buscarSemanaDeNascimento(String data) throws ParseException {
        String[] semana = {"", "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado"};
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date dataNasc = df.parse(data);
        Calendar c = Calendar.getInstance();
        c.setTime(dataNasc);
        System.out.println("Semana da data de nascimento: " + semana[c.get(Calendar.DAY_OF_WEEK)]);
    }

    public static void calcularTempoDecorrido(String dataEntrada) throws ParseException {
        Date dataAtual = new Date();
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date data = df.parse(dataEntrada);
        long diferencaDias = (dataAtual.getTime() - data.getTime()) / (1000 * 60 * 60 * 24);
        long diferencaMeses = (dataAtual.getTime() - data.getTime()) / (1000 * 60 * 60 * 24) / 30;
        long diferencaAnos = ((dataAtual.getTime() - data.getTime()) / (1000 * 60 * 60 * 24) / 30) / 12;
        System.out.println("Tempo decorrido até a data atual: " + diferencaAnos +" ano(s), " +
                            diferencaMeses + " mese(s), " + diferencaDias + " dia(s).");
    }

}
