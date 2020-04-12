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
import model.TTipoObjt;

/**
 *
 * @author terra
 */

public class TTipoObjtDao implements Serializable{
    public static TTipoObjtDao tTipoObjtDao;
    
    public static TTipoObjtDao getInstance(){
        if(tTipoObjtDao == null){
            tTipoObjtDao = new TTipoObjtDao();
        }
        return tTipoObjtDao;
    }
    
    public TTipoObjt buscar(int idTipoObjt){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT to FROM TTipoObjt to WHERE to.idTipoObjt = :idTipoObjt");
            query.setParameter("idTipoObjt", idTipoObjt);
            TTipoObjt tTipoObjt = (TTipoObjt) query.getSingleResult();
            if(tTipoObjt != null && tTipoObjt.getIdTipoObjt()> 0){
                return tTipoObjt;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public TTipoObjt buscar(TTipoObjt to){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT to FROM TTipoObjt to WHERE to.idTipoObjt = :idTipoObjt");
            query.setParameter("idTipoObjt", to.getIdTipoObjt());
            TTipoObjt tTipoObjt = (TTipoObjt) query.getSingleResult();
            if(tTipoObjt != null && tTipoObjt.getIdTipoObjt()> 0){
                return tTipoObjt;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public List<TTipoObjt> buscarTodas(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT to FROM TTipoObjt to");
            return query.getResultList();
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return new ArrayList<>();
        }
    }
    
    public String excluir(TTipoObjt tTipoObjt){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            tTipoObjt = em.merge(tTipoObjt);
            em.remove(tTipoObjt);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TTipoObjt removido com sucesso!");
            return "TTipoObjt " + tTipoObjt.getDsTipoObjt()+ " removido com sucesso!";
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return "Não foi possível remover o tTipoObjt " + tTipoObjt.getDsTipoObjt();
        }
    }
    
    public String persistir(TTipoObjt tTipoObjt){
        EntityManager em = PersistenceUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            tTipoObjt = em.merge(tTipoObjt);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TTipoObjt Salvo com sucesso!");
            return "TTipoObjt " + tTipoObjt.getDsTipoObjt()+ " salvo com sucesso!";
        }catch(Exception e){
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível salvar o tTipoObjt!", e);
            if(e.getMessage().contains("ConstraintViolationException")){
                return "Não foi possível salvar o tTipoObjt " + tTipoObjt.getDsTipoObjt();
            }
        }return "Não foi possível salvar o tTipoObjt " + tTipoObjt.getDsTipoObjt()+ "!";
    }
            
    public String removeAll(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM TTipoObjt");
            query.executeUpdate();
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "Todos os tTipoObjts foram deletados com sucesso!");
            return "Todos os tTipoObjts foram deletados!";
        }catch(Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível deletar todos os tTipoObjts");
            return "Não foi possível deletar todos os tTipoObjts!";
        }
    }
}
