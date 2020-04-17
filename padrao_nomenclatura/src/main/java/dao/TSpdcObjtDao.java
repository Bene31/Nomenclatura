/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.PersistenceUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.TSpdcObjt;

/**
 *
 * @author terra
 */

public class TSpdcObjtDao {
    public static TSpdcObjtDao tSpdcObjtDao;
    
    public static TSpdcObjtDao getInstance(){
        if(tSpdcObjtDao == null){
            tSpdcObjtDao = new TSpdcObjtDao();
        }
        return tSpdcObjtDao;
    }
    
    public TSpdcObjt buscar(String nmObjt) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TSpdcObjt a where a.nmObjt =:nmObjt ");
        query.setParameter("nmObjt", nmObjt);

        List<TSpdcObjt> tSpdcObjt = query.getResultList();
        if (tSpdcObjt != null && tSpdcObjt.size() > 0) {
            return tSpdcObjt.get(0);
        }

        return null;
    }

    public List<TSpdcObjt> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from TSpdcObjt As a");
        return query.getResultList();
    }

    public List<TSpdcObjt> buscarTSpdcObjteInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from TSpdcObjt a group by a.name");
        return query.getResultList();
    }

        public List<TSpdcObjt> buscarTSpdcObjteTypeInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from TSpdcObjt a group by a.typeTSpdcObjt");
        return query.getResultList();
    }

        public void excluir(TSpdcObjt tSpdcObjt) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tSpdcObjt)) {
            tSpdcObjt = em.merge(tSpdcObjt);
        }
        em.remove(tSpdcObjt);
        em.getTransaction().commit();
    }

    public TSpdcObjt persistir(TSpdcObjt tSpdcObjt) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tSpdcObjt = em.merge(tSpdcObjt);
            em.getTransaction().commit();
            System.out.println("Registro TSpdcObjt gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSpdcObjt;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from TSpdcObjt ");
       query.executeUpdate();
       em.getTransaction().commit();
    }
    
}
