package module4.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import module4.hibernate.config.HibernateConfiguration;
import module4.hibernate.model.User;
import module4.hibernate.model.UserDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.UUID;

// TODO add migration for database
public class Main {
    public static void main(String[] args) {
//        nativeHibernate();
//         jpaHibernate();
//        mergeExample();
//        receiveExample();
        deleteExample();
//        getPartInfoFromEntity();
    }

    private static void getPartInfoFromEntity() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        createUser(sessionFactory);
        createUser(sessionFactory);

        final Session session = sessionFactory.openSession();
        session.createQuery("SELECT u.id, u.email FROM User u", Object[].class)
                .stream()
                .forEach(g -> {
                    UUID key = (UUID) g[0];
                    String email = (String) g[1];
                    System.out.printf("key: %s, email: %s%n", key, email);
                });

        session.createQuery("SELECT u.email as email, u.id as id FROM User u", Tuple.class)
                .stream()
                .forEach(g -> {
                    UUID key = g.get("id", UUID.class);
                    String email =  g.get("email", String.class);
                    final UserDto userDto = new UserDto(key, email);
                    System.out.printf("key: %s, email: %s%n", key, email);
                });

        final UserDto userDto = new UserDto(UUID.randomUUID(), "");
        session.createQuery("SELECT new UserDto(u.id, u.email) FROM User u", UserDto.class)
                .stream()
                .forEach(g -> System.out.printf("key: %s, email: %s%n", g.getId(), g.getEmail()));
        session.close();
    }

    private static void deleteExample() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

        final User user1 = createUser(sessionFactory);
        final Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        final User getUser = session1.get(User.class, user1.getId());
        session1.remove(getUser);
        session1.getTransaction().commit();
        session1.close();

        final User user2 = createUser(sessionFactory);
        final Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        session2.createMutationQuery("delete from User where id = :id")
                .setParameter("id", user2.getId())
                .executeUpdate();
        session2.getTransaction().commit();
        session2.close();
    }

    private static User createUser(final SessionFactory sessionFactory) {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setName("Ivan");
        user.setEmail("ivan" + Math.random() + "@example.com");
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    private static void receiveExample() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setName("Ivan");
        user.setEmail("ivan1@example.com");
        session.persist(user);
        User user2 = new User();
        user2.setName("Ivan");
        user2.setEmail("ivan2@example.com");
        session.persist(user2);
        User user3 = new User();
        user3.setName("Ivan");
        user3.setEmail("ivan3@example.com");
        session.persist(user3);
        session.getTransaction().commit();
        session.close();

        final Session session2 = sessionFactory.openSession();

        final User getUser = session2.get(User.class, user.getId());
        final User getUserError = session2.get(User.class, UUID.randomUUID());

        final User referenceUser = session2.getReference(User.class, user2.getId());
        final User referenceUserError = session2.getReference(User.class, UUID.randomUUID());

        final User findUser = session2.find(User.class, user3.getId());
        final User findUserError = session2.find(User.class, UUID.randomUUID());

        // SELECT * FROM users WHERE id = ?
        // SELECT * FROM users WHERE id in [...]

        session2.close();

        System.out.println("Result of GET method");
        System.out.println(getUser.getClass());
        System.out.println(getUser);
        System.out.println(getUserError);

        System.out.println("Result of GET REFERENCE method");
        System.out.println(referenceUser.getClass());
        System.out.println(referenceUser.getId());
//        System.out.println(referenceUser.getEmail());  // no session
        final Session session3 = sessionFactory.openSession();
        session3.refresh(referenceUser);
        System.out.println(referenceUser.getEmail());
        System.out.println(referenceUser);
        try {
            System.out.println(referenceUserError);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Result of FIND method");
        System.out.println(findUser.getClass());
        System.out.println(findUser.getId());
        System.out.println(findUser);
        System.out.println(findUserError);

    }

    private static void mergeExample() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        final Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        User user = new User();
        user.setName("Ivan");
        user.setEmail("ivan@example.com");
        session1.persist(user);
        UUID userId = user.getId();
        session1.getTransaction().commit();
        session1.close();

        final Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        User detachedUser = new User();
        detachedUser.setId(userId);
        detachedUser.setName("Ivan Updated");
        User mergedUser = session2.merge(detachedUser);
        System.out.println("detachedUser == mergedUser: " + (detachedUser == mergedUser)); // false
        System.out.println("detachedUser hash: " + System.identityHashCode(detachedUser));
        System.out.println("mergedUser   hash: " + System.identityHashCode(mergedUser));
        session2.getTransaction().commit();
        session2.close();
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
        System.out.println("Before persist id: " + user.getId());
        session.persist(user);
        System.out.println("After persist id: " + user.getId());
        user.setEmail("Daniel@gmail.com");
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
