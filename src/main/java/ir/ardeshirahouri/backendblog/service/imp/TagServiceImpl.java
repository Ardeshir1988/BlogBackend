package ir.ardeshirahouri.backendblog.service.imp;


import ir.ardeshirahouri.backendblog.dto.ServiceResponse;
import ir.ardeshirahouri.backendblog.model.Tag;
import ir.ardeshirahouri.backendblog.repository.TagRepository;
import ir.ardeshirahouri.backendblog.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private TagRepository tagRepository;
    TagServiceImpl(TagRepository tagRepository)
    {this.tagRepository=tagRepository;}
    @Override
    public List<Tag> findAllTag() {
        return tagRepository.findAll();
    }

    @Override
    public ServiceResponse saveAndUpdateTag(Tag tag) {
        Tag savedTag=tagRepository.save(tag);
        if (savedTag.getTagId()!=null)
            return new ServiceResponse("saved or updated tag",savedTag);
        else
            return new ServiceResponse("failed operation",tag);
    }

    @Override
    public ServiceResponse deleteTag(Integer tagid) {
        tagRepository.deleteById(tagid);
        return new ServiceResponse("tag deleted",new Tag());
    }
}
