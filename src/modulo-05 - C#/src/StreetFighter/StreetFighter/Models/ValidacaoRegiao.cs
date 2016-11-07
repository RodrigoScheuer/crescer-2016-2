using System.ComponentModel.DataAnnotations;

namespace StreetFighter.Models
{
    public class ValidacaoRegiao : ValidationAttribute
    {
        public ValidacaoRegiao()
        {
            ErrorMessage = "Somente um personagem pode ser dessa região.";
        }

        public override bool IsValid(object value)
        {
            var nome = value as string;
            if (nome != null)
                if (!nome.Equals("Nunes"))
                    return false;
            return true;
        }
    }
}