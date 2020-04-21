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
import model.TSpdcPrpdVocbCntld;

/**
 *
 * @author terra
 */
public class TSpdcPrpdVocbCntldDao {
    public static TSpdcPrpdVocbCntldDao tSpdcPrpdVocbCntldDao;
    
    public static TSpdcPrpdVocbCntldDao getInstance(){
        if(tSpdcPrpdVocbCntldDao == null){
            tSpdcPrpdVocbCntldDao = new TSpdcPrpdVocbCntldDao();
        }
        return tSpdcPrpdVocbCntldDao;
    }
    
    public TSpdcPrpdVocbCntld buscar(String idPrpdobjtVocb) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TSpdcPrpdVocbCntld a where a.idPrpdobjtVocb =:idPrpdobjtVocb ");
        query.setParameter("idPrpdobjtVocb", idPrpdobjtVocb);

        List<TSpdcPrpdVocbCntld> tSpdcObjt = query.getResultList();
        if (tSpdcObjt != null && tSpdcObjt.size() > 0) {
            return tSpdcObjt.get(0);
        }

        return null;
    }

    public List<TSpdcPrpdVocbCntld> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from TSpdcPrpdVocbCntld As a");
        return query.getResultList();
    }

    public List<TSpdcPrpdVocbCntld> buscarTSpdcPrpdVocbCntldInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from TSpdcPrpdVocbCntld a group by a.idPrpdobjtVocb");
        return query.getResultList();
    }

        public List<TSpdcPrpdVocbCntld> buscarTSpdcPrpdVocbCntldTypeInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from TSpdcPrpdVocbCntld a group by a.typeTSpdcPrpdVocbCntld");
        return query.getResultList();
    }

        public void excluir(TSpdcPrpdVocbCntld tSpdcPrpdVocbCntld) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tSpdcPrpdVocbCntld)) {
            tSpdcPrpdVocbCntld = em.merge(tSpdcPrpdVocbCntld);
        }
        em.remove(tSpdcPrpdVocbCntld);
        em.getTransaction().commit();
    }

    public TSpdcPrpdVocbCntld persistir(TSpdcPrpdVocbCntld tSpdcObjt) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tSpdcObjt = em.merge(tSpdcObjt);
            em.getTransaction().commit();
            System.out.println("Registro TSpdcPrpdVocbCntld gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSpdcObjt;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from TSpdcPrpdVocbCntld ");
       query.executeUpdate();
       em.getTransaction().commit();
    }
}
