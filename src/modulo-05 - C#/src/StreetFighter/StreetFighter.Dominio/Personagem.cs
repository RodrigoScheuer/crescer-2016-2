using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; set; }
        public String Imagem { get; private set; }
        public String Nome { get; private set; }
        public String IdOrigem { get; private set; }
        public DateTime Nascimento { get; private set; }
        public int Altura { get; private set; }
        public decimal Peso { get; private set; }
        public String GolpesEspeciais { get; private set; }
        public bool PersonagemOculto { get; private set; }

    public Personagem(int id, String imagem, String nome, String idOrigem, DateTime nascimento, 
                          int altura, decimal peso, String golpesEspeciais, bool personagemOculto)
        {
            this.Id = id;
            this.Imagem = imagem;
            this.Nome = nome;
            this.IdOrigem = idOrigem;
            this.Nascimento = nascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
        }

        public Personagem() { }

        public String DadosString()
        {
            return  this.Id + ";" + this.Imagem + ";" + this.Nome + ";" + this.IdOrigem + ";" + this.Nascimento + ";" +
                    this.Altura + ";" + this.Peso + ";" + this.GolpesEspeciais + ";" + this.PersonagemOculto;
        }
    }
}
