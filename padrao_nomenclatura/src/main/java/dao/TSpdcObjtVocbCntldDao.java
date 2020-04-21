/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.TSpdcObjtVocbCntld;

/**
 *
 * @author terra
 */
public class TSpdcObjtVocbCntldDao {
    public static TSpdcObjtVocbCntldDao tSpdcObjtVocbCntldDao;
    
    public static TSpdcObjtVocbCntldDao getInstance(){
        if(tSpdcObjtVocbCntldDao == null){
            tSpdcObjtVocbCntldDao = new TSpdcObjtVocbCntldDao();
        }
        return tSpdcObjtVocbCntldDao;
    }
    
    public TSpdcObjtVocbCntld buscar(String idObjtVocb) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TSpdcObjtVocbCntld a where a.idObjtVocb =:idObjtVocb ");
        query.setParameter("idObjtVocb", idObjtVocb);

        List<TSpdcObjtVocbCntld> tSpdcObjt = query.getResultList();
        if (tSpdcObjt != null && tSpdcObjt.size() > 0) {
            return tSpdcObjt.get(0);
        }

        return null;
    }

    public List<TSpdcObjtVocbCntld> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from TSpdcObjtVocbCntld As a");
        return query.getResultList();
    }

    public List<TSpdcObjtVocbCntld> buscarTSpdcObjtVocbCntldInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from TSpdcObjtVocbCntld a group by a.idObjtVocb");
        return query.getResultList();
    }

        public List<TSpdcObjtVocbCntld> buscarTSpdcObjtVocbCntldTypeInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from TSpdcObjtVocbCntld a group by a.typeTSpdcObjtVocbCntld");
        return query.getResultList();
    }

        public void excluir(TSpdcObjtVocbCntld tSpdcObjtVocbCntld) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tSpdcObjtVocbCntld)) {
            tSpdcObjtVocbCntld = em.merge(tSpdcObjtVocbCntld);
        }
        em.remove(tSpdcObjtVocbCntld);
        em.getTransaction().commit();
    }

    public TSpdcObjtVocbCntld persistir(TSpdcObjtVocbCntld tSpdcObjt) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tSpdcObjt = em.merge(tSpdcObjt);
            em.getTransaction().commit();
            System.out.println("Registro TSpdcObjtVocbCntld gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSpdcObjt;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from TSpdcObjtVocbCntld ");
       query.executeUpdate();
       em.getTransaction().commit();
    }
    
}
