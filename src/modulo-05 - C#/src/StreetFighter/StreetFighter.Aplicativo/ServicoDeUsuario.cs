using StreetFighter.Dominio;
using StreetFighter.Infra;
using System.Linq;

namespace StreetFighter.Aplicativo
{
    public class ServicoDeUsuario
    {
        private static Usuario[] _usuarios =
        {
            new Usuario()
            {
                Nome = "rodrigo",
                Senha = "afc1237c6b7b965e3d24791d7c7c7966",
                Permissoes = new string[] { "CHINELO" }
            }
        };

        public static Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {
            Usuario usuarioEncontrado = _usuarios.FirstOrDefault(
                usuario => usuario.Nome.Equals(nome));

            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{nome}_$_{senha}");

            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaDeComparacao))
            {
                // escrever dados em arquivo de txt
                return usuarioEncontrado;
            }

            return null;
        }
    }
}
