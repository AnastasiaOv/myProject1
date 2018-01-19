package ru.mephi.qualityManagement.service;

import ru.mephi.qualityManagement.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 09.03.2015.
 */
public interface UserMealService {

    /**
     * create new meal
     * @param meal
     * @param userId
     * @return
     */
    public UserMeal save(UserMeal meal, int userId);

    /**
     * update meal
     * @param meal
     * @param userId
     * @return
     */
    public UserMeal update(UserMeal meal, int userId);

    /**
     * delete meal by id
     * @param id
     * @param userId
     * @return
     */
    public void delete(int id, int userId);

    /**
     * delete all meals for current user by id
     * @param userId
     * @return
     */
    public void deleteAll(int userId);

    /**
     * get meal by id
     * @param id
     * @param userId
     * @return
     */
    public UserMeal get(int id, int userId);

    /**
     * get all meals for current user by id
     * @param userId
     * @return
     */
    public List<UserMeal> getAll(int userId);

    /**
     * get all meals between dates for current user
     * @param startDate
     * @param endDate
     * @param userId
     * @return
     */
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);

}
