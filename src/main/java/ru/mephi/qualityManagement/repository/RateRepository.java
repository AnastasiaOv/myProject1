package ru.mephi.qualityManagement.repository;

import ru.mephi.qualityManagement.model.Rate;
import ru.mephi.qualityManagement.to.RateTo;

import java.util.List;

/**
 * Created by Анастасия on 24.11.2017.
 */
public interface RateRepository {
    Rate save(Rate user, int userId);

    // false if not found
    boolean delete(int id);

    // null if not found
    Rate get(int id, int userId);

    Rate get(int id);

    // null if not found
    List<Rate> getByUserId(int userId);

    List<Rate> getAll();

    List<RateTo> getAllRatesForProcess(int processId);

}
