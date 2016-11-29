<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <h1>Cadastro de Pessoas</h1>

        <form action="pessoa" method="POST" >
            <table width="75%">
                <tr> 
                    <td width="10%">Nome: </td>
                    <td width="90%">
                        <input type="text" name="nome" />
                    </td>
                </tr>
            </table>
            <p> 
                <input type="submit" name="Submit" value="Cadastrar" />
            </p>
        </form>


        <div id="tabela-pessoas">
           <!-- <iframe src="pessoa"/> -->
        </div>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript">
            $.ajax({
                url: "/pessoa",
                methor: "GET"
                }.then(function(resultado){
                 $('#tabela-pessoa').html(resultado);
            })};
        </script>

    </body>
</html>
