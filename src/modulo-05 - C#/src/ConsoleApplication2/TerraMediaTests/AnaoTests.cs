using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Personagens;

namespace TerraMediaTests
{
    [TestClass]
    public class AnaoTests
    {
        [TestMethod]
        public void AnaoRecebeAtaqueDeOrcEFicaCom15DeVida()
        {
            var orc = new Orc();
            var anao = new Anao();

            orc.Atacar(anao);

            Assert.AreEqual(15, anao.Vida);

        }        
    }
}
