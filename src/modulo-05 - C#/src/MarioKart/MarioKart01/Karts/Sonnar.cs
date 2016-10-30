using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor corredor) : base(corredor)
        {

        }

        public override int CalcularVelocidade()
        {
            if(this.Equipamentos.Capacity > 0)
            {
                this.Velocidade += 2;
            }

            return Velocidade += SomaBonusEquipamentos() + BonusHabilidadeCorredor();

        }
    }
}
