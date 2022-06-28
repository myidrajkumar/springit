package com.rajkumar.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class Link extends Auditable {
    
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String url;
    
    @OneToMany(mappedBy = "link")
    private List<Comment> commentsList = new ArrayList<>();
    
    public void addComment(final Comment comment) {
        this.commentsList.add(comment);
    }
    
}
