using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class PneuDeCouroDeDragao : IEquipamento
    {
        public double Bonus
        {
            get
            {
                return 3;
            }
        }
    }
}
