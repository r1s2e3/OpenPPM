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
 * Module: front
 * File: CategoryActionImpl.java
 * Create User: javier.hernandez
 * Create Date: 21/09/2015 11:58:53
 */

package es.sm2.openppm.api.impl.maintenance;

import es.sm2.openppm.api.converter.maintenance.CategoryDTOConverter;
import es.sm2.openppm.api.rest.BaseResource;
import es.sm2.openppm.core.logic.impl.CategoryLogic;
import es.sm2.openppm.core.model.impl.Category;
import es.sm2.openppm.core.model.impl.Company;
import es.sm2.openppm.core.model.impl.Contracttype;
import es.sm2.openppm.core.model.impl.Employee;
import es.sm2.openppm.utils.LogManager;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by javier.hernandez on 21/09/2015.
 */
public class CategoryActionImpl implements MaintenanceAction {

    @Override
    public Response save(Object object, Company company) {

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response update(Object object, Company company) {

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response findAll(Company company, Employee user) {

        Response response;

        try {
            // Find data
            CategoryLogic logic = new CategoryLogic();
            List<Category> contractTypes = logic.findByRelation(Contracttype.COMPANY, company);

            // Convert to DTO and Send data
            CategoryDTOConverter converter = new CategoryDTOConverter();
            response = Response.ok().entity(converter.toDTOList(contractTypes)).build();
        }
        catch (Exception e) {
            response = BaseResource.generateErrorResponse(LogManager.getLog(getClass()), "findAll()", e);
        }

        return response;
    }

    @Override
    public Response findByID(Integer id) {

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response remove(Integer id, ResourceBundle resourceBundle) {

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
