package com.dais.ioi.external.domain.dto.spec;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonAutoDetect( fieldVisibility = JsonAutoDetect.Visibility.ANY )
public class HubspotTrackSpec
{
    private String portalId;

    private String apiKey;

    private String eventId;

    //TODO: This should be of type Map<String, String>
    //      Need to resolve serialization issue
    private String mappings;
}
