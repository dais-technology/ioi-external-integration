
package com.dais.ioi.external.domain.dto.af;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SignonRq" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SignonPswd">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CustId">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="CustPermId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="CustLoginId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="CustPswd">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="EncryptionTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Pswd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ClientDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CustLangPref" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ClientApp">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Org" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="SubmissionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InsuranceSvcRq">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RqUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="WorkCompPolicyQuoteInqRq">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="TransactionRequestDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TransactionEffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CurCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Producer">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="ItemIdInfo">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="AgencyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="GeneralPartyInfo">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="NameInfo">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="PersonName">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="ProducerInfo" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="ContractNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="ProducerSubCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="com.afg_ProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="com.afg_MarketSegment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="com.afg_PayrollVendor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="com.afg_UWREVIEW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="InsuredOrPrincipal">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="GeneralPartyInfo">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="NameInfo">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="CommlName">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="SupplementaryNameInfo" minOccurs="0">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                               &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="com.afg_LongName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Addr">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Communications">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="PhoneInfo">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="PhoneTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                     &lt;element name="CommunicationUseCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                     &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="EmailInfo">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="EmailAddr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="WebsiteInfo" minOccurs="0">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="WebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="InsuredOrPrincipalInfo" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="InsuredOrPrincipalRoleCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="BusinessInfo" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="com.afg_NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="CommlPolicy">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="NAICCd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="ControllingStateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="com.afg_TotalEmployees" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="ExpiringPremium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="TargetPremium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="ContractTerm">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="CommissionRatePct" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="OtherOrPriorPolicy" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="PolicyCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="InsurerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="ContractTerm">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="PolicyAmt">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="PaymentOption" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="PaymentPlanCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="CommlPolicySupplement">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="OperationsDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="LengthTimeInBusiness">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="NumUnits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="AuditFrequencyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="com.afg_AuditTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="LossDataAvailable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="NumberClaims" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                 &lt;element name="NumberClaims1" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                 &lt;element name="NumberClaims2" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                 &lt;element name="NumberClaims3" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                 &lt;element name="TotalClaimAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="com.afg_CompanyPolicyProcessingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="com.afg_InsuranceLineIssuingCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="com.afg_PolicyTermMonths" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="com.afg_NextLocationAssignedId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="OtherIdentifier">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Location" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="ItemIdInfo" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="InsurerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="OtherIdentifier">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Addr">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="AdditionalInterest" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="ItemIdInfo" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="OtherIdentifier">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="GeneralPartyInfo" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="NameInfo">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="CommlName">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="SupplementaryNameInfo">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                                         &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                       &lt;/sequence>
 *                                                                                     &lt;/restriction>
 *                                                                                   &lt;/complexContent>
 *                                                                                 &lt;/complexType>
 *                                                                               &lt;/element>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="TaxIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="Addr">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="Addr4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="AdditionalInterestInfo">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="NatureInterestCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="InterestRank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="ClassCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="OwnershipPct" minOccurs="0">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="NumericValue">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="ActualRemunerationAmt" minOccurs="0">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="AccountNumberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="com.afg_InterestStartDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="InterestEndDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="com.afg_ItemIdInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="OtherIdentifier">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="OtherTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="OtherId2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="NumberofDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="TaxCodeInfo" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                                                 &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="TaxTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="WorkCompLineBusiness">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="WorkCompRateState" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="ParticipatingPlanInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="AnniversaryRatingDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="LossRatio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="com.afg_PremiumDiscount" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="PremiumDiscountInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="PremiumDiscountPercentage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="MRCAPriorPolicyYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="CreditOrSurcharge" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="com.afg_CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="NumericValue">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="FormatModFactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="FormatCurrencyAmt" minOccurs="0">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                                                                     &lt;element name="com.afg_AnniversaryFactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="ModifierEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="SecondaryCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="com.afg_WorkSafeCredit" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="com.afg_BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="com.afg_WS01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="com.afg_WS02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="com.afg_WS03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="com.afg_SubName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="com.afg_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="WorkCompLocInfo" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                           &lt;element name="WorkCompRateClass" maxOccurs="unbounded" minOccurs="0">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="ActualRemunerationAmt" minOccurs="0">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                     &lt;element name="NumEmployeesFullTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                     &lt;element name="NumEmployeesPartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                     &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                     &lt;element name="RatingClassificationCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="RatingClassificationLetter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="RatingClassificationSubCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="PremiumBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                     &lt;element name="RatingClassificationDescCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                     &lt;element name="Exposure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                                     &lt;element name="RatingClassificationDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                     &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="OtherIdentifier">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                                                       &lt;/sequence>
 *                                                                                     &lt;/restriction>
 *                                                                                   &lt;/complexContent>
 *                                                                                 &lt;/complexType>
 *                                                                               &lt;/element>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="ClassCodeQuestions" minOccurs="0">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="ClassCodeQuestion" maxOccurs="unbounded" minOccurs="0">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="ResponseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                                         &lt;element name="PercentageAnswerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                                         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                                                         &lt;element name="OptionResponse" maxOccurs="unbounded" minOccurs="0">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                   &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                       &lt;/sequence>
 *                                                                                     &lt;/restriction>
 *                                                                                   &lt;/complexContent>
 *                                                                                 &lt;/complexType>
 *                                                                               &lt;/element>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="LocationRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="com.afg_Form" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="FormName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="FormDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="EditionDt" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="com.afg_ItemIdInfo" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="OtherIdentifier">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="CommlCoverage">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="CoverageCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="CoverageDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="Limit" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="FormatCurrencyAmt">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="LimitAppliesToCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Deductible" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="FormatCurrencyAmt">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="DeductibleTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="CurrentTermAmt" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Ineligibility">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Statement">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                           &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="Explanation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "signonRq",
    "insuranceSvcRq"
})
@XmlRootElement(name = "ACORD")
public class ACORD {

    @XmlElement(name = "SignonRq")
    protected ACORD.SignonRq signonRq;
    @XmlElement(name = "InsuranceSvcRq", required = true)
    protected ACORD.InsuranceSvcRq insuranceSvcRq;

    /**
     * Gets the value of the signonRq property.
     * 
     * @return
     *     possible object is
     *     {@link ACORD.SignonRq }
     *     
     */
    public ACORD.SignonRq getSignonRq() {
        return signonRq;
    }

    /**
     * Sets the value of the signonRq property.
     * 
     * @param value
     *     allowed object is
     *     {@link ACORD.SignonRq }
     *     
     */
    public void setSignonRq(ACORD.SignonRq value) {
        this.signonRq = value;
    }

    /**
     * Gets the value of the insuranceSvcRq property.
     * 
     * @return
     *     possible object is
     *     {@link ACORD.InsuranceSvcRq }
     *     
     */
    public ACORD.InsuranceSvcRq getInsuranceSvcRq() {
        return insuranceSvcRq;
    }

    /**
     * Sets the value of the insuranceSvcRq property.
     * 
     * @param value
     *     allowed object is
     *     {@link ACORD.InsuranceSvcRq }
     *     
     */
    public void setInsuranceSvcRq(ACORD.InsuranceSvcRq value) {
        this.insuranceSvcRq = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="RqUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="WorkCompPolicyQuoteInqRq">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="TransactionRequestDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TransactionEffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CurCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Producer">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="ItemIdInfo">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="AgencyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="GeneralPartyInfo">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="NameInfo">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="PersonName">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                               &lt;/sequence>
     *                                               &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="ProducerInfo" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="ContractNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="ProducerSubCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="com.afg_ProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="com.afg_MarketSegment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="com.afg_PayrollVendor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="com.afg_UWREVIEW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="InsuredOrPrincipal">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="GeneralPartyInfo">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="NameInfo">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="CommlName">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="SupplementaryNameInfo" minOccurs="0">
     *                                                             &lt;complexType>
     *                                                               &lt;complexContent>
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                   &lt;sequence>
     *                                                                     &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                                     &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                   &lt;/sequence>
     *                                                                 &lt;/restriction>
     *                                                               &lt;/complexContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="com.afg_LongName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="Addr">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="Communications">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="PhoneInfo">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="PhoneTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                           &lt;element name="CommunicationUseCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                           &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="EmailInfo">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="EmailAddr" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="WebsiteInfo" minOccurs="0">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="WebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="InsuredOrPrincipalInfo" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="InsuredOrPrincipalRoleCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="BusinessInfo" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="com.afg_NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="CommlPolicy">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                             &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="NAICCd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                             &lt;element name="ControllingStateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="com.afg_TotalEmployees" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="ExpiringPremium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="TargetPremium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="ContractTerm">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="CommissionRatePct" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="OtherOrPriorPolicy" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="PolicyCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="InsurerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="ContractTerm">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="PolicyAmt">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="PaymentOption" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="PaymentPlanCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="CommlPolicySupplement">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="OperationsDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="LengthTimeInBusiness">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="NumUnits" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="AuditFrequencyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="com.afg_AuditTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="LossDataAvailable" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="NumberClaims" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                                       &lt;element name="NumberClaims1" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                                       &lt;element name="NumberClaims2" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                                       &lt;element name="NumberClaims3" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                                       &lt;element name="TotalClaimAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="com.afg_CompanyPolicyProcessingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="com.afg_InsuranceLineIssuingCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="com.afg_PolicyTermMonths" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                             &lt;element name="com.afg_NextLocationAssignedId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="OtherIdentifier">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Location" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="ItemIdInfo" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="InsurerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                                       &lt;element name="OtherIdentifier">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="Addr">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="AdditionalInterest" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="ItemIdInfo" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="OtherIdentifier">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="GeneralPartyInfo" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="NameInfo">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="CommlName">
     *                                                             &lt;complexType>
     *                                                               &lt;complexContent>
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                   &lt;sequence>
     *                                                                     &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                     &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                     &lt;element name="SupplementaryNameInfo">
     *                                                                       &lt;complexType>
     *                                                                         &lt;complexContent>
     *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                             &lt;sequence>
     *                                                                               &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                                               &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                             &lt;/sequence>
     *                                                                           &lt;/restriction>
     *                                                                         &lt;/complexContent>
     *                                                                       &lt;/complexType>
     *                                                                     &lt;/element>
     *                                                                   &lt;/sequence>
     *                                                                 &lt;/restriction>
     *                                                               &lt;/complexContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                           &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
     *                                                             &lt;complexType>
     *                                                               &lt;complexContent>
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                   &lt;sequence>
     *                                                                     &lt;element name="TaxIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                     &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                     &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                   &lt;/sequence>
     *                                                                 &lt;/restriction>
     *                                                               &lt;/complexContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                           &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="Addr">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="Addr4" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="AdditionalInterestInfo">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="NatureInterestCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="InterestRank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="ClassCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="OwnershipPct" minOccurs="0">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="NumericValue">
     *                                                             &lt;complexType>
     *                                                               &lt;complexContent>
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                   &lt;sequence>
     *                                                                     &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                                                                   &lt;/sequence>
     *                                                                 &lt;/restriction>
     *                                                               &lt;/complexContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="ActualRemunerationAmt" minOccurs="0">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="AccountNumberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="com.afg_InterestStartDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="InterestEndDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="com.afg_ItemIdInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="OtherIdentifier">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="OtherTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="OtherId2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="NumberofDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="TaxCodeInfo" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *                                       &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="TaxTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="WorkCompLineBusiness">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="WorkCompRateState" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="ParticipatingPlanInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="AnniversaryRatingDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="LossRatio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="com.afg_PremiumDiscount" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="PremiumDiscountInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="PremiumDiscountPercentage" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="MRCAPriorPolicyYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="CreditOrSurcharge" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="com.afg_CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="NumericValue">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="FormatModFactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="FormatCurrencyAmt" minOccurs="0">
     *                                                             &lt;complexType>
     *                                                               &lt;complexContent>
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                   &lt;sequence>
     *                                                                     &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                   &lt;/sequence>
     *                                                                 &lt;/restriction>
     *                                                               &lt;/complexContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                           &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                                                           &lt;element name="com.afg_AnniversaryFactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="ModifierEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="SecondaryCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="com.afg_WorkSafeCredit" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="com.afg_BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="com.afg_WS01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="com.afg_WS02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="com.afg_WS03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="com.afg_SubName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="com.afg_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="WorkCompLocInfo" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                                                 &lt;element name="WorkCompRateClass" maxOccurs="unbounded" minOccurs="0">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="ActualRemunerationAmt" minOccurs="0">
     *                                                             &lt;complexType>
     *                                                               &lt;complexContent>
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                   &lt;sequence>
     *                                                                     &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                   &lt;/sequence>
     *                                                                 &lt;/restriction>
     *                                                               &lt;/complexContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                           &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                           &lt;element name="NumEmployeesFullTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                           &lt;element name="NumEmployeesPartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                           &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                           &lt;element name="RatingClassificationCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="RatingClassificationLetter" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="RatingClassificationSubCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="PremiumBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                           &lt;element name="RatingClassificationDescCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                           &lt;element name="Exposure" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                                                           &lt;element name="RatingClassificationDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                           &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
     *                                                             &lt;complexType>
     *                                                               &lt;complexContent>
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                   &lt;sequence>
     *                                                                     &lt;element name="OtherIdentifier">
     *                                                                       &lt;complexType>
     *                                                                         &lt;complexContent>
     *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                             &lt;sequence>
     *                                                                               &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                               &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                                                                             &lt;/sequence>
     *                                                                           &lt;/restriction>
     *                                                                         &lt;/complexContent>
     *                                                                       &lt;/complexType>
     *                                                                     &lt;/element>
     *                                                                   &lt;/sequence>
     *                                                                 &lt;/restriction>
     *                                                               &lt;/complexContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                           &lt;element name="ClassCodeQuestions" minOccurs="0">
     *                                                             &lt;complexType>
     *                                                               &lt;complexContent>
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                   &lt;sequence>
     *                                                                     &lt;element name="ClassCodeQuestion" maxOccurs="unbounded" minOccurs="0">
     *                                                                       &lt;complexType>
     *                                                                         &lt;complexContent>
     *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                             &lt;sequence>
     *                                                                               &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                               &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                               &lt;element name="ResponseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                                               &lt;element name="PercentageAnswerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                                               &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                                               &lt;element name="OptionResponse" maxOccurs="unbounded" minOccurs="0">
     *                                                                                 &lt;complexType>
     *                                                                                   &lt;complexContent>
     *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                                       &lt;sequence>
     *                                                                                         &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                                         &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                                                       &lt;/sequence>
     *                                                                                     &lt;/restriction>
     *                                                                                   &lt;/complexContent>
     *                                                                                 &lt;/complexType>
     *                                                                               &lt;/element>
     *                                                                             &lt;/sequence>
     *                                                                           &lt;/restriction>
     *                                                                         &lt;/complexContent>
     *                                                                       &lt;/complexType>
     *                                                                     &lt;/element>
     *                                                                   &lt;/sequence>
     *                                                                 &lt;/restriction>
     *                                                               &lt;/complexContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                               &lt;/sequence>
     *                                               &lt;attribute name="LocationRef" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="com.afg_Form" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="FormName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="FormDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="EditionDt" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="com.afg_ItemIdInfo" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="OtherIdentifier">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                           &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="CommlCoverage">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="CoverageCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="CoverageDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="Limit" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="FormatCurrencyAmt">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="LimitAppliesToCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="Deductible" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="FormatCurrencyAmt">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="DeductibleTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="CurrentTermAmt" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="Ineligibility">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="Statement">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                                 &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="Explanation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rqUID",
        "workCompPolicyQuoteInqRq"
    })
    public static class InsuranceSvcRq {

        @XmlElement(name = "RqUID", required = true)
        protected String rqUID;
        @XmlElement(name = "WorkCompPolicyQuoteInqRq", required = true)
        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq workCompPolicyQuoteInqRq;

        /**
         * Gets the value of the rqUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRqUID() {
            return rqUID;
        }

        /**
         * Sets the value of the rqUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRqUID(String value) {
            this.rqUID = value;
        }

        /**
         * Gets the value of the workCompPolicyQuoteInqRq property.
         * 
         * @return
         *     possible object is
         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq }
         *     
         */
        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq getWorkCompPolicyQuoteInqRq() {
            return workCompPolicyQuoteInqRq;
        }

        /**
         * Sets the value of the workCompPolicyQuoteInqRq property.
         * 
         * @param value
         *     allowed object is
         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq }
         *     
         */
        public void setWorkCompPolicyQuoteInqRq(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq value) {
            this.workCompPolicyQuoteInqRq = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="TransactionRequestDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TransactionEffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CurCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Producer">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="ItemIdInfo">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="AgencyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="GeneralPartyInfo">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="NameInfo">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="PersonName">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                     &lt;/sequence>
         *                                     &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="ProducerInfo" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="ContractNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="ProducerSubCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="com.afg_ProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="com.afg_MarketSegment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="com.afg_PayrollVendor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="com.afg_UWREVIEW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="InsuredOrPrincipal">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="GeneralPartyInfo">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="NameInfo">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="CommlName">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="SupplementaryNameInfo" minOccurs="0">
         *                                                   &lt;complexType>
         *                                                     &lt;complexContent>
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                         &lt;sequence>
         *                                                           &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                           &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                         &lt;/sequence>
         *                                                       &lt;/restriction>
         *                                                     &lt;/complexContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="com.afg_LongName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="Addr">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="Communications">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="PhoneInfo">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="PhoneTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                 &lt;element name="CommunicationUseCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                 &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="EmailInfo">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="EmailAddr" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="WebsiteInfo" minOccurs="0">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="WebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="InsuredOrPrincipalInfo" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="InsuredOrPrincipalRoleCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="BusinessInfo" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="com.afg_NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="CommlPolicy">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                   &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="NAICCd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                   &lt;element name="ControllingStateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="com.afg_TotalEmployees" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="ExpiringPremium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="TargetPremium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="ContractTerm">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="CommissionRatePct" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="OtherOrPriorPolicy" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="PolicyCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="InsurerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="ContractTerm">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="PolicyAmt">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="PaymentOption" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="PaymentPlanCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="CommlPolicySupplement">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="OperationsDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="LengthTimeInBusiness">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="NumUnits" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="AuditFrequencyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="com.afg_AuditTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="LossDataAvailable" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="NumberClaims" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                             &lt;element name="NumberClaims1" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                             &lt;element name="NumberClaims2" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                             &lt;element name="NumberClaims3" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                             &lt;element name="TotalClaimAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="com.afg_CompanyPolicyProcessingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="com.afg_InsuranceLineIssuingCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="com.afg_PolicyTermMonths" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                   &lt;element name="com.afg_NextLocationAssignedId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="OtherIdentifier">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Location" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="ItemIdInfo" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="InsurerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                             &lt;element name="OtherIdentifier">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="Addr">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="AdditionalInterest" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="ItemIdInfo" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="OtherIdentifier">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="GeneralPartyInfo" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="NameInfo">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="CommlName">
         *                                                   &lt;complexType>
         *                                                     &lt;complexContent>
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                         &lt;sequence>
         *                                                           &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                           &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                           &lt;element name="SupplementaryNameInfo">
         *                                                             &lt;complexType>
         *                                                               &lt;complexContent>
         *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                                   &lt;sequence>
         *                                                                     &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                                     &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                                   &lt;/sequence>
         *                                                                 &lt;/restriction>
         *                                                               &lt;/complexContent>
         *                                                             &lt;/complexType>
         *                                                           &lt;/element>
         *                                                         &lt;/sequence>
         *                                                       &lt;/restriction>
         *                                                     &lt;/complexContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                                 &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
         *                                                   &lt;complexType>
         *                                                     &lt;complexContent>
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                         &lt;sequence>
         *                                                           &lt;element name="TaxIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                           &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                           &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                         &lt;/sequence>
         *                                                       &lt;/restriction>
         *                                                     &lt;/complexContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                                 &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="Addr">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="Addr4" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="AdditionalInterestInfo">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="NatureInterestCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="InterestRank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="ClassCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="OwnershipPct" minOccurs="0">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="NumericValue">
         *                                                   &lt;complexType>
         *                                                     &lt;complexContent>
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                         &lt;sequence>
         *                                                           &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                                                         &lt;/sequence>
         *                                                       &lt;/restriction>
         *                                                     &lt;/complexContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="ActualRemunerationAmt" minOccurs="0">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="AccountNumberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="com.afg_InterestStartDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="InterestEndDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="com.afg_ItemIdInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="OtherIdentifier">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="OtherTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="OtherId2" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="NumberofDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="TaxCodeInfo" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence maxOccurs="unbounded" minOccurs="0">
         *                             &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="TaxTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="WorkCompLineBusiness">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="WorkCompRateState" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="ParticipatingPlanInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="AnniversaryRatingDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="LossRatio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="com.afg_PremiumDiscount" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="PremiumDiscountInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="PremiumDiscountPercentage" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="MRCAPriorPolicyYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="CreditOrSurcharge" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="com.afg_CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="NumericValue">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="FormatModFactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="FormatCurrencyAmt" minOccurs="0">
         *                                                   &lt;complexType>
         *                                                     &lt;complexContent>
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                         &lt;sequence>
         *                                                           &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                         &lt;/sequence>
         *                                                       &lt;/restriction>
         *                                                     &lt;/complexContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                                 &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *                                                 &lt;element name="com.afg_AnniversaryFactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="ModifierEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="SecondaryCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="com.afg_WorkSafeCredit" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="com.afg_BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="com.afg_WS01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="com.afg_WS02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="com.afg_WS03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="com.afg_SubName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="com.afg_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="WorkCompLocInfo" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                                       &lt;element name="WorkCompRateClass" maxOccurs="unbounded" minOccurs="0">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="ActualRemunerationAmt" minOccurs="0">
         *                                                   &lt;complexType>
         *                                                     &lt;complexContent>
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                         &lt;sequence>
         *                                                           &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                         &lt;/sequence>
         *                                                       &lt;/restriction>
         *                                                     &lt;/complexContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                                 &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                 &lt;element name="NumEmployeesFullTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                 &lt;element name="NumEmployeesPartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                 &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                 &lt;element name="RatingClassificationCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="RatingClassificationLetter" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="RatingClassificationSubCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="PremiumBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                 &lt;element name="RatingClassificationDescCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                 &lt;element name="Exposure" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                                                 &lt;element name="RatingClassificationDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                 &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
         *                                                   &lt;complexType>
         *                                                     &lt;complexContent>
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                         &lt;sequence>
         *                                                           &lt;element name="OtherIdentifier">
         *                                                             &lt;complexType>
         *                                                               &lt;complexContent>
         *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                                   &lt;sequence>
         *                                                                     &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                                     &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                                                                   &lt;/sequence>
         *                                                                 &lt;/restriction>
         *                                                               &lt;/complexContent>
         *                                                             &lt;/complexType>
         *                                                           &lt;/element>
         *                                                         &lt;/sequence>
         *                                                       &lt;/restriction>
         *                                                     &lt;/complexContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                                 &lt;element name="ClassCodeQuestions" minOccurs="0">
         *                                                   &lt;complexType>
         *                                                     &lt;complexContent>
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                         &lt;sequence>
         *                                                           &lt;element name="ClassCodeQuestion" maxOccurs="unbounded" minOccurs="0">
         *                                                             &lt;complexType>
         *                                                               &lt;complexContent>
         *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                                   &lt;sequence>
         *                                                                     &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                                     &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                                     &lt;element name="ResponseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                                     &lt;element name="PercentageAnswerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                                     &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                                                     &lt;element name="OptionResponse" maxOccurs="unbounded" minOccurs="0">
         *                                                                       &lt;complexType>
         *                                                                         &lt;complexContent>
         *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                                             &lt;sequence>
         *                                                                               &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                                               &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                                             &lt;/sequence>
         *                                                                           &lt;/restriction>
         *                                                                         &lt;/complexContent>
         *                                                                       &lt;/complexType>
         *                                                                     &lt;/element>
         *                                                                   &lt;/sequence>
         *                                                                 &lt;/restriction>
         *                                                               &lt;/complexContent>
         *                                                             &lt;/complexType>
         *                                                           &lt;/element>
         *                                                         &lt;/sequence>
         *                                                       &lt;/restriction>
         *                                                     &lt;/complexContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                     &lt;/sequence>
         *                                     &lt;attribute name="LocationRef" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="com.afg_Form" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="FormName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="FormDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="EditionDt" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="com.afg_ItemIdInfo" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="OtherIdentifier">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                                 &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="CommlCoverage">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="CoverageCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="CoverageDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="Limit" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="FormatCurrencyAmt">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="LimitAppliesToCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="Deductible" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="FormatCurrencyAmt">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="DeductibleTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="CurrentTermAmt" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="Ineligibility">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="Statement">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                       &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="Explanation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "transactionRequestDt",
            "transactionEffectiveDt",
            "curCd",
            "producer",
            "insuredOrPrincipal",
            "commlPolicy",
            "location",
            "workCompLineBusiness"
        })
        public static class WorkCompPolicyQuoteInqRq {

            @XmlElement(name = "TransactionRequestDt")
            protected String transactionRequestDt;
            @XmlElement(name = "TransactionEffectiveDt")
            protected String transactionEffectiveDt;
            @XmlElement(name = "CurCd")
            protected String curCd;
            @XmlElement(name = "Producer", required = true)
            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer producer;
            @XmlElement(name = "InsuredOrPrincipal", required = true)
            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal insuredOrPrincipal;
            @XmlElement(name = "CommlPolicy", required = true)
            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy commlPolicy;
            @XmlElement(name = "Location")
            protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location> location;
            @XmlElement(name = "WorkCompLineBusiness", required = true)
            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness workCompLineBusiness;

            /**
             * Gets the value of the transactionRequestDt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransactionRequestDt() {
                return transactionRequestDt;
            }

            /**
             * Sets the value of the transactionRequestDt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransactionRequestDt(String value) {
                this.transactionRequestDt = value;
            }

            /**
             * Gets the value of the transactionEffectiveDt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransactionEffectiveDt() {
                return transactionEffectiveDt;
            }

            /**
             * Sets the value of the transactionEffectiveDt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransactionEffectiveDt(String value) {
                this.transactionEffectiveDt = value;
            }

            /**
             * Gets the value of the curCd property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCurCd() {
                return curCd;
            }

            /**
             * Sets the value of the curCd property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCurCd(String value) {
                this.curCd = value;
            }

            /**
             * Gets the value of the producer property.
             * 
             * @return
             *     possible object is
             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer }
             *     
             */
            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer getProducer() {
                return producer;
            }

            /**
             * Sets the value of the producer property.
             * 
             * @param value
             *     allowed object is
             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer }
             *     
             */
            public void setProducer(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer value) {
                this.producer = value;
            }

            /**
             * Gets the value of the insuredOrPrincipal property.
             * 
             * @return
             *     possible object is
             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal }
             *     
             */
            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal getInsuredOrPrincipal() {
                return insuredOrPrincipal;
            }

            /**
             * Sets the value of the insuredOrPrincipal property.
             * 
             * @param value
             *     allowed object is
             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal }
             *     
             */
            public void setInsuredOrPrincipal(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal value) {
                this.insuredOrPrincipal = value;
            }

            /**
             * Gets the value of the commlPolicy property.
             * 
             * @return
             *     possible object is
             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy }
             *     
             */
            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy getCommlPolicy() {
                return commlPolicy;
            }

            /**
             * Sets the value of the commlPolicy property.
             * 
             * @param value
             *     allowed object is
             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy }
             *     
             */
            public void setCommlPolicy(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy value) {
                this.commlPolicy = value;
            }

            /**
             * Gets the value of the location property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the location property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLocation().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location }
             * 
             * 
             */
            public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location> getLocation() {
                if (location == null) {
                    location = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location>();
                }
                return this.location;
            }

            /**
             * Gets the value of the workCompLineBusiness property.
             * 
             * @return
             *     possible object is
             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness }
             *     
             */
            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness getWorkCompLineBusiness() {
                return workCompLineBusiness;
            }

            /**
             * Sets the value of the workCompLineBusiness property.
             * 
             * @param value
             *     allowed object is
             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness }
             *     
             */
            public void setWorkCompLineBusiness(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness value) {
                this.workCompLineBusiness = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *         &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="NAICCd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *         &lt;element name="ControllingStateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="com.afg_TotalEmployees" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="ExpiringPremium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="TargetPremium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="ContractTerm">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="CommissionRatePct" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="OtherOrPriorPolicy" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="PolicyCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="InsurerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="ContractTerm">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="PolicyAmt">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="PaymentOption" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="PaymentPlanCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="CommlPolicySupplement">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="OperationsDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="LengthTimeInBusiness">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="NumUnits" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="AuditFrequencyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="com.afg_AuditTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="LossDataAvailable" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="NumberClaims" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *                   &lt;element name="NumberClaims1" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *                   &lt;element name="NumberClaims2" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *                   &lt;element name="NumberClaims3" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *                   &lt;element name="TotalClaimAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="com.afg_CompanyPolicyProcessingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="com.afg_InsuranceLineIssuingCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="com.afg_PolicyTermMonths" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *         &lt;element name="com.afg_NextLocationAssignedId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="OtherIdentifier">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "policyNumber",
                "lobCd",
                "naicCd",
                "controllingStateProvCd",
                "comAfgTotalEmployees",
                "expiringPremium",
                "targetPremium",
                "contractTerm",
                "commissionRatePct",
                "otherOrPriorPolicy",
                "paymentOption",
                "commlPolicySupplement",
                "comAfgCompanyPolicyProcessingId",
                "comAfgInsuranceLineIssuingCompany",
                "comAfgPolicyTermMonths",
                "comAfgNextLocationAssignedId",
                "comAfgItemIdInfo"
            })
            public static class CommlPolicy {

                @XmlElement(name = "PolicyNumber")
                protected Integer policyNumber;
                @XmlElement(name = "LOBCd")
                protected String lobCd;
                @XmlElement(name = "NAICCd")
                protected Integer naicCd;
                @XmlElement(name = "ControllingStateProvCd", required = true)
                protected String controllingStateProvCd;
                @XmlElement(name = "com.afg_TotalEmployees")
                protected int comAfgTotalEmployees;
                @XmlElement(name = "ExpiringPremium")
                protected String expiringPremium;
                @XmlElement(name = "TargetPremium")
                protected String targetPremium;
                @XmlElement(name = "ContractTerm", required = true)
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ContractTerm contractTerm;
                @XmlElement(name = "CommissionRatePct")
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommissionRatePct commissionRatePct;
                @XmlElement(name = "OtherOrPriorPolicy")
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy otherOrPriorPolicy;
                @XmlElement(name = "PaymentOption")
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.PaymentOption paymentOption;
                @XmlElement(name = "CommlPolicySupplement", required = true)
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement commlPolicySupplement;
                @XmlElement(name = "com.afg_CompanyPolicyProcessingId")
                protected String comAfgCompanyPolicyProcessingId;
                @XmlElement(name = "com.afg_InsuranceLineIssuingCompany")
                protected String comAfgInsuranceLineIssuingCompany;
                @XmlElement(name = "com.afg_PolicyTermMonths")
                protected Integer comAfgPolicyTermMonths;
                @XmlElement(name = "com.afg_NextLocationAssignedId")
                protected String comAfgNextLocationAssignedId;
                @XmlElement(name = "com.afg_ItemIdInfo")
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo comAfgItemIdInfo;

                /**
                 * Gets the value of the policyNumber property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getPolicyNumber() {
                    return policyNumber;
                }

                /**
                 * Sets the value of the policyNumber property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setPolicyNumber(Integer value) {
                    this.policyNumber = value;
                }

                /**
                 * Gets the value of the lobCd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLOBCd() {
                    return lobCd;
                }

                /**
                 * Sets the value of the lobCd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLOBCd(String value) {
                    this.lobCd = value;
                }

                /**
                 * Gets the value of the naicCd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getNAICCd() {
                    return naicCd;
                }

                /**
                 * Sets the value of the naicCd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setNAICCd(Integer value) {
                    this.naicCd = value;
                }

                /**
                 * Gets the value of the controllingStateProvCd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getControllingStateProvCd() {
                    return controllingStateProvCd;
                }

                /**
                 * Sets the value of the controllingStateProvCd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setControllingStateProvCd(String value) {
                    this.controllingStateProvCd = value;
                }

                /**
                 * Gets the value of the comAfgTotalEmployees property.
                 * 
                 */
                public int getComAfgTotalEmployees() {
                    return comAfgTotalEmployees;
                }

                /**
                 * Sets the value of the comAfgTotalEmployees property.
                 * 
                 */
                public void setComAfgTotalEmployees(int value) {
                    this.comAfgTotalEmployees = value;
                }

                /**
                 * Gets the value of the expiringPremium property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getExpiringPremium() {
                    return expiringPremium;
                }

                /**
                 * Sets the value of the expiringPremium property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setExpiringPremium(String value) {
                    this.expiringPremium = value;
                }

                /**
                 * Gets the value of the targetPremium property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTargetPremium() {
                    return targetPremium;
                }

                /**
                 * Sets the value of the targetPremium property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTargetPremium(String value) {
                    this.targetPremium = value;
                }

                /**
                 * Gets the value of the contractTerm property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ContractTerm }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ContractTerm getContractTerm() {
                    return contractTerm;
                }

                /**
                 * Sets the value of the contractTerm property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ContractTerm }
                 *     
                 */
                public void setContractTerm(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ContractTerm value) {
                    this.contractTerm = value;
                }

                /**
                 * Gets the value of the commissionRatePct property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommissionRatePct }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommissionRatePct getCommissionRatePct() {
                    return commissionRatePct;
                }

                /**
                 * Sets the value of the commissionRatePct property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommissionRatePct }
                 *     
                 */
                public void setCommissionRatePct(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommissionRatePct value) {
                    this.commissionRatePct = value;
                }

                /**
                 * Gets the value of the otherOrPriorPolicy property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy getOtherOrPriorPolicy() {
                    return otherOrPriorPolicy;
                }

                /**
                 * Sets the value of the otherOrPriorPolicy property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy }
                 *     
                 */
                public void setOtherOrPriorPolicy(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy value) {
                    this.otherOrPriorPolicy = value;
                }

                /**
                 * Gets the value of the paymentOption property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.PaymentOption }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.PaymentOption getPaymentOption() {
                    return paymentOption;
                }

                /**
                 * Sets the value of the paymentOption property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.PaymentOption }
                 *     
                 */
                public void setPaymentOption(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.PaymentOption value) {
                    this.paymentOption = value;
                }

                /**
                 * Gets the value of the commlPolicySupplement property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement getCommlPolicySupplement() {
                    return commlPolicySupplement;
                }

                /**
                 * Sets the value of the commlPolicySupplement property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement }
                 *     
                 */
                public void setCommlPolicySupplement(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement value) {
                    this.commlPolicySupplement = value;
                }

                /**
                 * Gets the value of the comAfgCompanyPolicyProcessingId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getComAfgCompanyPolicyProcessingId() {
                    return comAfgCompanyPolicyProcessingId;
                }

                /**
                 * Sets the value of the comAfgCompanyPolicyProcessingId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setComAfgCompanyPolicyProcessingId(String value) {
                    this.comAfgCompanyPolicyProcessingId = value;
                }

                /**
                 * Gets the value of the comAfgInsuranceLineIssuingCompany property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getComAfgInsuranceLineIssuingCompany() {
                    return comAfgInsuranceLineIssuingCompany;
                }

                /**
                 * Sets the value of the comAfgInsuranceLineIssuingCompany property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setComAfgInsuranceLineIssuingCompany(String value) {
                    this.comAfgInsuranceLineIssuingCompany = value;
                }

                /**
                 * Gets the value of the comAfgPolicyTermMonths property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getComAfgPolicyTermMonths() {
                    return comAfgPolicyTermMonths;
                }

                /**
                 * Sets the value of the comAfgPolicyTermMonths property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setComAfgPolicyTermMonths(Integer value) {
                    this.comAfgPolicyTermMonths = value;
                }

                /**
                 * Gets the value of the comAfgNextLocationAssignedId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getComAfgNextLocationAssignedId() {
                    return comAfgNextLocationAssignedId;
                }

                /**
                 * Sets the value of the comAfgNextLocationAssignedId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setComAfgNextLocationAssignedId(String value) {
                    this.comAfgNextLocationAssignedId = value;
                }

                /**
                 * Gets the value of the comAfgItemIdInfo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo getComAfgItemIdInfo() {
                    return comAfgItemIdInfo;
                }

                /**
                 * Sets the value of the comAfgItemIdInfo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo }
                 *     
                 */
                public void setComAfgItemIdInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo value) {
                    this.comAfgItemIdInfo = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="OtherIdentifier">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "otherIdentifier"
                })
                public static class ComAfgItemIdInfo {

                    @XmlElement(name = "OtherIdentifier", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo.OtherIdentifier otherIdentifier;

                    /**
                     * Gets the value of the otherIdentifier property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo.OtherIdentifier }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo.OtherIdentifier getOtherIdentifier() {
                        return otherIdentifier;
                    }

                    /**
                     * Sets the value of the otherIdentifier property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo.OtherIdentifier }
                     *     
                     */
                    public void setOtherIdentifier(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.ComAfgItemIdInfo.OtherIdentifier value) {
                        this.otherIdentifier = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "otherIdTypeCd",
                        "otherId"
                    })
                    public static class OtherIdentifier {

                        @XmlElement(name = "OtherIdTypeCd", required = true)
                        protected String otherIdTypeCd;
                        @XmlElement(name = "OtherId", required = true)
                        protected String otherId;

                        /**
                         * Gets the value of the otherIdTypeCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getOtherIdTypeCd() {
                            return otherIdTypeCd;
                        }

                        /**
                         * Sets the value of the otherIdTypeCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setOtherIdTypeCd(String value) {
                            this.otherIdTypeCd = value;
                        }

                        /**
                         * Gets the value of the otherId property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getOtherId() {
                            return otherId;
                        }

                        /**
                         * Sets the value of the otherId property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setOtherId(String value) {
                            this.otherId = value;
                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "amt"
                })
                public static class CommissionRatePct {

                    @XmlElement(name = "Amt", required = true)
                    protected String amt;

                    /**
                     * Gets the value of the amt property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAmt() {
                        return amt;
                    }

                    /**
                     * Sets the value of the amt property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAmt(String value) {
                        this.amt = value;
                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="OperationsDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="LengthTimeInBusiness">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="NumUnits" type="{http://www.w3.org/2001/XMLSchema}int"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="AuditFrequencyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="com.afg_AuditTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="LossDataAvailable" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="NumberClaims" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
                 *         &lt;element name="NumberClaims1" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
                 *         &lt;element name="NumberClaims2" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
                 *         &lt;element name="NumberClaims3" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
                 *         &lt;element name="TotalClaimAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "operationsDesc",
                    "lengthTimeInBusiness",
                    "auditFrequencyCd",
                    "comAfgAuditTypeCd",
                    "lossDataAvailable",
                    "numberClaims",
                    "numberClaims1",
                    "numberClaims2",
                    "numberClaims3",
                    "totalClaimAmount"
                })
                public static class CommlPolicySupplement {

                    @XmlElement(name = "OperationsDesc", required = true)
                    protected String operationsDesc;
                    @XmlElement(name = "LengthTimeInBusiness", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement.LengthTimeInBusiness lengthTimeInBusiness;
                    @XmlElement(name = "AuditFrequencyCd")
                    protected String auditFrequencyCd;
                    @XmlElement(name = "com.afg_AuditTypeCd")
                    protected String comAfgAuditTypeCd;
                    @XmlElement(name = "LossDataAvailable", required = true)
                    protected String lossDataAvailable;
                    @XmlElement(name = "NumberClaims")
                    protected Integer numberClaims;
                    @XmlElement(name = "NumberClaims1")
                    protected Integer numberClaims1;
                    @XmlElement(name = "NumberClaims2")
                    protected Integer numberClaims2;
                    @XmlElement(name = "NumberClaims3")
                    protected Integer numberClaims3;
                    @XmlElement(name = "TotalClaimAmount")
                    protected Float totalClaimAmount;

                    /**
                     * Gets the value of the operationsDesc property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getOperationsDesc() {
                        return operationsDesc;
                    }

                    /**
                     * Sets the value of the operationsDesc property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setOperationsDesc(String value) {
                        this.operationsDesc = value;
                    }

                    /**
                     * Gets the value of the lengthTimeInBusiness property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement.LengthTimeInBusiness }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement.LengthTimeInBusiness getLengthTimeInBusiness() {
                        return lengthTimeInBusiness;
                    }

                    /**
                     * Sets the value of the lengthTimeInBusiness property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement.LengthTimeInBusiness }
                     *     
                     */
                    public void setLengthTimeInBusiness(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.CommlPolicySupplement.LengthTimeInBusiness value) {
                        this.lengthTimeInBusiness = value;
                    }

                    /**
                     * Gets the value of the auditFrequencyCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAuditFrequencyCd() {
                        return auditFrequencyCd;
                    }

                    /**
                     * Sets the value of the auditFrequencyCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAuditFrequencyCd(String value) {
                        this.auditFrequencyCd = value;
                    }

                    /**
                     * Gets the value of the comAfgAuditTypeCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getComAfgAuditTypeCd() {
                        return comAfgAuditTypeCd;
                    }

                    /**
                     * Sets the value of the comAfgAuditTypeCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setComAfgAuditTypeCd(String value) {
                        this.comAfgAuditTypeCd = value;
                    }

                    /**
                     * Gets the value of the lossDataAvailable property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getLossDataAvailable() {
                        return lossDataAvailable;
                    }

                    /**
                     * Sets the value of the lossDataAvailable property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setLossDataAvailable(String value) {
                        this.lossDataAvailable = value;
                    }

                    /**
                     * Gets the value of the numberClaims property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Integer }
                     *     
                     */
                    public Integer getNumberClaims() {
                        return numberClaims;
                    }

                    /**
                     * Sets the value of the numberClaims property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Integer }
                     *     
                     */
                    public void setNumberClaims(Integer value) {
                        this.numberClaims = value;
                    }

                    /**
                     * Gets the value of the numberClaims1 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Integer }
                     *     
                     */
                    public Integer getNumberClaims1() {
                        return numberClaims1;
                    }

                    /**
                     * Sets the value of the numberClaims1 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Integer }
                     *     
                     */
                    public void setNumberClaims1(Integer value) {
                        this.numberClaims1 = value;
                    }

                    /**
                     * Gets the value of the numberClaims2 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Integer }
                     *     
                     */
                    public Integer getNumberClaims2() {
                        return numberClaims2;
                    }

                    /**
                     * Sets the value of the numberClaims2 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Integer }
                     *     
                     */
                    public void setNumberClaims2(Integer value) {
                        this.numberClaims2 = value;
                    }

                    /**
                     * Gets the value of the numberClaims3 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Integer }
                     *     
                     */
                    public Integer getNumberClaims3() {
                        return numberClaims3;
                    }

                    /**
                     * Sets the value of the numberClaims3 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Integer }
                     *     
                     */
                    public void setNumberClaims3(Integer value) {
                        this.numberClaims3 = value;
                    }

                    /**
                     * Gets the value of the totalClaimAmount property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Float }
                     *     
                     */
                    public Float getTotalClaimAmount() {
                        return totalClaimAmount;
                    }

                    /**
                     * Sets the value of the totalClaimAmount property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Float }
                     *     
                     */
                    public void setTotalClaimAmount(Float value) {
                        this.totalClaimAmount = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="NumUnits" type="{http://www.w3.org/2001/XMLSchema}int"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "numUnits"
                    })
                    public static class LengthTimeInBusiness {

                        @XmlElement(name = "NumUnits")
                        protected int numUnits;

                        /**
                         * Gets the value of the numUnits property.
                         * 
                         */
                        public int getNumUnits() {
                            return numUnits;
                        }

                        /**
                         * Sets the value of the numUnits property.
                         * 
                         */
                        public void setNumUnits(int value) {
                            this.numUnits = value;
                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "effectiveDt",
                    "expirationDt"
                })
                public static class ContractTerm {

                    @XmlElement(name = "EffectiveDt", required = true)
                    protected String effectiveDt;
                    @XmlElement(name = "ExpirationDt", required = true)
                    protected String expirationDt;

                    /**
                     * Gets the value of the effectiveDt property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getEffectiveDt() {
                        return effectiveDt;
                    }

                    /**
                     * Sets the value of the effectiveDt property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setEffectiveDt(String value) {
                        this.effectiveDt = value;
                    }

                    /**
                     * Gets the value of the expirationDt property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getExpirationDt() {
                        return expirationDt;
                    }

                    /**
                     * Sets the value of the expirationDt property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setExpirationDt(String value) {
                        this.expirationDt = value;
                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="PolicyCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="InsurerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="ContractTerm">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="PolicyAmt">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "policyCd",
                    "policyNumber",
                    "lobCd",
                    "insurerName",
                    "contractTerm",
                    "policyAmt"
                })
                public static class OtherOrPriorPolicy {

                    @XmlElement(name = "PolicyCd", required = true)
                    protected String policyCd;
                    @XmlElement(name = "PolicyNumber", required = true)
                    protected String policyNumber;
                    @XmlElement(name = "LOBCd", required = true)
                    protected String lobCd;
                    @XmlElement(name = "InsurerName", required = true)
                    protected String insurerName;
                    @XmlElement(name = "ContractTerm", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.ContractTerm contractTerm;
                    @XmlElement(name = "PolicyAmt", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.PolicyAmt policyAmt;

                    /**
                     * Gets the value of the policyCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPolicyCd() {
                        return policyCd;
                    }

                    /**
                     * Sets the value of the policyCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPolicyCd(String value) {
                        this.policyCd = value;
                    }

                    /**
                     * Gets the value of the policyNumber property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPolicyNumber() {
                        return policyNumber;
                    }

                    /**
                     * Sets the value of the policyNumber property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPolicyNumber(String value) {
                        this.policyNumber = value;
                    }

                    /**
                     * Gets the value of the lobCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getLOBCd() {
                        return lobCd;
                    }

                    /**
                     * Sets the value of the lobCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setLOBCd(String value) {
                        this.lobCd = value;
                    }

                    /**
                     * Gets the value of the insurerName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getInsurerName() {
                        return insurerName;
                    }

                    /**
                     * Sets the value of the insurerName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setInsurerName(String value) {
                        this.insurerName = value;
                    }

                    /**
                     * Gets the value of the contractTerm property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.ContractTerm }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.ContractTerm getContractTerm() {
                        return contractTerm;
                    }

                    /**
                     * Sets the value of the contractTerm property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.ContractTerm }
                     *     
                     */
                    public void setContractTerm(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.ContractTerm value) {
                        this.contractTerm = value;
                    }

                    /**
                     * Gets the value of the policyAmt property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.PolicyAmt }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.PolicyAmt getPolicyAmt() {
                        return policyAmt;
                    }

                    /**
                     * Sets the value of the policyAmt property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.PolicyAmt }
                     *     
                     */
                    public void setPolicyAmt(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.CommlPolicy.OtherOrPriorPolicy.PolicyAmt value) {
                        this.policyAmt = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="EffectiveDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="ExpirationDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "effectiveDt",
                        "expirationDt"
                    })
                    public static class ContractTerm {

                        @XmlElement(name = "EffectiveDt", required = true)
                        protected String effectiveDt;
                        @XmlElement(name = "ExpirationDt", required = true)
                        protected String expirationDt;

                        /**
                         * Gets the value of the effectiveDt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getEffectiveDt() {
                            return effectiveDt;
                        }

                        /**
                         * Sets the value of the effectiveDt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setEffectiveDt(String value) {
                            this.effectiveDt = value;
                        }

                        /**
                         * Gets the value of the expirationDt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getExpirationDt() {
                            return expirationDt;
                        }

                        /**
                         * Sets the value of the expirationDt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setExpirationDt(String value) {
                            this.expirationDt = value;
                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "amt"
                    })
                    public static class PolicyAmt {

                        @XmlElement(name = "Amt", required = true)
                        protected String amt;

                        /**
                         * Gets the value of the amt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAmt() {
                            return amt;
                        }

                        /**
                         * Sets the value of the amt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAmt(String value) {
                            this.amt = value;
                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="PaymentPlanCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "paymentPlanCd"
                })
                public static class PaymentOption {

                    @XmlElement(name = "PaymentPlanCd", required = true)
                    protected String paymentPlanCd;

                    /**
                     * Gets the value of the paymentPlanCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPaymentPlanCd() {
                        return paymentPlanCd;
                    }

                    /**
                     * Sets the value of the paymentPlanCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPaymentPlanCd(String value) {
                        this.paymentPlanCd = value;
                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="GeneralPartyInfo">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="NameInfo">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="CommlName">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="SupplementaryNameInfo" minOccurs="0">
             *                                         &lt;complexType>
             *                                           &lt;complexContent>
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                               &lt;sequence>
             *                                                 &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                                 &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                               &lt;/sequence>
             *                                             &lt;/restriction>
             *                                           &lt;/complexContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="com.afg_LongName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="Addr">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="Communications">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="PhoneInfo">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="PhoneTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                       &lt;element name="CommunicationUseCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                       &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="EmailInfo">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="EmailAddr" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="WebsiteInfo" minOccurs="0">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="WebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="InsuredOrPrincipalInfo" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="InsuredOrPrincipalRoleCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="BusinessInfo" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="com.afg_NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "generalPartyInfo",
                "insuredOrPrincipalInfo"
            })
            public static class InsuredOrPrincipal {

                @XmlElement(name = "GeneralPartyInfo", required = true)
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo generalPartyInfo;
                @XmlElement(name = "InsuredOrPrincipalInfo")
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo insuredOrPrincipalInfo;
                @XmlAttribute(name = "id")
                protected String id;

                /**
                 * Gets the value of the generalPartyInfo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo getGeneralPartyInfo() {
                    return generalPartyInfo;
                }

                /**
                 * Sets the value of the generalPartyInfo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo }
                 *     
                 */
                public void setGeneralPartyInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo value) {
                    this.generalPartyInfo = value;
                }

                /**
                 * Gets the value of the insuredOrPrincipalInfo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo getInsuredOrPrincipalInfo() {
                    return insuredOrPrincipalInfo;
                }

                /**
                 * Sets the value of the insuredOrPrincipalInfo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo }
                 *     
                 */
                public void setInsuredOrPrincipalInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo value) {
                    this.insuredOrPrincipalInfo = value;
                }

                /**
                 * Gets the value of the id property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getId() {
                    return id;
                }

                /**
                 * Sets the value of the id property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setId(String value) {
                    this.id = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="NameInfo">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="CommlName">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="SupplementaryNameInfo" minOccurs="0">
                 *                               &lt;complexType>
                 *                                 &lt;complexContent>
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                     &lt;sequence>
                 *                                       &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                                       &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                     &lt;/sequence>
                 *                                   &lt;/restriction>
                 *                                 &lt;/complexContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="com.afg_LongName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="Addr">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="Communications">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="PhoneInfo">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="PhoneTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                             &lt;element name="CommunicationUseCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                             &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="EmailInfo">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="EmailAddr" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="WebsiteInfo" minOccurs="0">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="WebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "nameInfo",
                    "addr",
                    "communications"
                })
                public static class GeneralPartyInfo {

                    @XmlElement(name = "NameInfo", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo nameInfo;
                    @XmlElement(name = "Addr", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Addr addr;
                    @XmlElement(name = "Communications", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications communications;

                    /**
                     * Gets the value of the nameInfo property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo getNameInfo() {
                        return nameInfo;
                    }

                    /**
                     * Sets the value of the nameInfo property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo }
                     *     
                     */
                    public void setNameInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo value) {
                        this.nameInfo = value;
                    }

                    /**
                     * Gets the value of the addr property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Addr }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Addr getAddr() {
                        return addr;
                    }

                    /**
                     * Sets the value of the addr property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Addr }
                     *     
                     */
                    public void setAddr(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Addr value) {
                        this.addr = value;
                    }

                    /**
                     * Gets the value of the communications property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications getCommunications() {
                        return communications;
                    }

                    /**
                     * Sets the value of the communications property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications }
                     *     
                     */
                    public void setCommunications(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications value) {
                        this.communications = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "addrTypeCd",
                        "addr1",
                        "addr2",
                        "city",
                        "stateProvCd",
                        "postalCode",
                        "countryCd",
                        "county"
                    })
                    public static class Addr {

                        @XmlElement(name = "AddrTypeCd")
                        protected String addrTypeCd;
                        @XmlElement(name = "Addr1", required = true)
                        protected String addr1;
                        @XmlElement(name = "Addr2")
                        protected String addr2;
                        @XmlElement(name = "City", required = true)
                        protected String city;
                        @XmlElement(name = "StateProvCd", required = true)
                        protected String stateProvCd;
                        @XmlElement(name = "PostalCode", required = true)
                        protected String postalCode;
                        @XmlElement(name = "CountryCd", required = true)
                        protected String countryCd;
                        @XmlElement(name = "County")
                        protected String county;

                        /**
                         * Gets the value of the addrTypeCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAddrTypeCd() {
                            return addrTypeCd;
                        }

                        /**
                         * Sets the value of the addrTypeCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAddrTypeCd(String value) {
                            this.addrTypeCd = value;
                        }

                        /**
                         * Gets the value of the addr1 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAddr1() {
                            return addr1;
                        }

                        /**
                         * Sets the value of the addr1 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAddr1(String value) {
                            this.addr1 = value;
                        }

                        /**
                         * Gets the value of the addr2 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAddr2() {
                            return addr2;
                        }

                        /**
                         * Sets the value of the addr2 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAddr2(String value) {
                            this.addr2 = value;
                        }

                        /**
                         * Gets the value of the city property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCity() {
                            return city;
                        }

                        /**
                         * Sets the value of the city property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCity(String value) {
                            this.city = value;
                        }

                        /**
                         * Gets the value of the stateProvCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getStateProvCd() {
                            return stateProvCd;
                        }

                        /**
                         * Sets the value of the stateProvCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setStateProvCd(String value) {
                            this.stateProvCd = value;
                        }

                        /**
                         * Gets the value of the postalCode property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getPostalCode() {
                            return postalCode;
                        }

                        /**
                         * Sets the value of the postalCode property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setPostalCode(String value) {
                            this.postalCode = value;
                        }

                        /**
                         * Gets the value of the countryCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCountryCd() {
                            return countryCd;
                        }

                        /**
                         * Sets the value of the countryCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCountryCd(String value) {
                            this.countryCd = value;
                        }

                        /**
                         * Gets the value of the county property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCounty() {
                            return county;
                        }

                        /**
                         * Sets the value of the county property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCounty(String value) {
                            this.county = value;
                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="PhoneInfo">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="PhoneTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                   &lt;element name="CommunicationUseCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                   &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="EmailInfo">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="EmailAddr" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="WebsiteInfo" minOccurs="0">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="WebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "phoneInfo",
                        "emailInfo",
                        "websiteInfo"
                    })
                    public static class Communications {

                        @XmlElement(name = "PhoneInfo", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.PhoneInfo phoneInfo;
                        @XmlElement(name = "EmailInfo", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.EmailInfo emailInfo;
                        @XmlElement(name = "WebsiteInfo")
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.WebsiteInfo websiteInfo;

                        /**
                         * Gets the value of the phoneInfo property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.PhoneInfo }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.PhoneInfo getPhoneInfo() {
                            return phoneInfo;
                        }

                        /**
                         * Sets the value of the phoneInfo property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.PhoneInfo }
                         *     
                         */
                        public void setPhoneInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.PhoneInfo value) {
                            this.phoneInfo = value;
                        }

                        /**
                         * Gets the value of the emailInfo property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.EmailInfo }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.EmailInfo getEmailInfo() {
                            return emailInfo;
                        }

                        /**
                         * Sets the value of the emailInfo property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.EmailInfo }
                         *     
                         */
                        public void setEmailInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.EmailInfo value) {
                            this.emailInfo = value;
                        }

                        /**
                         * Gets the value of the websiteInfo property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.WebsiteInfo }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.WebsiteInfo getWebsiteInfo() {
                            return websiteInfo;
                        }

                        /**
                         * Sets the value of the websiteInfo property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.WebsiteInfo }
                         *     
                         */
                        public void setWebsiteInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.Communications.WebsiteInfo value) {
                            this.websiteInfo = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="EmailAddr" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "emailAddr"
                        })
                        public static class EmailInfo {

                            @XmlElement(name = "EmailAddr", required = true)
                            protected String emailAddr;

                            /**
                             * Gets the value of the emailAddr property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getEmailAddr() {
                                return emailAddr;
                            }

                            /**
                             * Sets the value of the emailAddr property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setEmailAddr(String value) {
                                this.emailAddr = value;
                            }

                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="PhoneTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *         &lt;element name="CommunicationUseCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "phoneTypeCd",
                            "communicationUseCd",
                            "phoneNumber"
                        })
                        public static class PhoneInfo {

                            @XmlElement(name = "PhoneTypeCd")
                            protected String phoneTypeCd;
                            @XmlElement(name = "CommunicationUseCd")
                            protected String communicationUseCd;
                            @XmlElement(name = "PhoneNumber", required = true)
                            protected String phoneNumber;

                            /**
                             * Gets the value of the phoneTypeCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getPhoneTypeCd() {
                                return phoneTypeCd;
                            }

                            /**
                             * Sets the value of the phoneTypeCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setPhoneTypeCd(String value) {
                                this.phoneTypeCd = value;
                            }

                            /**
                             * Gets the value of the communicationUseCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getCommunicationUseCd() {
                                return communicationUseCd;
                            }

                            /**
                             * Sets the value of the communicationUseCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setCommunicationUseCd(String value) {
                                this.communicationUseCd = value;
                            }

                            /**
                             * Gets the value of the phoneNumber property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getPhoneNumber() {
                                return phoneNumber;
                            }

                            /**
                             * Sets the value of the phoneNumber property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setPhoneNumber(String value) {
                                this.phoneNumber = value;
                            }

                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="WebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "websiteURL"
                        })
                        public static class WebsiteInfo {

                            @XmlElement(name = "WebsiteURL", required = true)
                            protected String websiteURL;

                            /**
                             * Gets the value of the websiteURL property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getWebsiteURL() {
                                return websiteURL;
                            }

                            /**
                             * Sets the value of the websiteURL property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setWebsiteURL(String value) {
                                this.websiteURL = value;
                            }

                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="CommlName">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="SupplementaryNameInfo" minOccurs="0">
                     *                     &lt;complexType>
                     *                       &lt;complexContent>
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                           &lt;sequence>
                     *                             &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                             &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                           &lt;/sequence>
                     *                         &lt;/restriction>
                     *                       &lt;/complexContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="com.afg_LongName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "commlName",
                        "legalEntityCd",
                        "taxIdentity",
                        "comAfgLongName"
                    })
                    public static class NameInfo {

                        @XmlElement(name = "CommlName", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName commlName;
                        @XmlElement(name = "LegalEntityCd", required = true)
                        protected String legalEntityCd;
                        @XmlElement(name = "TaxIdentity")
                        protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.TaxIdentity> taxIdentity;
                        @XmlElement(name = "com.afg_LongName")
                        protected String comAfgLongName;

                        /**
                         * Gets the value of the commlName property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName getCommlName() {
                            return commlName;
                        }

                        /**
                         * Sets the value of the commlName property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName }
                         *     
                         */
                        public void setCommlName(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName value) {
                            this.commlName = value;
                        }

                        /**
                         * Gets the value of the legalEntityCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getLegalEntityCd() {
                            return legalEntityCd;
                        }

                        /**
                         * Sets the value of the legalEntityCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setLegalEntityCd(String value) {
                            this.legalEntityCd = value;
                        }

                        /**
                         * Gets the value of the taxIdentity property.
                         * 
                         * <p>
                         * This accessor method returns a reference to the live list,
                         * not a snapshot. Therefore any modification you make to the
                         * returned list will be present inside the JAXB object.
                         * This is why there is not a <CODE>set</CODE> method for the taxIdentity property.
                         * 
                         * <p>
                         * For example, to add a new item, do as follows:
                         * <pre>
                         *    getTaxIdentity().add(newItem);
                         * </pre>
                         * 
                         * 
                         * <p>
                         * Objects of the following type(s) are allowed in the list
                         * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.TaxIdentity }
                         * 
                         * 
                         */
                        public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.TaxIdentity> getTaxIdentity() {
                            if (taxIdentity == null) {
                                taxIdentity = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.TaxIdentity>();
                            }
                            return this.taxIdentity;
                        }

                        /**
                         * Gets the value of the comAfgLongName property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgLongName() {
                            return comAfgLongName;
                        }

                        /**
                         * Sets the value of the comAfgLongName property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgLongName(String value) {
                            this.comAfgLongName = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="SupplementaryNameInfo" minOccurs="0">
                         *           &lt;complexType>
                         *             &lt;complexContent>
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                 &lt;sequence>
                         *                   &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *                   &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                 &lt;/sequence>
                         *               &lt;/restriction>
                         *             &lt;/complexContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "commercialName",
                            "supplementaryNameInfo"
                        })
                        public static class CommlName {

                            @XmlElement(name = "CommercialName", required = true)
                            protected String commercialName;
                            @XmlElement(name = "SupplementaryNameInfo")
                            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo supplementaryNameInfo;

                            /**
                             * Gets the value of the commercialName property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getCommercialName() {
                                return commercialName;
                            }

                            /**
                             * Sets the value of the commercialName property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setCommercialName(String value) {
                                this.commercialName = value;
                            }

                            /**
                             * Gets the value of the supplementaryNameInfo property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo }
                             *     
                             */
                            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo getSupplementaryNameInfo() {
                                return supplementaryNameInfo;
                            }

                            /**
                             * Sets the value of the supplementaryNameInfo property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo }
                             *     
                             */
                            public void setSupplementaryNameInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo value) {
                                this.supplementaryNameInfo = value;
                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType>
                             *   &lt;complexContent>
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *       &lt;sequence>
                             *         &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                             *         &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *       &lt;/sequence>
                             *     &lt;/restriction>
                             *   &lt;/complexContent>
                             * &lt;/complexType>
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "supplementaryNameCd",
                                "supplementaryName"
                            })
                            public static class SupplementaryNameInfo {

                                @XmlElement(name = "SupplementaryNameCd")
                                protected String supplementaryNameCd;
                                @XmlElement(name = "SupplementaryName", required = true)
                                protected String supplementaryName;

                                /**
                                 * Gets the value of the supplementaryNameCd property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getSupplementaryNameCd() {
                                    return supplementaryNameCd;
                                }

                                /**
                                 * Sets the value of the supplementaryNameCd property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setSupplementaryNameCd(String value) {
                                    this.supplementaryNameCd = value;
                                }

                                /**
                                 * Gets the value of the supplementaryName property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getSupplementaryName() {
                                    return supplementaryName;
                                }

                                /**
                                 * Sets the value of the supplementaryName property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setSupplementaryName(String value) {
                                    this.supplementaryName = value;
                                }

                            }

                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "taxId"
                        })
                        public static class TaxIdentity {

                            @XmlElement(name = "TaxId", required = true)
                            protected String taxId;

                            /**
                             * Gets the value of the taxId property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getTaxId() {
                                return taxId;
                            }

                            /**
                             * Sets the value of the taxId property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setTaxId(String value) {
                                this.taxId = value;
                            }

                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="InsuredOrPrincipalRoleCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="BusinessInfo" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="com.afg_NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "insuredOrPrincipalRoleCd",
                    "businessInfo"
                })
                public static class InsuredOrPrincipalInfo {

                    @XmlElement(name = "InsuredOrPrincipalRoleCd")
                    protected String insuredOrPrincipalRoleCd;
                    @XmlElement(name = "BusinessInfo")
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo.BusinessInfo businessInfo;

                    /**
                     * Gets the value of the insuredOrPrincipalRoleCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getInsuredOrPrincipalRoleCd() {
                        return insuredOrPrincipalRoleCd;
                    }

                    /**
                     * Sets the value of the insuredOrPrincipalRoleCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setInsuredOrPrincipalRoleCd(String value) {
                        this.insuredOrPrincipalRoleCd = value;
                    }

                    /**
                     * Gets the value of the businessInfo property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo.BusinessInfo }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo.BusinessInfo getBusinessInfo() {
                        return businessInfo;
                    }

                    /**
                     * Sets the value of the businessInfo property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo.BusinessInfo }
                     *     
                     */
                    public void setBusinessInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.InsuredOrPrincipal.InsuredOrPrincipalInfo.BusinessInfo value) {
                        this.businessInfo = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="com.afg_NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "comAfgNCCIIDNumber"
                    })
                    public static class BusinessInfo {

                        @XmlElement(name = "com.afg_NCCIIDNumber")
                        protected String comAfgNCCIIDNumber;

                        /**
                         * Gets the value of the comAfgNCCIIDNumber property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgNCCIIDNumber() {
                            return comAfgNCCIIDNumber;
                        }

                        /**
                         * Sets the value of the comAfgNCCIIDNumber property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgNCCIIDNumber(String value) {
                            this.comAfgNCCIIDNumber = value;
                        }

                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ItemIdInfo" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="InsurerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *                   &lt;element name="OtherIdentifier">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="Addr">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="AdditionalInterest" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="ItemIdInfo" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="OtherIdentifier">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="GeneralPartyInfo" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="NameInfo">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="CommlName">
             *                                         &lt;complexType>
             *                                           &lt;complexContent>
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                               &lt;sequence>
             *                                                 &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                 &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                 &lt;element name="SupplementaryNameInfo">
             *                                                   &lt;complexType>
             *                                                     &lt;complexContent>
             *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                                         &lt;sequence>
             *                                                           &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                                           &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                         &lt;/sequence>
             *                                                       &lt;/restriction>
             *                                                     &lt;/complexContent>
             *                                                   &lt;/complexType>
             *                                                 &lt;/element>
             *                                               &lt;/sequence>
             *                                             &lt;/restriction>
             *                                           &lt;/complexContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                       &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
             *                                         &lt;complexType>
             *                                           &lt;complexContent>
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                               &lt;sequence>
             *                                                 &lt;element name="TaxIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                 &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                 &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                               &lt;/sequence>
             *                                             &lt;/restriction>
             *                                           &lt;/complexContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                       &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="Addr">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="Addr4" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="AdditionalInterestInfo">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="NatureInterestCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="InterestRank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="ClassCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="OwnershipPct" minOccurs="0">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="NumericValue">
             *                                         &lt;complexType>
             *                                           &lt;complexContent>
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                               &lt;sequence>
             *                                                 &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *                                               &lt;/sequence>
             *                                             &lt;/restriction>
             *                                           &lt;/complexContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="ActualRemunerationAmt" minOccurs="0">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="AccountNumberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="com.afg_InterestStartDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="InterestEndDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="com.afg_ItemIdInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="OtherIdentifier">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="OtherTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="OtherId2" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="NumberofDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="TaxCodeInfo" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
             *                   &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="TaxTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "itemIdInfo",
                "addr",
                "additionalInterest",
                "taxCodeInfo"
            })
            public static class Location {

                @XmlElement(name = "ItemIdInfo")
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo itemIdInfo;
                @XmlElement(name = "Addr", required = true)
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.Addr addr;
                @XmlElement(name = "AdditionalInterest")
                protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest> additionalInterest;
                @XmlElement(name = "TaxCodeInfo")
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.TaxCodeInfo taxCodeInfo;
                @XmlAttribute(name = "id")
                protected String id;

                /**
                 * Gets the value of the itemIdInfo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo getItemIdInfo() {
                    return itemIdInfo;
                }

                /**
                 * Sets the value of the itemIdInfo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo }
                 *     
                 */
                public void setItemIdInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo value) {
                    this.itemIdInfo = value;
                }

                /**
                 * Gets the value of the addr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.Addr }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.Addr getAddr() {
                    return addr;
                }

                /**
                 * Sets the value of the addr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.Addr }
                 *     
                 */
                public void setAddr(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.Addr value) {
                    this.addr = value;
                }

                /**
                 * Gets the value of the additionalInterest property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the additionalInterest property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAdditionalInterest().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest }
                 * 
                 * 
                 */
                public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest> getAdditionalInterest() {
                    if (additionalInterest == null) {
                        additionalInterest = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest>();
                    }
                    return this.additionalInterest;
                }

                /**
                 * Gets the value of the taxCodeInfo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.TaxCodeInfo }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.TaxCodeInfo getTaxCodeInfo() {
                    return taxCodeInfo;
                }

                /**
                 * Sets the value of the taxCodeInfo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.TaxCodeInfo }
                 *     
                 */
                public void setTaxCodeInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.TaxCodeInfo value) {
                    this.taxCodeInfo = value;
                }

                /**
                 * Gets the value of the id property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getId() {
                    return id;
                }

                /**
                 * Sets the value of the id property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setId(String value) {
                    this.id = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="ItemIdInfo" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="OtherIdentifier">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="GeneralPartyInfo" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="NameInfo">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="CommlName">
                 *                               &lt;complexType>
                 *                                 &lt;complexContent>
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                     &lt;sequence>
                 *                                       &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                       &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                       &lt;element name="SupplementaryNameInfo">
                 *                                         &lt;complexType>
                 *                                           &lt;complexContent>
                 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                               &lt;sequence>
                 *                                                 &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                                                 &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                               &lt;/sequence>
                 *                                             &lt;/restriction>
                 *                                           &lt;/complexContent>
                 *                                         &lt;/complexType>
                 *                                       &lt;/element>
                 *                                     &lt;/sequence>
                 *                                   &lt;/restriction>
                 *                                 &lt;/complexContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                             &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
                 *                               &lt;complexType>
                 *                                 &lt;complexContent>
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                     &lt;sequence>
                 *                                       &lt;element name="TaxIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                       &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                       &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                     &lt;/sequence>
                 *                                   &lt;/restriction>
                 *                                 &lt;/complexContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                             &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="Addr">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="Addr4" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="AdditionalInterestInfo">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="NatureInterestCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="InterestRank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="ClassCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="OwnershipPct" minOccurs="0">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="NumericValue">
                 *                               &lt;complexType>
                 *                                 &lt;complexContent>
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                     &lt;sequence>
                 *                                       &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}int"/>
                 *                                     &lt;/sequence>
                 *                                   &lt;/restriction>
                 *                                 &lt;/complexContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="ActualRemunerationAmt" minOccurs="0">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="AccountNumberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="com.afg_InterestStartDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="InterestEndDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="com.afg_ItemIdInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="OtherIdentifier">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="OtherTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="OtherId2" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="NumberofDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "itemIdInfo",
                    "generalPartyInfo",
                    "additionalInterestInfo",
                    "comAfgItemIdInfo"
                })
                public static class AdditionalInterest {

                    @XmlElement(name = "ItemIdInfo")
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo itemIdInfo;
                    @XmlElement(name = "GeneralPartyInfo")
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo generalPartyInfo;
                    @XmlElement(name = "AdditionalInterestInfo", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo additionalInterestInfo;
                    @XmlElement(name = "com.afg_ItemIdInfo")
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo comAfgItemIdInfo;
                    @XmlAttribute(name = "id")
                    protected String id;

                    /**
                     * Gets the value of the itemIdInfo property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo getItemIdInfo() {
                        return itemIdInfo;
                    }

                    /**
                     * Sets the value of the itemIdInfo property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo }
                     *     
                     */
                    public void setItemIdInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo value) {
                        this.itemIdInfo = value;
                    }

                    /**
                     * Gets the value of the generalPartyInfo property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo getGeneralPartyInfo() {
                        return generalPartyInfo;
                    }

                    /**
                     * Sets the value of the generalPartyInfo property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo }
                     *     
                     */
                    public void setGeneralPartyInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo value) {
                        this.generalPartyInfo = value;
                    }

                    /**
                     * Gets the value of the additionalInterestInfo property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo getAdditionalInterestInfo() {
                        return additionalInterestInfo;
                    }

                    /**
                     * Sets the value of the additionalInterestInfo property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo }
                     *     
                     */
                    public void setAdditionalInterestInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo value) {
                        this.additionalInterestInfo = value;
                    }

                    /**
                     * Gets the value of the comAfgItemIdInfo property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo getComAfgItemIdInfo() {
                        return comAfgItemIdInfo;
                    }

                    /**
                     * Sets the value of the comAfgItemIdInfo property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo }
                     *     
                     */
                    public void setComAfgItemIdInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo value) {
                        this.comAfgItemIdInfo = value;
                    }

                    /**
                     * Gets the value of the id property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getId() {
                        return id;
                    }

                    /**
                     * Sets the value of the id property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setId(String value) {
                        this.id = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="NatureInterestCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="InterestRank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="ClassCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="OwnershipPct" minOccurs="0">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="NumericValue">
                     *                     &lt;complexType>
                     *                       &lt;complexContent>
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                           &lt;sequence>
                     *                             &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}int"/>
                     *                           &lt;/sequence>
                     *                         &lt;/restriction>
                     *                       &lt;/complexContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="ActualRemunerationAmt" minOccurs="0">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="AccountNumberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="com.afg_InterestStartDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="InterestEndDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="com.afg_ItemIdInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "natureInterestCd",
                        "interestRank",
                        "classCD",
                        "ownershipPct",
                        "actualRemunerationAmt",
                        "accountNumberId",
                        "comAfgInterestStartDt",
                        "interestEndDt",
                        "comAfgItemIdInfo"
                    })
                    public static class AdditionalInterestInfo {

                        @XmlElement(name = "NatureInterestCd", required = true)
                        protected String natureInterestCd;
                        @XmlElement(name = "InterestRank")
                        protected String interestRank;
                        @XmlElement(name = "ClassCD")
                        protected String classCD;
                        @XmlElement(name = "OwnershipPct")
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct ownershipPct;
                        @XmlElement(name = "ActualRemunerationAmt")
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.ActualRemunerationAmt actualRemunerationAmt;
                        @XmlElement(name = "AccountNumberId")
                        protected String accountNumberId;
                        @XmlElement(name = "com.afg_InterestStartDt")
                        protected String comAfgInterestStartDt;
                        @XmlElement(name = "InterestEndDt")
                        protected String interestEndDt;
                        @XmlElement(name = "com.afg_ItemIdInfo")
                        protected String comAfgItemIdInfo;

                        /**
                         * Gets the value of the natureInterestCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNatureInterestCd() {
                            return natureInterestCd;
                        }

                        /**
                         * Sets the value of the natureInterestCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNatureInterestCd(String value) {
                            this.natureInterestCd = value;
                        }

                        /**
                         * Gets the value of the interestRank property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getInterestRank() {
                            return interestRank;
                        }

                        /**
                         * Sets the value of the interestRank property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setInterestRank(String value) {
                            this.interestRank = value;
                        }

                        /**
                         * Gets the value of the classCD property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getClassCD() {
                            return classCD;
                        }

                        /**
                         * Sets the value of the classCD property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setClassCD(String value) {
                            this.classCD = value;
                        }

                        /**
                         * Gets the value of the ownershipPct property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct getOwnershipPct() {
                            return ownershipPct;
                        }

                        /**
                         * Sets the value of the ownershipPct property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct }
                         *     
                         */
                        public void setOwnershipPct(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct value) {
                            this.ownershipPct = value;
                        }

                        /**
                         * Gets the value of the actualRemunerationAmt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.ActualRemunerationAmt }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.ActualRemunerationAmt getActualRemunerationAmt() {
                            return actualRemunerationAmt;
                        }

                        /**
                         * Sets the value of the actualRemunerationAmt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.ActualRemunerationAmt }
                         *     
                         */
                        public void setActualRemunerationAmt(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.ActualRemunerationAmt value) {
                            this.actualRemunerationAmt = value;
                        }

                        /**
                         * Gets the value of the accountNumberId property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAccountNumberId() {
                            return accountNumberId;
                        }

                        /**
                         * Sets the value of the accountNumberId property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAccountNumberId(String value) {
                            this.accountNumberId = value;
                        }

                        /**
                         * Gets the value of the comAfgInterestStartDt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgInterestStartDt() {
                            return comAfgInterestStartDt;
                        }

                        /**
                         * Sets the value of the comAfgInterestStartDt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgInterestStartDt(String value) {
                            this.comAfgInterestStartDt = value;
                        }

                        /**
                         * Gets the value of the interestEndDt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getInterestEndDt() {
                            return interestEndDt;
                        }

                        /**
                         * Sets the value of the interestEndDt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setInterestEndDt(String value) {
                            this.interestEndDt = value;
                        }

                        /**
                         * Gets the value of the comAfgItemIdInfo property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgItemIdInfo() {
                            return comAfgItemIdInfo;
                        }

                        /**
                         * Sets the value of the comAfgItemIdInfo property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgItemIdInfo(String value) {
                            this.comAfgItemIdInfo = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "amt"
                        })
                        public static class ActualRemunerationAmt {

                            @XmlElement(name = "Amt")
                            protected int amt;

                            /**
                             * Gets the value of the amt property.
                             * 
                             */
                            public int getAmt() {
                                return amt;
                            }

                            /**
                             * Sets the value of the amt property.
                             * 
                             */
                            public void setAmt(int value) {
                                this.amt = value;
                            }

                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="NumericValue">
                         *           &lt;complexType>
                         *             &lt;complexContent>
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                 &lt;sequence>
                         *                   &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}int"/>
                         *                 &lt;/sequence>
                         *               &lt;/restriction>
                         *             &lt;/complexContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "numericValue"
                        })
                        public static class OwnershipPct {

                            @XmlElement(name = "NumericValue", required = true)
                            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct.NumericValue numericValue;

                            /**
                             * Gets the value of the numericValue property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct.NumericValue }
                             *     
                             */
                            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct.NumericValue getNumericValue() {
                                return numericValue;
                            }

                            /**
                             * Sets the value of the numericValue property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct.NumericValue }
                             *     
                             */
                            public void setNumericValue(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.AdditionalInterestInfo.OwnershipPct.NumericValue value) {
                                this.numericValue = value;
                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType>
                             *   &lt;complexContent>
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *       &lt;sequence>
                             *         &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}int"/>
                             *       &lt;/sequence>
                             *     &lt;/restriction>
                             *   &lt;/complexContent>
                             * &lt;/complexType>
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "formatInteger"
                            })
                            public static class NumericValue {

                                @XmlElement(name = "FormatInteger")
                                protected int formatInteger;

                                /**
                                 * Gets the value of the formatInteger property.
                                 * 
                                 */
                                public int getFormatInteger() {
                                    return formatInteger;
                                }

                                /**
                                 * Sets the value of the formatInteger property.
                                 * 
                                 */
                                public void setFormatInteger(int value) {
                                    this.formatInteger = value;
                                }

                            }

                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="OtherIdentifier">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="OtherTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="OtherId2" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="NumberofDays" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "otherIdentifier",
                        "numberofDays"
                    })
                    public static class ComAfgItemIdInfo {

                        @XmlElement(name = "OtherIdentifier", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo.OtherIdentifier otherIdentifier;
                        @XmlElement(name = "NumberofDays", required = true)
                        protected String numberofDays;

                        /**
                         * Gets the value of the otherIdentifier property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo.OtherIdentifier }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo.OtherIdentifier getOtherIdentifier() {
                            return otherIdentifier;
                        }

                        /**
                         * Sets the value of the otherIdentifier property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo.OtherIdentifier }
                         *     
                         */
                        public void setOtherIdentifier(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ComAfgItemIdInfo.OtherIdentifier value) {
                            this.otherIdentifier = value;
                        }

                        /**
                         * Gets the value of the numberofDays property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNumberofDays() {
                            return numberofDays;
                        }

                        /**
                         * Sets the value of the numberofDays property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNumberofDays(String value) {
                            this.numberofDays = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="OtherTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="OtherId2" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "otherIdTypeCd",
                            "otherTypeCd",
                            "otherId",
                            "otherId2"
                        })
                        public static class OtherIdentifier {

                            @XmlElement(name = "OtherIdTypeCd", required = true)
                            protected String otherIdTypeCd;
                            @XmlElement(name = "OtherTypeCd", required = true)
                            protected String otherTypeCd;
                            @XmlElement(name = "OtherId", required = true)
                            protected String otherId;
                            @XmlElement(name = "OtherId2", required = true)
                            protected String otherId2;

                            /**
                             * Gets the value of the otherIdTypeCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getOtherIdTypeCd() {
                                return otherIdTypeCd;
                            }

                            /**
                             * Sets the value of the otherIdTypeCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setOtherIdTypeCd(String value) {
                                this.otherIdTypeCd = value;
                            }

                            /**
                             * Gets the value of the otherTypeCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getOtherTypeCd() {
                                return otherTypeCd;
                            }

                            /**
                             * Sets the value of the otherTypeCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setOtherTypeCd(String value) {
                                this.otherTypeCd = value;
                            }

                            /**
                             * Gets the value of the otherId property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getOtherId() {
                                return otherId;
                            }

                            /**
                             * Sets the value of the otherId property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setOtherId(String value) {
                                this.otherId = value;
                            }

                            /**
                             * Gets the value of the otherId2 property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getOtherId2() {
                                return otherId2;
                            }

                            /**
                             * Sets the value of the otherId2 property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setOtherId2(String value) {
                                this.otherId2 = value;
                            }

                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="NameInfo">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="CommlName">
                     *                     &lt;complexType>
                     *                       &lt;complexContent>
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                           &lt;sequence>
                     *                             &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                             &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                             &lt;element name="SupplementaryNameInfo">
                     *                               &lt;complexType>
                     *                                 &lt;complexContent>
                     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                                     &lt;sequence>
                     *                                       &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                                       &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                                     &lt;/sequence>
                     *                                   &lt;/restriction>
                     *                                 &lt;/complexContent>
                     *                               &lt;/complexType>
                     *                             &lt;/element>
                     *                           &lt;/sequence>
                     *                         &lt;/restriction>
                     *                       &lt;/complexContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                   &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
                     *                     &lt;complexType>
                     *                       &lt;complexContent>
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                           &lt;sequence>
                     *                             &lt;element name="TaxIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                             &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                             &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                           &lt;/sequence>
                     *                         &lt;/restriction>
                     *                       &lt;/complexContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                   &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="Addr">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="Addr4" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "nameInfo",
                        "addr"
                    })
                    public static class GeneralPartyInfo {

                        @XmlElement(name = "NameInfo", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo nameInfo;
                        @XmlElement(name = "Addr", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.Addr addr;

                        /**
                         * Gets the value of the nameInfo property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo getNameInfo() {
                            return nameInfo;
                        }

                        /**
                         * Sets the value of the nameInfo property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo }
                         *     
                         */
                        public void setNameInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo value) {
                            this.nameInfo = value;
                        }

                        /**
                         * Gets the value of the addr property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.Addr }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.Addr getAddr() {
                            return addr;
                        }

                        /**
                         * Sets the value of the addr property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.Addr }
                         *     
                         */
                        public void setAddr(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.Addr value) {
                            this.addr = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="Addr4" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="CountryCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "addrTypeCd",
                            "addr1",
                            "addr2",
                            "addr3",
                            "addr4",
                            "city",
                            "stateProvCd",
                            "postalCode",
                            "countryCd"
                        })
                        public static class Addr {

                            @XmlElement(name = "AddrTypeCd", required = true)
                            protected String addrTypeCd;
                            @XmlElement(name = "Addr1", required = true)
                            protected String addr1;
                            @XmlElement(name = "Addr2", required = true)
                            protected String addr2;
                            @XmlElement(name = "Addr3", required = true)
                            protected String addr3;
                            @XmlElement(name = "Addr4", required = true)
                            protected String addr4;
                            @XmlElement(name = "City", required = true)
                            protected String city;
                            @XmlElement(name = "StateProvCd", required = true)
                            protected String stateProvCd;
                            @XmlElement(name = "PostalCode", required = true)
                            protected String postalCode;
                            @XmlElement(name = "CountryCd", required = true)
                            protected String countryCd;

                            /**
                             * Gets the value of the addrTypeCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getAddrTypeCd() {
                                return addrTypeCd;
                            }

                            /**
                             * Sets the value of the addrTypeCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setAddrTypeCd(String value) {
                                this.addrTypeCd = value;
                            }

                            /**
                             * Gets the value of the addr1 property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getAddr1() {
                                return addr1;
                            }

                            /**
                             * Sets the value of the addr1 property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setAddr1(String value) {
                                this.addr1 = value;
                            }

                            /**
                             * Gets the value of the addr2 property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getAddr2() {
                                return addr2;
                            }

                            /**
                             * Sets the value of the addr2 property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setAddr2(String value) {
                                this.addr2 = value;
                            }

                            /**
                             * Gets the value of the addr3 property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getAddr3() {
                                return addr3;
                            }

                            /**
                             * Sets the value of the addr3 property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setAddr3(String value) {
                                this.addr3 = value;
                            }

                            /**
                             * Gets the value of the addr4 property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getAddr4() {
                                return addr4;
                            }

                            /**
                             * Sets the value of the addr4 property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setAddr4(String value) {
                                this.addr4 = value;
                            }

                            /**
                             * Gets the value of the city property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getCity() {
                                return city;
                            }

                            /**
                             * Sets the value of the city property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setCity(String value) {
                                this.city = value;
                            }

                            /**
                             * Gets the value of the stateProvCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getStateProvCd() {
                                return stateProvCd;
                            }

                            /**
                             * Sets the value of the stateProvCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setStateProvCd(String value) {
                                this.stateProvCd = value;
                            }

                            /**
                             * Gets the value of the postalCode property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getPostalCode() {
                                return postalCode;
                            }

                            /**
                             * Sets the value of the postalCode property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setPostalCode(String value) {
                                this.postalCode = value;
                            }

                            /**
                             * Gets the value of the countryCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getCountryCd() {
                                return countryCd;
                            }

                            /**
                             * Sets the value of the countryCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setCountryCd(String value) {
                                this.countryCd = value;
                            }

                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="CommlName">
                         *           &lt;complexType>
                         *             &lt;complexContent>
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                 &lt;sequence>
                         *                   &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                   &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                   &lt;element name="SupplementaryNameInfo">
                         *                     &lt;complexType>
                         *                       &lt;complexContent>
                         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                           &lt;sequence>
                         *                             &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *                             &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                           &lt;/sequence>
                         *                         &lt;/restriction>
                         *                       &lt;/complexContent>
                         *                     &lt;/complexType>
                         *                   &lt;/element>
                         *                 &lt;/sequence>
                         *               &lt;/restriction>
                         *             &lt;/complexContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
                         *         &lt;element name="TaxIdentity" maxOccurs="unbounded" minOccurs="0">
                         *           &lt;complexType>
                         *             &lt;complexContent>
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                 &lt;sequence>
                         *                   &lt;element name="TaxIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                   &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                   &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                 &lt;/sequence>
                         *               &lt;/restriction>
                         *             &lt;/complexContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
                         *         &lt;element name="LegalEntityCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "commlName",
                            "taxIdentity",
                            "legalEntityCd"
                        })
                        public static class NameInfo {

                            @XmlElement(name = "CommlName", required = true)
                            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName commlName;
                            @XmlElement(name = "TaxIdentity")
                            protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.TaxIdentity> taxIdentity;
                            @XmlElement(name = "LegalEntityCd", required = true)
                            protected String legalEntityCd;

                            /**
                             * Gets the value of the commlName property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName }
                             *     
                             */
                            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName getCommlName() {
                                return commlName;
                            }

                            /**
                             * Sets the value of the commlName property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName }
                             *     
                             */
                            public void setCommlName(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName value) {
                                this.commlName = value;
                            }

                            /**
                             * Gets the value of the taxIdentity property.
                             * 
                             * <p>
                             * This accessor method returns a reference to the live list,
                             * not a snapshot. Therefore any modification you make to the
                             * returned list will be present inside the JAXB object.
                             * This is why there is not a <CODE>set</CODE> method for the taxIdentity property.
                             * 
                             * <p>
                             * For example, to add a new item, do as follows:
                             * <pre>
                             *    getTaxIdentity().add(newItem);
                             * </pre>
                             * 
                             * 
                             * <p>
                             * Objects of the following type(s) are allowed in the list
                             * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.TaxIdentity }
                             * 
                             * 
                             */
                            public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.TaxIdentity> getTaxIdentity() {
                                if (taxIdentity == null) {
                                    taxIdentity = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.TaxIdentity>();
                                }
                                return this.taxIdentity;
                            }

                            /**
                             * Gets the value of the legalEntityCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getLegalEntityCd() {
                                return legalEntityCd;
                            }

                            /**
                             * Sets the value of the legalEntityCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setLegalEntityCd(String value) {
                                this.legalEntityCd = value;
                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType>
                             *   &lt;complexContent>
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *       &lt;sequence>
                             *         &lt;element name="CommercialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *         &lt;element name="SupplementaryNameInfo">
                             *           &lt;complexType>
                             *             &lt;complexContent>
                             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *                 &lt;sequence>
                             *                   &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                             *                   &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *                 &lt;/sequence>
                             *               &lt;/restriction>
                             *             &lt;/complexContent>
                             *           &lt;/complexType>
                             *         &lt;/element>
                             *       &lt;/sequence>
                             *     &lt;/restriction>
                             *   &lt;/complexContent>
                             * &lt;/complexType>
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "commercialName",
                                "type",
                                "supplementaryNameInfo"
                            })
                            public static class CommlName {

                                @XmlElement(name = "CommercialName", required = true)
                                protected String commercialName;
                                @XmlElement(name = "Type", required = true)
                                protected String type;
                                @XmlElement(name = "SupplementaryNameInfo", required = true)
                                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo supplementaryNameInfo;

                                /**
                                 * Gets the value of the commercialName property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getCommercialName() {
                                    return commercialName;
                                }

                                /**
                                 * Sets the value of the commercialName property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setCommercialName(String value) {
                                    this.commercialName = value;
                                }

                                /**
                                 * Gets the value of the type property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getType() {
                                    return type;
                                }

                                /**
                                 * Sets the value of the type property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setType(String value) {
                                    this.type = value;
                                }

                                /**
                                 * Gets the value of the supplementaryNameInfo property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo }
                                 *     
                                 */
                                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo getSupplementaryNameInfo() {
                                    return supplementaryNameInfo;
                                }

                                /**
                                 * Sets the value of the supplementaryNameInfo property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo }
                                 *     
                                 */
                                public void setSupplementaryNameInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.GeneralPartyInfo.NameInfo.CommlName.SupplementaryNameInfo value) {
                                    this.supplementaryNameInfo = value;
                                }


                                /**
                                 * <p>Java class for anonymous complex type.
                                 * 
                                 * <p>The following schema fragment specifies the expected content contained within this class.
                                 * 
                                 * <pre>
                                 * &lt;complexType>
                                 *   &lt;complexContent>
                                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                                 *       &lt;sequence>
                                 *         &lt;element name="SupplementaryNameCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                                 *         &lt;element name="SupplementaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                                 *       &lt;/sequence>
                                 *     &lt;/restriction>
                                 *   &lt;/complexContent>
                                 * &lt;/complexType>
                                 * </pre>
                                 * 
                                 * 
                                 */
                                @XmlAccessorType(XmlAccessType.FIELD)
                                @XmlType(name = "", propOrder = {
                                    "supplementaryNameCd",
                                    "supplementaryName"
                                })
                                public static class SupplementaryNameInfo {

                                    @XmlElement(name = "SupplementaryNameCd")
                                    protected String supplementaryNameCd;
                                    @XmlElement(name = "SupplementaryName", required = true)
                                    protected String supplementaryName;

                                    /**
                                     * Gets the value of the supplementaryNameCd property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getSupplementaryNameCd() {
                                        return supplementaryNameCd;
                                    }

                                    /**
                                     * Sets the value of the supplementaryNameCd property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setSupplementaryNameCd(String value) {
                                        this.supplementaryNameCd = value;
                                    }

                                    /**
                                     * Gets the value of the supplementaryName property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getSupplementaryName() {
                                        return supplementaryName;
                                    }

                                    /**
                                     * Sets the value of the supplementaryName property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setSupplementaryName(String value) {
                                        this.supplementaryName = value;
                                    }

                                }

                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType>
                             *   &lt;complexContent>
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *       &lt;sequence>
                             *         &lt;element name="TaxIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *         &lt;element name="TaxId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *         &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *       &lt;/sequence>
                             *     &lt;/restriction>
                             *   &lt;/complexContent>
                             * &lt;/complexType>
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "taxIdTypeCd",
                                "taxId",
                                "taxCd"
                            })
                            public static class TaxIdentity {

                                @XmlElement(name = "TaxIdTypeCd", required = true)
                                protected String taxIdTypeCd;
                                @XmlElement(name = "TaxId", required = true)
                                protected String taxId;
                                @XmlElement(name = "TaxCd", required = true)
                                protected String taxCd;

                                /**
                                 * Gets the value of the taxIdTypeCd property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTaxIdTypeCd() {
                                    return taxIdTypeCd;
                                }

                                /**
                                 * Sets the value of the taxIdTypeCd property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTaxIdTypeCd(String value) {
                                    this.taxIdTypeCd = value;
                                }

                                /**
                                 * Gets the value of the taxId property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTaxId() {
                                    return taxId;
                                }

                                /**
                                 * Sets the value of the taxId property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTaxId(String value) {
                                    this.taxId = value;
                                }

                                /**
                                 * Gets the value of the taxCd property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTaxCd() {
                                    return taxCd;
                                }

                                /**
                                 * Sets the value of the taxCd property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTaxCd(String value) {
                                    this.taxCd = value;
                                }

                            }

                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="OtherIdentifier">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "otherIdentifier"
                    })
                    public static class ItemIdInfo {

                        @XmlElement(name = "OtherIdentifier", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo.OtherIdentifier otherIdentifier;

                        /**
                         * Gets the value of the otherIdentifier property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo.OtherIdentifier }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo.OtherIdentifier getOtherIdentifier() {
                            return otherIdentifier;
                        }

                        /**
                         * Sets the value of the otherIdentifier property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo.OtherIdentifier }
                         *     
                         */
                        public void setOtherIdentifier(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.AdditionalInterest.ItemIdInfo.OtherIdentifier value) {
                            this.otherIdentifier = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "otherIdTypeCd",
                            "otherId"
                        })
                        public static class OtherIdentifier {

                            @XmlElement(name = "OtherIdTypeCd", required = true)
                            protected String otherIdTypeCd;
                            @XmlElement(name = "OtherId", required = true)
                            protected String otherId;

                            /**
                             * Gets the value of the otherIdTypeCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getOtherIdTypeCd() {
                                return otherIdTypeCd;
                            }

                            /**
                             * Sets the value of the otherIdTypeCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setOtherIdTypeCd(String value) {
                                this.otherIdTypeCd = value;
                            }

                            /**
                             * Gets the value of the otherId property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getOtherId() {
                                return otherId;
                            }

                            /**
                             * Sets the value of the otherId property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setOtherId(String value) {
                                this.otherId = value;
                            }

                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="AddrTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "addrTypeCd",
                    "addr1",
                    "addr2",
                    "city",
                    "stateProvCd",
                    "postalCode",
                    "country",
                    "county"
                })
                public static class Addr {

                    @XmlElement(name = "AddrTypeCd")
                    protected String addrTypeCd;
                    @XmlElement(name = "Addr1", required = true)
                    protected String addr1;
                    @XmlElement(name = "Addr2")
                    protected String addr2;
                    @XmlElement(name = "City", required = true)
                    protected String city;
                    @XmlElement(name = "StateProvCd", required = true)
                    protected String stateProvCd;
                    @XmlElement(name = "PostalCode", required = true)
                    protected String postalCode;
                    @XmlElement(name = "Country")
                    protected String country;
                    @XmlElement(name = "County")
                    protected String county;

                    /**
                     * Gets the value of the addrTypeCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAddrTypeCd() {
                        return addrTypeCd;
                    }

                    /**
                     * Sets the value of the addrTypeCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAddrTypeCd(String value) {
                        this.addrTypeCd = value;
                    }

                    /**
                     * Gets the value of the addr1 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAddr1() {
                        return addr1;
                    }

                    /**
                     * Sets the value of the addr1 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAddr1(String value) {
                        this.addr1 = value;
                    }

                    /**
                     * Gets the value of the addr2 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAddr2() {
                        return addr2;
                    }

                    /**
                     * Sets the value of the addr2 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAddr2(String value) {
                        this.addr2 = value;
                    }

                    /**
                     * Gets the value of the city property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCity() {
                        return city;
                    }

                    /**
                     * Sets the value of the city property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCity(String value) {
                        this.city = value;
                    }

                    /**
                     * Gets the value of the stateProvCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getStateProvCd() {
                        return stateProvCd;
                    }

                    /**
                     * Sets the value of the stateProvCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setStateProvCd(String value) {
                        this.stateProvCd = value;
                    }

                    /**
                     * Gets the value of the postalCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPostalCode() {
                        return postalCode;
                    }

                    /**
                     * Sets the value of the postalCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPostalCode(String value) {
                        this.postalCode = value;
                    }

                    /**
                     * Gets the value of the country property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCountry() {
                        return country;
                    }

                    /**
                     * Sets the value of the country property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCountry(String value) {
                        this.country = value;
                    }

                    /**
                     * Gets the value of the county property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCounty() {
                        return county;
                    }

                    /**
                     * Sets the value of the county property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCounty(String value) {
                        this.county = value;
                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="InsurerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
                 *         &lt;element name="OtherIdentifier">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "insurerId",
                    "otherIdentifier"
                })
                public static class ItemIdInfo {

                    @XmlElement(name = "InsurerId")
                    protected int insurerId;
                    @XmlElement(name = "OtherIdentifier", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo.OtherIdentifier otherIdentifier;

                    /**
                     * Gets the value of the insurerId property.
                     * 
                     */
                    public int getInsurerId() {
                        return insurerId;
                    }

                    /**
                     * Sets the value of the insurerId property.
                     * 
                     */
                    public void setInsurerId(int value) {
                        this.insurerId = value;
                    }

                    /**
                     * Gets the value of the otherIdentifier property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo.OtherIdentifier }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo.OtherIdentifier getOtherIdentifier() {
                        return otherIdentifier;
                    }

                    /**
                     * Sets the value of the otherIdentifier property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo.OtherIdentifier }
                     *     
                     */
                    public void setOtherIdentifier(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Location.ItemIdInfo.OtherIdentifier value) {
                        this.otherIdentifier = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "otherIdTypeCd",
                        "otherId"
                    })
                    public static class OtherIdentifier {

                        @XmlElement(name = "OtherIdTypeCd", required = true)
                        protected String otherIdTypeCd;
                        @XmlElement(name = "OtherId", required = true)
                        protected String otherId;

                        /**
                         * Gets the value of the otherIdTypeCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getOtherIdTypeCd() {
                            return otherIdTypeCd;
                        }

                        /**
                         * Sets the value of the otherIdTypeCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setOtherIdTypeCd(String value) {
                            this.otherIdTypeCd = value;
                        }

                        /**
                         * Gets the value of the otherId property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getOtherId() {
                            return otherId;
                        }

                        /**
                         * Sets the value of the otherId property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setOtherId(String value) {
                            this.otherId = value;
                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
                 *         &lt;element name="TaxCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="TaxTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "taxCdAndTaxTypeCd"
                })
                public static class TaxCodeInfo {

                    @XmlElementRefs({
                        @XmlElementRef(name = "TaxTypeCd", type = JAXBElement.class, required = false),
                        @XmlElementRef(name = "TaxCd", type = JAXBElement.class, required = false)
                    })
                    protected List<JAXBElement<String>> taxCdAndTaxTypeCd;

                    /**
                     * Gets the value of the taxCdAndTaxTypeCd property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the taxCdAndTaxTypeCd property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getTaxCdAndTaxTypeCd().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link JAXBElement }{@code <}{@link String }{@code >}
                     * {@link JAXBElement }{@code <}{@link String }{@code >}
                     * 
                     * 
                     */
                    public List<JAXBElement<String>> getTaxCdAndTaxTypeCd() {
                        if (taxCdAndTaxTypeCd == null) {
                            taxCdAndTaxTypeCd = new ArrayList<JAXBElement<String>>();
                        }
                        return this.taxCdAndTaxTypeCd;
                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="ItemIdInfo">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="AgencyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="GeneralPartyInfo">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="NameInfo">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="PersonName">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                           &lt;/sequence>
             *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="ProducerInfo" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="ContractNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="ProducerSubCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="com.afg_ProducerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="com.afg_MarketSegment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="com.afg_PayrollVendor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="com.afg_UWREVIEW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "itemIdInfo",
                "generalPartyInfo",
                "producerInfo",
                "comAfgProducerCode",
                "comAfgMarketSegment",
                "comAfgPayrollVendor",
                "comAfgUWREVIEW"
            })
            public static class Producer {

                @XmlElement(name = "ItemIdInfo", required = true)
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ItemIdInfo itemIdInfo;
                @XmlElement(name = "GeneralPartyInfo", required = true)
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo generalPartyInfo;
                @XmlElement(name = "ProducerInfo")
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ProducerInfo producerInfo;
                @XmlElement(name = "com.afg_ProducerCode")
                protected String comAfgProducerCode;
                @XmlElement(name = "com.afg_MarketSegment")
                protected String comAfgMarketSegment;
                @XmlElement(name = "com.afg_PayrollVendor")
                protected String comAfgPayrollVendor;
                @XmlElement(name = "com.afg_UWREVIEW")
                protected String comAfgUWREVIEW;

                /**
                 * Gets the value of the itemIdInfo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ItemIdInfo }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ItemIdInfo getItemIdInfo() {
                    return itemIdInfo;
                }

                /**
                 * Sets the value of the itemIdInfo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ItemIdInfo }
                 *     
                 */
                public void setItemIdInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ItemIdInfo value) {
                    this.itemIdInfo = value;
                }

                /**
                 * Gets the value of the generalPartyInfo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo getGeneralPartyInfo() {
                    return generalPartyInfo;
                }

                /**
                 * Sets the value of the generalPartyInfo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo }
                 *     
                 */
                public void setGeneralPartyInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo value) {
                    this.generalPartyInfo = value;
                }

                /**
                 * Gets the value of the producerInfo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ProducerInfo }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ProducerInfo getProducerInfo() {
                    return producerInfo;
                }

                /**
                 * Sets the value of the producerInfo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ProducerInfo }
                 *     
                 */
                public void setProducerInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.ProducerInfo value) {
                    this.producerInfo = value;
                }

                /**
                 * Gets the value of the comAfgProducerCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getComAfgProducerCode() {
                    return comAfgProducerCode;
                }

                /**
                 * Sets the value of the comAfgProducerCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setComAfgProducerCode(String value) {
                    this.comAfgProducerCode = value;
                }

                /**
                 * Gets the value of the comAfgMarketSegment property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getComAfgMarketSegment() {
                    return comAfgMarketSegment;
                }

                /**
                 * Sets the value of the comAfgMarketSegment property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setComAfgMarketSegment(String value) {
                    this.comAfgMarketSegment = value;
                }

                /**
                 * Gets the value of the comAfgPayrollVendor property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getComAfgPayrollVendor() {
                    return comAfgPayrollVendor;
                }

                /**
                 * Sets the value of the comAfgPayrollVendor property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setComAfgPayrollVendor(String value) {
                    this.comAfgPayrollVendor = value;
                }

                /**
                 * Gets the value of the comAfgUWREVIEW property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getComAfgUWREVIEW() {
                    return comAfgUWREVIEW;
                }

                /**
                 * Sets the value of the comAfgUWREVIEW property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setComAfgUWREVIEW(String value) {
                    this.comAfgUWREVIEW = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="NameInfo">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="PersonName">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                 &lt;/sequence>
                 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "nameInfo"
                })
                public static class GeneralPartyInfo {

                    @XmlElement(name = "NameInfo", required = true)
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo nameInfo;

                    /**
                     * Gets the value of the nameInfo property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo getNameInfo() {
                        return nameInfo;
                    }

                    /**
                     * Sets the value of the nameInfo property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo }
                     *     
                     */
                    public void setNameInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo value) {
                        this.nameInfo = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="PersonName">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *       &lt;/sequence>
                     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "personName"
                    })
                    public static class NameInfo {

                        @XmlElement(name = "PersonName", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo.PersonName personName;
                        @XmlAttribute(name = "id", required = true)
                        protected String id;

                        /**
                         * Gets the value of the personName property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo.PersonName }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo.PersonName getPersonName() {
                            return personName;
                        }

                        /**
                         * Sets the value of the personName property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo.PersonName }
                         *     
                         */
                        public void setPersonName(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.Producer.GeneralPartyInfo.NameInfo.PersonName value) {
                            this.personName = value;
                        }

                        /**
                         * Gets the value of the id property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getId() {
                            return id;
                        }

                        /**
                         * Sets the value of the id property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setId(String value) {
                            this.id = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "surname",
                            "givenName"
                        })
                        public static class PersonName {

                            @XmlElement(name = "Surname", required = true)
                            protected String surname;
                            @XmlElement(name = "GivenName", required = true)
                            protected String givenName;

                            /**
                             * Gets the value of the surname property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getSurname() {
                                return surname;
                            }

                            /**
                             * Sets the value of the surname property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setSurname(String value) {
                                this.surname = value;
                            }

                            /**
                             * Gets the value of the givenName property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getGivenName() {
                                return givenName;
                            }

                            /**
                             * Sets the value of the givenName property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setGivenName(String value) {
                                this.givenName = value;
                            }

                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="AgencyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "agencyId"
                })
                public static class ItemIdInfo {

                    @XmlElement(name = "AgencyId", required = true)
                    protected String agencyId;

                    /**
                     * Gets the value of the agencyId property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAgencyId() {
                        return agencyId;
                    }

                    /**
                     * Sets the value of the agencyId property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAgencyId(String value) {
                        this.agencyId = value;
                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="ContractNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="ProducerSubCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "contractNumber",
                    "producerSubCode"
                })
                public static class ProducerInfo {

                    @XmlElement(name = "ContractNumber")
                    protected String contractNumber;
                    @XmlElement(name = "ProducerSubCode")
                    protected String producerSubCode;

                    /**
                     * Gets the value of the contractNumber property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getContractNumber() {
                        return contractNumber;
                    }

                    /**
                     * Sets the value of the contractNumber property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setContractNumber(String value) {
                        this.contractNumber = value;
                    }

                    /**
                     * Gets the value of the producerSubCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getProducerSubCode() {
                        return producerSubCode;
                    }

                    /**
                     * Sets the value of the producerSubCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setProducerSubCode(String value) {
                        this.producerSubCode = value;
                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="LOBCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="WorkCompRateState" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="ParticipatingPlanInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="AnniversaryRatingDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="LossRatio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="com.afg_PremiumDiscount" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="PremiumDiscountInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="PremiumDiscountPercentage" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="MRCAPriorPolicyYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="CreditOrSurcharge" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="com.afg_CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="NumericValue">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="FormatModFactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="FormatCurrencyAmt" minOccurs="0">
             *                                         &lt;complexType>
             *                                           &lt;complexContent>
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                               &lt;sequence>
             *                                                 &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                               &lt;/sequence>
             *                                             &lt;/restriction>
             *                                           &lt;/complexContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                       &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
             *                                       &lt;element name="com.afg_AnniversaryFactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="ModifierEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="SecondaryCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="com.afg_WorkSafeCredit" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="com.afg_BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="com.afg_WS01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="com.afg_WS02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="com.afg_WS03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="com.afg_SubName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="com.afg_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="WorkCompLocInfo" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *                             &lt;element name="WorkCompRateClass" maxOccurs="unbounded" minOccurs="0">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="ActualRemunerationAmt" minOccurs="0">
             *                                         &lt;complexType>
             *                                           &lt;complexContent>
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                               &lt;sequence>
             *                                                 &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                               &lt;/sequence>
             *                                             &lt;/restriction>
             *                                           &lt;/complexContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                       &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                       &lt;element name="NumEmployeesFullTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                       &lt;element name="NumEmployeesPartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                       &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                       &lt;element name="RatingClassificationCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="RatingClassificationLetter" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="RatingClassificationSubCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="PremiumBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                       &lt;element name="RatingClassificationDescCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                       &lt;element name="Exposure" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *                                       &lt;element name="RatingClassificationDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                       &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
             *                                         &lt;complexType>
             *                                           &lt;complexContent>
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                               &lt;sequence>
             *                                                 &lt;element name="OtherIdentifier">
             *                                                   &lt;complexType>
             *                                                     &lt;complexContent>
             *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                                         &lt;sequence>
             *                                                           &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                           &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *                                                         &lt;/sequence>
             *                                                       &lt;/restriction>
             *                                                     &lt;/complexContent>
             *                                                   &lt;/complexType>
             *                                                 &lt;/element>
             *                                               &lt;/sequence>
             *                                             &lt;/restriction>
             *                                           &lt;/complexContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                       &lt;element name="ClassCodeQuestions" minOccurs="0">
             *                                         &lt;complexType>
             *                                           &lt;complexContent>
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                               &lt;sequence>
             *                                                 &lt;element name="ClassCodeQuestion" maxOccurs="unbounded" minOccurs="0">
             *                                                   &lt;complexType>
             *                                                     &lt;complexContent>
             *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                                         &lt;sequence>
             *                                                           &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                           &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                           &lt;element name="ResponseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                                           &lt;element name="PercentageAnswerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                                           &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                                                           &lt;element name="OptionResponse" maxOccurs="unbounded" minOccurs="0">
             *                                                             &lt;complexType>
             *                                                               &lt;complexContent>
             *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                                                   &lt;sequence>
             *                                                                     &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                                     &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                                                   &lt;/sequence>
             *                                                                 &lt;/restriction>
             *                                                               &lt;/complexContent>
             *                                                             &lt;/complexType>
             *                                                           &lt;/element>
             *                                                         &lt;/sequence>
             *                                                       &lt;/restriction>
             *                                                     &lt;/complexContent>
             *                                                   &lt;/complexType>
             *                                                 &lt;/element>
             *                                               &lt;/sequence>
             *                                             &lt;/restriction>
             *                                           &lt;/complexContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                           &lt;/sequence>
             *                           &lt;attribute name="LocationRef" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="com.afg_Form" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="FormName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="FormDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="EditionDt" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="com.afg_ItemIdInfo" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="OtherIdentifier">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                       &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="CommlCoverage">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="CoverageCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="CoverageDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="Limit" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="FormatCurrencyAmt">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="LimitAppliesToCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="Deductible" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="FormatCurrencyAmt">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="DeductibleTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="CurrentTermAmt" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="Ineligibility">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="Statement">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                             &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="Explanation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "lobCd",
                "workCompRateState",
                "commlCoverage",
                "ineligibility",
                "statement"
            })
            public static class WorkCompLineBusiness {

                @XmlElement(name = "LOBCd")
                protected String lobCd;
                @XmlElement(name = "WorkCompRateState")
                protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState> workCompRateState;
                @XmlElement(name = "CommlCoverage", required = true)
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage commlCoverage;
                @XmlElement(name = "Ineligibility", required = true)
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Ineligibility ineligibility;
                @XmlElement(name = "Statement", required = true)
                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Statement statement;

                /**
                 * Gets the value of the lobCd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLOBCd() {
                    return lobCd;
                }

                /**
                 * Sets the value of the lobCd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLOBCd(String value) {
                    this.lobCd = value;
                }

                /**
                 * Gets the value of the workCompRateState property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the workCompRateState property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getWorkCompRateState().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState }
                 * 
                 * 
                 */
                public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState> getWorkCompRateState() {
                    if (workCompRateState == null) {
                        workCompRateState = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState>();
                    }
                    return this.workCompRateState;
                }

                /**
                 * Gets the value of the commlCoverage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage getCommlCoverage() {
                    return commlCoverage;
                }

                /**
                 * Sets the value of the commlCoverage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage }
                 *     
                 */
                public void setCommlCoverage(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage value) {
                    this.commlCoverage = value;
                }

                /**
                 * Gets the value of the ineligibility property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Ineligibility }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Ineligibility getIneligibility() {
                    return ineligibility;
                }

                /**
                 * Sets the value of the ineligibility property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Ineligibility }
                 *     
                 */
                public void setIneligibility(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Ineligibility value) {
                    this.ineligibility = value;
                }

                /**
                 * Gets the value of the statement property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Statement }
                 *     
                 */
                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Statement getStatement() {
                    return statement;
                }

                /**
                 * Sets the value of the statement property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Statement }
                 *     
                 */
                public void setStatement(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Statement value) {
                    this.statement = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="CoverageCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="CoverageDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="Limit" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="FormatCurrencyAmt">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="LimitAppliesToCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="Deductible" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="FormatCurrencyAmt">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="DeductibleTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="CurrentTermAmt" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "coverageCd",
                    "coverageDesc",
                    "limit",
                    "deductible",
                    "currentTermAmt"
                })
                public static class CommlCoverage {

                    @XmlElement(name = "CoverageCd", required = true)
                    protected String coverageCd;
                    @XmlElement(name = "CoverageDesc", required = true)
                    protected String coverageDesc;
                    @XmlElement(name = "Limit")
                    protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Limit> limit;
                    @XmlElement(name = "Deductible")
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible deductible;
                    @XmlElement(name = "CurrentTermAmt")
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.CurrentTermAmt currentTermAmt;

                    /**
                     * Gets the value of the coverageCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCoverageCd() {
                        return coverageCd;
                    }

                    /**
                     * Sets the value of the coverageCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCoverageCd(String value) {
                        this.coverageCd = value;
                    }

                    /**
                     * Gets the value of the coverageDesc property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCoverageDesc() {
                        return coverageDesc;
                    }

                    /**
                     * Sets the value of the coverageDesc property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCoverageDesc(String value) {
                        this.coverageDesc = value;
                    }

                    /**
                     * Gets the value of the limit property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the limit property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getLimit().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Limit }
                     * 
                     * 
                     */
                    public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Limit> getLimit() {
                        if (limit == null) {
                            limit = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Limit>();
                        }
                        return this.limit;
                    }

                    /**
                     * Gets the value of the deductible property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible getDeductible() {
                        return deductible;
                    }

                    /**
                     * Sets the value of the deductible property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible }
                     *     
                     */
                    public void setDeductible(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible value) {
                        this.deductible = value;
                    }

                    /**
                     * Gets the value of the currentTermAmt property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.CurrentTermAmt }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.CurrentTermAmt getCurrentTermAmt() {
                        return currentTermAmt;
                    }

                    /**
                     * Sets the value of the currentTermAmt property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.CurrentTermAmt }
                     *     
                     */
                    public void setCurrentTermAmt(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.CurrentTermAmt value) {
                        this.currentTermAmt = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "amt"
                    })
                    public static class CurrentTermAmt {

                        @XmlElement(name = "Amt", required = true)
                        protected String amt;

                        /**
                         * Gets the value of the amt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAmt() {
                            return amt;
                        }

                        /**
                         * Sets the value of the amt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAmt(String value) {
                            this.amt = value;
                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="FormatCurrencyAmt">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="DeductibleTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "formatCurrencyAmt",
                        "deductibleTypeCd"
                    })
                    public static class Deductible {

                        @XmlElement(name = "FormatCurrencyAmt", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible.FormatCurrencyAmt formatCurrencyAmt;
                        @XmlElement(name = "DeductibleTypeCd", required = true)
                        protected String deductibleTypeCd;

                        /**
                         * Gets the value of the formatCurrencyAmt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible.FormatCurrencyAmt }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible.FormatCurrencyAmt getFormatCurrencyAmt() {
                            return formatCurrencyAmt;
                        }

                        /**
                         * Sets the value of the formatCurrencyAmt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible.FormatCurrencyAmt }
                         *     
                         */
                        public void setFormatCurrencyAmt(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Deductible.FormatCurrencyAmt value) {
                            this.formatCurrencyAmt = value;
                        }

                        /**
                         * Gets the value of the deductibleTypeCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getDeductibleTypeCd() {
                            return deductibleTypeCd;
                        }

                        /**
                         * Sets the value of the deductibleTypeCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setDeductibleTypeCd(String value) {
                            this.deductibleTypeCd = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "amt"
                        })
                        public static class FormatCurrencyAmt {

                            @XmlElement(name = "Amt", required = true)
                            protected String amt;

                            /**
                             * Gets the value of the amt property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getAmt() {
                                return amt;
                            }

                            /**
                             * Sets the value of the amt property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setAmt(String value) {
                                this.amt = value;
                            }

                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="FormatCurrencyAmt">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="LimitAppliesToCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "formatCurrencyAmt",
                        "limitAppliesToCd"
                    })
                    public static class Limit {

                        @XmlElement(name = "FormatCurrencyAmt", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Limit.FormatCurrencyAmt formatCurrencyAmt;
                        @XmlElement(name = "LimitAppliesToCd", required = true)
                        protected String limitAppliesToCd;

                        /**
                         * Gets the value of the formatCurrencyAmt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Limit.FormatCurrencyAmt }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Limit.FormatCurrencyAmt getFormatCurrencyAmt() {
                            return formatCurrencyAmt;
                        }

                        /**
                         * Sets the value of the formatCurrencyAmt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Limit.FormatCurrencyAmt }
                         *     
                         */
                        public void setFormatCurrencyAmt(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.CommlCoverage.Limit.FormatCurrencyAmt value) {
                            this.formatCurrencyAmt = value;
                        }

                        /**
                         * Gets the value of the limitAppliesToCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getLimitAppliesToCd() {
                            return limitAppliesToCd;
                        }

                        /**
                         * Sets the value of the limitAppliesToCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setLimitAppliesToCd(String value) {
                            this.limitAppliesToCd = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}int"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "amt"
                        })
                        public static class FormatCurrencyAmt {

                            @XmlElement(name = "Amt")
                            protected int amt;

                            /**
                             * Gets the value of the amt property.
                             * 
                             */
                            public int getAmt() {
                                return amt;
                            }

                            /**
                             * Sets the value of the amt property.
                             * 
                             */
                            public void setAmt(int value) {
                                this.amt = value;
                            }

                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "disclaimer",
                    "questionAnswer"
                })
                public static class Ineligibility {

                    @XmlElement(name = "Disclaimer")
                    protected String disclaimer;
                    @XmlElement(name = "QuestionAnswer")
                    protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Ineligibility.QuestionAnswer> questionAnswer;

                    /**
                     * Gets the value of the disclaimer property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDisclaimer() {
                        return disclaimer;
                    }

                    /**
                     * Sets the value of the disclaimer property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDisclaimer(String value) {
                        this.disclaimer = value;
                    }

                    /**
                     * Gets the value of the questionAnswer property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the questionAnswer property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getQuestionAnswer().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Ineligibility.QuestionAnswer }
                     * 
                     * 
                     */
                    public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Ineligibility.QuestionAnswer> getQuestionAnswer() {
                        if (questionAnswer == null) {
                            questionAnswer = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Ineligibility.QuestionAnswer>();
                        }
                        return this.questionAnswer;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "questionCd",
                        "questionText",
                        "yesNoCd"
                    })
                    public static class QuestionAnswer {

                        @XmlElement(name = "QuestionCd", required = true)
                        protected String questionCd;
                        @XmlElement(name = "QuestionText")
                        protected String questionText;
                        @XmlElement(name = "YesNoCd", required = true)
                        protected String yesNoCd;

                        /**
                         * Gets the value of the questionCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQuestionCd() {
                            return questionCd;
                        }

                        /**
                         * Sets the value of the questionCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQuestionCd(String value) {
                            this.questionCd = value;
                        }

                        /**
                         * Gets the value of the questionText property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQuestionText() {
                            return questionText;
                        }

                        /**
                         * Sets the value of the questionText property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQuestionText(String value) {
                            this.questionText = value;
                        }

                        /**
                         * Gets the value of the yesNoCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getYesNoCd() {
                            return yesNoCd;
                        }

                        /**
                         * Sets the value of the yesNoCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setYesNoCd(String value) {
                            this.yesNoCd = value;
                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="Disclaimer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="QuestionAnswer" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="Explanation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "disclaimer",
                    "questionAnswer"
                })
                public static class Statement {

                    @XmlElement(name = "Disclaimer")
                    protected String disclaimer;
                    @XmlElement(name = "QuestionAnswer")
                    protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Statement.QuestionAnswer> questionAnswer;

                    /**
                     * Gets the value of the disclaimer property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDisclaimer() {
                        return disclaimer;
                    }

                    /**
                     * Sets the value of the disclaimer property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDisclaimer(String value) {
                        this.disclaimer = value;
                    }

                    /**
                     * Gets the value of the questionAnswer property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the questionAnswer property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getQuestionAnswer().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Statement.QuestionAnswer }
                     * 
                     * 
                     */
                    public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Statement.QuestionAnswer> getQuestionAnswer() {
                        if (questionAnswer == null) {
                            questionAnswer = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.Statement.QuestionAnswer>();
                        }
                        return this.questionAnswer;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="YesNoCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="Explanation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "questionCd",
                        "questionText",
                        "yesNoCd",
                        "explanation"
                    })
                    public static class QuestionAnswer {

                        @XmlElement(name = "QuestionCd", required = true)
                        protected String questionCd;
                        @XmlElement(name = "QuestionText")
                        protected String questionText;
                        @XmlElement(name = "YesNoCd", required = true)
                        protected String yesNoCd;
                        @XmlElement(name = "Explanation")
                        protected String explanation;

                        /**
                         * Gets the value of the questionCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQuestionCd() {
                            return questionCd;
                        }

                        /**
                         * Sets the value of the questionCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQuestionCd(String value) {
                            this.questionCd = value;
                        }

                        /**
                         * Gets the value of the questionText property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getQuestionText() {
                            return questionText;
                        }

                        /**
                         * Sets the value of the questionText property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setQuestionText(String value) {
                            this.questionText = value;
                        }

                        /**
                         * Gets the value of the yesNoCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getYesNoCd() {
                            return yesNoCd;
                        }

                        /**
                         * Sets the value of the yesNoCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setYesNoCd(String value) {
                            this.yesNoCd = value;
                        }

                        /**
                         * Gets the value of the explanation property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getExplanation() {
                            return explanation;
                        }

                        /**
                         * Sets the value of the explanation property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setExplanation(String value) {
                            this.explanation = value;
                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="StateProvCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="ParticipatingPlanInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="AnniversaryRatingDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="NCCIIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="LossRatio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="com.afg_PremiumDiscount" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="PremiumDiscountInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="PremiumDiscountPercentage" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="MRCAPriorPolicyYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="CreditOrSurcharge" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="com.afg_CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="NumericValue">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="FormatModFactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="FormatCurrencyAmt" minOccurs="0">
                 *                               &lt;complexType>
                 *                                 &lt;complexContent>
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                     &lt;sequence>
                 *                                       &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                     &lt;/sequence>
                 *                                   &lt;/restriction>
                 *                                 &lt;/complexContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                             &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
                 *                             &lt;element name="com.afg_AnniversaryFactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="ModifierEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="SecondaryCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="com.afg_WorkSafeCredit" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="com.afg_BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="com.afg_WS01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="com.afg_WS02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="com.afg_WS03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                   &lt;element name="com.afg_SubName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="com.afg_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="WorkCompLocInfo" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
                 *                   &lt;element name="WorkCompRateClass" maxOccurs="unbounded" minOccurs="0">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="ActualRemunerationAmt" minOccurs="0">
                 *                               &lt;complexType>
                 *                                 &lt;complexContent>
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                     &lt;sequence>
                 *                                       &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                     &lt;/sequence>
                 *                                   &lt;/restriction>
                 *                                 &lt;/complexContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                             &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                             &lt;element name="NumEmployeesFullTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                             &lt;element name="NumEmployeesPartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                             &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                             &lt;element name="RatingClassificationCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="RatingClassificationLetter" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="RatingClassificationSubCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="PremiumBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                             &lt;element name="RatingClassificationDescCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                             &lt;element name="Exposure" type="{http://www.w3.org/2001/XMLSchema}int"/>
                 *                             &lt;element name="RatingClassificationDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                             &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
                 *                               &lt;complexType>
                 *                                 &lt;complexContent>
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                     &lt;sequence>
                 *                                       &lt;element name="OtherIdentifier">
                 *                                         &lt;complexType>
                 *                                           &lt;complexContent>
                 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                               &lt;sequence>
                 *                                                 &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                                 &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}int"/>
                 *                                               &lt;/sequence>
                 *                                             &lt;/restriction>
                 *                                           &lt;/complexContent>
                 *                                         &lt;/complexType>
                 *                                       &lt;/element>
                 *                                     &lt;/sequence>
                 *                                   &lt;/restriction>
                 *                                 &lt;/complexContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                             &lt;element name="ClassCodeQuestions" minOccurs="0">
                 *                               &lt;complexType>
                 *                                 &lt;complexContent>
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                     &lt;sequence>
                 *                                       &lt;element name="ClassCodeQuestion" maxOccurs="unbounded" minOccurs="0">
                 *                                         &lt;complexType>
                 *                                           &lt;complexContent>
                 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                               &lt;sequence>
                 *                                                 &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                                 &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                                 &lt;element name="ResponseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                                                 &lt;element name="PercentageAnswerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                                                 &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *                                                 &lt;element name="OptionResponse" maxOccurs="unbounded" minOccurs="0">
                 *                                                   &lt;complexType>
                 *                                                     &lt;complexContent>
                 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                                         &lt;sequence>
                 *                                                           &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                                           &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                                                         &lt;/sequence>
                 *                                                       &lt;/restriction>
                 *                                                     &lt;/complexContent>
                 *                                                   &lt;/complexType>
                 *                                                 &lt;/element>
                 *                                               &lt;/sequence>
                 *                                             &lt;/restriction>
                 *                                           &lt;/complexContent>
                 *                                         &lt;/complexType>
                 *                                       &lt;/element>
                 *                                     &lt;/sequence>
                 *                                   &lt;/restriction>
                 *                                 &lt;/complexContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                 &lt;/sequence>
                 *                 &lt;attribute name="LocationRef" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="com.afg_Form" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="FormName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="FormDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="EditionDt" type="{http://www.w3.org/2001/XMLSchema}short"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="com.afg_ItemIdInfo" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="OtherIdentifier">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                             &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "stateProvCd",
                    "participatingPlanInd",
                    "anniversaryRatingDt",
                    "ncciidNumber",
                    "lossRatio",
                    "comAfgPremiumDiscount",
                    "mrcaPriorPolicyYear",
                    "creditOrSurcharge",
                    "comAfgWorkSafeCredit",
                    "workCompLocInfo",
                    "comAfgForm",
                    "comAfgItemIdInfo"
                })
                public static class WorkCompRateState {

                    @XmlElement(name = "StateProvCd")
                    protected String stateProvCd;
                    @XmlElement(name = "ParticipatingPlanInd")
                    protected String participatingPlanInd;
                    @XmlElement(name = "AnniversaryRatingDt")
                    protected String anniversaryRatingDt;
                    @XmlElement(name = "NCCIIDNumber")
                    protected String ncciidNumber;
                    @XmlElement(name = "LossRatio")
                    protected String lossRatio;
                    @XmlElement(name = "com.afg_PremiumDiscount")
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgPremiumDiscount comAfgPremiumDiscount;
                    @XmlElement(name = "MRCAPriorPolicyYear")
                    protected String mrcaPriorPolicyYear;
                    @XmlElement(name = "CreditOrSurcharge")
                    protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge> creditOrSurcharge;
                    @XmlElement(name = "com.afg_WorkSafeCredit")
                    protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgWorkSafeCredit comAfgWorkSafeCredit;
                    @XmlElement(name = "WorkCompLocInfo")
                    protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo> workCompLocInfo;
                    @XmlElement(name = "com.afg_Form")
                    protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgForm> comAfgForm;
                    @XmlElement(name = "com.afg_ItemIdInfo")
                    protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgItemIdInfo> comAfgItemIdInfo;

                    /**
                     * Gets the value of the stateProvCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getStateProvCd() {
                        return stateProvCd;
                    }

                    /**
                     * Sets the value of the stateProvCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setStateProvCd(String value) {
                        this.stateProvCd = value;
                    }

                    /**
                     * Gets the value of the participatingPlanInd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getParticipatingPlanInd() {
                        return participatingPlanInd;
                    }

                    /**
                     * Sets the value of the participatingPlanInd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setParticipatingPlanInd(String value) {
                        this.participatingPlanInd = value;
                    }

                    /**
                     * Gets the value of the anniversaryRatingDt property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAnniversaryRatingDt() {
                        return anniversaryRatingDt;
                    }

                    /**
                     * Sets the value of the anniversaryRatingDt property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAnniversaryRatingDt(String value) {
                        this.anniversaryRatingDt = value;
                    }

                    /**
                     * Gets the value of the ncciidNumber property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNCCIIDNumber() {
                        return ncciidNumber;
                    }

                    /**
                     * Sets the value of the ncciidNumber property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNCCIIDNumber(String value) {
                        this.ncciidNumber = value;
                    }

                    /**
                     * Gets the value of the lossRatio property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getLossRatio() {
                        return lossRatio;
                    }

                    /**
                     * Sets the value of the lossRatio property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setLossRatio(String value) {
                        this.lossRatio = value;
                    }

                    /**
                     * Gets the value of the comAfgPremiumDiscount property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgPremiumDiscount }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgPremiumDiscount getComAfgPremiumDiscount() {
                        return comAfgPremiumDiscount;
                    }

                    /**
                     * Sets the value of the comAfgPremiumDiscount property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgPremiumDiscount }
                     *     
                     */
                    public void setComAfgPremiumDiscount(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgPremiumDiscount value) {
                        this.comAfgPremiumDiscount = value;
                    }

                    /**
                     * Gets the value of the mrcaPriorPolicyYear property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getMRCAPriorPolicyYear() {
                        return mrcaPriorPolicyYear;
                    }

                    /**
                     * Sets the value of the mrcaPriorPolicyYear property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setMRCAPriorPolicyYear(String value) {
                        this.mrcaPriorPolicyYear = value;
                    }

                    /**
                     * Gets the value of the creditOrSurcharge property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the creditOrSurcharge property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getCreditOrSurcharge().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge }
                     * 
                     * 
                     */
                    public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge> getCreditOrSurcharge() {
                        if (creditOrSurcharge == null) {
                            creditOrSurcharge = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge>();
                        }
                        return this.creditOrSurcharge;
                    }

                    /**
                     * Gets the value of the comAfgWorkSafeCredit property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgWorkSafeCredit }
                     *     
                     */
                    public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgWorkSafeCredit getComAfgWorkSafeCredit() {
                        return comAfgWorkSafeCredit;
                    }

                    /**
                     * Sets the value of the comAfgWorkSafeCredit property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgWorkSafeCredit }
                     *     
                     */
                    public void setComAfgWorkSafeCredit(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgWorkSafeCredit value) {
                        this.comAfgWorkSafeCredit = value;
                    }

                    /**
                     * Gets the value of the workCompLocInfo property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the workCompLocInfo property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getWorkCompLocInfo().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo }
                     * 
                     * 
                     */
                    public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo> getWorkCompLocInfo() {
                        if (workCompLocInfo == null) {
                            workCompLocInfo = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo>();
                        }
                        return this.workCompLocInfo;
                    }

                    /**
                     * Gets the value of the comAfgForm property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the comAfgForm property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getComAfgForm().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgForm }
                     * 
                     * 
                     */
                    public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgForm> getComAfgForm() {
                        if (comAfgForm == null) {
                            comAfgForm = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgForm>();
                        }
                        return this.comAfgForm;
                    }

                    /**
                     * Gets the value of the comAfgItemIdInfo property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the comAfgItemIdInfo property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getComAfgItemIdInfo().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgItemIdInfo }
                     * 
                     * 
                     */
                    public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgItemIdInfo> getComAfgItemIdInfo() {
                        if (comAfgItemIdInfo == null) {
                            comAfgItemIdInfo = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgItemIdInfo>();
                        }
                        return this.comAfgItemIdInfo;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="FormName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="FormDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="EditionDt" type="{http://www.w3.org/2001/XMLSchema}short"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "formName",
                        "formDesc",
                        "editionDt"
                    })
                    public static class ComAfgForm {

                        @XmlElement(name = "FormName", required = true)
                        protected String formName;
                        @XmlElement(name = "FormDesc", required = true)
                        protected String formDesc;
                        @XmlElement(name = "EditionDt")
                        protected short editionDt;

                        /**
                         * Gets the value of the formName property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFormName() {
                            return formName;
                        }

                        /**
                         * Sets the value of the formName property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFormName(String value) {
                            this.formName = value;
                        }

                        /**
                         * Gets the value of the formDesc property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFormDesc() {
                            return formDesc;
                        }

                        /**
                         * Sets the value of the formDesc property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFormDesc(String value) {
                            this.formDesc = value;
                        }

                        /**
                         * Gets the value of the editionDt property.
                         * 
                         */
                        public short getEditionDt() {
                            return editionDt;
                        }

                        /**
                         * Sets the value of the editionDt property.
                         * 
                         */
                        public void setEditionDt(short value) {
                            this.editionDt = value;
                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="OtherIdentifier">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "otherIdentifier"
                    })
                    public static class ComAfgItemIdInfo {

                        @XmlElement(name = "OtherIdentifier", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgItemIdInfo.OtherIdentifier otherIdentifier;

                        /**
                         * Gets the value of the otherIdentifier property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgItemIdInfo.OtherIdentifier }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgItemIdInfo.OtherIdentifier getOtherIdentifier() {
                            return otherIdentifier;
                        }

                        /**
                         * Sets the value of the otherIdentifier property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgItemIdInfo.OtherIdentifier }
                         *     
                         */
                        public void setOtherIdentifier(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.ComAfgItemIdInfo.OtherIdentifier value) {
                            this.otherIdentifier = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "otherIdTypeCd",
                            "otherId"
                        })
                        public static class OtherIdentifier {

                            @XmlElement(name = "OtherIdTypeCd", required = true)
                            protected String otherIdTypeCd;
                            @XmlElement(name = "OtherId", required = true)
                            protected String otherId;

                            /**
                             * Gets the value of the otherIdTypeCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getOtherIdTypeCd() {
                                return otherIdTypeCd;
                            }

                            /**
                             * Sets the value of the otherIdTypeCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setOtherIdTypeCd(String value) {
                                this.otherIdTypeCd = value;
                            }

                            /**
                             * Gets the value of the otherId property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getOtherId() {
                                return otherId;
                            }

                            /**
                             * Sets the value of the otherId property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setOtherId(String value) {
                                this.otherId = value;
                            }

                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="PremiumDiscountInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="PremiumDiscountPercentage" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "premiumDiscountInd",
                        "premiumDiscountPercentage"
                    })
                    public static class ComAfgPremiumDiscount {

                        @XmlElement(name = "PremiumDiscountInd", required = true)
                        protected String premiumDiscountInd;
                        @XmlElement(name = "PremiumDiscountPercentage", required = true)
                        protected String premiumDiscountPercentage;

                        /**
                         * Gets the value of the premiumDiscountInd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getPremiumDiscountInd() {
                            return premiumDiscountInd;
                        }

                        /**
                         * Sets the value of the premiumDiscountInd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setPremiumDiscountInd(String value) {
                            this.premiumDiscountInd = value;
                        }

                        /**
                         * Gets the value of the premiumDiscountPercentage property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getPremiumDiscountPercentage() {
                            return premiumDiscountPercentage;
                        }

                        /**
                         * Sets the value of the premiumDiscountPercentage property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setPremiumDiscountPercentage(String value) {
                            this.premiumDiscountPercentage = value;
                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="com.afg_BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="com.afg_WS01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="com.afg_WS02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="com.afg_WS03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="com.afg_SubName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="com.afg_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "comAfgBusinessName",
                        "comAfgWS01",
                        "comAfgWS02",
                        "comAfgWS03",
                        "comAfgSubName",
                        "comAfgTitle"
                    })
                    public static class ComAfgWorkSafeCredit {

                        @XmlElement(name = "com.afg_BusinessName")
                        protected String comAfgBusinessName;
                        @XmlElement(name = "com.afg_WS01")
                        protected String comAfgWS01;
                        @XmlElement(name = "com.afg_WS02")
                        protected String comAfgWS02;
                        @XmlElement(name = "com.afg_WS03")
                        protected String comAfgWS03;
                        @XmlElement(name = "com.afg_SubName", required = true)
                        protected String comAfgSubName;
                        @XmlElement(name = "com.afg_Title", required = true)
                        protected String comAfgTitle;

                        /**
                         * Gets the value of the comAfgBusinessName property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgBusinessName() {
                            return comAfgBusinessName;
                        }

                        /**
                         * Sets the value of the comAfgBusinessName property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgBusinessName(String value) {
                            this.comAfgBusinessName = value;
                        }

                        /**
                         * Gets the value of the comAfgWS01 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgWS01() {
                            return comAfgWS01;
                        }

                        /**
                         * Sets the value of the comAfgWS01 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgWS01(String value) {
                            this.comAfgWS01 = value;
                        }

                        /**
                         * Gets the value of the comAfgWS02 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgWS02() {
                            return comAfgWS02;
                        }

                        /**
                         * Sets the value of the comAfgWS02 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgWS02(String value) {
                            this.comAfgWS02 = value;
                        }

                        /**
                         * Gets the value of the comAfgWS03 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgWS03() {
                            return comAfgWS03;
                        }

                        /**
                         * Sets the value of the comAfgWS03 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgWS03(String value) {
                            this.comAfgWS03 = value;
                        }

                        /**
                         * Gets the value of the comAfgSubName property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgSubName() {
                            return comAfgSubName;
                        }

                        /**
                         * Sets the value of the comAfgSubName property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgSubName(String value) {
                            this.comAfgSubName = value;
                        }

                        /**
                         * Gets the value of the comAfgTitle property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgTitle() {
                            return comAfgTitle;
                        }

                        /**
                         * Sets the value of the comAfgTitle property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgTitle(String value) {
                            this.comAfgTitle = value;
                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="com.afg_CreditSurchargeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *         &lt;element name="NumericValue">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="FormatModFactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="FormatCurrencyAmt" minOccurs="0">
                     *                     &lt;complexType>
                     *                       &lt;complexContent>
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                           &lt;sequence>
                     *                             &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                           &lt;/sequence>
                     *                         &lt;/restriction>
                     *                       &lt;/complexContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                   &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
                     *                   &lt;element name="com.afg_AnniversaryFactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="ModifierEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="SecondaryCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *       &lt;/sequence>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "creditSurchargeCd",
                        "comAfgCreditSurchargeCd",
                        "numericValue",
                        "modifierEffectiveDate",
                        "secondaryCd"
                    })
                    public static class CreditOrSurcharge {

                        @XmlElement(name = "CreditSurchargeCd", required = true)
                        protected String creditSurchargeCd;
                        @XmlElement(name = "com.afg_CreditSurchargeCd")
                        protected String comAfgCreditSurchargeCd;
                        @XmlElement(name = "NumericValue", required = true)
                        protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue numericValue;
                        @XmlElement(name = "ModifierEffectiveDate", required = true)
                        protected String modifierEffectiveDate;
                        @XmlElement(name = "SecondaryCd")
                        protected String secondaryCd;

                        /**
                         * Gets the value of the creditSurchargeCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCreditSurchargeCd() {
                            return creditSurchargeCd;
                        }

                        /**
                         * Sets the value of the creditSurchargeCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCreditSurchargeCd(String value) {
                            this.creditSurchargeCd = value;
                        }

                        /**
                         * Gets the value of the comAfgCreditSurchargeCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComAfgCreditSurchargeCd() {
                            return comAfgCreditSurchargeCd;
                        }

                        /**
                         * Sets the value of the comAfgCreditSurchargeCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComAfgCreditSurchargeCd(String value) {
                            this.comAfgCreditSurchargeCd = value;
                        }

                        /**
                         * Gets the value of the numericValue property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue }
                         *     
                         */
                        public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue getNumericValue() {
                            return numericValue;
                        }

                        /**
                         * Sets the value of the numericValue property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue }
                         *     
                         */
                        public void setNumericValue(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue value) {
                            this.numericValue = value;
                        }

                        /**
                         * Gets the value of the modifierEffectiveDate property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getModifierEffectiveDate() {
                            return modifierEffectiveDate;
                        }

                        /**
                         * Sets the value of the modifierEffectiveDate property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setModifierEffectiveDate(String value) {
                            this.modifierEffectiveDate = value;
                        }

                        /**
                         * Gets the value of the secondaryCd property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getSecondaryCd() {
                            return secondaryCd;
                        }

                        /**
                         * Sets the value of the secondaryCd property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setSecondaryCd(String value) {
                            this.secondaryCd = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="FormatModFactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="FormatCurrencyAmt" minOccurs="0">
                         *           &lt;complexType>
                         *             &lt;complexContent>
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                 &lt;sequence>
                         *                   &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                 &lt;/sequence>
                         *               &lt;/restriction>
                         *             &lt;/complexContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
                         *         &lt;element name="FormatInteger" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
                         *         &lt;element name="com.afg_AnniversaryFactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "formatModFactor",
                            "formatCurrencyAmt",
                            "formatInteger",
                            "comAfgAnniversaryFactor"
                        })
                        public static class NumericValue {

                            @XmlElement(name = "FormatModFactor", required = true)
                            protected String formatModFactor;
                            @XmlElement(name = "FormatCurrencyAmt")
                            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue.FormatCurrencyAmt formatCurrencyAmt;
                            @XmlElement(name = "FormatInteger")
                            protected List<String> formatInteger;
                            @XmlElement(name = "com.afg_AnniversaryFactor")
                            protected String comAfgAnniversaryFactor;

                            /**
                             * Gets the value of the formatModFactor property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getFormatModFactor() {
                                return formatModFactor;
                            }

                            /**
                             * Sets the value of the formatModFactor property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setFormatModFactor(String value) {
                                this.formatModFactor = value;
                            }

                            /**
                             * Gets the value of the formatCurrencyAmt property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue.FormatCurrencyAmt }
                             *     
                             */
                            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue.FormatCurrencyAmt getFormatCurrencyAmt() {
                                return formatCurrencyAmt;
                            }

                            /**
                             * Sets the value of the formatCurrencyAmt property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue.FormatCurrencyAmt }
                             *     
                             */
                            public void setFormatCurrencyAmt(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.CreditOrSurcharge.NumericValue.FormatCurrencyAmt value) {
                                this.formatCurrencyAmt = value;
                            }

                            /**
                             * Gets the value of the formatInteger property.
                             * 
                             * <p>
                             * This accessor method returns a reference to the live list,
                             * not a snapshot. Therefore any modification you make to the
                             * returned list will be present inside the JAXB object.
                             * This is why there is not a <CODE>set</CODE> method for the formatInteger property.
                             * 
                             * <p>
                             * For example, to add a new item, do as follows:
                             * <pre>
                             *    getFormatInteger().add(newItem);
                             * </pre>
                             * 
                             * 
                             * <p>
                             * Objects of the following type(s) are allowed in the list
                             * {@link String }
                             * 
                             * 
                             */
                            public List<String> getFormatInteger() {
                                if (formatInteger == null) {
                                    formatInteger = new ArrayList<String>();
                                }
                                return this.formatInteger;
                            }

                            /**
                             * Gets the value of the comAfgAnniversaryFactor property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getComAfgAnniversaryFactor() {
                                return comAfgAnniversaryFactor;
                            }

                            /**
                             * Sets the value of the comAfgAnniversaryFactor property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setComAfgAnniversaryFactor(String value) {
                                this.comAfgAnniversaryFactor = value;
                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType>
                             *   &lt;complexContent>
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *       &lt;sequence>
                             *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *       &lt;/sequence>
                             *     &lt;/restriction>
                             *   &lt;/complexContent>
                             * &lt;/complexType>
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "amt"
                            })
                            public static class FormatCurrencyAmt {

                                @XmlElement(name = "Amt", required = true)
                                protected String amt;

                                /**
                                 * Gets the value of the amt property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getAmt() {
                                    return amt;
                                }

                                /**
                                 * Sets the value of the amt property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setAmt(String value) {
                                    this.amt = value;
                                }

                            }

                        }

                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
                     *         &lt;element name="WorkCompRateClass" maxOccurs="unbounded" minOccurs="0">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="ActualRemunerationAmt" minOccurs="0">
                     *                     &lt;complexType>
                     *                       &lt;complexContent>
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                           &lt;sequence>
                     *                             &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                           &lt;/sequence>
                     *                         &lt;/restriction>
                     *                       &lt;/complexContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                   &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                   &lt;element name="NumEmployeesFullTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                   &lt;element name="NumEmployeesPartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                   &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                   &lt;element name="RatingClassificationCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="RatingClassificationLetter" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="RatingClassificationSubCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                   &lt;element name="PremiumBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                   &lt;element name="RatingClassificationDescCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                   &lt;element name="Exposure" type="{http://www.w3.org/2001/XMLSchema}int"/>
                     *                   &lt;element name="RatingClassificationDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                   &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
                     *                     &lt;complexType>
                     *                       &lt;complexContent>
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                           &lt;sequence>
                     *                             &lt;element name="OtherIdentifier">
                     *                               &lt;complexType>
                     *                                 &lt;complexContent>
                     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                                     &lt;sequence>
                     *                                       &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                                       &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}int"/>
                     *                                     &lt;/sequence>
                     *                                   &lt;/restriction>
                     *                                 &lt;/complexContent>
                     *                               &lt;/complexType>
                     *                             &lt;/element>
                     *                           &lt;/sequence>
                     *                         &lt;/restriction>
                     *                       &lt;/complexContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                   &lt;element name="ClassCodeQuestions" minOccurs="0">
                     *                     &lt;complexType>
                     *                       &lt;complexContent>
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                           &lt;sequence>
                     *                             &lt;element name="ClassCodeQuestion" maxOccurs="unbounded" minOccurs="0">
                     *                               &lt;complexType>
                     *                                 &lt;complexContent>
                     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                                     &lt;sequence>
                     *                                       &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                                       &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                                       &lt;element name="ResponseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                                       &lt;element name="PercentageAnswerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                                       &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                     *                                       &lt;element name="OptionResponse" maxOccurs="unbounded" minOccurs="0">
                     *                                         &lt;complexType>
                     *                                           &lt;complexContent>
                     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                                               &lt;sequence>
                     *                                                 &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                                                 &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *                                               &lt;/sequence>
                     *                                             &lt;/restriction>
                     *                                           &lt;/complexContent>
                     *                                         &lt;/complexType>
                     *                                       &lt;/element>
                     *                                     &lt;/sequence>
                     *                                   &lt;/restriction>
                     *                                 &lt;/complexContent>
                     *                               &lt;/complexType>
                     *                             &lt;/element>
                     *                           &lt;/sequence>
                     *                         &lt;/restriction>
                     *                       &lt;/complexContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *       &lt;/sequence>
                     *       &lt;attribute name="LocationRef" type="{http://www.w3.org/2001/XMLSchema}string" />
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "numEmployees",
                        "workCompRateClass"
                    })
                    public static class WorkCompLocInfo {

                        @XmlElement(name = "NumEmployees")
                        protected Integer numEmployees;
                        @XmlElement(name = "WorkCompRateClass")
                        protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass> workCompRateClass;
                        @XmlAttribute(name = "LocationRef")
                        protected String locationRef;

                        /**
                         * Gets the value of the numEmployees property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Integer }
                         *     
                         */
                        public Integer getNumEmployees() {
                            return numEmployees;
                        }

                        /**
                         * Sets the value of the numEmployees property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Integer }
                         *     
                         */
                        public void setNumEmployees(Integer value) {
                            this.numEmployees = value;
                        }

                        /**
                         * Gets the value of the workCompRateClass property.
                         * 
                         * <p>
                         * This accessor method returns a reference to the live list,
                         * not a snapshot. Therefore any modification you make to the
                         * returned list will be present inside the JAXB object.
                         * This is why there is not a <CODE>set</CODE> method for the workCompRateClass property.
                         * 
                         * <p>
                         * For example, to add a new item, do as follows:
                         * <pre>
                         *    getWorkCompRateClass().add(newItem);
                         * </pre>
                         * 
                         * 
                         * <p>
                         * Objects of the following type(s) are allowed in the list
                         * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass }
                         * 
                         * 
                         */
                        public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass> getWorkCompRateClass() {
                            if (workCompRateClass == null) {
                                workCompRateClass = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass>();
                            }
                            return this.workCompRateClass;
                        }

                        /**
                         * Gets the value of the locationRef property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getLocationRef() {
                            return locationRef;
                        }

                        /**
                         * Sets the value of the locationRef property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setLocationRef(String value) {
                            this.locationRef = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType>
                         *   &lt;complexContent>
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *       &lt;sequence>
                         *         &lt;element name="ActualRemunerationAmt" minOccurs="0">
                         *           &lt;complexType>
                         *             &lt;complexContent>
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                 &lt;sequence>
                         *                   &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                 &lt;/sequence>
                         *               &lt;/restriction>
                         *             &lt;/complexContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
                         *         &lt;element name="NumEmployees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *         &lt;element name="NumEmployeesFullTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *         &lt;element name="NumEmployeesPartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *         &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *         &lt;element name="RatingClassificationCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="RatingClassificationLetter" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="RatingClassificationSubCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *         &lt;element name="PremiumBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *         &lt;element name="RatingClassificationDescCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *         &lt;element name="Exposure" type="{http://www.w3.org/2001/XMLSchema}int"/>
                         *         &lt;element name="RatingClassificationDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *         &lt;element name="com.afg_ItemIdInfo" minOccurs="0">
                         *           &lt;complexType>
                         *             &lt;complexContent>
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                 &lt;sequence>
                         *                   &lt;element name="OtherIdentifier">
                         *                     &lt;complexType>
                         *                       &lt;complexContent>
                         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                           &lt;sequence>
                         *                             &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                             &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}int"/>
                         *                           &lt;/sequence>
                         *                         &lt;/restriction>
                         *                       &lt;/complexContent>
                         *                     &lt;/complexType>
                         *                   &lt;/element>
                         *                 &lt;/sequence>
                         *               &lt;/restriction>
                         *             &lt;/complexContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
                         *         &lt;element name="ClassCodeQuestions" minOccurs="0">
                         *           &lt;complexType>
                         *             &lt;complexContent>
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                 &lt;sequence>
                         *                   &lt;element name="ClassCodeQuestion" maxOccurs="unbounded" minOccurs="0">
                         *                     &lt;complexType>
                         *                       &lt;complexContent>
                         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                           &lt;sequence>
                         *                             &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                             &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                             &lt;element name="ResponseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *                             &lt;element name="PercentageAnswerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *                             &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                         *                             &lt;element name="OptionResponse" maxOccurs="unbounded" minOccurs="0">
                         *                               &lt;complexType>
                         *                                 &lt;complexContent>
                         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                                     &lt;sequence>
                         *                                       &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                                       &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                         *                                     &lt;/sequence>
                         *                                   &lt;/restriction>
                         *                                 &lt;/complexContent>
                         *                               &lt;/complexType>
                         *                             &lt;/element>
                         *                           &lt;/sequence>
                         *                         &lt;/restriction>
                         *                       &lt;/complexContent>
                         *                     &lt;/complexType>
                         *                   &lt;/element>
                         *                 &lt;/sequence>
                         *               &lt;/restriction>
                         *             &lt;/complexContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
                         *       &lt;/sequence>
                         *     &lt;/restriction>
                         *   &lt;/complexContent>
                         * &lt;/complexType>
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "actualRemunerationAmt",
                            "numEmployees",
                            "numEmployeesFullTime",
                            "numEmployeesPartTime",
                            "rate",
                            "ratingClassificationCd",
                            "ratingClassificationLetter",
                            "ratingClassificationSubCd",
                            "premiumBasisCd",
                            "ratingClassificationDescCd",
                            "exposure",
                            "ratingClassificationDesc",
                            "comAfgItemIdInfo",
                            "classCodeQuestions"
                        })
                        public static class WorkCompRateClass {

                            @XmlElement(name = "ActualRemunerationAmt")
                            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ActualRemunerationAmt actualRemunerationAmt;
                            @XmlElement(name = "NumEmployees")
                            protected String numEmployees;
                            @XmlElement(name = "NumEmployeesFullTime")
                            protected String numEmployeesFullTime;
                            @XmlElement(name = "NumEmployeesPartTime")
                            protected String numEmployeesPartTime;
                            @XmlElement(name = "Rate")
                            protected String rate;
                            @XmlElement(name = "RatingClassificationCd", required = true)
                            protected String ratingClassificationCd;
                            @XmlElement(name = "RatingClassificationLetter", required = true)
                            protected String ratingClassificationLetter;
                            @XmlElement(name = "RatingClassificationSubCd", required = true)
                            protected String ratingClassificationSubCd;
                            @XmlElement(name = "PremiumBasisCd")
                            protected String premiumBasisCd;
                            @XmlElement(name = "RatingClassificationDescCd")
                            protected String ratingClassificationDescCd;
                            @XmlElement(name = "Exposure")
                            protected int exposure;
                            @XmlElement(name = "RatingClassificationDesc")
                            protected String ratingClassificationDesc;
                            @XmlElement(name = "com.afg_ItemIdInfo")
                            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo comAfgItemIdInfo;
                            @XmlElement(name = "ClassCodeQuestions")
                            protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions classCodeQuestions;

                            /**
                             * Gets the value of the actualRemunerationAmt property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ActualRemunerationAmt }
                             *     
                             */
                            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ActualRemunerationAmt getActualRemunerationAmt() {
                                return actualRemunerationAmt;
                            }

                            /**
                             * Sets the value of the actualRemunerationAmt property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ActualRemunerationAmt }
                             *     
                             */
                            public void setActualRemunerationAmt(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ActualRemunerationAmt value) {
                                this.actualRemunerationAmt = value;
                            }

                            /**
                             * Gets the value of the numEmployees property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getNumEmployees() {
                                return numEmployees;
                            }

                            /**
                             * Sets the value of the numEmployees property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setNumEmployees(String value) {
                                this.numEmployees = value;
                            }

                            /**
                             * Gets the value of the numEmployeesFullTime property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getNumEmployeesFullTime() {
                                return numEmployeesFullTime;
                            }

                            /**
                             * Sets the value of the numEmployeesFullTime property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setNumEmployeesFullTime(String value) {
                                this.numEmployeesFullTime = value;
                            }

                            /**
                             * Gets the value of the numEmployeesPartTime property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getNumEmployeesPartTime() {
                                return numEmployeesPartTime;
                            }

                            /**
                             * Sets the value of the numEmployeesPartTime property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setNumEmployeesPartTime(String value) {
                                this.numEmployeesPartTime = value;
                            }

                            /**
                             * Gets the value of the rate property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getRate() {
                                return rate;
                            }

                            /**
                             * Sets the value of the rate property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setRate(String value) {
                                this.rate = value;
                            }

                            /**
                             * Gets the value of the ratingClassificationCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getRatingClassificationCd() {
                                return ratingClassificationCd;
                            }

                            /**
                             * Sets the value of the ratingClassificationCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setRatingClassificationCd(String value) {
                                this.ratingClassificationCd = value;
                            }

                            /**
                             * Gets the value of the ratingClassificationLetter property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getRatingClassificationLetter() {
                                return ratingClassificationLetter;
                            }

                            /**
                             * Sets the value of the ratingClassificationLetter property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setRatingClassificationLetter(String value) {
                                this.ratingClassificationLetter = value;
                            }

                            /**
                             * Gets the value of the ratingClassificationSubCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getRatingClassificationSubCd() {
                                return ratingClassificationSubCd;
                            }

                            /**
                             * Sets the value of the ratingClassificationSubCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setRatingClassificationSubCd(String value) {
                                this.ratingClassificationSubCd = value;
                            }

                            /**
                             * Gets the value of the premiumBasisCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getPremiumBasisCd() {
                                return premiumBasisCd;
                            }

                            /**
                             * Sets the value of the premiumBasisCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setPremiumBasisCd(String value) {
                                this.premiumBasisCd = value;
                            }

                            /**
                             * Gets the value of the ratingClassificationDescCd property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getRatingClassificationDescCd() {
                                return ratingClassificationDescCd;
                            }

                            /**
                             * Sets the value of the ratingClassificationDescCd property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setRatingClassificationDescCd(String value) {
                                this.ratingClassificationDescCd = value;
                            }

                            /**
                             * Gets the value of the exposure property.
                             * 
                             */
                            public int getExposure() {
                                return exposure;
                            }

                            /**
                             * Sets the value of the exposure property.
                             * 
                             */
                            public void setExposure(int value) {
                                this.exposure = value;
                            }

                            /**
                             * Gets the value of the ratingClassificationDesc property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getRatingClassificationDesc() {
                                return ratingClassificationDesc;
                            }

                            /**
                             * Sets the value of the ratingClassificationDesc property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setRatingClassificationDesc(String value) {
                                this.ratingClassificationDesc = value;
                            }

                            /**
                             * Gets the value of the comAfgItemIdInfo property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo }
                             *     
                             */
                            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo getComAfgItemIdInfo() {
                                return comAfgItemIdInfo;
                            }

                            /**
                             * Sets the value of the comAfgItemIdInfo property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo }
                             *     
                             */
                            public void setComAfgItemIdInfo(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo value) {
                                this.comAfgItemIdInfo = value;
                            }

                            /**
                             * Gets the value of the classCodeQuestions property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions }
                             *     
                             */
                            public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions getClassCodeQuestions() {
                                return classCodeQuestions;
                            }

                            /**
                             * Sets the value of the classCodeQuestions property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions }
                             *     
                             */
                            public void setClassCodeQuestions(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions value) {
                                this.classCodeQuestions = value;
                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType>
                             *   &lt;complexContent>
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *       &lt;sequence>
                             *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *       &lt;/sequence>
                             *     &lt;/restriction>
                             *   &lt;/complexContent>
                             * &lt;/complexType>
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "amt"
                            })
                            public static class ActualRemunerationAmt {

                                @XmlElement(name = "Amt", required = true)
                                protected String amt;

                                /**
                                 * Gets the value of the amt property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getAmt() {
                                    return amt;
                                }

                                /**
                                 * Sets the value of the amt property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setAmt(String value) {
                                    this.amt = value;
                                }

                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType>
                             *   &lt;complexContent>
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *       &lt;sequence>
                             *         &lt;element name="ClassCodeQuestion" maxOccurs="unbounded" minOccurs="0">
                             *           &lt;complexType>
                             *             &lt;complexContent>
                             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *                 &lt;sequence>
                             *                   &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *                   &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *                   &lt;element name="ResponseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                             *                   &lt;element name="PercentageAnswerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                             *                   &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                             *                   &lt;element name="OptionResponse" maxOccurs="unbounded" minOccurs="0">
                             *                     &lt;complexType>
                             *                       &lt;complexContent>
                             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *                           &lt;sequence>
                             *                             &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *                             &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *                           &lt;/sequence>
                             *                         &lt;/restriction>
                             *                       &lt;/complexContent>
                             *                     &lt;/complexType>
                             *                   &lt;/element>
                             *                 &lt;/sequence>
                             *               &lt;/restriction>
                             *             &lt;/complexContent>
                             *           &lt;/complexType>
                             *         &lt;/element>
                             *       &lt;/sequence>
                             *     &lt;/restriction>
                             *   &lt;/complexContent>
                             * &lt;/complexType>
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "classCodeQuestion"
                            })
                            public static class ClassCodeQuestions {

                                @XmlElement(name = "ClassCodeQuestion")
                                protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions.ClassCodeQuestion> classCodeQuestion;

                                /**
                                 * Gets the value of the classCodeQuestion property.
                                 * 
                                 * <p>
                                 * This accessor method returns a reference to the live list,
                                 * not a snapshot. Therefore any modification you make to the
                                 * returned list will be present inside the JAXB object.
                                 * This is why there is not a <CODE>set</CODE> method for the classCodeQuestion property.
                                 * 
                                 * <p>
                                 * For example, to add a new item, do as follows:
                                 * <pre>
                                 *    getClassCodeQuestion().add(newItem);
                                 * </pre>
                                 * 
                                 * 
                                 * <p>
                                 * Objects of the following type(s) are allowed in the list
                                 * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions.ClassCodeQuestion }
                                 * 
                                 * 
                                 */
                                public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions.ClassCodeQuestion> getClassCodeQuestion() {
                                    if (classCodeQuestion == null) {
                                        classCodeQuestion = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions.ClassCodeQuestion>();
                                    }
                                    return this.classCodeQuestion;
                                }


                                /**
                                 * <p>Java class for anonymous complex type.
                                 * 
                                 * <p>The following schema fragment specifies the expected content contained within this class.
                                 * 
                                 * <pre>
                                 * &lt;complexType>
                                 *   &lt;complexContent>
                                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                                 *       &lt;sequence>
                                 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
                                 *         &lt;element name="QuestionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                                 *         &lt;element name="ResponseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                                 *         &lt;element name="PercentageAnswerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                                 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                                 *         &lt;element name="OptionResponse" maxOccurs="unbounded" minOccurs="0">
                                 *           &lt;complexType>
                                 *             &lt;complexContent>
                                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                                 *                 &lt;sequence>
                                 *                   &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                                 *                   &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                                 *                 &lt;/sequence>
                                 *               &lt;/restriction>
                                 *             &lt;/complexContent>
                                 *           &lt;/complexType>
                                 *         &lt;/element>
                                 *       &lt;/sequence>
                                 *     &lt;/restriction>
                                 *   &lt;/complexContent>
                                 * &lt;/complexType>
                                 * </pre>
                                 * 
                                 * 
                                 */
                                @XmlAccessorType(XmlAccessType.FIELD)
                                @XmlType(name = "", propOrder = {
                                    "questionId",
                                    "questionCd",
                                    "responseInd",
                                    "percentageAnswerValue",
                                    "remarks",
                                    "optionResponse"
                                })
                                public static class ClassCodeQuestion {

                                    @XmlElement(name = "QuestionId", required = true)
                                    protected String questionId;
                                    @XmlElement(name = "QuestionCd", required = true)
                                    protected String questionCd;
                                    @XmlElement(name = "ResponseInd")
                                    protected String responseInd;
                                    @XmlElement(name = "PercentageAnswerValue")
                                    protected String percentageAnswerValue;
                                    @XmlElement(name = "Remarks")
                                    protected String remarks;
                                    @XmlElement(name = "OptionResponse")
                                    protected List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions.ClassCodeQuestion.OptionResponse> optionResponse;

                                    /**
                                     * Gets the value of the questionId property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getQuestionId() {
                                        return questionId;
                                    }

                                    /**
                                     * Sets the value of the questionId property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setQuestionId(String value) {
                                        this.questionId = value;
                                    }

                                    /**
                                     * Gets the value of the questionCd property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getQuestionCd() {
                                        return questionCd;
                                    }

                                    /**
                                     * Sets the value of the questionCd property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setQuestionCd(String value) {
                                        this.questionCd = value;
                                    }

                                    /**
                                     * Gets the value of the responseInd property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getResponseInd() {
                                        return responseInd;
                                    }

                                    /**
                                     * Sets the value of the responseInd property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setResponseInd(String value) {
                                        this.responseInd = value;
                                    }

                                    /**
                                     * Gets the value of the percentageAnswerValue property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getPercentageAnswerValue() {
                                        return percentageAnswerValue;
                                    }

                                    /**
                                     * Sets the value of the percentageAnswerValue property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setPercentageAnswerValue(String value) {
                                        this.percentageAnswerValue = value;
                                    }

                                    /**
                                     * Gets the value of the remarks property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getRemarks() {
                                        return remarks;
                                    }

                                    /**
                                     * Sets the value of the remarks property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setRemarks(String value) {
                                        this.remarks = value;
                                    }

                                    /**
                                     * Gets the value of the optionResponse property.
                                     * 
                                     * <p>
                                     * This accessor method returns a reference to the live list,
                                     * not a snapshot. Therefore any modification you make to the
                                     * returned list will be present inside the JAXB object.
                                     * This is why there is not a <CODE>set</CODE> method for the optionResponse property.
                                     * 
                                     * <p>
                                     * For example, to add a new item, do as follows:
                                     * <pre>
                                     *    getOptionResponse().add(newItem);
                                     * </pre>
                                     * 
                                     * 
                                     * <p>
                                     * Objects of the following type(s) are allowed in the list
                                     * {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions.ClassCodeQuestion.OptionResponse }
                                     * 
                                     * 
                                     */
                                    public List<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions.ClassCodeQuestion.OptionResponse> getOptionResponse() {
                                        if (optionResponse == null) {
                                            optionResponse = new ArrayList<ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ClassCodeQuestions.ClassCodeQuestion.OptionResponse>();
                                        }
                                        return this.optionResponse;
                                    }


                                    /**
                                     * <p>Java class for anonymous complex type.
                                     * 
                                     * <p>The following schema fragment specifies the expected content contained within this class.
                                     * 
                                     * <pre>
                                     * &lt;complexType>
                                     *   &lt;complexContent>
                                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                                     *       &lt;sequence>
                                     *         &lt;element name="YesOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                                     *         &lt;element name="OtherOptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
                                     *       &lt;/sequence>
                                     *     &lt;/restriction>
                                     *   &lt;/complexContent>
                                     * &lt;/complexType>
                                     * </pre>
                                     * 
                                     * 
                                     */
                                    @XmlAccessorType(XmlAccessType.FIELD)
                                    @XmlType(name = "", propOrder = {
                                        "yesOptionResponse",
                                        "otherOptionResponse"
                                    })
                                    public static class OptionResponse {

                                        @XmlElement(name = "YesOptionResponse", required = true)
                                        protected String yesOptionResponse;
                                        @XmlElement(name = "OtherOptionResponse", required = true)
                                        protected String otherOptionResponse;

                                        /**
                                         * Gets the value of the yesOptionResponse property.
                                         * 
                                         * @return
                                         *     possible object is
                                         *     {@link String }
                                         *     
                                         */
                                        public String getYesOptionResponse() {
                                            return yesOptionResponse;
                                        }

                                        /**
                                         * Sets the value of the yesOptionResponse property.
                                         * 
                                         * @param value
                                         *     allowed object is
                                         *     {@link String }
                                         *     
                                         */
                                        public void setYesOptionResponse(String value) {
                                            this.yesOptionResponse = value;
                                        }

                                        /**
                                         * Gets the value of the otherOptionResponse property.
                                         * 
                                         * @return
                                         *     possible object is
                                         *     {@link String }
                                         *     
                                         */
                                        public String getOtherOptionResponse() {
                                            return otherOptionResponse;
                                        }

                                        /**
                                         * Sets the value of the otherOptionResponse property.
                                         * 
                                         * @param value
                                         *     allowed object is
                                         *     {@link String }
                                         *     
                                         */
                                        public void setOtherOptionResponse(String value) {
                                            this.otherOptionResponse = value;
                                        }

                                    }

                                }

                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType>
                             *   &lt;complexContent>
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *       &lt;sequence>
                             *         &lt;element name="OtherIdentifier">
                             *           &lt;complexType>
                             *             &lt;complexContent>
                             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                             *                 &lt;sequence>
                             *                   &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                             *                   &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}int"/>
                             *                 &lt;/sequence>
                             *               &lt;/restriction>
                             *             &lt;/complexContent>
                             *           &lt;/complexType>
                             *         &lt;/element>
                             *       &lt;/sequence>
                             *     &lt;/restriction>
                             *   &lt;/complexContent>
                             * &lt;/complexType>
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "otherIdentifier"
                            })
                            public static class ComAfgItemIdInfo {

                                @XmlElement(name = "OtherIdentifier", required = true)
                                protected ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo.OtherIdentifier otherIdentifier;

                                /**
                                 * Gets the value of the otherIdentifier property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo.OtherIdentifier }
                                 *     
                                 */
                                public ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo.OtherIdentifier getOtherIdentifier() {
                                    return otherIdentifier;
                                }

                                /**
                                 * Sets the value of the otherIdentifier property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo.OtherIdentifier }
                                 *     
                                 */
                                public void setOtherIdentifier(ACORD.InsuranceSvcRq.WorkCompPolicyQuoteInqRq.WorkCompLineBusiness.WorkCompRateState.WorkCompLocInfo.WorkCompRateClass.ComAfgItemIdInfo.OtherIdentifier value) {
                                    this.otherIdentifier = value;
                                }


                                /**
                                 * <p>Java class for anonymous complex type.
                                 * 
                                 * <p>The following schema fragment specifies the expected content contained within this class.
                                 * 
                                 * <pre>
                                 * &lt;complexType>
                                 *   &lt;complexContent>
                                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                                 *       &lt;sequence>
                                 *         &lt;element name="OtherIdTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                                 *         &lt;element name="OtherId" type="{http://www.w3.org/2001/XMLSchema}int"/>
                                 *       &lt;/sequence>
                                 *     &lt;/restriction>
                                 *   &lt;/complexContent>
                                 * &lt;/complexType>
                                 * </pre>
                                 * 
                                 * 
                                 */
                                @XmlAccessorType(XmlAccessType.FIELD)
                                @XmlType(name = "", propOrder = {
                                    "otherIdTypeCd",
                                    "otherId"
                                })
                                public static class OtherIdentifier {

                                    @XmlElement(name = "OtherIdTypeCd", required = true)
                                    protected String otherIdTypeCd;
                                    @XmlElement(name = "OtherId")
                                    protected int otherId;

                                    /**
                                     * Gets the value of the otherIdTypeCd property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link String }
                                     *     
                                     */
                                    public String getOtherIdTypeCd() {
                                        return otherIdTypeCd;
                                    }

                                    /**
                                     * Sets the value of the otherIdTypeCd property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link String }
                                     *     
                                     */
                                    public void setOtherIdTypeCd(String value) {
                                        this.otherIdTypeCd = value;
                                    }

                                    /**
                                     * Gets the value of the otherId property.
                                     * 
                                     */
                                    public int getOtherId() {
                                        return otherId;
                                    }

                                    /**
                                     * Sets the value of the otherId property.
                                     * 
                                     */
                                    public void setOtherId(int value) {
                                        this.otherId = value;
                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SignonPswd">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CustId">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="CustPermId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="CustLoginId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="CustPswd">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="EncryptionTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Pswd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ClientDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CustLangPref" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ClientApp">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Org" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="SubmissionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "signonPswd",
        "clientDt",
        "custLangPref",
        "clientApp"
    })
    public static class SignonRq {

        @XmlElement(name = "SignonPswd", required = true)
        protected ACORD.SignonRq.SignonPswd signonPswd;
        @XmlElement(name = "ClientDt")
        protected String clientDt;
        @XmlElement(name = "CustLangPref", required = true)
        protected String custLangPref;
        @XmlElement(name = "ClientApp", required = true)
        protected ACORD.SignonRq.ClientApp clientApp;

        /**
         * Gets the value of the signonPswd property.
         * 
         * @return
         *     possible object is
         *     {@link ACORD.SignonRq.SignonPswd }
         *     
         */
        public ACORD.SignonRq.SignonPswd getSignonPswd() {
            return signonPswd;
        }

        /**
         * Sets the value of the signonPswd property.
         * 
         * @param value
         *     allowed object is
         *     {@link ACORD.SignonRq.SignonPswd }
         *     
         */
        public void setSignonPswd(ACORD.SignonRq.SignonPswd value) {
            this.signonPswd = value;
        }

        /**
         * Gets the value of the clientDt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getClientDt() {
            return clientDt;
        }

        /**
         * Sets the value of the clientDt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setClientDt(String value) {
            this.clientDt = value;
        }

        /**
         * Gets the value of the custLangPref property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCustLangPref() {
            return custLangPref;
        }

        /**
         * Sets the value of the custLangPref property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCustLangPref(String value) {
            this.custLangPref = value;
        }

        /**
         * Gets the value of the clientApp property.
         * 
         * @return
         *     possible object is
         *     {@link ACORD.SignonRq.ClientApp }
         *     
         */
        public ACORD.SignonRq.ClientApp getClientApp() {
            return clientApp;
        }

        /**
         * Sets the value of the clientApp property.
         * 
         * @param value
         *     allowed object is
         *     {@link ACORD.SignonRq.ClientApp }
         *     
         */
        public void setClientApp(ACORD.SignonRq.ClientApp value) {
            this.clientApp = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Org" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="SubmissionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "org",
            "submissionId",
            "name",
            "version"
        })
        public static class ClientApp {

            @XmlElement(name = "Org", required = true)
            protected String org;
            @XmlElement(name = "SubmissionId", required = true)
            protected String submissionId;
            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Version", required = true)
            protected String version;

            /**
             * Gets the value of the org property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOrg() {
                return org;
            }

            /**
             * Sets the value of the org property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOrg(String value) {
                this.org = value;
            }

            /**
             * Gets the value of the submissionId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubmissionId() {
                return submissionId;
            }

            /**
             * Sets the value of the submissionId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubmissionId(String value) {
                this.submissionId = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the version property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVersion() {
                return version;
            }

            /**
             * Sets the value of the version property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVersion(String value) {
                this.version = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="CustId">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="CustPermId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="CustLoginId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="CustPswd">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="EncryptionTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Pswd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "custId",
            "custPswd"
        })
        public static class SignonPswd {

            @XmlElement(name = "CustId", required = true)
            protected ACORD.SignonRq.SignonPswd.CustId custId;
            @XmlElement(name = "CustPswd", required = true)
            protected ACORD.SignonRq.SignonPswd.CustPswd custPswd;

            /**
             * Gets the value of the custId property.
             * 
             * @return
             *     possible object is
             *     {@link ACORD.SignonRq.SignonPswd.CustId }
             *     
             */
            public ACORD.SignonRq.SignonPswd.CustId getCustId() {
                return custId;
            }

            /**
             * Sets the value of the custId property.
             * 
             * @param value
             *     allowed object is
             *     {@link ACORD.SignonRq.SignonPswd.CustId }
             *     
             */
            public void setCustId(ACORD.SignonRq.SignonPswd.CustId value) {
                this.custId = value;
            }

            /**
             * Gets the value of the custPswd property.
             * 
             * @return
             *     possible object is
             *     {@link ACORD.SignonRq.SignonPswd.CustPswd }
             *     
             */
            public ACORD.SignonRq.SignonPswd.CustPswd getCustPswd() {
                return custPswd;
            }

            /**
             * Sets the value of the custPswd property.
             * 
             * @param value
             *     allowed object is
             *     {@link ACORD.SignonRq.SignonPswd.CustPswd }
             *     
             */
            public void setCustPswd(ACORD.SignonRq.SignonPswd.CustPswd value) {
                this.custPswd = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="SPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="CustPermId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="CustLoginId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "spName",
                "custPermId",
                "custLoginId"
            })
            public static class CustId {

                @XmlElement(name = "SPName")
                protected String spName;
                @XmlElement(name = "CustPermId")
                protected String custPermId;
                @XmlElement(name = "CustLoginId", required = true)
                protected String custLoginId;

                /**
                 * Gets the value of the spName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSPName() {
                    return spName;
                }

                /**
                 * Sets the value of the spName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSPName(String value) {
                    this.spName = value;
                }

                /**
                 * Gets the value of the custPermId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCustPermId() {
                    return custPermId;
                }

                /**
                 * Sets the value of the custPermId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCustPermId(String value) {
                    this.custPermId = value;
                }

                /**
                 * Gets the value of the custLoginId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCustLoginId() {
                    return custLoginId;
                }

                /**
                 * Sets the value of the custLoginId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCustLoginId(String value) {
                    this.custLoginId = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="EncryptionTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Pswd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "encryptionTypeCd",
                "pswd"
            })
            public static class CustPswd {

                @XmlElement(name = "EncryptionTypeCd", required = true)
                protected String encryptionTypeCd;
                @XmlElement(name = "Pswd", required = true)
                protected String pswd;

                /**
                 * Gets the value of the encryptionTypeCd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEncryptionTypeCd() {
                    return encryptionTypeCd;
                }

                /**
                 * Sets the value of the encryptionTypeCd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEncryptionTypeCd(String value) {
                    this.encryptionTypeCd = value;
                }

                /**
                 * Gets the value of the pswd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPswd() {
                    return pswd;
                }

                /**
                 * Sets the value of the pswd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPswd(String value) {
                    this.pswd = value;
                }

            }

        }

    }

}
