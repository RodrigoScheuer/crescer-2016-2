using System.Configuration;


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
