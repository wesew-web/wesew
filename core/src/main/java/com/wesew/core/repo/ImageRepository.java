package com.wesew.core.repo;

import com.wesew.core.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vladyslav.yemelianov
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
}
