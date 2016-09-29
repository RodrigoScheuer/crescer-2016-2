<<<<<<< HEAD

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
=======
public class CestoDeLembas
{
    private int numeroPaes;
    
    public CestoDeLembas(int numeroPaes) {
        this.numeroPaes = numeroPaes;
    }
    
    public boolean podeDividirEmPares() {
        return numeroPaes > 2 && numeroPaes % 2 == 0 && numeroPaes <= 100;
    }
}
>>>>>>> master
