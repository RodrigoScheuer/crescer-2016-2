using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Kart
    {
        public Corredor Corredor { get; set; }
        public int Velocidade { get; private set; }
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

        public void CalcularVelocidade()
        {
            this.Velocidade = 3 + SomaBonusEquipamentos() + BonusHabilidadeCorredor();
        }

        private int BonusHabilidadeCorredor()
        {
            if (Corredor.Equals("Noob"))
            {
                return 3;
            }
            else if (Corredor.Equals("Mediano"))
            {
                return 5;
            }
            return 6 + Equipamentos
        

        public int SomaBonusEquipamentos()
        {
            return 1;
        }

    }
}
