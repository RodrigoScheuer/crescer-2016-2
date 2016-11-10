using System;
using System.ComponentModel.DataAnnotations;

namespace Loja.Web.Models
{
    public class ProdutoModel
    {
        public int Id { get; set; }
        [Required]
        [ValidacaoProduto]
        public String Nome { get; set; }
        [Required]
        public decimal Valor { get; set; }
    }
}