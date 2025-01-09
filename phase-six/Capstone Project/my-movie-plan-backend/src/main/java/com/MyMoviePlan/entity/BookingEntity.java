package com.MyMoviePlan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "bookings")
public class BookingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    @Column(name = "total_seats")
    private int totalSeats;

    @Column(name = "booked_on")
    @Temporal(TemporalType.DATE)
    private Date bookedOn;

    @Column(name = "date_of_booking")
    @Temporal(TemporalType.DATE)
    private Date dateOfBooking;

    @Column(name = "user_id")
    private String userId;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @CollectionTable(name = "booked_seats", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "seat_numbers")
    private List<String>seatNumbers;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(targetEntity = PaymentEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(targetEntity = BookingDetailsEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_details_id")
    private BookingDetailsEntitybookingDetails;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity = MovieShowsEntity.class)
    private MovieShowsEntitymovieShow;

    public BookingEntity(double amount, int totalSeats, Date bookedOn, Date dateOfBooking, List<String>seatNumbers,
PaymentEntity payment, String userId, MovieShowsEntitymovieShow) {
this.amount = amount;
this.totalSeats = totalSeats;
this.bookedOn = bookedOn;
this.dateOfBooking = dateOfBooking;
this.seatNumbers = seatNumbers;
this.payment = payment;
this.userId = userId;
this.movieShow = movieShow;
    }

    public BookingEntitysetMovieShow(MovieShowsEntitymovieShow) {
this.movieShow = movieShow;
        return this;
    }

    public BookingEntitysetId(int id) {
        this.id = id;
        return this;
    }

    public BookingEntitysetAmount(double amount) {
this.amount = amount;
        return this;
    }

    public BookingEntitysetTotalSeats(int totalSeats) {
this.totalSeats = totalSeats;
        return this;
    }

    public BookingEntitysetStatus(Date bookedOn) {
this.bookedOn = bookedOn;
        return this;
    }

    public BookingEntitysetDateOfBooking(Date dateOfBooking) {
this.dateOfBooking = dateOfBooking;
        return this;
    }

    public BookingEntitysetSeatNumbers(List<String>seatNumbers) {
this.seatNumbers = seatNumbers;
        return this;
    }

    public BookingEntitysetPayment(PaymentEntity payment) {
this.payment = payment;
        return this;
    }

    public BookingEntitysetUserId(String userId) {
this.userId = userId;
        return this;
    }
}
