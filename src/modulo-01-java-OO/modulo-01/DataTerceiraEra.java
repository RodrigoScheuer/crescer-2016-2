public class DataTerceiraEra{

    private int dia;
    private int mes;
    private int ano;
    
    public DataTerceiraEra(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia(){
        return this.dia;
    }
    
    public int getMes(){
        return this.mes;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public boolean ehBissexto(int anoBissexto){
              //é divisivel por 4        n pode ser centenário           validar a cada 400 anos
        return (anoBissexto % 4 == 0) && ( (anoBissexto % 100 != 0) || (anoBissexto % 400 == 0) );
    }
    
    
}