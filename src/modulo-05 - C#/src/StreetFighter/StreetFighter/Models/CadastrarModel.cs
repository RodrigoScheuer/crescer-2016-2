using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace StreetFighter.web.Models
{
    public class CadastrarModel
    {
        [DisplayName("URL da Imagem")]
        public String Imagem { get; set; }

        [Required]
        [DisplayName("Origem")]
        public String IdOrigem { get; set; }

        [Required]
        public String Nome { get; set; }

        [Required]
        [DisplayName("Data de Nascimento")]
        public DateTime DataNascimento { get; set; }

        [Required]
        public int Altura { get; set; }

        [Required]
        public decimal Peso { get; set; }

        [Required]
        [DisplayName("Golpes Especiais") ]
        public String GolpesEspeciais { get; set; }

        [DisplayName("Personagem Oculto")]
        public bool PersonagemOculto { get; set; }

    }
}