﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class PneuDeCouroDeDragao : IEquipamento
    {
        public int Bonus
        {
            get
            {
                return 3;
            }
        }
    }
}
