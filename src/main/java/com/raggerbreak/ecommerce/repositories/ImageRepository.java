package com.raggerbreak.ecommerce.repositories;

import com.raggerbreak.ecommerce.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
