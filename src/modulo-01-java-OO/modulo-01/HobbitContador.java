import java.util.*;

public class HobbitContador
{
    
    public Integer calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares){
        Integer soma = 0;
        for(int i = 0; i < arrayDePares.size() ; i++){
            Integer a = 0;
            Integer b = 0;
            for(int j = 0; j < arrayDePares.get(i).size(); j++){
                if(j == 0){
                    a = arrayDePares.get(i).get(j) ;
                }else{
                    b = arrayDePares.get(i).get(j);
                }
            }
            soma += calcularSomaDiferenca(a, b);
        }
        return soma;
    }
    
    private Integer calcularSomaDiferenca(Integer a, Integer b){
        int produto = a * b;
        int MMC = 1;
        int somaDaDiferenca;
        int i = 2;

        while(i <= 5){
            if(a % i == 0){
                if(a % i == 0 && b % i == 0){
                    a = a/i;
                    b = b/i;
                    MMC = MMC * i;

                }else{
                    a = a/i;
                    b = b;
                    MMC = MMC * i;

                }
            }else if(b % i == 0){
                a = a;
                b = b/i;
                MMC = MMC * i;

            }else{
                i++;}
        }
        somaDaDiferenca = (produto) - (MMC);
        return somaDaDiferenca;
    }

}
