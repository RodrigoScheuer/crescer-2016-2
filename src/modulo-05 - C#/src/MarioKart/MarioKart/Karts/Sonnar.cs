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

        public override void CalcularVelocidade()
        {
            base.CalcularVelocidade();

            if(Equipamentos.Capacity > 0)
            {
                Velocidade += 2;
            }
            
        }
    }
}
