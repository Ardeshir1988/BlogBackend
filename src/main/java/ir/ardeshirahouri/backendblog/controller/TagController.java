package ir.ardeshirahouri.backendblog.controller;


import ir.ardeshirahouri.backendblog.model.Tag;
import ir.ardeshirahouri.backendblog.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = ResourceConstants.Blog_TAG)
public class TagController {
    private TagRepository tagRepository;
    TagController(TagRepository tagRepository){
        this.tagRepository=tagRepository;
    }

    @RequestMapping(path = "",method = RequestMethod.GET)
    public ResponseEntity<List<Tag>> getAllTags(){
        return new ResponseEntity<>(tagRepository.findAll(),HttpStatus.OK);
    }

}
