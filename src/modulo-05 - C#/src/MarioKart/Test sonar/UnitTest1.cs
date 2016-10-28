using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Karts;

namespace Test_sonar
{
    [TestClass]
    public class VelocidadeKart
    {
        [TestMethod]
        public void TestSonnarSemEquipamento()
        {
            Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
            var kart = new Sonnar(corredor01);

            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void TestSonnarComPneuDeCouroDeDragao()
        {
            Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
            MarioKart.Equipamentos.PneuDeCouroDeDragao Pneu = new MarioKart.Equipamentos.PneuDeCouroDeDragao();
            var kart = new Sonnar(corredor01);

            kart.Equipar(Pneu);

            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void TestSonnarComMotorABaseDeLava()
        {
            Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
            MarioKart.Equipamentos.MotorABaseDeLava motor = new MarioKart.Equipamentos.MotorABaseDeLava();
            var kart = new Sonnar(corredor01);

            kart.Equipar(motor);

            Assert.AreEqual(12, kart.Velocidade);
        }

        [TestMethod]
        public void TestSonnarComUltraPack()
        {
            Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
            MarioKart.Equipamentos.MotorABaseDeLava motor = new MarioKart.Equipamentos.MotorABaseDeLava();
            MarioKart.Equipamentos.UltraPack ultraPack = new MarioKart.Equipamentos.UltraPack(motor);
            var kart = new Sonnar(corredor01);
            
            kart.Equipar(ultraPack);

            Assert.AreEqual(13, kart.Velocidade);
        }

        [TestMethod]
        public void TestSonnarComFoguetePlutonioSemInformarNivel()
        {
            Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
            MarioKart.Equipamentos.FoguetePlutonio foguete = new MarioKart.Equipamentos.FoguetePlutonio();
            var kart = new Sonnar(corredor01);

            kart.Equipar(foguete);

            Assert.AreEqual(10, kart.Velocidade);

        }

        [TestMethod]
        public void TestSonnarComFoguetePlutonioInformandoNivel3()
        {
            Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
            MarioKart.Equipamentos.FoguetePlutonio foguete = new MarioKart.Equipamentos.FoguetePlutonio(3);
            var kart = new Sonnar(corredor01);

            kart.Equipar(foguete);

            Assert.AreEqual(11, kart.Velocidade);

        }

        //---------------------------------------------Terminar Testes-----------------------------------------

        // outro kart
        [TestMethod]
        public void TestLigthDirigidoPorNoob() { }

        [TestMethod]
        public void TestLigthDirigidoPorIntermediario() { }

        [TestMethod]
        public void TestLigthDirigidoPorProfissional() { }

        //outro Kart
        [TestMethod]
        public void TestDinam() { }

    }
}
