
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

    static final String pattern = "dd/MM/yyyy";
    static final DateFormat df = new SimpleDateFormat(pattern);
    static final Calendar calendar = Calendar.getInstance();
    
    public static void main(String[] args) {

        try (final Scanner scanner = new Scanner(System.in)) {
            int opcao = 0;
            String data;
            do {
                data = "";
                System.out.println("-----------------------------------------");
                System.out.println("Informe uma data: ");
                data = scanner.nextLine();

                System.out.println("");
                System.out.println("1 - Retornar dia da semana de nascimento");
                System.out.println("2 - Retornar tempo decorrido até a data atual");
                System.out.println("9 - sair");
                System.out.print("\n Digite a opção desejada: ");
                opcao = scanner.nextInt();
                // se opcao invalida, não entra em nenhum caso
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
        Date dataNasc = df.parse(data);
        calendar.setTime(dataNasc);
        System.out.println("Semana da data de nascimento: " + semana[calendar.get(Calendar.DAY_OF_WEEK)]);
    }

    public static void calcularTempoDecorrido(String dataEntrada) throws ParseException {
        Date data = df.parse(dataEntrada);
        long diff = new Date().getTime() - data.getTime();
        calendar.setTime(new Date(diff));

        System.out.println("Tempo decorrido até a data atual: " + 
                           (calendar.get(Calendar.YEAR) - 1970) +" ano(s), " +
                            calendar.get(Calendar.MONTH) + " mese(s), " + 
                            calendar.get(Calendar.DAY_OF_MONTH) + " dia(s).");
    }

}
