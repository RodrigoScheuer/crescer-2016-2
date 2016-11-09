using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public void AdicionarProdutos(Produto produto)
        {
            throw new NotImplementedException();
        }

        public Produto BuscarProduto(int id)
        {
            throw new NotImplementedException();
        }

        public List<Produto> ListarProdutos()
        {
            List<Produto> lista = new List<Produto>();

            using (var context = new ContextoDeDados())
            {
                lista = context.Produto.ToList();
            }

            return lista;
        }        
    }
}
