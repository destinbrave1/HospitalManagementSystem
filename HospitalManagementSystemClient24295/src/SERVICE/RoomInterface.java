/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.Rooms;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author destin
 */
public interface RoomInterface extends Remote{
    public String Registerroom(Rooms rooms) throws RemoteException;
    public String updateRooms(Rooms rooms) throws RemoteException;
    public String deleteRooms(Rooms rooms) throws RemoteException;
    public List<Rooms> allRooms()throws RemoteException;
    public Rooms getroomById(Rooms rooms) throws RemoteException;
}
