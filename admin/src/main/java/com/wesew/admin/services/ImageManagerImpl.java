package com.wesew.admin.services;

import com.wesew.admin.view.command.ImageCreateCommand;
import com.wesew.admin.view.command.ImageUpdateCommand;
import com.wesew.core.Image;
import com.wesew.core.repo.ImageRepository;
import com.wesew.core.services.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author vladyslav.yemelianov
 */
@Service
public class ImageManagerImpl implements ImageManager {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private FileManager fileManager;

    @Override
    public Image create(ImageCreateCommand imageCreateCommand) {
        return null;
    }

    @Override
    public Set<Image> create(Collection<ImageCreateCommand> images) {
        return null;
    }

    @Override
    public Image update(ImageUpdateCommand image) {
        return null;
    }

    @Override
    public Image delete(String id) {
        return null;
    }

    @Override
    public Set<Image> getAll() {
        return imageRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Image> getAllActive() {
        return null;
    }
}
