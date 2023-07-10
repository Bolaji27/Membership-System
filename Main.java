
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {



                try {
                    Membership membership = new MembershipImpl();


                    Registry registry = LocateRegistry.createRegistry(1099);
                    registry.bind("Membership", membership);

                    System.out.println("Membership server is running...");
                } catch (Exception e) {
                    System.err.println("Membership server exception: " + e.toString());
                    e.printStackTrace();
                }
            }
        }

