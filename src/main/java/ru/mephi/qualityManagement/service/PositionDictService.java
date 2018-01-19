package ru.mephi.qualityManagement.service;

import org.springframework.stereotype.Service;
import ru.mephi.qualityManagement.model.PositionDict;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Service
public interface PositionDictService {
    List<PositionDict> getAll();


    List<String> getAllPositionNames();

    List<PositionDict> getPositionsByName(List<String> positionNames);


}
