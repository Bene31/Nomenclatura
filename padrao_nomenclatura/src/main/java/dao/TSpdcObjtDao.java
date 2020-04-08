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

public class TSpdcObjtDao implements Serializable{
    public static TSpdcObjtDao tSpdcObjtDao;
    
    public static TSpdcObjtDao getInstance(){
        if(tSpdcObjtDao == null){
            tSpdcObjtDao = new TSpdcObjtDao();
        }
        return tSpdcObjtDao;
    }
    
    public TSpdcObjt buscar(int idObjt){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT obj FROM TSpdcObjt obj WHERE obj.idObjt = :idObjt");
            query.setParameter("idObjt", idObjt);
            TSpdcObjt tSpdcObjt = (TSpdcObjt) query.getSingleResult();
            if(tSpdcObjt != null && tSpdcObjt.getIdObjt()> 0){
                return tSpdcObjt;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public TSpdcObjt buscar(TSpdcObjt obj){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT obj FROM TSpdcObjt obj WHERE obj.idObjt = :idObjt");
            query.setParameter("idObjt", obj.getIdObjt());
            TSpdcObjt tSpdcObjt = (TSpdcObjt) query.getSingleResult();
            if(tSpdcObjt != null && tSpdcObjt.getIdObjt()> 0){
                return tSpdcObjt;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public List<TSpdcObjt> buscarTodas(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT obj FROM TSpdcObjt obj");
            return query.getResultList();
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return new ArrayList<>();
        }
    }
    
    public String excluir(TSpdcObjt tSpdcObjt){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            tSpdcObjt = em.merge(tSpdcObjt);
            em.remove(tSpdcObjt);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcPrfx removido com sucesso!");
            return "TSpdcObjt " + tSpdcObjt.getNmObjt()+ " removido com sucesso!";
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return "Não foi possível remover o tSpdcObjt " + tSpdcObjt.getNmObjt();
        }
    }
    
    public String persistir(TSpdcObjt tSpdcObjt){
        EntityManager em = PersistenceUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            tSpdcObjt = em.merge(tSpdcObjt);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcObjt Salvo com sucesso!");
            return "TSpdcObjt " + tSpdcObjt.getNmObjt()+ " salvo com sucesso!";
        }catch(Exception e){
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível salvar o tSpdcPrfx!", e);
            if(e.getMessage().contains("ConstraintViolationException")){
                return "Não foi possível salvar o tSpdcPrfx " + tSpdcObjt.getNmObjt()+ ", pois o tSpdcObjt deve ser único ";
            }
        }return "Não foi possível salvar o tSpdcObjt " + tSpdcObjt.getNmObjt()+ "!";
    }
            
    public String removeAll(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM TSpdcObjt");
            query.executeUpdate();
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "Todos os tSpdcObjt foram deletados com sucesso!");
            return "Todos os tSpdcObjt foram deletados!";
        }catch(Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível deletar todos os tSpdcObjt");
            return "Não foi possível deletar todos os tSpdcObjt!";
        }
    }
}
