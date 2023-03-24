import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * Classe amb el suite de proves per la funcionalitat de login.
 * @author Daniel Garcia Ruiz
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    TestLogin.class,
    TestRestablirParaulaClau.class,
    TestPrincipal.class
})

public class Suite_login {}