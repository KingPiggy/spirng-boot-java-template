package com.kingpiggy.app.api.web.dto.request;

import com.kingpiggy.app.core.persistence.entity.HelloEntity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleRequest {

    private String title;
    private String description;

    public HelloEntity toEntity() {
        return HelloEntity.builder()
                .title(this.title)
                .description(this.description)
                .build();
    }

}
