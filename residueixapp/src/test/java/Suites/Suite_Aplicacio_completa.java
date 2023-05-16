package Suites;

// Imports
import acces.TestLogin;
import acces.TestPerfil;
import acces.TestPrincipal;
import acces.TestRestablirParaulaClau;
import esdeveniments.TestAltaEsdeveniment;
import esdeveniments.TestAssistentsEsdeveniments;
import esdeveniments.TestBaixaEsdeveniment;
import esdeveniments.TestEstadistiguesEsdeveniments;
import esdeveniments.TestLlistatEsdeveniments;
import esdeveniments.TestModificarEsdeveniment;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import puntsrecollida.TestAltaPuntRecollida;
import puntsrecollida.TestBaixaPuntRecollida;
import puntsrecollida.TestLlistatPuntsRecollida;
import puntsrecollida.TestModificarPuntRecollida;
import puntsrecollida.TestRecollida;
import puntsrecollida.TestRecollidaIdentifcacio;
import residus.TestAltaResidus;
import residus.TestAltaTipusResidu;
import residus.TestBaixaResidu;
import residus.TestBaixaTipusResidu;
import residus.TestLListatResidus;
import residus.TestLListatTipusResidu;
import residus.TestModificarResidu;
import residus.TestModificarTipusResidu;
import usuaris.TestAltaUsuari;
import usuaris.TestBaixaUsuari;
import usuaris.TestLlistatUsuaris;
import usuaris.TestModificarUsuari;
import usuaris.TestTransaccionsUsuari;
import utils.TestUtils;
import utils.TestXifratParaulaClau;

/**
 * Classe amb el suite de proves per a tota l'aplicació.
 * @author Daniel Garcia Ruiz
 * @version 16/05/2023
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    TestUtils.class,
    TestXifratParaulaClau.class,
    TestLogin.class,
    TestPerfil.class,
    TestPrincipal.class,
    TestRestablirParaulaClau.class,
    TestLlistatUsuaris.class,
    TestAltaUsuari.class,
    TestModificarUsuari.class,
    TestBaixaUsuari.class,
    TestTransaccionsUsuari.class,
    TestLListatResidus.class,
    TestLListatTipusResidu.class,
    TestAltaTipusResidu.class,
    TestModificarTipusResidu.class,
    TestBaixaTipusResidu.class,
    TestAltaResidus.class,
    TestModificarResidu.class,
    TestBaixaResidu.class,
    TestLlistatPuntsRecollida.class,
    TestAltaPuntRecollida.class,
    TestModificarPuntRecollida.class,
    TestBaixaPuntRecollida.class,
    TestRecollidaIdentifcacio.class,
    TestRecollida.class,
    TestLlistatEsdeveniments.class,
    TestAltaEsdeveniment.class,
    TestModificarEsdeveniment.class,
    TestBaixaEsdeveniment.class,
    TestAssistentsEsdeveniments.class,
    TestEstadistiguesEsdeveniments.class
})

public class Suite_Aplicacio_completa {}