package ir.ardeshirahouri.backendblog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post_tag")
public class PostTag {
    @Id
    @Column(name = "tag_id")
    private Integer TagId;
    @Column(name = "post_id")
    private Integer PostId;

}
