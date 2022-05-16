package com.example.practicalxxx.street;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;
    public List<Street> findAll(String name,int districtId){
        if (districtId==0){
            return streetRepository.findByInfo(name);
        }
        return streetRepository.findByInfo(name,districtId);
    }
    public List<Street> findAll(){
        return streetRepository.findAll();
    }
    public Street save(Street street){
        return streetRepository.save(street);
    }
    public Optional<?> findById(int id){
        return streetRepository.findById(id);
    }
    public List<Street> saveAll(List<Street> districts){
        return streetRepository.saveAll(districts);
    }
}
