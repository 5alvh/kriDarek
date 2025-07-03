package com.kriDarek.back.repositories;

import com.kriDarek.back.entities.Property;
import com.kriDarek.back.enums.PropertyType;
import com.kriDarek.back.enums.TransactionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT p FROM Property p WHERE " +
            "(:type IS NULL OR p.type = :type) AND " +
            "(:transactionType IS NULL OR p.transactionType = :transactionType) AND " +
            "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR p.price <= :maxPrice) AND " +
            "(:minBedrooms IS NULL OR p.bedrooms >= :minBedrooms) AND " +
            "(:maxBedrooms IS NULL OR p.bedrooms <= :maxBedrooms) AND " +
            "(:city IS NULL OR LOWER(p.address.city) LIKE LOWER(CONCAT('%', :city, '%'))) AND " +
            "p.active = true")
    Page<Property> findBySearchCriteria(
            @Param("type") PropertyType type,
            @Param("transactionType") TransactionType transactionType,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("minBedrooms") Integer minBedrooms,
            @Param("maxBedrooms") Integer maxBedrooms,
            @Param("city") String city,
            Pageable pageable
    );

    List<Property> findByOwnerIdAndActiveTrue(Long ownerId);
    /*
    @Query("SELECT p FROM Property p WHERE " +
            "6371 * acos(cos(radians(:latitude)) * cos(radians(p.address.latitude)) * " +
            "cos(radians(p.address.longitude) - radians(:longitude)) + " +
            "sin(radians(:latitude)) * sin(radians(p.address.latitude))) <= :radius " +
            "AND p.active = true")
    List<Property> findPropertiesWithinRadius(
            @Param("latitude") Double latitude,
            @Param("longitude") Double longitude,
            @Param("radius") Double radius
    );
    */

}
