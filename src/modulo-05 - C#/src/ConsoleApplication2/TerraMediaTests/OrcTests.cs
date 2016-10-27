using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Personagens;

namespace TerraMediaTests
{
    [TestClass]
    public class OrcTests
    {
        [TestMethod]
        public void TestMethod1()
        {
            var orc = new Orc();
            orc.ataque = 10;

            Assert.AreEqual(12, orc.Ataque);
        }

        
    }
}
