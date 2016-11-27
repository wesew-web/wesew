package com.wesew.core.repo;

import com.wesew.core.Image;
import com.wesew.core.abs.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author vladyslav.yemelianov
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

    List<Image> findAllByStatus(StatusEntity status);
}
