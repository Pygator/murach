package music.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import music.business.Download;

public class DownloadDB {
    
    public static void insert(Download download) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(download);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}