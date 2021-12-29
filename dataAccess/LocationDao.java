package taxi.dataAccess;

import org.hibernate.Session;
import org.hibernate.Transaction;
import taxi.models.Location;


public class LocationDao extends BaseDao {
    public void save(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(location);
        transaction.commit();
        session.close();
    }
}
