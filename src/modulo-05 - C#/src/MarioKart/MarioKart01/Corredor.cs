using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Corredor
    {   
        // enum dentro da classe       
        public string Nome { get; }
        public Enumerador.NivelCorredor Nivel{ get; }

        public Corredor(String nome, Enumerador.NivelCorredor nivel)
        {
            this.Nome = nome;
            this.Nivel = Enumerador.NivelCorredor.Noob | nivel;
        }

    }
}
