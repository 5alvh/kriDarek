package com.kriDarek.back.repositories;

import com.kriDarek.back.entities.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    @Query("SELECT c FROM Conversation c WHERE " +
            "(c.user1.id = :userId OR c.user2.id = :userId) " +
            "ORDER BY c.lastMessageAt DESC")
    List<Conversation> findByUserIdOrderByLastMessageAtDesc(Long userId);

    Optional<Conversation> findByUser1IdAndUser2IdAndPropertyId(Long user1Id, Long user2Id, Long propertyId);

    @Query("SELECT c FROM Conversation c WHERE " +
            "((c.user1.id = :user1Id AND c.user2.id = :user2Id) OR " +
            "(c.user1.id = :user2Id AND c.user2.id = :user1Id)) AND " +
            "c.property.id = :propertyId")
    Optional<Conversation> findConversationBetweenUsers(Long user1Id, Long user2Id, Long propertyId);
}