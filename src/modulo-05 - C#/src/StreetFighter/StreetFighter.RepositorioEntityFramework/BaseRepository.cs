using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEntityFramework
{
    public abstract class BaseRepository
    {
        protected string ConnectionString
        {
            get
            {
                return ConfigurationManager.ConnectionStrings["StreetConnection"].ConnectionString;
            }
        }
    }
}
