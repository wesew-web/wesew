package com.wesew.admin.services;

import com.wesew.admin.view.command.ImageCreateCommand;
import com.wesew.core.Image;

import java.util.Collection;
import java.util.Set;

/**
 * @author vladyslav.yemelianov
 */
public interface ImageManager {
    Image create(String title, byte[] data);
    Set<Image> create(Collection<ImageCreateCommand> images);
    Image update(String id, String title);
    Image get(String id);
    Image delete(String id);
    Set<Image> getAll();
    Set<Image> getAllActive();
}
