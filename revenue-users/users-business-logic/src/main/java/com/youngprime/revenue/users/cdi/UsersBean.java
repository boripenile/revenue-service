package com.youngprime.revenue.users.cdi;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import com.youngprime.revenue.users.Users;

@RequestScoped
public class UsersBean {

	private Logger log = LogManager.getLogger(UsersBean.class.getName());

    @PersistenceContext(unitName = "users-jpa")
    private EntityManager em;

    public List<Users> getUsers() {
    	log.info("Called getUsers");
        Query query = em.createNamedQuery(Users.USER_GETALL, Users.class);

        return query.getResultList();

    }

    public List<Users> getUsersFilter(UriInfo uriInfo) {

    	log.info("Called getUsersFilter");
        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();

        List<Users> users = JPAUtils.queryEntities(em, Users.class, queryParameters);

        return users;
    }

    public Users getUser(String userId) {

    	log.info("Called getUser");
        Users user = em.find(Users.class, userId);

        if (user == null) {
            throw new NotFoundException();
        }

        return user;
    }

    public Users createUser(Users user) {

    	log.info("Called createUser");
        try {
            beginTx();
            user.setCreatedAt(new Date());
            em.persist(user);
            commitTx();
        } catch (Exception e) {
            rollbackTx();
        }

        return user;
    }

    public Users putUser(String userId, Users user) {

    	log.info("Called putUser");
    	Users c = em.find(Users.class, userId);

        if (c == null) {
            return null;
        }

        try {
            beginTx();
            user.setId(c.getId());
            user = em.merge(user);
            commitTx();
        } catch (Exception e) {
            rollbackTx();
        }

        return user;
    }

    public boolean deleteUser(String userId) {

    	log.info("Called deleteUser");
    	Users user = em.find(Users.class, userId);

        if (user != null) {
            try {
                beginTx();
                em.remove(user);
                commitTx();
            } catch (Exception e) {
                rollbackTx();
            }
        } else
            return false;

        return true;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
    }

    private void commitTx() {
        if (em.getTransaction().isActive())
            em.getTransaction().commit();
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive())
            em.getTransaction().rollback();
    }
}
