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

                 kart.CalcularVelocidade();

                 Assert.AreEqual(6, kart.Velocidade);

             }

             [TestMethod]
             public void TestSonnarComPneuDeCouroDeDragao()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
                 MarioKart.Equipamentos.PneuDeCouroDeDragao Pneu = new MarioKart.Equipamentos.PneuDeCouroDeDragao();
                 var kart = new Sonnar(corredor01);

                 kart.Equipar(Pneu);
                 kart.CalcularVelocidade();

                 Assert.AreEqual(11, kart.Velocidade);
             }

             [TestMethod]
             public void TestSonnarComMotorABaseDeLava()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
                 MarioKart.Equipamentos.MotorABaseDeLava motor = new MarioKart.Equipamentos.MotorABaseDeLava();
                 var kart = new Sonnar(corredor01);

                 kart.Equipar(motor);
                 kart.CalcularVelocidade();

                 Assert.AreEqual(10, kart.Velocidade);
             }

             [TestMethod]
             public void TestSonnarComUltraPack()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Mediano);
                 MarioKart.Equipamentos.IEquipamento motor = new MarioKart.Equipamentos.MotorABaseDeLava();
                 MarioKart.Equipamentos.UltraPack ultraPack = new MarioKart.Equipamentos.UltraPack(motor);
                 var kart = new Sonnar(corredor01);

                 kart.Equipar(ultraPack);
                 kart.CalcularVelocidade();

                 Assert.AreEqual(13, kart.Velocidade);
             }

             [TestMethod]
             public void TestSonnarComFoguetePlutonioSemInformarNivel()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
                 MarioKart.Equipamentos.FoguetePlutonio foguete = new MarioKart.Equipamentos.FoguetePlutonio();
                 var kart = new Sonnar(corredor01);

                 kart.Equipar(foguete);
                 kart.CalcularVelocidade();

                 Assert.AreEqual(10, kart.Velocidade);

             }

             [TestMethod]
             public void TestSonnarComFoguetePlutonioInformandoNivel3()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob); //3
                 MarioKart.Equipamentos.FoguetePlutonio foguete = new MarioKart.Equipamentos.FoguetePlutonio(3); //3
                 var kart = new Sonnar(corredor01); 
                 kart.Equipar(foguete);

                 kart.CalcularVelocidade(); //11 = 5 do kart + 3 + 3


                 Assert.AreEqual(11, kart.Velocidade);

             }

             // outro kart
             [TestMethod]
             public void TestLigthDirigidoPorNoob() 
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
                 var kart = new Light(corredor01);

                 Assert.AreEqual(9, kart.CalcularVelocidade());

             }

             [TestMethod]
             public void TestLigthDirigidoPorIntermediario()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Mediano);
                 var kart = new Light(corredor01);

                 Assert.AreEqual(8, kart.CalcularVelocidade());
             }

             [TestMethod]
             public void TestLigthDirigidoPorProfissionalSemEquipamento()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Profissional);
                 var kart = new Light(corredor01);

                 Assert.AreEqual(8, kart.CalcularVelocidade());
             }

             //teste falhando miticamente
             [TestMethod]
             public void TestLigthDirigidoPorProfissionalComEquipamento()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Profissional); // 6 + 1 equipamento
                 MarioKart.Equipamentos.IEquipamento foguete = new MarioKart.Equipamentos.FoguetePlutonio(); //2
                 var kart = new Light(corredor01); //-1
                 kart.Equipar(foguete);

                 Assert.AreEqual(11, kart.CalcularVelocidade());
             }

             //outro Kart
             [TestMethod]
             public void TestDinam()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Profissional);
                 var kart = new Dinam(corredor01);

                 Assert.AreEqual(15, kart.CalcularVelocidade());
             }

             //outro kart
             [TestMethod]
             public void TestSkyFusionComoKartSemEquipamento()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
                 var kart = new SkyFusion(corredor01);

                 Assert.AreEqual(6, kart.CalcularVelocidade());
             }

             [TestMethod]
             public void TestSkyFusionComoKartComEquipamento()
             {
                 Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Noob);
                 MarioKart.Equipamentos.MotorABaseDeLava motor = new MarioKart.Equipamentos.MotorABaseDeLava();
                 var kart = new SkyFusion(corredor01);
                 kart.Equipar(motor);

                 Assert.AreEqual(8, kart.CalcularVelocidade());
             }

        [TestMethod]
        public void TestSkyFusionComoEquipamento()
        {
            Corredor corredor01 = new Corredor("Yoshi", Enumerador.NivelCorredor.Profissional);
            MarioKart.Equipamentos.IEquipamento upgrade = new SkyFusion(corredor01);
            var kart = new Dinam(corredor01);
            kart.Equipar(upgrade);
            var test = kart.CalcularVelocidade();

            Assert.AreEqual(20, test);
        }

    }
}
