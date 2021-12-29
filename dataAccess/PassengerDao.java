package taxi.dataAccess;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import taxi.models.Passenger;

import java.sql.SQLException;
import java.util.List;

public class PassengerDao extends BaseDao {

    public void save(Passenger passenger)  {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(passenger);
        transaction.commit();
        session.close();
    }


    public Passenger findPassengerByUsername(String userName)  {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Passenger p Where p.userName = :userName ");
        query.setParameter("userName", userName);
        Passenger passenger = (Passenger) query.uniqueResult();
        transaction.commit();
        session.close();
        return passenger;
    }

    public void updatePassengerBalance(Passenger passenger) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(passenger);
        transaction.commit();
        session.close();
    }


    public List<Passenger> findAllPassenger() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Passenger");
        List list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

}