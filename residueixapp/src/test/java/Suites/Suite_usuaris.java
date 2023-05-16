package Suites;

// Imports
import acces.TestPerfil;
import usuaris.TestBaixaUsuari;
import usuaris.TestAltaUsuari;
import usuaris.TestModificarUsuari;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import usuaris.TestLlistatUsuaris;
import usuaris.TestTransaccionsUsuari;

/**
 * Classe amb el suite de proves per la funcionalitat d'usuari.
 * @author Daniel Garcia Ruiz
 * @version 15/05/2023
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    TestPerfil.class,
    TestLlistatUsuaris.class,
    TestAltaUsuari.class,
    TestModificarUsuari.class,
    TestBaixaUsuari.class,
    TestTransaccionsUsuari.class
})

public class Suite_usuaris {}