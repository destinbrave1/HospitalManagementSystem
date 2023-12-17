/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;
import DAO.DaoRoom;
import MODEL.Rooms;
import SERVICE.RoomInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
/**
 *
 * @author destin
 */
public class RoomImpl extends UnicastRemoteObject implements RoomInterface {
    public RoomImpl() throws RemoteException{
        super();
    }
    DaoRoom dao = new DaoRoom();
    @Override
    public String Registerroom(Rooms rooms) throws RemoteException {
        return dao.registerRooms(rooms);
    }

    @Override
    public String updateRooms(Rooms rooms) throws RemoteException {
       return dao.updateRooms(rooms);
    }

    @Override
    public String deleteRooms(Rooms rooms) throws RemoteException {
       return dao.deleteRooms(rooms);
    }

    @Override
    public List<Rooms> allRooms() throws RemoteException {
       return dao.allRooms();
    }

    @Override
    public Rooms getroomById(Rooms rooms) throws RemoteException {
        return dao.searchRooms(rooms);
    }
    
}
