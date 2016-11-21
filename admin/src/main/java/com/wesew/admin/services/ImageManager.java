package com.wesew.admin.services;

import com.wesew.admin.view.command.ImageCreateCommand;
import com.wesew.admin.view.command.ImageUpdateCommand;
import com.wesew.core.Image;

import java.util.Collection;
import java.util.Set;

/**
 * @author vladyslav.yemelianov
 */
public interface ImageManager {
    Image create(ImageCreateCommand imageCreateCommand);
    Set<Image> create(Collection<ImageCreateCommand> images);
    Image update(ImageUpdateCommand image);
    Image delete(String id);
    Set<Image> getAll();
    Set<Image> getAllActive();
}
