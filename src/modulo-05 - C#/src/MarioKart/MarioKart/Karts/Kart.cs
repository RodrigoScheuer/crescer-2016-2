using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public abstract class Kart
    {
        public Corredor Corredor { get; set; }
        public double Velocidade { get; protected set; }
        protected List<IEquipamento> Equipamentos { get; set; }

        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            this.Equipamentos = new List<IEquipamento>();
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        public virtual void CalcularVelocidade()
        {
            this.Velocidade = 3 + SomaBonusEquipamentos() + BonusHabilidadeCorredor();
        }

        protected int BonusHabilidadeCorredor()
        {
            if (Corredor.Equals("Noob"))
            {
                return 3;
            }
            else if (Corredor.Equals("Mediano"))
            {
                return 5;
            }
            return 6 + Equipamentos.Capacity;
        }

        protected double SomaBonusEquipamentos()
        {
            double Soma = 0;
            if (Equipamentos.Capacity > 0)
            {
                foreach (var item in Equipamentos)
                {
                    Soma += item.Bonus;
                }
            }
            return Soma;
        }

    }
}
