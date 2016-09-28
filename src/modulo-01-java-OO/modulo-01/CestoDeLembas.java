
public class CestoDeLembas
{
    int quantidade;
    
   public CestoDeLembas(int quantidade){
       if(quantidade >= 1 && quantidade <= 100)
            this.quantidade = quantidade;
   }
   
   public boolean podeDividirEmPares(){
       return quantidade > 2 && quantidade % 2 == 0;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
}
