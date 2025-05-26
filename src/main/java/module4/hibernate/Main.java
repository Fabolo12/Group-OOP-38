package module4.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import module4.hibernate.config.HibernateConfiguration;
import module4.hibernate.model.City;
import module4.hibernate.model.Note;
import module4.hibernate.model.Passport;
import module4.hibernate.model.Subject;
import module4.hibernate.model.User;
import module4.hibernate.model.UserDto;
import module4.hibernate.model.UserStatus;
import module4.hibernate.model.joined.JChildClass1;
import module4.hibernate.model.joined.JChildClass2;
import module4.hibernate.model.mappedSuperclass.MChildClass1;
import module4.hibernate.model.mappedSuperclass.MChildClass2;
import module4.hibernate.model.simple.BaseClass;
import module4.hibernate.model.simple.ChildClass1;
import module4.hibernate.model.simple.ChildClass2;
import module4.hibernate.model.singleTable.SChildClass1;
import module4.hibernate.model.singleTable.SChildClass2;
import module4.hibernate.model.tablePerClass.TChildClass1;
import module4.hibernate.model.tablePerClass.TChildClass2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        /*Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5433/TestBase", "postgres", "root")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.migrate();*/

//        nativeHibernate();
//         jpaHibernate();
//        mergeExample();
//        receiveExample();
//        deleteExample();
//        getPartInfoFromEntity();
//        oneToOneExample();
//        oneToManyExample();
//        manyToManyExample();
//        problemOfLazyLoading();
//        problemNPlusOne();
//        firstLevelCacheExample();
//        simpleInheritance();
//        mappedSuperclassInheritance();
//        singleTableInheritance();
//        joinedInheritance();
        tablePerClassInheritance();
    }

    private static void tablePerClassInheritance() {
        final EntityManager entityManager = HibernateConfiguration.getEntityManager();
        entityManager.getTransaction().begin();
        final TChildClass1 childClass1 = new TChildClass1("Base name", "Base description", "Child name");
        final TChildClass2 childClass2 = new TChildClass2("Base name", "Base description", "Child description");
        entityManager.persist(childClass1);
        entityManager.persist(childClass2);
        entityManager.getTransaction().commit();

        System.out.println("Get one");
        final TChildClass1 jChildClass1 = entityManager.find(TChildClass1.class, childClass1.getId());
        System.out.println(jChildClass1);
        final TChildClass2 jChildClass2 = entityManager.find(TChildClass2.class, childClass2.getId());
        System.out.println(jChildClass2);

        System.out.println("Get all");
        entityManager.createQuery("from TChildClass1", TChildClass1.class)
                .getResultStream()
                .forEach(System.out::println);
    }

    private static void joinedInheritance() {
        final EntityManager entityManager = HibernateConfiguration.getEntityManager();
        entityManager.getTransaction().begin();
        final JChildClass1 childClass1 = new JChildClass1("Base name", "Base description", "Child name");
        final JChildClass2 childClass2 = new JChildClass2("Base name", "Base description", "Child description");
        entityManager.persist(childClass1);
        entityManager.persist(childClass2);
        entityManager.getTransaction().commit();

        System.out.println("Get one");
        final JChildClass1 jChildClass1 = entityManager.find(JChildClass1.class, childClass1.getId());
        System.out.println(jChildClass1);
        final JChildClass2 jChildClass2 = entityManager.find(JChildClass2.class, childClass2.getId());
        System.out.println(jChildClass2);

        System.out.println("Get all");
        entityManager.createQuery("from JChildClass1", JChildClass1.class)
                .getResultStream()
                .forEach(System.out::println);
    }

    private static void singleTableInheritance() {
        final EntityManager entityManager = HibernateConfiguration.getEntityManager();
        entityManager.getTransaction().begin();
        final SChildClass1 childClass1 = new SChildClass1("Base name", "Base description", "Child name");
        final SChildClass2 childClass2 = new SChildClass2("Base name", "Base description", "Child description");
        entityManager.persist(childClass1);
        entityManager.persist(childClass2);
        entityManager.getTransaction().commit();

        System.out.println("Get one");
        final SChildClass1 sChildClass1 = entityManager.find(SChildClass1.class, childClass1.getId());
        System.out.println(sChildClass1);
        final SChildClass2 sChildClass2 = entityManager.find(SChildClass2.class, childClass2.getId());
        System.out.println(sChildClass2);

        System.out.println("Get all");
        entityManager.createNativeQuery("SELECT * FROM sbaseclass WHERE type = 'child_1'", SChildClass1.class)
                .getResultStream()
                .forEach(System.out::println);

        entityManager.createQuery("from SChildClass1", SChildClass1.class)
                .getResultStream()
                .forEach(System.out::println);
    }

    private static void mappedSuperclassInheritance() {
        final EntityManager entityManager = HibernateConfiguration.getEntityManager();
        entityManager.getTransaction().begin();
        final MChildClass1 childClass1 = new MChildClass1("Base name", "Base description", "Child name");
        final MChildClass2 childClass2 = new MChildClass2("Base name", "Base description", "Child description");
        entityManager.persist(childClass1);
        entityManager.persist(childClass2);
        entityManager.getTransaction().commit();

        System.out.println("Get one");
        final MChildClass1 mChildClass1 = entityManager.find(MChildClass1.class, childClass1.getId());
        System.out.println(mChildClass1);
        final MChildClass2 mChildClass2 = entityManager.find(MChildClass2.class, childClass2.getId());
        System.out.println(mChildClass2);

        System.out.println("Get all");
        entityManager.createQuery("from MChildClass1", MChildClass1.class)
                .getResultStream()
                .forEach(System.out::println);
    }

    private static void simpleInheritance() {
        final EntityManager entityManager = HibernateConfiguration.getEntityManager();
        entityManager.getTransaction().begin();
        final BaseClass baseClass = new BaseClass("Base name", "Base description");
        final ChildClass1 childClass1 = new ChildClass1("Base name", "Base description", "Child name");
        final ChildClass2 childClass2 = new ChildClass2("Base name", "Base description", "Child description");
        entityManager.persist(baseClass);
        entityManager.persist(childClass1);
        entityManager.persist(childClass2);
        entityManager.getTransaction().commit();
    }

    private static void firstLevelCacheExample() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        final User user01 = createUser(sessionFactory);
        final User user02 = createUser(sessionFactory);

        final Session session = sessionFactory.openSession();
        final User user1 = session.get(User.class, user01.getId());
        session.clear();
        final User user2 = session.get(User.class, user01.getId());
        final User user3 = session.get(User.class, user02.getId());
        session.close();
    }

    private static void problemNPlusOne() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        final User user1 = createUser(sessionFactory);
        user1.setRoles(List.of("USER"));
        final User user2 = createUser(sessionFactory);
        user2.setRoles(List.of("ADMIN"));
        final User user3 = createUser(sessionFactory);
        user3.setRoles(List.of("ADMIN"));

        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(user1);
        session.merge(user2);
        session.merge(user3);
        session.getTransaction().commit();
        session.close();

        final Session session2 = sessionFactory.openSession();
        final User user = session2.get(User.class, user1.getId());
        System.out.println(user);
        final List<User> fromUser = session2.createQuery("from User", User.class).list();
        fromUser.forEach(System.out::println);
        session2.close();
    }

    private static void problemOfLazyLoading() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        final User user1 = createUser(sessionFactory);
        user1.setRoles(List.of("USER", "ADMIN"));
        final Passport passport = new Passport();
        user1.setPassport(passport);
        final Subject subject1 = new Subject();
        final Subject subject2 = new Subject();
        subject1.setUsers(Set.of(user1));
        subject2.setUsers(Set.of(user1));
        final Set<Subject> subjects = Set.of(subject1, subject2);
        user1.setSubjects(subjects);
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(user1);
        session.getTransaction().commit();
        session.close();

        final Session session2 = sessionFactory.openSession();
        final User user = session2.get(User.class, user1.getId());
        System.out.println(user);
        System.out.println(user.getPassportField().getId());
        System.out.println(user.getRoles().getLast());
        System.out.println(user.getRoles().getFirst());

        session2.close();

    }

    private static void manyToManyExample() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        final User user1 = createUser(sessionFactory);
        final User user2 = createUser(sessionFactory);
        final Subject subject1 = new Subject();
        final Subject subject2 = new Subject();

        final Set<User> users = Set.of(user1, user2);
        subject1.setUsers(users);
        subject2.setUsers(users);

        final Set<Subject> subjects = Set.of(subject1, subject2);
        user1.setSubjects(subjects);
        user2.setSubjects(subjects);

        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(user1);
        session.merge(user2);
//        session.persist(subject1);
//        session.persist(subject2);
        session.getTransaction().commit();

//        final Session session2 = sessionFactory.openSession();
//        final Subject subject3 = session2.get(Subject.class, subject1.getId());
//        System.out.println(subject3);
//        System.out.println(subject3.getUsers().size());
    }

    private static void oneToManyExample() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        final User user = createUser(sessionFactory);
        final Note note1 = new Note();
        note1.setUser(user);
        final Note note2 = new Note();
        note2.setUser(user);

        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(note1);
        session.persist(note2);
        session.getTransaction().commit();

        final Session session2 = sessionFactory.openSession();
        final User user1 = session2.get(User.class, user.getId());
        System.out.println(user1);
        System.out.println(user1.getNotes().size());
    }

    private static void oneToOneExample() {
        final SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        final User user = createUser(sessionFactory);
        final Passport passport = new Passport();
//        passport.setUser(user);
        user.setPassport(passport); // Optional, depend on set method

        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(passport);
        session.merge(user);
        session.getTransaction().commit();

        final Session session2 = sessionFactory.openSession();
        final Passport passport1 = session2.get(Passport.class, passport.getId());
        System.out.println(passport1);
        System.out.println(passport1.getUser());

        // Create PreparedStatement
        // INSERT INTO users (id, name, email, age, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)
        // INSERT INTO passport (id, user_id) VALUES (?, ?)
        // Fill PreparedStatement
        // Execute PreparedStatement

        // Create PreparedStatement
        // SELECT * FROM users WHERE id = ?
        // SELECT * FROM passport WHERE user_id = ?
        // Fill Java Objects from ResultSet
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
        final Transaction transaction = session1.beginTransaction();
        final User getUser = session1.get(User.class, user1.getId());
        session1.remove(getUser);
        transaction.commit();
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
        user.setStatus(UserStatus.ACTIVE);
        user.setPremium(true);
        user.setRoles(List.of("USER"));

        final City city = new City();
        city.setName("San Francisco");
        city.setCountry("USA");
        user.setCity(city);

        user.setTime(LocalTime.now());
        user.setDate(LocalDate.now());
        user.setDateTime(LocalDateTime.now());

        System.out.println("Before persist id: " + user.getId());
        session.persist(user);
        System.out.println("After persist id: " + user.getId());
        user.setEmail("Daniel@gmail.com");
        session.persist(user);

        final Passport passport = new Passport();
        passport.setUser(user);
        session.persist(passport);
        session.persist(user);

        final User user1 = new User();
        user1.setName("John");
        user1.setStatus(UserStatus.BANNED);
        user1.setPremium(false);
        user1.setRoles(List.of("ADMIN"));
        session.persist(user1);

        final User user2 = new User();
        user2.setName("Jane");
        user2.setEmail("jane@gmail.com");
        user2.setAge(30);
        user2.setStatus(UserStatus.DELETED);
        user2.setRoles(List.of("MODERATOR", "ADMIN"));
        session.persist(user2);

        session.getTransaction().commit();
    }


    private static void nativeHibernateGet(final Session session) {
        session.createQuery("from User", User.class)
                .stream()
                .peek(System.out::println)
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
