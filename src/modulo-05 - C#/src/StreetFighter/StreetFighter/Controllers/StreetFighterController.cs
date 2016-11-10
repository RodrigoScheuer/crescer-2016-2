
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.web.Models;
using System;
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

        public ActionResult FichaTecnica(int id)
        {
           
           var model = pesquisarPersonagem(id);
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
            PopularDropDownOrigens();

            return View("TelaDeCadastro");
        }

        public ActionResult Salvar(FichaTecnicaModel model)
        {
            PopularDropDownOrigens();
            
            if (ModelState.IsValid)
            {
                TempData["cadastradoComSucesso"] = "* Personagem Cadastrado com sucesso!";

                var aplicativo = new PersonagemAplicativo();
                Personagem personagem = new Personagem(Convert.ToInt32(model.Id), model.Imagem, model.Nome, model.IdOrigem, model.Nascimento,
                                                       model.Altura, model.Peso, model.GolpesEspeciais, model.PersonagemOculto);
                //aplicativo.Salvar(personagem);

                // usando entityFramework
                aplicativo.AdicionarPersonagemEntityFramework(personagem);
                return RedirectToAction("ListaPersonagens");
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro.");
                if (model.Nome != null && model.IdOrigem != null)
                {
                    if (model.Nome.Equals("Nunes"))
                        ModelState.AddModelError("", "Não é permitido cadastrar persongens overpowered.");

                    if (model.IdOrigem.Equals("RS") && !model.Nome.Equals("Nunes"))
                        ModelState.AddModelError("", "Somente um personagem pode ser dessa região e não é o " + model.Nome + ".");
                }
                return View("TelaDeCadastro");
            }
        }

        public ActionResult ListaPersonagens(String pesquisar = "AllPersonagens")
        {
            var aplicativo = new PersonagemAplicativo();
            return View(aplicativo.ListarPersonagens(pesquisar));
        }

        public ActionResult ExcluirPersonagem(int id)
        {
            var aplicativo = new PersonagemAplicativo();
            foreach (var personagem in aplicativo.ListarPersonagens("AllPersonagens"))
            {
                if (personagem.Id == id)
                {
                    aplicativo.Excluir(personagem);
                    TempData["PersonagemExcluido"] = "* Personagem Excluido!";
                }
            }        
            return RedirectToAction("ListaPersonagens");
        }

        public ActionResult EditarPersonagem(int id)
        {
            PopularDropDownOrigens();
            TempData["PersonagemEditado"] = "* Personagem Editado.";

            var model = pesquisarPersonagem(id);
            return View("TelaDeCadastro", model);
        }

        public ActionResult editarPersonagemEntityFramework(int id)
        {
            PopularDropDownOrigens();
            TempData["PersonagemEditado"] = "* Personagem Editado.";

            var model = new FichaTecnicaModel();
            var aplicativo = new PersonagemAplicativo();
            Personagem personagem = aplicativo.BuscarPersonagemPorIdEntityFramework(id);
            model.Imagem = personagem.Imagem;
            model.Nome = personagem.Nome;
            model.Nascimento = personagem.Nascimento;
            model.Altura = personagem.Altura;
            model.Peso = personagem.Peso;
            model.IdOrigem = personagem.IdOrigem;
            model.GolpesEspeciais = personagem.GolpesEspeciais;
            model.PersonagemOculto = personagem.PersonagemOculto;
            return View("TelaDeCadastro", model);
        }

        // sem EntityFramework
        public ActionResult ObterPersonagemDoBanco(String pesquisar)
        {
            if(pesquisar != null) { 
            int id = Convert.ToInt32(pesquisar);
            var aplicativo = new PersonagemAplicativo();
            List<Dominio.Personagem> lista =  aplicativo.ObterPersonagemDoBanco(id);
            return View("ListaPersonagens", lista);
            }else
            {
                return View("ListaPersonagens");
            }
            
        }

        // com EntityFramework
        public  ActionResult BuscarPorId(String pesquisar)
        {
            if (pesquisar != null)
            {
                int id = Convert.ToInt32(pesquisar);
                var aplicativo = new PersonagemAplicativo();
                Personagem personagem = aplicativo.BuscarPersonagemPorIdEntityFramework(id);
                List<Dominio.Personagem> lista = new List<Personagem>();
                if(personagem != null)
                {
                    lista.Add(personagem);
                }
                return View("ListaPersonagens", lista);
            }
            else
            {
                return View("ListaPersonagens");
            }
        }

        private void PopularDropDownOrigens()
        {
            ViewData["ListaPais"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "AR", Text = "Argentina" },
                new SelectListItem() { Value = "JP", Text = "Japão" },
                new SelectListItem() { Value = "RS", Text = "Morro da Pedra"}
            };
        }

        private FichaTecnicaModel pesquisarPersonagem(int id)
        {
            var model = new FichaTecnicaModel();
            var aplicativo = new PersonagemAplicativo();
            foreach (var personagem in aplicativo.ListarPersonagens("AllPersonagens"))
            {
                if (personagem.Id == id)
                {
                    model.Imagem = personagem.Imagem;
                    model.Nome = personagem.Nome;
                    model.Nascimento = personagem.Nascimento;
                    model.Altura = personagem.Altura;
                    model.Peso = personagem.Peso;
                    model.IdOrigem = personagem.IdOrigem;
                    model.GolpesEspeciais = personagem.GolpesEspeciais;
                    model.PersonagemOculto = personagem.PersonagemOculto;
                    break;
                }
            }
            return model;
        }
    }
}