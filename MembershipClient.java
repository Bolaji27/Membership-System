import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MembershipClient implements Membership {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Membership membership = (Membership) registry.lookup("Membership");

            System.out.println("print your memberId");

            //enables the customers to input their member's details
            Scanner input = new Scanner(System.in);

            //for reading customer's input ID
            String memberId = input.next();

            System.out.println("input your siteId");
            //for reading customer's siteId
            String siteId = input.next();


          //calling the submitVisitorsReport from the Membership Interface
            String report = members.submitVisitorsReport(memberId,siteId);

            System.out.println("from Server" +" "+ report);


            // Call the remote methods here
            // e.g. stub.addMemberBenefits("123", new String[] {"discounts", "free shipping"});
           // membership.addMemberBenefits("214",{"bread");
        } catch (Exception e) {
            System.err.println("Membership client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void addMemberBenefits(String memberId, String[] benefits) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMemberBenefits'");
    }

    @Override
    public void updateMemberBenefits(String memberId, String[] benefits) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateMemberBenefits'");
    }

    @Override
    public void submitVisitorsReport(String memberId, String siteId, String report) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'submitVisitorsReport'");
    }
}

