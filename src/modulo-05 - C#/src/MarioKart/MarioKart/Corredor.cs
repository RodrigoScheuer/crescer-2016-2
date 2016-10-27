using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public enum NivelCorredor
    {
        Noob, Mediano, Profissional
    };

    public class Corredor
    {   
        // enum dentro da classe       
        public String Nome { get; }
        public NivelCorredor Nivel { get; set; }

        public Corredor(String nome, NivelCorredor nivel)
        {
            this.Nome = nome;
            this.Nivel = nivel;

        }

    }
}
