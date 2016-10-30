using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public abstract class Kart
    {
        public Corredor Corredor { get; set; }
        public int Velocidade { get; protected set; }
        protected List<IEquipamento> Equipamentos { get; set; }

        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            this.Equipamentos = new List<IEquipamento>();
            this.Velocidade = 3;
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        public virtual int CalcularVelocidade()
        {
            return Velocidade += SomaBonusEquipamentos() + BonusHabilidadeCorredor();
        }

        protected int BonusHabilidadeCorredor()
        {
            if (Corredor.Nivel == Enumerador.NivelCorredor.Noob)
            {
                return 3;
            }
            else if (Corredor.Nivel == Enumerador.NivelCorredor.Mediano)
            {
                return 5;
            }
            else if(Corredor.Nivel == Enumerador.NivelCorredor.Profissional)
            {
                return 6 + this.Equipamentos.Count;
            }
            else
            {
                return 0;
            }
            
        }

        protected int SomaBonusEquipamentos()
        {
            int Soma = 0;
            if (this.Equipamentos.Count > 0)
            {
                foreach (var item in this.Equipamentos)
                {
                    Soma += item.Bonus;
                }
            }
            return Soma;
        }

    }
}
