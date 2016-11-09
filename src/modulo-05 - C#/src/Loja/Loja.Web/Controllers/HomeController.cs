using Loja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Salvar()
        {
            return null;
        }

        public ActionResult Cadastrar()
        {
            return View("TelaDeCadastro");
        }

        public ActionResult Listar()
        {
            ProdutoRepositorio repositorio = new ProdutoRepositorio();

            return View("ListaProdutos", repositorio.ListarProdutos());
        }
    }
}