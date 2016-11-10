
using System.ComponentModel.DataAnnotations;
using Loja.Repositorio;

namespace Loja.Web.Models
{
    public class ValidacaoProduto : ValidationAttribute
    {
        ProdutoRepositorio repositorio = new ProdutoRepositorio();

        public ValidacaoProduto()
        {
            ErrorMessage = "Produto com esse nome já existe.";
        }

        public override bool IsValid(object value)
        {
            var nome = value as string;
            if (nome != null)
            {
                return repositorio.BuscarNomeRepetido(nome);
            }
            else
            {
                return false;
            }
        }
    }
}