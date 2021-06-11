package com.kolhoz.paddock.dao.payment;

import com.kolhoz.paddock.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "ID")
    private Long id;

    @Column(name = "SUM_PAYMENT")
    private Long sumPayment;

    @Column(name = "PAYMENT_DATE")
    private LocalDateTime paymentDate;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus status;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
