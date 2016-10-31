using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            var retorno = new List<Funcionario>();
            return Funcionarios.Where(fnc => fnc.Cargo.Titulo.Contains(cargo.Titulo)).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(fnc => fnc.Cargo.Titulo).ThenBy(fnc => fnc.Nome).ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.Where(fnc => fnc.Nome.Contains(nome)).ToList();
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            return Funcionarios.Where(fnc => turnos.Contains(fnc.TurnoTrabalho)).ToList();
        }        

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            var anoAtual = DateTime.Now.Year;
            return Funcionarios.Where(fnc => (anoAtual - fnc.DataNascimento.Year) >= (idade - 5)
                                          && (anoAtual - fnc.DataNascimento.Year) <= (idade + 5)).ToList();

        }        

        // falta uma parte - verificar média por turno
        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            if (turno == null)
            {
                return Funcionarios.Average(func => func.Cargo.Salario);
            }

            var novoFuncionario = from fnc in Funcionarios
                    where fnc.TurnoTrabalho == turno
                    select new { Func = fnc, salario = fnc.Cargo.Salario };

               double media = novoFuncionario.Average(fnc => fnc.salario);
            
            return media;
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var MesAtual = DateTime.Now.Month;
            return Funcionarios.Where(fnc =>  fnc.DataNascimento.Month  == MesAtual).ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
            var resultado = from fnc in Funcionarios
                             select new { NomeFuncionario = fnc.Nome , TituloCargo = fnc.Cargo.Titulo };
            return new List<dynamic>(resultado);
        }

        // esta incorreto
       public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
           var resultado = from fnc in Funcionarios
                            group fnc by fnc.TurnoTrabalho into funcionario
                            select new { Turno = funcionario , Quantidade = funcionario.Distinct().Count() };

            return new List<dynamic>(resultado);
        }

        public dynamic FuncionarioMaisComplexo()
        {
            throw new NotImplementedException();
        }
    }
}
