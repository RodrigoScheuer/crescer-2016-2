using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace StreetFighter.Repositorio
{

    public class PersonagemRepositorio : IPersonagemRepositorio 
    {   // diretorio cwi
        private String Diretorio = @"C:\Users\rodrigo.scheuer\GitHub\src\modulo-05 - C#\src\StreetFighter\DadosPersonagens.txt";
        // diretorio casa
        //private String Diretorio = @"C:\Users\Rodrigo\GitHub\src\modulo-05 - C#\src\StreetFighter\DadosPersonagens.txt";

        public List<Personagem> ObterPersonagem(int id)
        {
            String connectionString = ConfigurationManager.ConnectionStrings["StreetConnection"].ConnectionString;

            List<Personagem> result = new List<Personagem>();

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                String sql = $"SELECT * FROM Personagens WHERE id = @param_id";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_id", id));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Personagem found = ConvertReaderToPersonagem(reader);

                    result.Add(found);
                }
            }
            return result;
	}

        public void Save(Personagem personagem)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["MovieConnection"]
                                    .ConnectionString;

            var result = new List<Personagem>();

            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();
                    string sql = "";
                    var parameters = new List<SqlParameter>();

                    if (personagem.Id > 0)
                    {
                        sql = $"UPDATE Personagens SET urlImagem=@param_imagem, nome=@param_nome, nascimento=@param_nascimento, altura=@param_altura, peso=@param_peso, golpesEspecias=@param_golpesEspeciais, personagemOculto=@param_personagemOculto WHERE Id = @param_id";
                        parameters.Add(new SqlParameter("param_id", personagem.Id));
                        parameters.Add(new SqlParameter("param_imagem", personagem.Imagem));
                        parameters.Add(new SqlParameter("param_nome", personagem.Nome));
                        parameters.Add(new SqlParameter("param_nascimento", personagem.Nascimento));
                        parameters.Add(new SqlParameter("param_altura", personagem.Altura));
                        parameters.Add(new SqlParameter("param_peso", personagem.Peso));
                        parameters.Add(new SqlParameter("param_golpesEspeciais", personagem.GolpesEspeciais));
                        parameters.Add(new SqlParameter("param_personagemOculto", personagem.PersonagemOculto));
                    }
                    else
                    {
                        sql = $"INSERT INTO Personagens (id) values (@param_id)";
                        //parameters.Add(new SqlParameter("param_id", personagem.Id));
                        //....
                    }

                    var command = new SqlCommand(sql, connection);
                    foreach (SqlParameter param in parameters)
                    {
                        command.Parameters.Add(param);
                    }
                    command.ExecuteNonQuery();
                    // nunca esquecer de colocar o codigo abaixo
                    transaction.Complete();
                }
                catch (Exception ex)
                {
                    // tratar erro aki
                    Console.WriteLine(ex); 
                }
                finally
                {
                    connection.Close();
                }
            }
        }


        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            string line;
            String[] dados;
            List<Personagem> lista = new List<Personagem>();
            // Read the file and display it line by line.
            System.IO.StreamReader file = 
            new System.IO.StreamReader(Diretorio);

            while ((line = file.ReadLine()) != null)
            {
                dados = line.Split(';');

                if (dados[2].Contains(filtroNome))
                {
                    lista.Add(AdicionarPersonagemNaLista(dados));
                }else if (filtroNome == "AllPersonagens")
                {
                    lista.Add(AdicionarPersonagemNaLista(dados));
                }
            }
            file.Close();
            return lista;
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            string[] lines = System.IO.File.ReadAllLines(Diretorio);
            if(personagem.Id == 0)
            {
                personagem.Id = lines.Count() + 1;
            }

            List<String> arquivo = new List<string>();
            if(lines != null)
            {
                foreach (var item in lines)
                {
                    arquivo.Add(item);
                }
            }
            arquivo.Add(personagem.DadosString());
            System.IO.File.WriteAllLines(Diretorio, arquivo);
        }

        public void EditarPersonagem(Personagem personagem)
        {
            ExcluirPersonagem(personagem);
            IncluirPersonagem(personagem);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            string[] lines = System.IO.File.ReadAllLines(Diretorio);
            String[] dados;
            List<String> arquivo = new List<string>();

            foreach (var itemDoArquivo in lines)
            {
                dados = itemDoArquivo.Split(';');

                if (!dados[0].Contains(personagem.Id.ToString()))
                {
                    arquivo.Add(itemDoArquivo);
                }
            }
            
            System.IO.File.WriteAllLines(Diretorio, arquivo);
        }


        private Personagem AdicionarPersonagemNaLista(String[] dados)
        {
            Personagem personagem;

            int id = Convert.ToInt32(dados[0]);
            String imagem = dados[1];
            String nome = dados[2];
            String idOrigem = dados[3];
            DateTime nascimento = Convert.ToDateTime(dados[4]);
            int altura = Convert.ToInt32(dados[5]);
            decimal peso = Convert.ToDecimal(dados[6]);
            String golpesEspeciais = dados[7];
            bool personagemOculto = Convert.ToBoolean(dados[8]);

            personagem = new Personagem(id, imagem, nome, idOrigem, nascimento,
                                        altura, peso, golpesEspeciais, personagemOculto);
            return personagem;
        }

        private Personagem ConvertReaderToPersonagem(SqlDataReader reader)
        {
            int IdRow = Convert.ToInt32(reader["id"]);
            String ImagemRow = reader["urlImagem"].ToString();
            String NomeRow = reader["nome"].ToString();
            String IdOrigemRow = reader["idOrigem"].ToString();
            DateTime NascimentoRow = Convert.ToDateTime(reader["nascimento"]);
            int AlturaRow = Convert.ToInt32(reader["altura"]);
            decimal PesoRow = Convert.ToDecimal(reader["peso"]);
            String GolpesEspeciaisRow = reader["golpesEspeciais"].ToString();
            bool PersonagemOcultoRow = Convert.ToBoolean(reader["personagemOculto"]);

           return new Personagem(id: IdRow, imagem: ImagemRow, nome: NomeRow, idOrigem: IdOrigemRow,
                                            nascimento: NascimentoRow, altura: AlturaRow, peso: PesoRow,
                                            golpesEspeciais: GolpesEspeciaisRow, personagemOculto: PersonagemOcultoRow);
        }
    }

}
