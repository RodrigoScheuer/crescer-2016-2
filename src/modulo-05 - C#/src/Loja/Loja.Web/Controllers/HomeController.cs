using Loja.Dominio;
using Loja.Repositorio;
using Loja.Web.Models;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class HomeController : Controller
    {
        ProdutoRepositorio repositorio = new ProdutoRepositorio();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Salvar(ProdutoModel produto)
        {
            if (ModelState.IsValid)
            {
                if (produto.Nome.Length > 2 )
                {
                    if (produto.Valor > 0)
                    {
                        Produto produtoNovo = new Produto();
                        produtoNovo.Id = produto.Id;
                        produtoNovo.Nome = produto.Nome;
                        produtoNovo.Valor = produto.Valor;

                        repositorio.AdicionarProdutos(produtoNovo);
                        TempData["mensagemCadastro"] = "Cadastro realizado com sucesso.";
                        return RedirectToAction("Listar", "Home");
                    }
                    else
                    {
                        ModelState.AddModelError("", "Valor deve ser maior que 0");
                    }     
                }
                else
                {
                    ModelState.AddModelError("", "Nome Inválido!");
                }
            }
            ModelState.AddModelError("", "Ocorreu algum erro.");
            return View("TelaDeCadastro", produto);           
        }

        public ActionResult Cadastrar(int id = 0)
        {
            if(id == 0)
                return View("TelaDeCadastro");
             else
                return View("TelaDeCadastro", repositorio.BuscarProduto(id));
        }

        public ActionResult Listar()
        {
            return View("ListaProdutos", repositorio.ListarProdutos());
        }

        public ActionResult ExcluirProduto(int id)
        {
            repositorio.Excluir(id);
            return RedirectToAction("Listar", "Home");
        }

    }
}