package com.MyMoviePlan.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id", scope = ShowEntity.class)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "auditoriums")
public class AuditoriumEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(length = Integer.MAX_VALUE, columnDefinition="TEXT")
    private String image;

    private String email;

    @Column(name = "customer_care_no")
    private String customerCareNo;

    private String address;

    @Column(name = "seat_capacity")
    private int seatCapacity;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @CollectionTable(name = "auditorium_facilities", joinColumns = @JoinColumn(name = "auditorium_id"))
    @Column(name = "facility")
    private List<String> facilities;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @CollectionTable(name = "auditorium_safeties", joinColumns = @JoinColumn(name = "auditorium_id"))
    @Column(name = "safety")
    private List<String> safeties;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "auditorium_id", referencedColumnName = "id")
    @OneToMany(targetEntity = ShowEntity.class, cascade = CascadeType.ALL)
//    @JoinTable(name = "auditorium_shows",
//            joinColumns = @JoinColumn(name = "auditorium_id", unique = false),
//            inverseJoinColumns = @JoinColumn(name = "show_id", unique = false))
    private List<ShowEntity> shows;

    public AuditoriumEntity(String name, String image, String email, String customerCareNo, String address,
                            int seatCapacity, List<String> facilities, List<String> safeties, List<ShowEntity> shows) {
        this.name = name;
this.image = image;
this.email = email;
this.customerCareNo = customerCareNo;
this.address = address;
this.seatCapacity = seatCapacity;
this.facilities = facilities;
this.safeties = safeties;
this.shows = shows;
    }

    public AuditoriumEntitysetId(int id) {
        this.id = id;
        return this;
    }

    public AuditoriumEntitysetName(String name) {
        this.name = name;
        return this;
    }

    public AuditoriumEntitysetImage(String image) {
this.image = image;
        return this;
    }

    public AuditoriumEntitysetEmail(String email) {
this.email = email;
        return this;
    }

    public AuditoriumEntitysetCustomerCare(String customerCareNo) {
this.customerCareNo = customerCareNo;
        return this;
    }

    public AuditoriumEntitysetAddress(String address) {
this.address = address;
        return this;
    }

    public AuditoriumEntitysetSeatCapacity(int seatCapacity) {
this.seatCapacity = seatCapacity;
        return this;
    }

    public AuditoriumEntitysetFacilities(List<String> facilities) {
this.facilities = facilities;
        return this;
    }

    public AuditoriumEntitysetSafeties(List<String> safeties) {
this.safeties = safeties;
        return this;
    }

    public AuditoriumEntitysetShows(List<ShowEntity> shows) {
this.shows = shows;
        return this;
    }
}

