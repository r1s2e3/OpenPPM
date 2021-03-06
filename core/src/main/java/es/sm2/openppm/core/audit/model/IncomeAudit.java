/*
 * Copyright (C) 2009-2015 SM2 SOFTWARE & SERVICES MANAGEMENT
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program has been created in the hope that it will be useful.
 * It is distributed WITHOUT ANY WARRANTY of any Kind,
 * without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses/.
 *
 * For more information, please contact SM2 Software & Services Management.
 * Mail: info@talaia-openppm.com
 * Web: http://www.talaia-openppm.com
 *
 * Module: core
 * File: IncomeSync.java
 * Create User: javier.hernandez
 * Create Date: 14/09/2015 17:24:00
 */

package es.sm2.openppm.core.audit.model;

import es.sm2.openppm.core.model.impl.Incomes;

import java.util.Date;

public class IncomeAudit {

     private Date plannedBillDate;
     private Double plannedBillAmmount;
     private Date actualBillDate;
     private Double actualBillAmmount;
     private String plannedDescription;
     private String actualDescription;
     private Date actualPaymentDate;

    public IncomeAudit(Incomes income) {
    	
    	setPlannedBillDate(income.getPlannedBillDate());
    	setPlannedBillAmmount(income.getPlannedBillAmmount());
    	setActualBillDate(income.getActualBillDate());
    	setActualBillAmmount(income.getActualBillAmmount());
    	setPlannedDescription(income.getPlannedDescription());
    	setActualDescription(income.getActualDescription());
    	setActualPaymentDate(income.getActualPaymentDate());
    }
    
    public Date getPlannedBillDate() {
        return this.plannedBillDate;
    }
    
    public void setPlannedBillDate(Date plannedBillDate) {
        this.plannedBillDate = plannedBillDate;
    }
    public Double getPlannedBillAmmount() {
        return this.plannedBillAmmount;
    }
    
    public void setPlannedBillAmmount(Double plannedBillAmmount) {
        this.plannedBillAmmount = plannedBillAmmount;
    }
    public Date getActualBillDate() {
        return this.actualBillDate;
    }
    
    public void setActualBillDate(Date actualBillDate) {
        this.actualBillDate = actualBillDate;
    }
    public Double getActualBillAmmount() {
        return this.actualBillAmmount;
    }
    
    public void setActualBillAmmount(Double actualBillAmmount) {
        this.actualBillAmmount = actualBillAmmount;
    }
    public String getPlannedDescription() {
        return this.plannedDescription;
    }
    
    public void setPlannedDescription(String plannedDescription) {
        this.plannedDescription = plannedDescription;
    }
    public String getActualDescription() {
        return this.actualDescription;
    }
    
    public void setActualDescription(String actualDescription) {
        this.actualDescription = actualDescription;
    }
    public Date getActualPaymentDate() {
        return this.actualPaymentDate;
    }
    
    public void setActualPaymentDate(Date actualPaymentDate) {
        this.actualPaymentDate = actualPaymentDate;
    }
}


