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
import model.TSpdcVocbCntld;

/**
 *
 * @author terra
 */

public class TSpdcVocbCntldDao {
    public static TSpdcVocbCntldDao tSpdcVocbCntldDao;
    
    public static TSpdcVocbCntldDao getInstance(){
        if(tSpdcVocbCntldDao == null){
            tSpdcVocbCntldDao = new TSpdcVocbCntldDao();
        }
        return tSpdcVocbCntldDao;
    }
    
    public TSpdcVocbCntld buscar(int idVocbCntld){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT v FROM TSpdcVocbCntld v WHERE v.idVocbCntld = :idVocbCntld");
            query.setParameter("idVocbCntld", idVocbCntld);
            TSpdcVocbCntld tSpdcVocbCntld = (TSpdcVocbCntld) query.getSingleResult();
            if(tSpdcVocbCntld != null && tSpdcVocbCntld.getIdVocbCntld()> 0){
                return tSpdcVocbCntld;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public TSpdcVocbCntld buscar(TSpdcVocbCntld v){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT v FROM TSpdcVocbCntld v WHERE v.idVocbCntld = :idVocbCntld");
            query.setParameter("idVocbCntld", v.getIdVocbCntld());
            TSpdcVocbCntld tSpdcVocbCntld = (TSpdcVocbCntld) query.getSingleResult();
            if(tSpdcVocbCntld != null && tSpdcVocbCntld.getIdVocbCntld()> 0){
                return tSpdcVocbCntld;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public List<TSpdcVocbCntld> buscarTodas(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT v FROM TSpdcVocbCntld v");
            return query.getResultList();
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return new ArrayList<>();
        }
    }
    
    public String excluir(TSpdcVocbCntld tSpdcVocbCntld){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            tSpdcVocbCntld = em.merge(tSpdcVocbCntld);
            em.remove(tSpdcVocbCntld);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcVocbCntld removido com sucesso!");
            return "TSpdcVocbCntld " + tSpdcVocbCntld.getDsVocbCntld()+ " removido com sucesso!";
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return "Não foi possível remover o tSpdcVocbCntld " + tSpdcVocbCntld.getDsVocbCntld();
        }
    }
    
    public String persistir(TSpdcVocbCntld tSpdcVocbCntld){
        EntityManager em = PersistenceUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            tSpdcVocbCntld = em.merge(tSpdcVocbCntld);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcVocbCntld Salvo com sucesso!");
            return "TSpdcVocbCntld " + tSpdcVocbCntld.getDsVocbCntld()+ " salvo com sucesso!";
        }catch(Exception e){
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível salvar o tSpdcVocbCntld!", e);
            if(e.getMessage().contains("ConstraintViolationException")){
                return "Não foi possível salvar o tSpdcVocbCntld " + tSpdcVocbCntld.getDsVocbCntld()+ ", pois o tSpdcVocbCntld deve ser único ";
            }
        }return "Não foi possível salvar o tSpdcVocbCntld " + tSpdcVocbCntld.getDsVocbCntld()+ "!";
    }
            
    public String removeAll(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM TSpdcVocbCntld");
            query.executeUpdate();
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "Todos os tSpdcVocbCntlds foram deletados com sucesso!");
            return "Todos os tSpdcVocbCntlds foram deletados!";
        }catch(Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível deletar todos os tSpdcVocbCntlds");
            return "Não foi possível deletar todos os tSpdcVocbCntlds!";
        }
    }
}
