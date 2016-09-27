package example.crawllinkstodb.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VisitedPageService {

	@PersistenceContext(unitName="crawlLinksToDBPU")
    private EntityManager em;

    public List<VisitedPage> list() {
        return em.createQuery("FROM VisitedPage", VisitedPage.class).getResultList();
    }

    public VisitedPage find(Integer id) {
        return em.find(VisitedPage.class, id);
    }

    public Integer save(VisitedPage page) {
        em.persist(page);
        return page.getId();
    }

    public void update(VisitedPage page) {
        em.merge(page);
    }

    public void delete(VisitedPage page) {
        em.remove(em.contains(page) ? page : em.merge(page));
    }

}
