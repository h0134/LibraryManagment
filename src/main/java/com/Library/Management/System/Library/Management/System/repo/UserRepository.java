package com.Library.Management.System.Library.Management.System.repo;

import com.Library.Management.System.Library.Management.System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

