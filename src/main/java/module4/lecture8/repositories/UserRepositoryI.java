package module4.lecture8.repositories;

import module4.lecture8.controllers.beans.ClientBean;
import module4.lecture8.models.Client;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserRepositoryI {

    Set<Client> getAll();

    Optional<Client> get(final UUID id);

    UUID create(final ClientBean bean);

    void update(final ClientBean bean);

    void delete(final UUID id);

    void restore(final UUID id);
}
