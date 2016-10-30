using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class SkyFusion : Kart, IEquipamento
    {
        public SkyFusion(Corredor corredor) : base(corredor)
        {

        }

        private int bonus;

        public int Bonus
        {
            
            get
            {
                bonus += Equipamentos.Capacity;

                if (Corredor.Nivel == Enumerador.NivelCorredor.Noob)
                {
                    bonus += 1;
                }
                else if (Corredor.Nivel == Enumerador.NivelCorredor.Mediano)
                {
                    bonus += 2;
                }
                else
                {
                    bonus += 3;
                }
                
                if (this.CalcularVelocidade() > 12)
                {
                    bonus += 5;
                }
                return bonus;
            }
            protected set
            {
                this.bonus = value;
            }
        }

        public override int CalcularVelocidade()
        {
            return this.Velocidade += SomaBonusEquipamentos() + BonusHabilidadeCorredor();
        }

    }
}
