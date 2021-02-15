import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.net.URL;
import java.security.ProtectionDomain;

public class Main {

    public static void main(String[] args) {

        int port = 8080;
        String contextPath = "/web";

        Server server = new Server(port);
        server.setStopAtShutdown(true);

        String proDir = new File(Main.class.getResource("").getPath()).getParentFile().getParent();
        System.out.println(proDir);
        String webappLocalDir = "/src/main/webapp";

        ProtectionDomain protectionDomain = Main.class.getProtectionDomain();
        URL location = protectionDomain.getCodeSource().getLocation();

        WebAppContext context = new WebAppContext(proDir + webappLocalDir, contextPath);
        context.setDefaultsDescriptor("./webdefault.xml");
        context.setServer(server);

        String curDir = new File(location.getPath()).getParent();
        File work = new File(curDir, "work");
        context.setTempDirectory(work);

        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(100);
        }
    }

}
