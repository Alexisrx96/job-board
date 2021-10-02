package sv.edu.udb.www.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.jobboard.models.dao.TagDao;
import sv.edu.udb.www.jobboard.models.dto.TagForm;
import sv.edu.udb.www.jobboard.models.entities.Tag;

import java.util.List;

@Service
public class TagService {

    @Autowired
    TagDao tagDao;

    public List<Tag> getTags(){
        return tagDao.getTags();
    }

    public TagForm getTag(int id){
        TagForm tagForm = new TagForm();
        Tag tag = tagDao.getTag(id);
        tagForm.setId(tag.getId());
        tagForm.setName(tag.getName());
        return tagForm;
    }

    public void addTag(TagForm tagForm){
        Tag tag = new Tag();
        tag.setName(tagForm.getName());
        tagDao.createTag(tag);
    }

    public void editTag(TagForm tagForm){
        Tag tag = new Tag();
        tag.setId(tagForm.getId());
        tag.setName(tagForm.getName());
        tagDao.updateTag(tag);
    }

    public void removeTag(int id){
        tagDao.deleteTag(id);
    }
}
