package com.example.paddock.dao.payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.example.paddock.dao.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT_HISTORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_HISTORY_SEQ_GENERATOR")
    @SequenceGenerator(name = "PAYMENT_HISTORY_SEQ_GENERATOR", sequenceName = "PAYMENT_HISTORY_SEQ", allocationSize = 1)
    @Column(name = "RECORD_ID")
    private Long recordId;

    @Column(name = "SUM_PAYMENT")
    private Long sumPayment;

    @Column(name = "PAYMENT_DATE")
    private LocalDateTime paymentDate;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

}
