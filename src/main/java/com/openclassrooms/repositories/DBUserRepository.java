package com.openclassrooms.repositories;

import com.openclassrooms.models.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Long> {
    public DBUser findByUsername(String username);
}
