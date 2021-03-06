﻿using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
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

        public void AdicionarPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public void EditarPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

    }
}
