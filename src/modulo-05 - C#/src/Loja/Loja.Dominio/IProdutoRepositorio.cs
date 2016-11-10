using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        List<Produto> ListarProdutos();
        void AdicionarProdutos(Produto produto);
        Produto BuscarProduto(int id);
        void Excluir(int id);
    }
}
