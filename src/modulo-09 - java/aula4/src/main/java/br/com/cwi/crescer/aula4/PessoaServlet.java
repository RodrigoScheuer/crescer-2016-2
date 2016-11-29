package br.com.cwi.crescer.aula4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Carlos H. Nonnemacher
 */
@WebServlet(name = "pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    @EJB
    private PessoaBean pessoaBean;

    List<String> nomes = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (final PrintWriter out = response.getWriter();) {

            out.append("<table id=\"tabela-pessoas\">");
           out.append("<thead>");
           out.append("<tr>");
           out.append("<th>");
           out.append("Nome");
           out.append("</th>");        
           out.append("</tr>");
           out.append("<thead>");
           out.append("<tbody>");
           pessoaBean.findAll().forEach(p -> {
               out.append("<tr>");
               out.append("<td>").append(p.getNmPessoa()).append("</td>");
               out.append("</tr>");
           });
           out.append("</tbody>");
           out.append("</table>");

           out.append("</body>");
           out.append("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nomePessoa = request.getParameter("nome");
      
        Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa(nomePessoa);
        pessoaBean.insert(pessoa);
        doGet(request, response);
    }
}
