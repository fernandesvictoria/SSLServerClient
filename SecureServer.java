import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureServer {
    private static final int PORT = 8443;

    public static void main(String[] args) {
        try {
            char[] password = "senha123".toCharArray(); // Senha do keystore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            FileInputStream keyStoreInput = new FileInputStream("server.keystore"); // Nome do seu keystore
            keyStore.load(keyStoreInput, password);
            keyStoreInput.close();

            SSLContext sslContext = SSLContext.getInstance("TLS");
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, password);
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            SSLServerSocketFactory factory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);
            System.out.println("Servidor SSL iniciado na porta " + PORT);

            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                System.out.println("Conexão aceita de " + socket.getInetAddress());
                handleClient(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(SSLSocket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println("Conexão segura estabelecida com o servidor SSL.");

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Recebido do cliente: " + message);
                out.println("Mensagem recebida: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
