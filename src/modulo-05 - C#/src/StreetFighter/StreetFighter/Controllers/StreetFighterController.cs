using StreetFighter.web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            var model = new FichaTecnicaModel();
            
                
           model.PrimeiraAparicao = "Street Fighter II The World Warrior(1991)";
           model.Nascimento = "12 de fevereiro de 1966.";
           model.Altura = 192;
           model.Peso = 96;
           model.Medidas = " B198, C120, Q172.";
           model.TipoSanguineo = "B";
           model.HabilidadesEspeciais = "Caçar, Eletricidade.";
           model.Gosta = "Frutas tropicais, Pirarucu, Sua mãe.";
           model.Desgosta = "Army ants(espécie de formiga).";
           model.EstiloDeLuta = "Luta Selvagem autodidata(Army Ants) / Capoeira.";
           model.Origem = " Brasil(lugar de nascença é provável como sendo Tailândia).";
           model.FalaVitoria = "Ver você em ação é uma piada!";
           model.SSF2_NickName = "A selvagem criança da natureza";
           model.SFA3_NickName = "A animal pessoa amazônica";
           model.SF4_NickName = "Guerreiro da selva";
           model.SFA3_Stage = "Ramificação do Rio Madeira - pantano, Brasil \n (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?).";
           model.SF2_Stage = "Bacia do rio Amazonas(Brasil).";
           model.GolpesEspeciaisFamosos = "Electric Thunder, Rolling Attack.";
            
            return View(model);
        }

        public ActionResult Sobre()
        {
            var model = new SobreModel();

            model.PrimeiraAparicao = "Projeto Crescer";
            model.Nascimento = "30 de dezembro de 1992";
            model.Altura = 175;
            model.Peso = 71;
            model.Medidas = "B150, C100, Q150";
            model.TipoSanguineo = "B + ";
            model.HabilidadesEspeciais = "Programar Java, Piloto de fuga.";
            model.Gosta = "Frutas, Churrasco, Pizza.";
            model.Desgosta = "vegetais e legumes.";
            model.EstiloDeLuta = "Luta pela sobrevivência.";
            model.Origem = "Brasil(lugar de nascença Sapucaia do Sul).";
            model.FalaVitoria = "Uhuulll!";
            model.GolpesEspeciaisFamosos = "gancho de direita, cabeçada.";

            return View(model);
        }
    }
}