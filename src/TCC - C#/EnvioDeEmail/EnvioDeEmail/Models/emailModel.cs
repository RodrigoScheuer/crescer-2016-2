using System;
using System.Net.Mail;
using System.Text.RegularExpressions;

namespace EnvioDeEmail.Models
{
    public class emailModel
    {
        public string para { get; set; }
        public string assunto { get; set; }
        public string mensagem { get; set; }
        public bool teste { get; set; }

        public object enviarEmail(string para, string assunto, string mensagem)
        {
            try
            {
                // Hotmail                                          gmail
                //smtp.Host = "smtp.live.com";                  smtp.Host = "smtp.gmail.com";
                //smtp.Port = 587;                              smtp.Port = 465;
                //email:rodrigo.scheuer@hotmail.com             email:  emailTesteCwi@gmail.com
                //                                              senha: GAoXIP3tC0Qv

                teste = false;
                SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587);
                MailMessage mail = new MailMessage("emailTesteCwi@gmail.com", para, assunto, mensagem);

                smtp.EnableSsl = true;
                smtp.UseDefaultCredentials = false;
                smtp.Credentials = new System.Net.NetworkCredential("emailTesteCwi@gmail.com", "GAoXIP3tC0Qv");

                if (!string.IsNullOrWhiteSpace(para))
                {
                    teste = true;
                }
                else
                {
                    teste = false;
                }

                smtp.Send(mail);
                return teste;
            }
            catch (Exception ex)
            {
                throw ex;
            }

        }

        public static bool ValidaEnderecoEmail(string enderecoEmail)
        {
            Regex expressaoRegex = new Regex(@"\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}");

            if (expressaoRegex.IsMatch(enderecoEmail))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}