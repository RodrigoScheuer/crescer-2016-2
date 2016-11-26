/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import static br.com.cwi.crescer.aula1.MeuCalendarioUtil.transformarEmDate;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class Parcelator {

    static final Calendar calendar = Calendar.getInstance();
    private final double valor;
    private final double juros;
    private final int parcelas;

    public Parcelator(double valor, double juros, int parcelas, Date dataPrimeiroPagamento) {
        this.valor = valor;
        this.juros = juros;
        this.parcelas = parcelas;
        calendar.setTime(dataPrimeiroPagamento);
    }
    
    public String gerarData(){
        calendar.getTime();
        
        return calendar.get(Calendar.DAY_OF_MONTH) + "/"+
               (calendar.get(Calendar.MONTH) + 1) + "/" + 
               calendar.get(Calendar.YEAR);
    }

    public void Imprimir() {

        double total = valor + (valor * (juros/100));
        double valorParcela = total / parcelas;
                
        System.out.println("----- imprimindo -----");
        System.out.println("valor da compra: R$" + valor + "\n"
                + "juros: " + juros + "% \n"
                + "Quantidade de parcelas: " + parcelas + "\n"
                + "Data 1° pagamento: " + gerarData() + "\n");
        
        for (int i = 1; i < parcelas + 1; i++) {
            System.out.println(i + ". " + gerarData() + " - R$ " + valorParcela);
            calendar.add(Calendar.MONTH, 1);
        }
    }

    public static void main(String[] args) throws ParseException {

        try (final Scanner scanner = new Scanner(System.in)) {
            

            System.out.print("Digite o valor da compra: ");
            double valor = scanner.nextDouble();
            
            System.out.print("Digite o valor do juros: ");
            double juros = scanner.nextDouble();
            
            System.out.print("Digite a quantidade de parcelas: ");
            int parcelas = scanner.nextInt();
            
            System.out.print("Digite a data do 1° pagamento: ");
            String data = scanner.next();
            
            Parcelator parcelator = new Parcelator(valor, juros, parcelas, transformarEmDate(data));
            
            parcelator.Imprimir();
        }
    }

}
