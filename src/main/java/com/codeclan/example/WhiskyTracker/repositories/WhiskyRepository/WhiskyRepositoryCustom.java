package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepositoryCustom {

    List<Whisky> findWhiskyByAgeAndDistillery(int age, Long id);

    List<Whisky> findWhiskyByRegion(String region);

}
