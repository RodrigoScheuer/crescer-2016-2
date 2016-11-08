using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using StreetFighter.RepositorioEntityFramework;
using System.Collections.Generic;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly PersonagemRepositorio repositorio;
        private readonly PersonagemRepositorioEf repositorioEf;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
            this.repositorioEf = new PersonagemRepositorioEf();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = (PersonagemRepositorio) repositorio;
        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            return repositorio.ListarPersonagens(filtroNome);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.IncluirPersonagem(personagem);
            else
                repositorio.EditarPersonagem(personagem);
        }

        public void Excluir(Personagem personagem)
        {
            repositorio.ExcluirPersonagem(personagem);
        }

        public List<Personagem> ObterPersonagemDoBanco(int id)
        {
            return repositorio.ObterPersonagem(id);
        }

        // chamar esse metodo na controler
        public Personagem BuscarPersonagemPorIdEntityFramework(int id)
        {
            return repositorioEf.BuscarPersonagem(id);
        }

    }
}
