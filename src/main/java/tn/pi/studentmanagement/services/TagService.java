package tn.pi.studentmanagement.services;

import tn.pi.studentmanagement.tools.dtos.request.TagRequest;
import tn.pi.studentmanagement.tools.dtos.response.TagResponse;

import java.util.List;

public interface TagService {


    public List<TagResponse> getAllTag();

    public TagResponse createTag(TagRequest tagRequest);
}
