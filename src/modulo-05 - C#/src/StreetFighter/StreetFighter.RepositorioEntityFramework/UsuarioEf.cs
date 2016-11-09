using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEntityFramework
{
    class UsuarioEf
    {
        public Usuario BuscarUsuario(int id)
        {
            using (var context = new DatabaseContext())
            {
                Usuario usuarioFound = context.usuario.FirstOrDefault(u => u.Id == id);
                return usuarioFound;
            }
        }

        public void AdicionarUsuario(Usuario usuario)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Usuario>(usuario).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public void EditarUsuario(Usuario usuario)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Usuario>(usuario).State = EntityState.Modified;
                context.SaveChanges();
            }
        }
    }
}
