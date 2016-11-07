using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{

    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            string line;
            String[] dados;
            List<Personagem> lista = new List<Personagem>();
            // Read the file and display it line by line.
            System.IO.StreamReader file = 
            new System.IO.StreamReader(@"C:\Users\Rodrigo\GitHub\src\modulo-05 - C#\src\StreetFighter\DadosPersonagens.txt");

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
            string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Rodrigo\GitHub\src\modulo-05 - C#\src\StreetFighter\DadosPersonagens.txt");
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
            System.IO.File.WriteAllLines(@"C:\Users\Rodrigo\GitHub\src\modulo-05 - C#\src\StreetFighter\DadosPersonagens.txt", arquivo);
        }

        public void EditarPersonagem(Personagem personagem)
        {
            ExcluirPersonagem(personagem);
            IncluirPersonagem(personagem);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Rodrigo\GitHub\src\modulo-05 - C#\src\StreetFighter\DadosPersonagens.txt");
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
            
            System.IO.File.WriteAllLines(@"C:\Users\Rodrigo\GitHub\src\modulo-05 - C#\src\StreetFighter\DadosPersonagens.txt", arquivo);
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
    }

}
