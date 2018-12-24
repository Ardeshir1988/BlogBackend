package ir.ardeshirahouri.backendblog.service;


import ir.ardeshirahouri.backendblog.dto.ServiceResponse;
import ir.ardeshirahouri.backendblog.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAllTag();
    ServiceResponse saveAndUpdateTag(Tag tag);
    ServiceResponse deleteTag(Integer tagid);
}
