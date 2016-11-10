using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public void AdicionarProdutos(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                if(produto.Id == 0)
                {
                    context.Entry<Produto>(produto).State = EntityState.Added;
                    context.SaveChanges();
                }
                else
                {
                    context.Entry<Produto>(produto).State = EntityState.Modified;
                    context.SaveChanges();
                }
                
            }
        }

        public Produto BuscarProduto(int id)
        {
            using (var context = new ContextoDeDados())
            {
                Produto produtoFound = context.Produto.FirstOrDefault(p => p.Id == id);
                return produtoFound;
            }
                
        }

        public void Excluir(int id)
        {
            using (var context = new ContextoDeDados())
            {
                //context.Produto.Attach(id);
                context.Produto.Remove(context.Produto.FirstOrDefault(p => p.Id == id));
                context.SaveChanges();
            }
        }

        public List<Produto> ListarProdutos()
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.ToList();
            }
        }
        
        public bool BuscarNomeRepetido(String nome)
        {
            using (var context = new ContextoDeDados())
            {
                Produto produtoFound = context.Produto.FirstOrDefault(p => p.Nome.Equals(nome));
                if(produtoFound != null)
                {
                    return false;
                }
                return true;
            }
        }        
    }
}
