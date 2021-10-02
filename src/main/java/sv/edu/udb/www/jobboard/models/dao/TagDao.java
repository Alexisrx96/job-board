package sv.edu.udb.www.jobboard.models.dao;
import sv.edu.udb.www.jobboard.models.entities.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> getTags();
    Tag getTag(int id);
    void updateTag(Tag tag);
    void deleteTag(int id);
    void createTag(Tag tag);
}