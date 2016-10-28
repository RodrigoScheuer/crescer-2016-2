using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class FoguetePlutonio : IEquipamento
    {
        public int nivel { get; }

        public FoguetePlutonio(int nivel = 2)
        {
            if(nivel > 0 && nivel <= 5)
            {
                this.nivel = nivel;
            }
            else
            {
                this.nivel = 2;
            }
        }

        public double Bonus
        {
            get
            {
                return nivel;
            }
        }
    }
}
