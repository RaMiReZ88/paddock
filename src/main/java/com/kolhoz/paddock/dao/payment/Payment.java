package com.kolhoz.paddock.dao.payment;

import com.kolhoz.paddock.dao.IdGenerator;
import com.kolhoz.paddock.dao.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT")
@SequenceGenerator(name = "PAYMENT_RECORD_ID_GENERATOR", sequenceName = "PAYMENT_SEQ", allocationSize = 1)

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends IdGenerator {

    private Long sumPayment;

    private LocalDateTime paymentDate;

    @Enumerated(value = EnumType.STRING)
    private PaymentStatus status;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
