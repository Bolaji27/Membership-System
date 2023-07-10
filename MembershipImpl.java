import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class MembershipImpl extends UnicastRemoteObject implements Membership {
    private Map<String, String[]> memberBenefits = new HashMap<String, String[]>();
    private Map<String, Integer> memberReports = new HashMap<String, Integer>();

    public MembershipImpl() throws RemoteException { super();}


    @Override
    public void addMemberBenefits(String memberId, String[] benefits) throws RemoteException {
        memberBenefits.put(memberId, benefits);
    }

    @Override
    public void updateMemberBenefits(String memberId, String[] benefits) throws RemoteException {
        if(memberBenefits.containsKey(memberId)){
            String[] existingBenefits = memberBenefits.get(memberId);
            String[] updatedBenefits = new String[existingBenefits.length + benefits.length];
            System.arraycopy(existingBenefits,0, updatedBenefits, 0, existingBenefits.length);
            System.arraycopy(benefits, 0 , updatedBenefits, existingBenefits.length, benefits.length);
            memberBenefits.put(memberId, updatedBenefits);

        }

    }

    public void submitVisitorsReport(String memberId, String siteId, String report) throws RemoteException{
        int reports = 1;
        if(memberReports.containsKey(memberId)) {
            reports = memberReports.get(memberId) + 1;

            if (reports == 5){
                MessageQueue.publish("Free Entry for" + memberId);
                memberReports.put(memberId,0);
            }
        }
    }


}
