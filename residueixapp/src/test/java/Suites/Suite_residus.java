package Suites;

// Imports
import utils.TestUtils;
import residus.TestLListatResidus;
import residus.TestLListatTipusResidu;
import residus.TestAltaTipusResidu;
import residus.TestModificarTipusResidu;
import residus.TestBaixaTipusResidu;
import residus.TestAltaResidus;
import residus.TestModificarResidu;
import residus.TestBaixaResidu;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * Classe amb el suite de proves per la funcionalitat de residus
 * @author Daniel Garcia Ruiz
 * @version 21/04/2023
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    TestUtils.class,
    TestLListatResidus.class,
    TestLListatTipusResidu.class,
    TestAltaTipusResidu.class,
    TestModificarTipusResidu.class,
    TestBaixaTipusResidu.class,
    TestAltaResidus.class,
    TestModificarResidu.class,
    TestBaixaResidu.class
})

public class Suite_residus {}