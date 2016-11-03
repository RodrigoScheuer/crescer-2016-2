using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.web.Models
{
    public class FichaTecnicaModel
    {
        public String Imagem { get; set; }
        public String IdOrigem { get; set; }
        public String Nome { get; set; }
        public String Nascimento { get; set; }
        public int Altura { get; set; }
        public int Peso { get; set; }
        public String GolpesEspeciais { get; set; }
        public bool PersonagemOculto { get; set; }

    }
}