
public class CestoDeLembas
{
    int quantidade;
    
   public CestoDeLembas(int quantidade){
       if(quantidade >= 1 && quantidade <= 100)
            this.quantidade = quantidade;
   }
   
   public boolean podeDividirEmPares(){
          if(quantidade > 2 && quantidade % 2 == 0)
             return true;
       return false;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
}
