using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEntityFramework
{
    public class DatabaseContext : DbContext
    {
        public DbSet<Personagem> personagem { get; set; }
        public DbSet<Usuario> usuario { get; set; }

        public DatabaseContext() : base("StreetConnection")
        {
          
        }

        // remove a pluralizacao padrao do entity framework
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }
    }
}
