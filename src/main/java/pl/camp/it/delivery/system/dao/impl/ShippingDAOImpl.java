package pl.camp.it.delivery.system.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.delivery.system.dao.IShippingDAO;
import pl.camp.it.delivery.system.model.Shipping;

import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class ShippingDAOImpl implements IShippingDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void persist(Shipping shipping) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(shipping);
            tx.commit();
        } catch(Exception e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Shipping> getShippingByNumber(int number) {
        Session session = this.sessionFactory.openSession();
        Query<Shipping> query = session.createQuery("FROM pl.camp.it.delivery.system.model.Shipping WHERE shippingNumber = :shippingNumber");
        query.setParameter("shippingNumber", number);
        try {
            Shipping shipping = query.getSingleResult();
            session.close();
            return Optional.of(shipping);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }
    }
}
