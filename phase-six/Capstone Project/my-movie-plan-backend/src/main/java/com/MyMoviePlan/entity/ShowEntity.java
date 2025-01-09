package com.MyMoviePlan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "shows")
public class ShowEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "start_time")
    private String startTime;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity = AuditoriumEntity.class)
    private AuditoriumEntity auditorium;

    //    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = MovieShowsEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "show_id", referencedColumnName = "id")
    private List<MovieShowsEntity>movieShows;

    public ShowEntity(String name, String startTime, List<MovieShowsEntity>movieShows) {
        this.name = name;
this.startTime = startTime;
this.movieShows = movieShows;
    }

    public ShowEntitysetId(int id) {
        this.id = id;
        return this;
    }

    public ShowEntitysetName(String name) {
        this.name = name;
        return this;
    }

    public ShowEntitysetStartTime(String startTime) {
this.startTime = startTime;
        return this;
    }

    public ShowEntitysetAuditorium(AuditoriumEntity auditorium) {
this.auditorium = auditorium;
        return this;
    }

    public ShowEntitysetMovieShows(List<MovieShowsEntity>movieShows) {
this.movieShows = movieShows;
        return this;
    }
}


