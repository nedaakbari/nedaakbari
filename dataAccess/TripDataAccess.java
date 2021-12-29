package taxi.dataAccess;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import taxi.models.Driver;
import taxi.models.Trip;

import java.util.List;

public class TripDataAccess extends BaseDao {

    public void save(Trip trip) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(trip);
        transaction.commit();
        session.close();
    }
    public void update(Trip trip) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(trip);
        transaction.commit();
        session.close();
    }



    public Trip findTripByDrive(Driver driver) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Trip> query = session.createQuery("FROM Trip t WHERE t.driver=:driver AND t.tripStatus='PROCESSING'");
        query.setParameter("driver", driver);
        List<Trip> resultList = query.getResultList();
        Trip trip = resultList.get(0);
        transaction.commit();
        session.close();
        return trip;
    }



}
