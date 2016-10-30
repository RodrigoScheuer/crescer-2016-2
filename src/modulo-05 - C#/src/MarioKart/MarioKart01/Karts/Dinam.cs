using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Dinam : Kart
    {
        public Dinam(Corredor corredor) : base(corredor)
        {

        }

        public override int CalcularVelocidade()
        {
           return this.Velocidade += SomaBonusEquipamentos() + (BonusHabilidadeCorredor() * 2);
        }
    }
}
