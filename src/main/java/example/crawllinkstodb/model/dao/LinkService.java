package example.crawllinkstodb.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LinkService {

	@PersistenceContext(unitName="crawlLinksToDBPU")
    private EntityManager em;

    public List<Link> list() {
        return em.createQuery("FROM Link", Link.class).getResultList();
    }

    public Link find(Integer id) {
        return em.find(Link.class, id);
    }

    public Integer save(Link link) {
        em.persist(link);
        return link.getId();
    }

    public void update(Link link) {
        em.merge(link);
    }

    public void delete(Link link) {
        em.remove(em.contains(link) ? link : em.merge(link));
    }

}
