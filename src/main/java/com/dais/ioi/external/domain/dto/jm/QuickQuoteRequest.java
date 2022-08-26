package com.dais.ioi.external.domain.dto.jm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;


@Data
@Builder
public class QuickQuoteRequest
{
    public String externalOrderNumber;

    public String county;

    public String state;

    public String postalCode;

    public ArrayList<JeweleryItem> jeweleryItems;

    public Date effectiveDate;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder

    public static class JeweleryItem
    {
        public String jeweleryType;

        public int itemValue;

        public String itemId;
    }
}





