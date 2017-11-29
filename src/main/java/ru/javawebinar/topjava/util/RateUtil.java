package ru.javawebinar.topjava.util;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.service.RateService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анастасия on 29.11.2017.
 */
public class RateUtil {
    @Autowired
    protected RateService service;

    public List<Rate> getRateByUserAndPositionsList(int userId, List<PositionDict> positionsList) {
        List<Rate> rates = new ArrayList<>();
        for (PositionDict position : positionsList) {
            Rate newRate = new Rate(userId, position.getId(), new BigDecimal(1));
            if (newRate.equals(service.getByUserAndPosition(userId, positionsList).get(0)))
                service.update(newRate);
            else service.save(newRate);
        }
        return rates;
    }

}
