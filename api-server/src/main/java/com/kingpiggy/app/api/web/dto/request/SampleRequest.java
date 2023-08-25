package com.kingpiggy.app.api.web.dto.request;

import com.kingpiggy.app.core.persistence.entity.SampleEntity;
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
