
using StreetFighter.web.Models;
using System.Collections.Generic;
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

           model.Imagem = "http://www.streetfighter.com.br/upload/editor/20120823194105_127.png";
           model.Nome = "Blanka";
           model.Nascimento = "12/02/1966";
           model.Altura = 192;
           model.Peso = 96;
           model.IdOrigem = "BR";
           model.GolpesEspeciais = "Electric Thunder, Rolling Attack.";
           model.PersonagemOculto = false;

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

        public ActionResult Cadastrar()
        {
            Origens();

            return View("TelaDeCadastro");
        }

        public ActionResult Salvar(CadastrarModel model)
        {
            Origens();

            if (ModelState.IsValid)
            {
                ViewBag.Mensagem = "Cadastro concluído com sucesso.";
                return View("ItemCadastrado", model);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro. Da uma olhada aí pls :(");
                return View("TelaDeCadastro");
            }
        }

        public void Origens()
        {
            //@ViewBag.ListaPais
            ViewData["ListaPais"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "AR", Text = "Argentina" },
                new SelectListItem() { Value = "JP", Text = "Japão" }
            };
        }
    }
}