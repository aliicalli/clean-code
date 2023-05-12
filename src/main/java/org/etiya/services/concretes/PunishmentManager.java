package org.etiya.services.concretes;

import org.etiya.core.util.DateUtil;
import org.etiya.entities.concretes.Punishment;
import org.etiya.repositories.abstracts.PunishmentRepository;
import org.etiya.services.abstracts.PunishmentSerivce;

import java.util.Date;
import java.util.List;

public class PunishmentManager implements PunishmentSerivce {

    private final PunishmentRepository punishmentRepository;

    public PunishmentManager(PunishmentRepository punishmentRepository) {
        this.punishmentRepository = punishmentRepository;
    }

    @Override
    public void add(Punishment entity) {
        punishmentRepository.add(entity);
        System.out.println("Punishment Eklendi.");
    }

    @Override
    public void update(Punishment entity) {

    }

    @Override
    public List<Punishment> getAll() {
        return punishmentRepository.getAll();
    }

    @Override
    public Punishment getById(int id) {
        return null;
    }

    @Override
    public Punishment getByName(String name) {
        return null;
    }

    public boolean checkIfBorrowEndDatePassedThreeDay(Date endDate) {
        if (DateUtil.dayDiffrenceBetweenTwoDays(endDate, new Date()) >= 3) {
            return true;
        }
        return false;
    }
}
