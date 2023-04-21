package Suites;

// Imports
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import utils.TestUtils;
import puntsrecollida.TestLlistatPuntsRecollida;
import puntsrecollida.TestAltaPuntRecollida;
import puntsrecollida.TestModificarPuntRecollida;
import puntsrecollida.TestBaixaPuntRecollida;
import puntsrecollida.TestRecollidaIdentifcacio;
import puntsrecollida.TestRecollida;

/**
 * Classe amb el suite de proves per la funcionalitat de residus
 * @author Daniel Garcia Ruiz
 * @version 21/04/2023
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    TestUtils.class,
    TestLlistatPuntsRecollida.class,
    TestAltaPuntRecollida.class,
    TestModificarPuntRecollida.class,
    TestBaixaPuntRecollida.class,
    TestRecollidaIdentifcacio.class,
    TestRecollida.class
})

public class Suite_puntsRecollida {}