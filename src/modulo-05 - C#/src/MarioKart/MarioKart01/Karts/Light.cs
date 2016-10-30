using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Light : Kart
    {
        public Light(Corredor corredor) : base(corredor)
        {
            
        }

        public override int CalcularVelocidade()
        {
            if (Corredor.Nivel == Enumerador.NivelCorredor.Noob)
            {
                this.Velocidade += 3;
            }

            if (Corredor.Nivel == Enumerador.NivelCorredor.Profissional)
            {
                this.Velocidade -= 1;
            }

            return this.Velocidade += SomaBonusEquipamentos() + BonusHabilidadeCorredor();

        }
    }
}
