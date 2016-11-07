using System.ComponentModel.DataAnnotations;

namespace StreetFighter.Models
{
    public class ValidacaoPersonagem : ValidationAttribute
    {
        public ValidacaoPersonagem()
        {
            ErrorMessage = "Não é permitido cadastrar persongens overpowered.";
        }

        public override bool IsValid(object value)
        {
            var nome = value as string;
            if(nome != null)
                if (nome.Equals("Nunes"))
                    return false;
            return true;
        }
    }
}