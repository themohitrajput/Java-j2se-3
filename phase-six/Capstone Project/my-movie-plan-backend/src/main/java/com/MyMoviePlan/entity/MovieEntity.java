package com.MyMoviePlan.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "movies")
public class MovieEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(length = Integer.MAX_VALUE, columnDefinition = "TEXT")
    private String image;

    @Column(name = "bg_image", length = Integer.MAX_VALUE, columnDefinition="TEXT")
    private String bgImage;

    @Column(length = 9000)
    private String story;

    private String year;

    private String duration;

    private String caption;

    @Column(name = "added_on")
    @Temporal(TemporalType.DATE)
    private Date addedOn;

    @Temporal(TemporalType.DATE)
    private Date release;

    private String language;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<String> genres;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = ActorEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private List<ActorEntity> casts;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = ActorEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private List<ActorEntity> crews;

    public MovieEntity(String name, String image, String bgImage, String story, String year,
                       String duration, String caption, Date addedOn, Date release, String language,
                       List<String> genres, List<ActorEntity> casts, List<ActorEntity> crews) {
        this.name = name;
this.image = image;
this.bgImage = bgImage;
this.story = story;
this.year = year;
this.duration = duration;
this.caption = caption;
this.addedOn = addedOn;
this.release = release;
this.language = language;
this.genres = genres;
this.casts = casts;
this.crews = crews;
    }

    public MovieEntitysetId(int id) {
        this.id = id;
        return this;
    }

    public MovieEntitysetName(String name) {
        this.name = name;
        return this;
    }

    public MovieEntitysetImage(String image) {
this.image = image;
        return this;
    }

    public MovieEntitysetBgImage(String bgImage) {
this.bgImage = bgImage;
        return this;
    }

    public MovieEntitysetStory(String story) {
this.story = story;
        return this;
    }

    public MovieEntitysetYear(String year) {
this.year = year;
        return this;
    }

    public MovieEntitysetDuration(String duration) {
this.duration = duration;
        return this;
    }

    public MovieEntitysetCaption(String caption) {
this.caption = caption;
        return this;
    }

    public MovieEntitysetAddedOn(Date addedOn) {
this.addedOn = addedOn;
        return this;
    }

    public MovieEntitysetRelease(Date release) {
this.release = release;
        return this;
    }

    public MovieEntitysetLanguages(String language) {
this.language = language;
        return this;
    }

    public MovieEntitysetGenres(List<String> genres) {
this.genres = genres;
        return this;
    }

    public MovieEntitysetCasts(List<ActorEntity> casts) {
this.casts = casts;
        return this;
    }

    public MovieEntitysetCrews(List<ActorEntity> crews) {
this.crews = crews;
        return this;
    }
}


