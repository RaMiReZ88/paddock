package com.kolhoz.paddock.dao.clan;

import com.kolhoz.paddock.dao.IdGenerator;
import com.kolhoz.paddock.dao.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
@SequenceGenerator(name = "CLAN_RECORD_ID_GENERATOR", sequenceName = "CLAN_SEQ", allocationSize = 1)

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Clan extends IdGenerator {

    private String clanName;

    private Long rating;

    private LocalDate creationDate;

    private Long numberOfParticipants;

    private byte[] emblem;

    private Long victories;

    private Long defeat;

    private Double profit;

    private Double loss;

    @OneToMany(mappedBy = "clan")
    private Set<User> participants;

    @OneToMany(mappedBy = "clanAdmin")
    private Set<User> admins;
}