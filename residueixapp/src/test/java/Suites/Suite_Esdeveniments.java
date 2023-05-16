package Suites;

// Imports
import esdeveniments.TestAltaEsdeveniment;
import esdeveniments.TestAssistentsEsdeveniments;
import esdeveniments.TestBaixaEsdeveniment;
import esdeveniments.TestEstadistiguesEsdeveniments;
import esdeveniments.TestLlistatEsdeveniments;
import esdeveniments.TestModificarEsdeveniment;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import utils.TestUtils;

/**
 * Classe amb el suite de proves per la funcionalitat d'esdeveniments
 * @author Daniel Garcia Ruiz
 * @version 15/05/2023
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    TestUtils.class,
    TestLlistatEsdeveniments.class,
    TestAltaEsdeveniment.class,
    TestModificarEsdeveniment.class,
    TestBaixaEsdeveniment.class,
    TestAssistentsEsdeveniments.class,
    TestEstadistiguesEsdeveniments.class
})

public class Suite_Esdeveniments {}