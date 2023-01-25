package com.spring.mvc.admission_committee.dao;

import com.spring.mvc.admission_committee.entity.Applicant;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ApplicantDaoImplementation implements ApplicantDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Applicant> getAllApplicants() {
        Session session = entityManager.unwrap(Session.class);
        Query<Applicant> applicantQuery = session.createQuery("from Applicant order by points desc",
                Applicant.class);
        return applicantQuery.getResultList();
    }

    @Override
    public void saveApplicant(Applicant applicant) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(applicant);
    }

    @Override
    public Applicant getApplicant(Integer applicantId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Applicant.class, applicantId);
    }

    @Override
    public void deleteApplicant(Integer applicantId) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("delete from Applicant where applicantId=:applicantId")
                .setParameter("applicantId", applicantId)
                .executeUpdate();
    }

    @Override
    public List<Applicant> createListOfApplicants() {
        Session session = entityManager.unwrap(Session.class);
        Long sumOfQuota = (Long) session.createQuery("select sum(quota) from Specialty").getSingleResult();
        return session.createQuery("from Applicant order by points desc", Applicant.class)
                .setMaxResults(Math.toIntExact(sumOfQuota))
                .getResultList();
    }
}
