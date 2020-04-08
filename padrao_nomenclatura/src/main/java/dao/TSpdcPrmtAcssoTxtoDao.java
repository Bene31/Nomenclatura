/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.PersistenceUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.TSpdcPrmtAcssoTxto;

/**
 *
 * @author terra
 */
public class TSpdcPrmtAcssoTxtoDao {
    public static TSpdcPrmtAcssoTxtoDao tSpdcPrmtAcssoTxtoDao;
    
    public static TSpdcPrmtAcssoTxtoDao getInstance(){
        if(tSpdcPrmtAcssoTxtoDao == null){
            tSpdcPrmtAcssoTxtoDao = new TSpdcPrmtAcssoTxtoDao();
        }
        return tSpdcPrmtAcssoTxtoDao;
    }
    
    public TSpdcPrmtAcssoTxto buscar(int idPrmtAcssoTxto){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT a FROM TSpdcPrmtAcssoTxto a WHERE a.idPrmtAcssoTxto = :idPrmtAcssoTxto");
            query.setParameter("idPrmtAcssoTxto", idPrmtAcssoTxto);
            TSpdcPrmtAcssoTxto tSpdcPrmtAcssoTxtoDao = (TSpdcPrmtAcssoTxto) query.getSingleResult();
            if(tSpdcPrmtAcssoTxtoDao != null && tSpdcPrmtAcssoTxtoDao.getIdPrmtAcssoTxto()> 0){
                return tSpdcPrmtAcssoTxtoDao;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public TSpdcPrmtAcssoTxto buscar(TSpdcPrmtAcssoTxto a){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT a FROM TSpdcPrmtAcssoTxto a WHERE a.idPrmtAcssoTxto = :idPrmtAcssoTxto");
            query.setParameter("idPrmtAcssoTxto", a.getIdPrmtAcssoTxto());
            TSpdcPrmtAcssoTxto tSpdcPrmtAcssoTxtoDao = (TSpdcPrmtAcssoTxto) query.getSingleResult();
            if(tSpdcPrmtAcssoTxtoDao != null && tSpdcPrmtAcssoTxtoDao.getIdPrmtAcssoTxto()> 0){
                return tSpdcPrmtAcssoTxtoDao;
            }else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "ERRO");
                return null;
            }
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return null;
        }
    }
    
    public List<TSpdcPrmtAcssoTxto> buscarTodas(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT a FROM TSpdcPrmtAcssoTxto a");
            return query.getResultList();
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return new ArrayList<>();
        }
    }
    
    public String excluir(TSpdcPrmtAcssoTxto tSpdcPrmtAcssoTxtoDao){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            tSpdcPrmtAcssoTxtoDao = em.merge(tSpdcPrmtAcssoTxtoDao);
            em.remove(tSpdcPrmtAcssoTxtoDao);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcPrmtAcssoTxto removido com sucesso!");
            return "TSpdcPrmtAcssoTxto " + tSpdcPrmtAcssoTxtoDao.getDsPrmtAcssoTxto()+ " removido com sucesso!";
        }catch (Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "ERRO");
            return "Não foi possível remover o tSpdcPrmtAcssoTxtoDao " + tSpdcPrmtAcssoTxtoDao.getDsPrmtAcssoTxto();
        }
    }
    
    public String persistir(TSpdcPrmtAcssoTxto tSpdcPrmtAcssoTxtoDao){
        EntityManager em = PersistenceUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            tSpdcPrmtAcssoTxtoDao = em.merge(tSpdcPrmtAcssoTxtoDao);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TSpdcPrmtAcssoTxto Salvo com sucesso!");
            return "TSpdcPrmtAcssoTxto " + tSpdcPrmtAcssoTxtoDao.getDsPrmtAcssoTxto()+ " salvo com sucesso!";
        }catch(Exception e){
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível salvar o tSpdcPrmtAcssoTxtoDao!", e);
            if(e.getMessage().contains("ConstraintViolationException")){
                return "Não foi possível salvar o tSpdcPrmtAcssoTxtoDao " + tSpdcPrmtAcssoTxtoDao.getDsPrmtAcssoTxto()+ ", pois o tSpdcPrmtAcssoTxtoDao deve ser único ";
            }
        }return "Não foi possível salvar o tSpdcPrmtAcssoTxtoDao " + tSpdcPrmtAcssoTxtoDao.getDsPrmtAcssoTxto()+ "!";
    }
            
    public String removeAll(){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM TSpdcPrmtAcssoTxto");
            query.executeUpdate();
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "Todos os tSpdcPrmtAcssoTxtoDaos foram deletados com sucesso!");
            return "Todos os tSpdcPrmtAcssoTxtoDaos foram deletados!";
        }catch(Exception e){
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível deletar todos os tSpdcPrmtAcssoTxtoDaos");
            return "Não foi possível deletar todos os tSpdcPrmtAcssoTxtoDaos!";
        }
    }
}
