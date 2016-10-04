public class Item{
    private String descricao;
    private int quantidade;

    public Item(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void aumentaQuantidadeItens(){
        int total = 0, soma = 0;
        if(this.quantidade < 0){
            this.quantidade = this.quantidade * -1;   // transforma numero negativo em positivo
        }
        while(soma < this.quantidade){
            soma += 1;
            total += soma * 1000;   // dwarf mt sortudo
        }
        // set quantidade ganha mais quantidade q tinha no inventario
        setQuantidade(total + this.quantidade);
    }
}