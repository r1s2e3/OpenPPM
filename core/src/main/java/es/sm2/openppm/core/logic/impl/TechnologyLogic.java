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
 * File: TechnologyLogic.java
 * Create User: jordi.ripoll
 * Create Date: 29/06/2015 13:45:22
 */

package es.sm2.openppm.core.logic.impl;

import es.sm2.openppm.core.dao.TechnologyDAO;
import es.sm2.openppm.core.exceptions.NoDataFoundException;
import es.sm2.openppm.core.model.impl.Company;
import es.sm2.openppm.core.model.impl.Project;
import es.sm2.openppm.core.model.impl.Technology;
import es.sm2.openppm.utils.exceptions.LogicException;
import es.sm2.openppm.utils.functions.ValidateUtil;
import es.sm2.openppm.utils.hibernate.SessionFactoryUtil;
import es.sm2.openppm.utils.hibernate.logic.AbstractGenericLogic;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Logic object for domain model class Technology
 * @see es.sm2.openppm.core.logic.impl.TechnologyLogic
 * @author Hibernate Generator by Javier Hernandez
 *
 * IMPORTANT! Instantiate the class for use generic methods
 *
 */
public final class TechnologyLogic extends AbstractGenericLogic<Technology, Integer> {

	/**
	 * Remove technology
	 * 
	 * @param technology
	 * @throws Exception 
	 */
	public void remove(Technology technology) throws Exception {
		
		if (technology == null) {
			throw new NoDataFoundException();
		}
		
		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			TechnologyDAO dao = new TechnologyDAO(session);

			technology = dao.findById(technology.getIdTechnology(), false);
			
			if (ValidateUtil.isNotNull(technology.getProjecttechnologies())) {
				
				throw new LogicException("msg.error.delete.this_has", "TECHNOLOGY","project");
			}
			else{
				dao.makeTransient(technology);
			}
			
			tx.commit();
		}
		catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		finally {
			SessionFactoryUtil.getInstance().close();
		}
	}

    /**
     * Search technologies except those who already have the project
     *
     * @param project
     * @param company
     * @return
     * @throws Exception
     */
    public List<Technology> findNotHave(Project project, Company company) throws Exception {

        List<Technology> list = null;

        Session session = SessionFactoryUtil.getInstance().getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            if (project != null && project.getIdProject() != null) {

                //Declare DAO
                TechnologyDAO technologyDAO = new TechnologyDAO(session);

                // DAO
                list = technologyDAO.findNotHave(project, company);
            }

            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            SessionFactoryUtil.getInstance().close();
        }

        return list;
    }
}

