
package taxi.dataAccess;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Driver;
import java.util.List;

public class DriverDao extends BaseDao {


    public void save(Driver driver) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(driver);
        transaction.commit();
        session.close();
    }
    public void updateDriverLocation(Driver driver) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(driver);
        transaction.commit();
        session.close();
    }

    public Driver findDriverByNationalCode(String nationalCode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Driver d Where d.nationalCode = :nationalCode ");
        query.setParameter("nationalCode", nationalCode);
        Driver driver = (Driver) query.uniqueResult();
        transaction.commit();
        session.close();
        return driver;
    }


    public List<Driver> findAllDrivers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Driver ");
        List list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

}

