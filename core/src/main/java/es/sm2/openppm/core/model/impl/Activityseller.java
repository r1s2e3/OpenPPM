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
 * File: Activityseller.java
 * Create User: javier.hernandez
 * Create Date: 15/03/2015 12:52:57
 */

package es.sm2.openppm.core.model.impl;

import org.apache.log4j.Logger;

import es.sm2.openppm.core.logic.impl.ActivitysellerLogic;
import es.sm2.openppm.core.model.base.BaseActivityseller;



/**
 * Model class Activityseller.
 * @author Hibernate Generator by Javier Hernandez
 */
public class Activityseller extends BaseActivityseller {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(Activityseller.class);

    public Activityseller() {
		super();
    }
    public Activityseller(Integer idActivitySeller) {
		super(idActivitySeller);
    }
    
    
    /**
     * ActivitySeller has associated projects
     * @return
     */
	public boolean hasAssociatedProjects() {
		boolean hasAssociated = false;
    	try {
    		ActivitysellerLogic activitysellerLogic = new ActivitysellerLogic();
    		hasAssociated = activitysellerLogic.hasAssociatedProjects(this);
    	}
    	catch (Exception e) {
    		LOGGER.error(e.getMessage(), e);
		}
    	return hasAssociated;
	}

}

