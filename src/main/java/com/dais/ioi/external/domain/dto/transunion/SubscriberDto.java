package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriberDto
{
    private String industryCode;

    private String memberCode;

    private String inquirySubscriberPrefixCode;

    private String password;
}
