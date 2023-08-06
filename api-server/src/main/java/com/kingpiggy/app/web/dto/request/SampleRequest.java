package com.kingpiggy.app.web.dto.request;

import com.kingpiggy.app.persistence.entity.SampleEntity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleRequest {

    private String title;
    private String description;

    public SampleEntity toEntity() {
        return SampleEntity.builder()
                .title(this.title)
                .description(this.description)
                .build();
    }

}
