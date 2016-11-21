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
import org.springframework.web.servlet.ModelAndView;

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
                .map(image -> mapper.map(image, ImageViewModel.class))
                .collect(Collectors.toList()));
        return imagesModel;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET, consumes = "application/json")
    public @ResponseBody ActualResult createImage(@RequestBody ImageCreateCommand imageCreateCommand) {
        Image createdImage = imageManager.create(imageCreateCommand);
        return ActualResultBuilder.ok(createdImage);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public ActualResult delete(@PathVariable String id) {
        Image deleted = imageManager.delete(id);
        return ActualResultBuilder.ok(deleted);
    }

}
