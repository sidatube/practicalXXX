package com.example.practicalxxx.street;

import com.example.practicalxxx.district.District;
import com.example.practicalxxx.enumAll.StreetEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date establishDate;
    private String description;
    @Column(name = "districtId")
    private int districtId;
    @ManyToOne
    @JoinColumn(name = "districtId",insertable = false,updatable = false)
    private District district;
    private StreetEnum status;
}
