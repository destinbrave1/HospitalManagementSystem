/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;
import DAO.DaoDiagnosis;
import MODEL.Diagnosis;
import SERVICE.DiagnosisInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
/**
 *
 * @author destin
 */
public class DiagnosisImpl extends UnicastRemoteObject implements DiagnosisInterface{
    
    public DiagnosisImpl() throws RemoteException
    {
        super();
    }
    DaoDiagnosis dao = new DaoDiagnosis();
    @Override
    public String Registerdiagnosis(Diagnosis diagnosis) throws RemoteException {
        return dao.registerDiagnosis(diagnosis);
    }

    @Override
    public String updateDiagnosis(Diagnosis diagnosis) throws RemoteException {
        return dao.updateDiagnosis(diagnosis);
    }

    @Override
    public String deleteDiagnosis(Diagnosis diagnosis) throws RemoteException {
        return dao.deleteDiagnosis(diagnosis);
    }

    @Override
    public List<Diagnosis> allDiagnosis() throws RemoteException {
         return dao.allDiagnosis();
    }

    @Override
    public Diagnosis getdiagnosisById(Diagnosis diagnosis) throws RemoteException {
        return dao.searchDiagnosis(diagnosis);
    }
    
}
