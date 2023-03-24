import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * Classe amb el suite de proves per la funcionalitat de login.
 * @author Daniel Garcia Ruiz
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    TestPerfil.class,
    TestAltaUsuari.class,
    TestModificarUsuari.class,
    TestBaixaUsuari.class
})

public class Suite_usuaris {}