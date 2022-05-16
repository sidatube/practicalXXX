package com.example.practicalxxx.seeder;

import com.example.practicalxxx.district.District;
import com.example.practicalxxx.district.DistrictService;
import com.example.practicalxxx.enumAll.StreetEnum;
import com.example.practicalxxx.street.Street;
import com.example.practicalxxx.street.StreetService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seed/generate")
public class SeederApi {
    @Autowired
    DistrictService districtService;
    @Autowired
    StreetService streetService;
    @GetMapping
    public ResponseEntity<String > seeder(){
        Faker faker = new Faker();
       try{
           if (districtService.findAll().isEmpty()){
               List<District> districts = new ArrayList<>();
               for (int i = 0; i < 5; i++) {
                   districts.add(new District(i,faker.pokemon().name()));
               }
               districtService.saveAll(districts);
           }
           if (streetService.findAll().isEmpty()){
               List<District> districts = districtService.findAll();
               List<Street> streets = new ArrayList<>();
               List<String> enumList= new ArrayList<>(Arrays.asList("Using","Doing","Fixing"));
               for (int i = 0; i <10; i++) {
                   Street street = Street.builder()
                           .establishDate(faker.date().birthday())
                           .description(faker.superhero().descriptor())
                           .districtId(districts.get(faker.random().nextInt(0, districts.size()-1)).getId())
                           .name(faker.name().lastName())
                           .status(StreetEnum.valueOf(enumList.get(faker.random().nextInt(0,enumList.size()-1))))
                           .build();
                   streets.add(street);
               }
               streetService.saveAll(streets);
           }
       }catch (Exception e){
           return ResponseEntity.badRequest().body("Seed thất bại");
       }
        return ResponseEntity.ok("Seed thành công");
    }
}
