package module4.lecture8.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import module4.lecture8.controllers.beans.ClientBean;
import module4.lecture8.models.Client;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientRepositoryJpa extends AbstractRepository implements UserRepositoryI {

    private static ClientRepositoryJpa instance;

    private ClientRepositoryJpa() {
        super();
    }

    public static ClientRepositoryJpa getInstance() {
        if (instance == null) {
            instance = new ClientRepositoryJpa();
        }
        return instance;
    }

    @Override
    public Set<Client> getAll() {
        return getEntityManager().createQuery("from Client c where c.active = true", Client.class)
                .getResultStream()
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Client> get(final UUID id) {
        return Optional.ofNullable(getEntityManager().find(Client.class, id));
    }

    @Override
    public UUID create(final ClientBean bean) {
        final Client client = new Client();
        client.setName(bean.getName());
        client.setAddress(bean.getAddress());
        client.setAge(bean.getAge());
        client.setActive(true);

        final EntityManager entityManager = getEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(client);
        transaction.commit();

        return client.getId();
    }

    @Override
    public void update(final ClientBean bean) {
        final Client client = get(bean.getId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + bean.getId()));

        final String name = bean.getName() == null ? client.getName() : bean.getName();
        client.setName(name);
        final String address = bean.getAddress() == null ? client.getAddress() : bean.getAddress();
        client.setAddress(address);
        final int age = bean.getAge() == null ? client.getAge() : bean.getAge();
        client.setAge(age);

        final EntityManager entityManager = getEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(client);
        transaction.commit();
    }

    @Override
    public void delete(final UUID id) {
        final EntityManager entityManager = getEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        get(id).ifPresent(e -> entityManager.remove(entityManager.contains(e) ? e : entityManager.merge(e)));
        transaction.commit();
    }

    @Override
    public void restore(final UUID id) {
        final EntityManager entityManager = getEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.createQuery("UPDATE Client c SET c.active = true WHERE c.id = :id")
                .setParameter("id", id)
                .executeUpdate();

        transaction.commit();
    }
}
