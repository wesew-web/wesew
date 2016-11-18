package com.wesew.admin.services;

import com.wesew.admin.view.command.ImageCreateCommand;
import com.wesew.admin.view.command.ImageUpdateCommand;

import java.util.Collection;
import java.util.Set;

/**
 * @author vladyslav.yemelianov
 */
public interface ImageManager {
    Object create(ImageCreateCommand imageCreateCommand);
    Set<Object> create(Collection<ImageCreateCommand> images);

    Object update(ImageUpdateCommand image);

    Object delete(String id);
}
