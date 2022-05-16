package com.example.practicalxxx.district;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    public List<District> findAll(){

        return districtRepository.findAll();
    }
    public List<District> saveAll(List<District> districts){
       return districtRepository.saveAll(districts);
    }

}
