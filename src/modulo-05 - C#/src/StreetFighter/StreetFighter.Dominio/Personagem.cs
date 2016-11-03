using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public String Imagem { get; set; }
        public int Id { get; private set; }
        public String Nome { get; private set; }
        public String IdOrigem { get; set; }
        public DateTime Nascimento { get; set; }
        public int Altura { get; set; }
        public decimal Peso { get; set; }
        public String GolpesEspeciais { get; set; }
        public bool PersonagemOculto { get; set; }

        public Personagem(int id, String nome, String origem) : this(nome, origem)
        {
            this.Id = id;

        }

        public Personagem(String nome, String origem)
        {
            this.Nome = nome;
            this.IdOrigem = origem;
        }
    }
}
