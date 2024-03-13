package org.sid.springcloudstreamkafka.entities;

import lombok.*;

import java.util.Date;


@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class PageEvent {
    private String name;
    private String user;
    private Date date;
    private long duration;
}
