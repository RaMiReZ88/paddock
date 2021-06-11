package com.kolhoz.paddock.dao.clan.repository;

import com.kolhoz.paddock.dao.clan.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Long> {
}
