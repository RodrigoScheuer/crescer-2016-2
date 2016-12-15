using EnvioDeEmail.Models;
using System.Web.Mvc;

namespace EnvioDeEmail.controller
{
    public class EmailController : Controller
    {
        // GET: Email
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cadastrar()
        {
            return View();
        }

        public ActionResult enviarEmail(emailModel model)
        {
            model.enviarEmail(model.para, model.assunto, model.mensagem);
            if (model.teste == true)
            {
                TempData["mensagemSucesso"] = "enviado com sucesso!";
            }
            TempData["mensagemErro"] = "erro";
            return View("index");
        }
    }
}