import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureClient {
    private static final String SERVER = "localhost";
    private static final int PORT = 8443;

    public static void main(String[] args) {
        try {
            // Carregar o KeyStore
            char[] password = "senha123".toCharArray(); // Senha do KeyStore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            FileInputStream keyStoreInput = new FileInputStream("server.keystore"); // Nome do seu KeyStore
            keyStore.load(keyStoreInput, password);
            keyStoreInput.close();

            // Criar SSLContext com o KeyStore
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            SSLSocketFactory factory = sslContext.getSocketFactory();
            SSLSocket socket = (SSLSocket) factory.createSocket(SERVER, PORT);
            System.out.println("Conectado ao servidor SSL em " + SERVER + ":" + PORT);

            // Receber mensagem do servidor
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Servidor: " + in.readLine()); // Mensagem de boas-vindas do servidor

                String userInput;
                while ((userInput = userIn.readLine()) != null) {
                    out.println(userInput); // Enviar mensagem para o servidor
                    System.out.println("Servidor: " + in.readLine()); // Receber resposta do servidor
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
