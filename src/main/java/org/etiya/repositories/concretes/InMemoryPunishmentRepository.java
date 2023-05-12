package org.etiya.repositories.concretes;

import org.etiya.entities.concretes.Punishment;
import org.etiya.repositories.abstracts.PunishmentRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPunishmentRepository implements PunishmentRepository {

    List<Punishment> punishmentList = new ArrayList<>();

    @Override
    public void add(Punishment entity) {
        punishmentList.add(entity);
    }

    @Override
    public void update(Punishment entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Punishment getById(int id) {
        return null;
    }

    @Override
    public List<Punishment> getAll() {
        return punishmentList;
    }
}
