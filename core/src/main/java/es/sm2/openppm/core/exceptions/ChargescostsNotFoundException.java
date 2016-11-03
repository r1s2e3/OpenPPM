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
 * File: ChargescostsNotFoundException.java
 * Create User: javier.hernandez
 * Create Date: 15/03/2015 12:53:03
 */

package es.sm2.openppm.core.exceptions;

import es.sm2.openppm.utils.exceptions.LogicException;



/**
 * Exception object for domain model class Chargescosts
 * @see es.sm2.openppm.core.exceptions.Chargescosts
 * @author Hibernate Generator by Javier Hernandez
 */
public final class ChargescostsNotFoundException extends LogicException{

	/**
	* ChargescostsNotFoundException is a LogicException class
	*/
	private static final long serialVersionUID = 1L;
	
	public ChargescostsNotFoundException(String msg) {
		super(msg);
	}
	
	/**
	* Metodo para errores multidioma
	* Funcionalidad en LocalicedException
	*/
	
	public ChargescostsNotFoundException() {
		super("msg.error.notfound.chargescosts");
	}	

}

