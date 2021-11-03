/* Comment creer un Client Web Services à l'aide de WSDL */

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

/* Proxy coté client on l'appelle un STUB*/
/* Proxy coté SERVEUR on l'appelle un SKELETON JAX-WS*/
public class ClientWS {
    public static void main(String[] args) {
        BanqueService stubWS = new BanqueWS().getBanqueServicePort();
        System.out.println(stubWS.conversionEuroToDH(11));
        Compte cp = stubWS.getCompte(2L);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
        List<Compte> cptes = stubWS.listComptes();
        cptes.forEach(c-> {
            System.out.println("----------------");
            System.out.println(c.getCode());
            System.out.println(c.getSolde());
        });
    }
}
