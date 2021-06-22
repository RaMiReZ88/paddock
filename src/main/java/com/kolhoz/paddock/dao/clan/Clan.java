package com.kolhoz.paddock.dao.clan;

import com.kolhoz.paddock.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/* TODO:
    1. Подумать над связью "клан-админы" (Готово)
    2. Добавить эмблему (Готово)
    3. Список игр клана
    4. Чемпионы (подумать: через доп. таблицу, по наибольшему рейтингу или через еще одну связь)
    5. Выигранные деньги (Готово)
    6. Проигранные деньги (Готово)
    7. Оценка стоимости клана
    8. Союзные кланы (не больше 2-3)
    9. Основные кланы-враги
    10. Макс. количество участников (В базовый пакет входит - 100 человек. Остальное обдумать)
    11. Статусы участников: заблокирован(навсегда или на опред. срок), (не)активный, оштрафован
    12. Достижения: кубки, значимые победы, открытия и т.п.
    13. Кол-во сыгранных игр вообще
    14. Кол-во побед и поражений
    15. Переговорные комнаты
    16. Стартовый арсенал в играх от клана (если предусмотрен)
 */

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

    @Column(name = "EMBLEM")
    private byte[] emblem;

    @Column(name = "VICTORIES")
    private Long victories;

    @Column(name = "DEFEAT")
    private Long defeat;

    @Column(name = "PROFIT")
    private Double profit;

    @Column(name = "LOSS")
    private Double loss;

    @OneToMany(mappedBy = "clan")
    private Set<User> participants;

    @OneToMany(mappedBy = "clanAdmin")
    private Set<User> admins;
}