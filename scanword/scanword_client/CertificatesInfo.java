package scanword_client;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.IOException;
import java.security.cert.Certificate;

public class CertificatesInfo {
    public void printCertificatesInfo(HttpsURLConnection connection) {
        if(connection != null){
            try {

                System.out.println("Response Code : " + connection.getResponseCode());
                System.out.println("Cipher Suite : " + connection.getCipherSuite());
                System.out.println("\n");

                Certificate[] certs = connection.getServerCertificates();
                for(Certificate cert : certs){
                    System.out.println("Cert Type : " + cert.getType());
                    System.out.println("Cert Hash Code : " + cert.hashCode());
                    System.out.println("Cert Public Key Algorithm : "
                            + cert.getPublicKey().getAlgorithm());
                    System.out.println("Cert Public Key Format : "
                            + cert.getPublicKey().getFormat());
                    System.out.println("\n");
                }

            } catch (SSLPeerUnverifiedException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
