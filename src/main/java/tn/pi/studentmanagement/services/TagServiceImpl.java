package tn.pi.studentmanagement.services;


import org.springframework.stereotype.Service;
import tn.pi.studentmanagement.entities.Tag;
import tn.pi.studentmanagement.repositories.TagRepository;
import tn.pi.studentmanagement.tools.dtos.DtoMapper;
import tn.pi.studentmanagement.tools.dtos.request.TagRequest;
import tn.pi.studentmanagement.tools.dtos.response.TagResponse;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {


    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TagResponse> getAllTag() {
        return DtoMapper.mapListTagToDto(tagRepository.findAll());
    }

    @Override
    public TagResponse createTag(TagRequest tagRequest) {
        Tag tag = new Tag();
        tag.setLibelle(tagRequest.getLibelle());
        tagRepository.save(tag);
        return DtoMapper.mapTagToDto(tag);
    }
}
