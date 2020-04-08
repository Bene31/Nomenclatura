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
    
    public TSpdcPrpdObjt buscar(int idPrpdObjt){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT po FROM TSpdcPrpdObjt po WHERE po.idPrpdObjt = :idPrpdObjt");
            query.setParameter("idPrpdObjt", idPrpdObjt);
            TSpdcPrpdObjt tSpdcPrpdObjt = (TSpdcPrpdObjt) query.getSingleResult();
            if(tSpdcPrpdObjt != null && tSpdcPrpdObjt.getIdPrpdObjt()> 0){
                return tSpdcPrpdObjt;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public TSpdcPrpdObjt buscar(TSpdcPrpdObjt po){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT po FROM TSpdcPrpdObjt po WHERE po.idPrpdObjt = :idPrpdObjt");
            query.setParameter("idPrpdObjt", po.getIdPrpdObjt());
            TSpdcPrpdObjt tSpdcPrpdObjt = (TSpdcPrpdObjt) query.getSingleResult();
            if(tSpdcPrpdObjt != null && tSpdcPrpdObjt.getIdPrpdObjt()> 0){
                return tSpdcPrpdObjt;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public List<TSpdcPrpdObjt> buscarTodas(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT po FROM TSpdcPrpdObjt po");
            return query.getResultList();
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return new ArrayList<>();
        }
    }
    
    public String excluir(TSpdcPrpdObjt tSpdcPrpdObjt){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            tSpdcPrpdObjt = em.merge(tSpdcPrpdObjt);
            em.remove(tSpdcPrpdObjt);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcPrpdObjt removido com sucesso!");
            return "TSpdcPrpdObjt " + tSpdcPrpdObjt.getNmPrpdObjt()+ " removido com sucesso!";
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return "Não foi possível remover o tSpdcPrpdObjt " + tSpdcPrpdObjt.getNmPrpdObjt();
        }
    }
    
    public String persistir(TSpdcPrpdObjt tSpdcPrpdObjt){
        EntityManager em = PersistenceUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            tSpdcPrpdObjt = em.merge(tSpdcPrpdObjt);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcPrpdObjt Salvo com sucesso!");
            return "TSpdcPrpdObjt " + tSpdcPrpdObjt.getNmPrpdObjt()+ " salvo com sucesso!";
        }catch(Exception e){
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível salvar o tSpdcPrpdObjt!", e);
            if(e.getMessage().contains("ConstraintViolationException")){
                return "Não foi possível salvar o tSpdcPrpdObjt " + tSpdcPrpdObjt.getNmPrpdObjt()+ ", pois o tSpdcPrpdObjt deve ser único ";
            }
        }return "Não foi possível salvar o tSpdcPrpdObjt " + tSpdcPrpdObjt.getNmPrpdObjt()+ "!";
    }
            
    public String removeAll(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM TSpdcPrpdObjt");
            query.executeUpdate();
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "Todos os tSpdcPrpdObjts foram deletados com sucesso!");
            return "Todos os tSpdcPrpdObjts foram deletados!";
        }catch(Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível deletar todos os tSpdcPrpdObjts");
            return "Não foi possível deletar todos os tSpdcPrpdObjts!";
        }
    }
}
