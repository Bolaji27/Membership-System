import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Membership extends Remote {
   public void addMemberBenefits(String memberId, String[] benefits) throws RemoteException;
   public void updateMemberBenefits(String memberId, String[] benefits) throws RemoteException;
   public void submitVisitorsReport(String memberId, String siteId, String report) throws RemoteException;

}
