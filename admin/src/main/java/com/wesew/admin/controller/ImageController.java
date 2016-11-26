package com.wesew.admin.controller;

import com.wesew.admin.services.ImageManager;
import com.wesew.admin.view.ActualResult;
import com.wesew.admin.view.ActualResultBuilder;
import com.wesew.admin.view.command.ImageCreateCommand;
import com.wesew.admin.view.model.ImageViewModel;
import com.wesew.core.Image;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author vladyslav.yemelianov
 */
@Controller
@RequestMapping(value = "/images")
public class ImageController {

    @Autowired
    private ImageManager imageManager;

    @Autowired
    private Mapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView page() {
        Set<Image> allImgs = imageManager.getAll();
        ModelAndView imagesModel = new ModelAndView("images");
        imagesModel.addObject("images", allImgs.stream()
                .map(this::map)
                .collect(Collectors.toList()));
        return imagesModel;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "multipart/form-data",produces = "application/json")
    public @ResponseBody ActualResult createImage(@RequestParam("title") String title, @RequestParam("file") MultipartFile file) throws IOException {
        Image createdImage = imageManager.create(title, file.getBytes());
        return ActualResultBuilder.ok(map(createdImage));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody ActualResult delete(@PathVariable String id) {
        Image deleted = imageManager.delete(id);
        return deleted == null ? ActualResultBuilder.error("not found") : ActualResultBuilder.ok(map(deleted));
    }

    private ImageViewModel map(Image image) {
        return mapper.map(image, ImageViewModel.class);
    }

}
