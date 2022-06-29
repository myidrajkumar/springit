package com.rajkumar.springboot.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import com.rajkumar.springboot.service.BeanUtil;

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
    @NotEmpty(message = "Please enter a title.")
    private String title;

    @NonNull
    @NotEmpty(message = "Please enter a url.")
    @URL(message = "Please enter a valid url.")
    private String url;
    
    @OneToMany(mappedBy = "link")
    private List<Comment> commentsList = new ArrayList<>();
    
    public void addComment(final Comment comment) {
        this.commentsList.add(comment);
    }

    public String getDomainName() throws URISyntaxException {
        final var uri = new URI(this.url);
        final var domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public String getPrettyTime() {
        final var pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(this.convertToDateViaInstant(this.getCreatedAt()));
    }

    private Date convertToDateViaInstant(final LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }
}
