package tcrawley.cdi;

import com.redhat.ceylon.compiler.java.runtime.tools.Backend;
import com.redhat.ceylon.compiler.java.runtime.tools.CeylonToolProvider;
import com.redhat.ceylon.compiler.java.runtime.tools.Runner;
import com.redhat.ceylon.compiler.java.runtime.tools.RunnerOptions;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Singleton;
import java.io.File;

@Singleton
public class App {

    public static Runner initCeylon() {
        System.out.println("Initializing Ceylon");
        final RunnerOptions options = new RunnerOptions();

        options.setOffline(true);
        options.setSystemRepository("flat:" + (new File("lib")).getAbsolutePath());

        return CeylonToolProvider.getRunner(Backend.Java, options, "helloworld", "1.0.0");
    }

    public static void main(String[] args) throws Exception {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        System.out.println("WELD initialized");
        Something something = container.instance().select(Something.class).get();
        System.out.println("From java: " + something.message());

        Runner runner = initCeylon();
        System.out.println("running helloworld module");
        runner.run();
    }
}
