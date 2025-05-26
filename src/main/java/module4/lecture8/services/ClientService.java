package module4.lecture8.services;

import module4.lecture8.controllers.beans.ClientBean;
import module4.lecture8.models.Client;
import module4.lecture8.repositories.ClientRepositoryJdbc;
import module4.lecture8.repositories.ClientRepositoryJpa;
import module4.lecture8.repositories.UserRepositoryI;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class ClientService {

    private static ClientService instance;

    private UserRepositoryI repository;

    private ClientService(UserRepositoryI repository) {
        this.repository = repository;
    }

    public static ClientService getInstance() {
        if (instance == null) {
//            instance = new ClientService(ClientRepositoryJdbc.getInstance());
            instance = new ClientService(ClientRepositoryJpa.getInstance());
        }
        return instance;
    }

    public Set<Client> getAll() {
        return repository.getAll();
    }

    public Optional<Client> get(final UUID id) {
        return repository.get(id);
    }

    public UUID create(final ClientBean bean) {
        return repository.create(bean);
    }

    public void update(final ClientBean bean) {
        repository.update(bean);
    }

    public void delete(final UUID id) {
        repository.delete(id);
    }

    public void restore(final UUID id) {
        repository.restore(id);
    }
}
