package module4.hibernate;

import jakarta.persistence.EntityManager;
import module4.hibernate.config.HibernateConfiguration;
import module4.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

// TODO add migration for database
public class Main {
    public static void main(String[] args) {
        nativeHibernate();
//         jpaHibernate();
    }

    private static void nativeHibernate() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        final Session session = sessionFactory.openSession();

        nativeHibernateCreate(session);
        nativeHibernateGet(session);
        nativeHibernateGetWithParam(session);

        session.close();
    }

    private static void nativeHibernateCreate(final Session session) {
        session.beginTransaction();

        final User user = new User();
        user.setName("Daniel");
        session.persist(user);

        final User user1 = new User();
        user1.setName("John");
        session.persist(user1);

        final User user2 = new User();
        user2.setName("Jane");
        user2.setEmail("jane@gmail.com");
        user2.setAge(30);
        session.persist(user2);

        session.getTransaction().commit();
    }


    private static void nativeHibernateGet(final Session session) {
        session.createQuery("from User", User.class)
                .stream()
                .forEach(g -> System.out.printf("[%s]: %s%n", g.getId(), g.getName()));
    }

    private static void nativeHibernateGetWithParam(final Session session) {
        final User user = session.createQuery("from User where name = :name", User.class)
                .setParameter("name", "Daniel")
                .getSingleResult();
        System.out.printf("[%s]: %s%n", user.getId(), user.getName());

        final User user2 = session.createQuery("from User as u where u.age > 20", User.class)
                .getSingleResult();
        System.out.printf("[%s]: %s%n", user2.getId(), user2.getName());

        final User user3 = session.createNamedQuery("getByEmail", User.class)
                .setParameter("email", "jane@gmail.com")
                .getSingleResult();
        System.out.printf("[%s]: %s%n", user3.getId(), user3.getName());
    }


    private static void jpaHibernate() {
        final EntityManager entityManager = HibernateConfiguration.getEntityManager();

        jpaHibernateCreate(entityManager);
        jpaHibernateGet(entityManager);
    }

    private static void jpaHibernateCreate(final EntityManager entityManager) {
        entityManager.getTransaction().begin();

        final User user = new User();
        user.setName("Daniel");
        entityManager.persist(user);

        final User user1 = new User();
        user1.setName("John");
        entityManager.persist(user1);

        final User user2 = new User();
        user2.setName("Jane");
        entityManager.persist(user2);

        entityManager.getTransaction().commit();
    }


    private static void jpaHibernateGet(final EntityManager entityManager) {
        entityManager.createQuery("from User", User.class)
                .getResultStream()
                .forEach(g -> System.out.printf("[%s]: %s%n", g.getId(), g.getName()));
    }
}
