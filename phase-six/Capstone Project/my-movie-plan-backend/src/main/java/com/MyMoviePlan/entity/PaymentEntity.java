package com.MyMoviePlan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "payments")
public class PaymentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "card_number", length = 20)
    private String cardNumber;

    @Column(name = "card_expiry_month", length = 5)
    private String cardExpiryMonth;

    @Column(name = "card_expiry_year", length = 5)
    private String cardExpiryYear;

    @Column(name = "card_cvv", length = 5)
    private String cardCVV;

    public PaymentEntity(double amount, Date paymentDate, String cardNumber, String cardExpiryMonth,
                         String cardExpiryYear, String cardCVV) {
this.amount = amount;
this.paymentDate = paymentDate;
this.cardNumber = cardNumber;
this.cardExpiryMonth = cardExpiryMonth;
this.cardExpiryYear = cardExpiryYear;
this.cardCVV = cardCVV;
    }

    public PaymentEntitysetId(int id) {
        this.id = id;
        return this;
    }

    public PaymentEntitysetAmount(double amount) {
this.amount = amount;
        return this;
    }

    public PaymentEntitysetPaymentDate(Date paymentDate) {
this.paymentDate = paymentDate;
        return this;
    }

    public PaymentEntitysetCardNumber(String cardNumber) {
this.cardNumber = cardNumber;
        return this;
    }

    public PaymentEntitysetCardExpiryMonth(String cardExpiryMonth) {
this.cardExpiryMonth = cardExpiryMonth;
        return this;
    }

    public PaymentEntitysetCardExpiryYear(String cardExpiryYear) {
this.cardExpiryYear = cardExpiryYear;
        return this;
    }

    public PaymentEntitysetCardCVV(String cardCVV) {
this.cardCVV = cardCVV;
        return this;
    }
}


