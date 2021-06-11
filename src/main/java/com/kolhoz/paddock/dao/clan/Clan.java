package com.kolhoz.paddock.dao.clan;

import com.kolhoz.paddock.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


// TODO:
//  1. Подумать над связью "клан-админы"

@Entity
@Table(name = "CLAN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAN_SEQ_GENERATOR")
    @SequenceGenerator(name = "CLAN_SEQ_GENERATOR", sequenceName = "CLAN_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CLAN_NAME")
    private String clanName;

    @Column(name = "RATING")
    private Long rating;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    @Column(name = "NUMBER_OF_PARTICIPANTS")
    private Long numberOfParticipants;

    @OneToMany(mappedBy = "clan")
    private Set<User> participants;
}
