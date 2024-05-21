package net.comece.smtpmailcomece.repository;

import net.comece.smtpmailcomece.model.UserSender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSenderRepository extends JpaRepository<UserSender, Long> {
}
