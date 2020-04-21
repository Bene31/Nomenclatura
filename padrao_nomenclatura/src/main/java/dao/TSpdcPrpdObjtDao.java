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
import model.TSpdcPrpdObjt;

/**
 *
 * @author terra
 */

public class TSpdcPrpdObjtDao {
    public static TSpdcPrpdObjtDao tSpdcPrpdObjtDao;
    
    public static TSpdcPrpdObjtDao getInstance(){
        if(tSpdcPrpdObjtDao == null){
            tSpdcPrpdObjtDao = new TSpdcPrpdObjtDao();
        }
        return tSpdcPrpdObjtDao;
    }
    
    public TSpdcPrpdObjt buscar(String nmPrpdObjt) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TSpdcPrpdObjt a where a.nmPrpdObjt =:nmPrpdObjt ");
        query.setParameter("nmPrpdObjt", nmPrpdObjt);

        List<TSpdcPrpdObjt> tSpdcPrpdObjt = query.getResultList();
        if (tSpdcPrpdObjt != null && tSpdcPrpdObjt.size() > 0) {
            return tSpdcPrpdObjt.get(0);
        }

        return null;
    }

    public List<TSpdcPrpdObjt> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from TSpdcPrpdObjt As a");
        return query.getResultList();
    }

    public List<TSpdcPrpdObjt> buscarTSpdcPrpdObjteInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from TSpdcPrpdObjt a group by a.nmPrpdObjt");
        return query.getResultList();
    }

        public List<TSpdcPrpdObjt> buscarTSpdcPrpdObjteTypeInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from TSpdcPrpdObjt a group by a.typeTSpdcPrpdObjt");
        return query.getResultList();
    }

        public void excluir(TSpdcPrpdObjt tSpdcPrpdObjt) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tSpdcPrpdObjt)) {
            tSpdcPrpdObjt = em.merge(tSpdcPrpdObjt);
        }
        em.remove(tSpdcPrpdObjt);
        em.getTransaction().commit();
    }

    public TSpdcPrpdObjt persistir(TSpdcPrpdObjt tSpdcPrpdObjt) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tSpdcPrpdObjt = em.merge(tSpdcPrpdObjt);
            em.getTransaction().commit();
            System.out.println("Registro TSpdcPrpdObjt gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSpdcPrpdObjt;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from TSpdcPrpdObjt ");
       query.executeUpdate();
       em.getTransaction().commit();
    }
    
}
