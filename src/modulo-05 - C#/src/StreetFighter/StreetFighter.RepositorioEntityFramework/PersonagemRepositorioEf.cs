using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEntityFramework
{
    public class PersonagemRepositorioEf
    {
        public Personagem BuscarPersonagem(int id)
        {

            using (var context = new DatabaseContext())
            {
                Personagem personagemFound = context.personagem.FirstOrDefault(u => u.Id == id);
                return personagemFound;
            }
        }

    }
}
