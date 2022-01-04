package com.kolhoz.paddock.dao.clan;

import com.kolhoz.paddock.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClanDto {

    private Long recordId;
    private String clanName;
    private Long rating;
    private LocalDate creationDate;
    private Long numberOfParticipants;
    private byte[] emblem;
    private Long victories;
    private Long defeat;
    private Double profit;
    private Double loss;
    private Set<User> participants;
    private Set<User> admins;
}
