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
import model.TSpdcPrfx;

/**
 *
 * @author terra
 */

public class TSpdcPrfxDao implements Serializable{
    public static TSpdcPrfxDao tSpdcPrfxDao;
    
    public static TSpdcPrfxDao getInstance(){
        if(tSpdcPrfxDao == null){
            tSpdcPrfxDao = new TSpdcPrfxDao();
        }
        return tSpdcPrfxDao;
    }
    
    public TSpdcPrfx buscar(int idPrfx){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT prfx FROM TSpdcPrfx prfx WHERE prfx.idPrfx = :idPrfx");
            query.setParameter("idPrfx", idPrfx);
            TSpdcPrfx tSpdcPrfx = (TSpdcPrfx) query.getSingleResult();
            if(tSpdcPrfx != null && tSpdcPrfx.getIdPrfx()> 0){
                return tSpdcPrfx;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public TSpdcPrfx buscar(TSpdcPrfx prfx){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT prfx FROM TSpdcPrfx prfx WHERE prfx.idPrfx = :idPrfx");
            query.setParameter("idPrfx", prfx.getIdPrfx());
            TSpdcPrfx tSpdcPrfx = (TSpdcPrfx) query.getSingleResult();
            if(tSpdcPrfx != null && tSpdcPrfx.getIdPrfx()> 0){
                return tSpdcPrfx;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public List<TSpdcPrfx> buscarTodas(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT prfx FROM TSpdcPrfx prfx");
            return query.getResultList();
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return new ArrayList<>();
        }
    }
    
    public String excluir(TSpdcPrfx tSpdcPrfx){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            tSpdcPrfx = em.merge(tSpdcPrfx);
            em.remove(tSpdcPrfx);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcPrfx removido com sucesso!");
            return "TSpdcPrfx " + tSpdcPrfx.getSgPrfx()+ " removido com sucesso!";
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return "Não foi possível remover o tSpdcPrfx " + tSpdcPrfx.getSgPrfx();
        }
    }
    
    public String persistir(TSpdcPrfx tSpdcPrfx){
        EntityManager em = PersistenceUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            tSpdcPrfx = em.merge(tSpdcPrfx);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcPrfx Salvo com sucesso!");
            return "TSpdcPrfx " + tSpdcPrfx.getSgPrfx()+ " salvo com sucesso!";
        }catch(Exception e){
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível salvar o tSpdcPrfx!", e);
            if(e.getMessage().contains("ConstraintViolationException")){
                return "Não foi possível salvar o tSpdcPrfx " + tSpdcPrfx.getSgPrfx()+ ", pois o tSpdcPrfx deve ser único ";
            }
        }return "Não foi possível salvar o tSpdcPrfx " + tSpdcPrfx.getSgPrfx()+ "!";
    }
            
    public String removeAll(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM TSpdcPrfx");
            query.executeUpdate();
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "Todos os tSpdcPrfxs foram deletados com sucesso!");
            return "Todos os tSpdcPrfxs foram deletados!";
        }catch(Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível deletar todos os tSpdcPrfxs");
            return "Não foi possível deletar todos os tSpdcPrfxs!";
        }
    }
}
