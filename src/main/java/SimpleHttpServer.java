import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.PropertiesReader;

import javax.xml.soap.SAAJResult;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pgupta10 on 27/08/16.
 */
public class SimpleHttpServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleHttpServer.class);

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(PropertiesReader.getHttpPort());
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                LOGGER.debug(inputLine);
            }
        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }

    }
}
