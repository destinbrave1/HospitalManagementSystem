/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import MODEL.Diagnosis;
/**
 *
 * @author destin
 */
public interface DiagnosisInterface extends Remote {
    
    public String Registerdiagnosis(Diagnosis diagnosis) throws RemoteException;
    public String updateDiagnosis(Diagnosis diagnosis) throws RemoteException;
    public String deleteDiagnosis(Diagnosis diagnosis) throws RemoteException;
    public List<Diagnosis> allDiagnosis()throws RemoteException;
    public Diagnosis getdiagnosisById(Diagnosis diagnosis) throws RemoteException;
}
