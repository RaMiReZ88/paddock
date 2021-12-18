package com.example.paddock.dao.clan.repository;

import com.example.paddock.dao.clan.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Long> {

}
