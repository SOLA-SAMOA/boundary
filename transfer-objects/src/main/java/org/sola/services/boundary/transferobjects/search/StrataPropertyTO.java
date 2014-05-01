/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.search;

import java.util.Date;
import org.sola.services.common.contracts.AbstractTO;

/**
 *
 * @author soladev
 */
public class StrataPropertyTO extends AbstractTO {

    private String id;
    private String typeCode;
    private String name;
    private String nameFirstpart;
    private String nameLastpart;
    private String statusCode;
    private String transactionId;
    private Date registrationDate;
    private Integer officialArea;
    private Integer unitEntitlement;
    private String unitParcelTypeCode;
    private String pendingActionCode;
    private String unitParcels;

    public StrataPropertyTO() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameFirstpart() {
        return nameFirstpart;
    }

    public void setNameFirstpart(String nameFirstpart) {
        this.nameFirstpart = nameFirstpart;
    }

    public String getNameLastpart() {
        return nameLastpart;
    }

    public void setNameLastpart(String nameLastpart) {
        this.nameLastpart = nameLastpart;
    }

    public Integer getOfficialArea() {
        return officialArea;
    }

    public void setOfficialArea(Integer officialArea) {
        this.officialArea = officialArea;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getUnitEntitlement() {
        return unitEntitlement;
    }

    public void setUnitEntitlement(Integer unitEntitlement) {
        this.unitEntitlement = unitEntitlement;
    }

    public String getUnitParcelTypeCode() {
        return unitParcelTypeCode;
    }

    public void setUnitParcelTypeCode(String unitParcelTypeCode) {
        this.unitParcelTypeCode = unitParcelTypeCode;
    }

    public String getPendingActionCode() {
        return pendingActionCode;
    }

    public void setPendingActionCode(String pendingActionCode) {
        this.pendingActionCode = pendingActionCode;
    }

    public String getUnitParcels() {
        return unitParcels;
    }

    public void setUnitParcels(String unitParcels) {
        this.unitParcels = unitParcels;
    }
}
