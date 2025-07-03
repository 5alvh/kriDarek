package com.kriDarek.back.repositories;

import com.kriDarek.back.entities.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findByPropertyOwnerIdOrderByCreatedAtDesc(Long ownerId);
    List<Inquiry> findByUserIdOrderByCreatedAtDesc(Long userId);
    List<Inquiry> findByPropertyIdOrderByCreatedAtDesc(Long propertyId);
}