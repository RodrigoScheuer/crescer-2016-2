using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {
        IEquipamento Equipamento;

        public UltraPack(IEquipamento equipamento)
        {
            Equipamento = equipamento;
        }

        public int Bonus
        {
            get
            {
                return Equipamento.Bonus + (int)Math.Ceiling(0.2 * Equipamento.Bonus);
            }
        }

        
    }
}
