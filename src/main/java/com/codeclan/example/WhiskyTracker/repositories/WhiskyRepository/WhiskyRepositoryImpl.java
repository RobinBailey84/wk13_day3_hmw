package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.lang.invoke.MethodType;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Whisky> findWhiskyByAgeAndDistillery(int age, Long id) {
        List<Whisky> results = null;

        Criteria cr = null;
        try{
            Session session = entityManager.unwrap(Session.class);
            cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("age", age));
            cr.add(Restrictions.eq("distillery.id", id));
        } catch (HibernateException e){
            e.printStackTrace();
        }

        results = cr.list();

        return results;
    }

    @Override
    public List<Whisky> findWhiskyByRegion(String region) {
        List<Whisky> results = null;

        Criteria cr = null;
        try{
            Session session = entityManager.unwrap(Session.class);
            cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distillery");
            cr.add(Restrictions.eq("distillery.region", region));
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        results = cr.list();

        return results;
    }
}
