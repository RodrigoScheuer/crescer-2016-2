using StreetFighter.Models;
using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace StreetFighter.web.Models
{
    public class FichaTecnicaModel
    {
        [DisplayName("URL da Imagem")]
        public String Imagem { get; set; }

        public int? Id { get; set; }

        [Required(ErrorMessage = "Origem de Nascimento obrigatório")]
        //[ValidacaoRegiao(ErrorMessage = "Somente um personagem pode ser dessa região.")]
        [DisplayName("Origem")]
        public String IdOrigem { get; set; }

        [Required]
        //[ValidacaoPersonagem]
        public String Nome { get; set; }

        [Required]
        [DisplayName("Data de Nascimento")]
        public DateTime Nascimento { get; set; }

        [Required]
        public int Altura { get; set; }

        [Required]
        public decimal Peso { get; set; }

        [Required]
        [DisplayName("Golpes Especiais")]
        public String GolpesEspeciais { get; set; }

        [DisplayName("Personagem Oculto")]
        public bool PersonagemOculto { get; set; }

    }
}