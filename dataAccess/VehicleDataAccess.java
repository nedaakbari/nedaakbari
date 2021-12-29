
package taxi.dataAccess;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import taxi.models.Vehicle;

import java.sql.SQLException;

public class VehicleDataAccess extends BaseDao {

    public void save(Vehicle vehicle) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(vehicle);
        transaction.commit();
        session.close();
    }

    public  Vehicle getVehicleById(int id)   {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Vehicle v Where v.id = :id ");
        query.setParameter("id", id);
        Vehicle vehicle = (Vehicle) query.uniqueResult();
        transaction.commit();
        session.close();
        return vehicle;
    }

    public Vehicle findVehicleIdByPlaque(String plaque) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Vehicle v Where v.plaque = :plaque ");
        query.setParameter("plaque", plaque);
        Vehicle vehicle = (Vehicle) query.uniqueResult();
        transaction.commit();
        session.close();
        return vehicle;
    }


}

