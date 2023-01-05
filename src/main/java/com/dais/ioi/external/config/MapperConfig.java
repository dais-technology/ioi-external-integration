package com.dais.ioi.external.config;

import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequest;
import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequestDto;
import com.dais.ioi.external.domain.dto.smarty.AddressVerificationResponseDto;
import com.smartystreets.api.international_street.Candidate;
import com.smartystreets.api.us_street.Components;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Configuration
@Slf4j
@RequiredArgsConstructor
public class MapperConfig
{
    private MapperFactory mapperFactory;


    @PostConstruct
    public void postConstruct()
    {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
        this.mapperFactory.classMap( AddressVerificationRequestDto.class, AddressVerificationRequest.class )
                          .field( "address1", "street" )
                          .field( "address2", "secondary" )
                          .field( "zip", "zipcode" )
                          .byDefault()
                          .register();
        this.mapperFactory.classMap( com.smartystreets.api.us_street.Candidate.class, AddressVerificationResponseDto.class )
                          .field( "components.cityName", "city" )
                          .field( "components.state", "state" )
                          .field( "components.zipCode", "zip" )
                          .field( "metadata.countyName", "county" )
                          .customize( new CustomMapper<com.smartystreets.api.us_street.Candidate, AddressVerificationResponseDto>()
                          {
                              @Override
                              public void mapAtoB( com.smartystreets.api.us_street.Candidate api,
                                                   AddressVerificationResponseDto dto,
                                                   MappingContext context )
                              {
                                  dto.setCountry( "US" );

                                  if ( api.getAnalysis().getDpvMatchCode() == null
                                       || "N".equalsIgnoreCase( api.getAnalysis().getDpvMatchCode() ) )
                                  {
                                      dto.setFound( false );
                                      dto.setComplete( false );
                                      return;
                                  }
                                  if ( "D".equalsIgnoreCase( api.getAnalysis().getDpvMatchCode() ) )
                                  {
                                      dto.setComplete( false );
                                  }

                                  if ( StringUtils.isNotBlank( api.getAnalysis().getFootnotes() ) )
                                  {
                                      dto.setUpdated( true );
                                  }

                                  Components components = api.getComponents();
                                  dto.setAddress1( join(
                                        " ",
                                        components.getPrimaryNumber(),
                                        components.getStreetPredirection(),
                                        components.getStreetName(),
                                        components.getStreetPostdirection(),
                                        components.getStreetSuffix()
                                  ) );
                                  dto.setAddress2( join(
                                        " ",
                                        components.getExtraSecondaryDesignator(),
                                        components.getExtraSecondaryNumber(),
                                        components.getSecondaryDesignator(),
                                        components.getSecondaryNumber(),
                                        components.getPmbDesignator(),
                                        components.getPmbNumber()
                                  ) );
                                  String zip = components.getZipCode();
                                  if ( StringUtils.isNotBlank( zip ) && StringUtils.isNotBlank( components.getPlus4Code() ) )
                                  {
                                      zip = zip + "-" + components.getPlus4Code();
                                  }
                                  dto.setZip( zip );
                              }
                          } )
                          .byDefault()
                          .register();

        mapperFactory.classMap( Candidate.class, AddressVerificationResponseDto.class )
                     .field( "components.countryIso3", "country" )
                     .field( "components.locality", "city" )
                     .field( "components.administrativeArea", "state" )
                     .field( "components.postalCode", "zip" )
                     .customize( new CustomMapper<Candidate, AddressVerificationResponseDto>()
                     {
                         @Override
                         public void mapAtoB( Candidate api,
                                              AddressVerificationResponseDto dto,
                                              MappingContext context )
                         {
                             if ( api.getAnalysis().getVerificationStatus() == null || api.getAnalysis().getAddressPrecision() == null )
                             {
                                 dto.setFound( false );
                                 return;
                             }
                             switch ( api.getAnalysis().getVerificationStatus() )
                             {
                                 case "None":
                                     dto.setFound( false );
                                     break;
                                 case "Partial":
                                     dto.setComplete( false );
                                     break;
                                 case "Ambiguous":
                                     if ( !"DeliveryPoint".equals( api.getAnalysis().getAddressPrecision() ) )
                                     {
                                         dto.setComplete( false );
                                     }
                                     break;
                                 default:
                             }

                             dto.setAddress1( api.getAddress1() );
                             // The last "addressX" field has the city, state, postalCode -- so only
                             // include address2 if address3 contains that information
                             if ( StringUtils.isNotBlank( api.getAddress3() ) )
                             {
                                 dto.setAddress2( api.getAddress2() );
                             }
                         }
                     } )
                     .register();
    }



    @Bean
    @Qualifier( "mapperFacade" )
    public MapperFacade getMapper()
    {
        return mapperFactory.getMapperFacade();
    }


    private static String join( String separator,
                                String... pieces )
    {
        List<Object> toJoin = new ArrayList<>();
        for ( String piece : pieces )
        {
            if ( StringUtils.isNotBlank( piece ) )
            {
                toJoin.add( piece );
            }
        }
        return StringUtils.join( toJoin, separator );
    }
}
