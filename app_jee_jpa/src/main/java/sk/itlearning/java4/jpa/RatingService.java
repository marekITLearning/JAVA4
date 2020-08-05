package sk.itlearning.java4.jpa;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateful
public class RatingService {

	@PersistenceContext(unitName = "APP_DB")
	private EntityManager em;

	public Rating find(String id) {
		return em.find(Rating.class, id);
	}
	
	public void create(Rating entity) {
		em.persist(entity);
		em.flush();
	}

	public List<Rating> getAll() {
		em.getEntityManagerFactory().getCache().evictAll();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Rating> q = cb.createQuery(Rating.class);
		Root<Rating> root = q.from(Rating.class);
		q.select(root);
		return em.createQuery(q).getResultList();
	}
	
	public void update(Rating customer) {
		if (!em.contains((Rating) customer)) {
			em.merge((Rating) customer);
		}
	}

	public void delete(String id) {
		Rating customer = find(id);
		if (!em.contains((Rating) customer)) {
			customer = em.merge((Rating) customer);
		}
		em.remove((Rating) customer);
		em.flush();
	}

//	public List<Long> getOrsrAllIds() {
//		em.clear();
//		Query query = em.createQuery("SELECT c.id FROM Orsr c");
//		query.setHint(QueryHints.CACHE_USAGE, CacheUsage.NoCache);
//		return query.getResultList();
//	}
	
//	public List<Rating> read(String nameSubstring) {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Rating> q = cb.createQuery(Rating.class);
//		Root<Rating> root = q.from(Rating.class);
//		List<Predicate> conditions = new ArrayList<>();
//		if (nameSubstring != null && !nameSubstring.isEmpty()) {
//			conditions.add(cb.or(cb.like(root.get("firstName"), "%" + nameSubstring + "%"),
//					cb.like(root.get("lastName"), "%" + nameSubstring + "%")));
//		}
//		if (nameSubstring != null && !nameSubstring.isEmpty()) {
//			conditions.add(cb.or(cb.like(cb.upper(root.get("firstName")), "%" + nameSubstring.toUpperCase() + "%"),
//					cb.like(cb.upper(root.get("lastName")), "%" + nameSubstring.toUpperCase() + "%")));
//		}
//		q.select(root).where(conditions.toArray(new Predicate[] {}));
//		q.orderBy(cb.asc(root.get("firstName")));
//		List<Rating> result = em.createQuery(q).getResultList();
//		return result;
//	}
	
//	public List<Orsr> getOrsrByExid(Integer exid) {
//		Query query = em.createQuery("SELECT c FROM Orsr c WHERE c.exid = :exid");
//		query.setParameter("exid", exid);
//		return query.getResultList();
//	}

//	public Orsr getZeroExidRecord() {
//		Query query = em.createQuery("SELECT c FROM Orsr c WHERE c.exid = 0");
//		Orsr zeroRecord = null;
//		try {
//			zeroRecord = (Orsr) query.getSingleResult();
//		} catch (NoResultException e) {
//			zeroRecord = new Orsr();
//			zeroRecord.setExid(0);
//			zeroRecord.setEstablished(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
//			zeroRecord.setUpdated(Date.from(LocalDate.parse("2020-06-19").atStartOfDay().toInstant(ZoneOffset.UTC)));
//			em.persist(zeroRecord);
//			em.flush();
//		}
//		em.refresh(zeroRecord);
//		return zeroRecord;
//	}
	
}
