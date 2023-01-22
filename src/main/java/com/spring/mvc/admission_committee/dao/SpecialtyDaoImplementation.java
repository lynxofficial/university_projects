package com.spring.mvc.admission_committee.dao;

import com.spring.mvc.admission_committee.entity.Applicant;
import com.spring.mvc.admission_committee.entity.Specialty;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SpecialtyDaoImplementation implements SpecialtyDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Specialty> getAllSpecialties() {
        Session session = entityManager.unwrap(Session.class);
        Query<Specialty> specialtyQuery = session.createQuery("from Specialty", Specialty.class);
        return specialtyQuery.getResultList();
    }

    @Override
    public void saveSpecialty(Specialty specialty) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(specialty);
    }

    @Override
    public Specialty getSpecialty(Integer specialtyId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Specialty.class, specialtyId);
    }

    @Override
    public void deleteSpecialty(Integer specialtyId) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("delete from Specialty where specialtyId=:specialtyId")
                .setParameter("specialtyId", specialtyId)
                .executeUpdate();
    }

    @Override
    public void addSpecialtiesToApplicant(List<Specialty> specialties, Applicant applicant) {
        Session session = entityManager.unwrap(Session.class);
        for (Specialty specialty : specialties) {
            applicant.addSpecialty(specialty);
        }
        session.saveOrUpdate(applicant);
    }
}