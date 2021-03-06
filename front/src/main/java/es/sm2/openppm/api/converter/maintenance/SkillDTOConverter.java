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
 * File: SkillDTOConverter.java
 * Create User: javier.hernandez
 * Create Date: 25/09/2015 12:52:25
 */

package es.sm2.openppm.api.converter.maintenance;

import es.sm2.openppm.api.converter.AbstractConverter;
import es.sm2.openppm.api.model.common.EntityDTO;
import es.sm2.openppm.core.model.impl.Resourcepool;
import es.sm2.openppm.core.model.impl.Skill;

/**
 * Created by javier.hernandez on 21/09/2015.
 */
public class SkillDTOConverter extends AbstractConverter<EntityDTO, Skill> {

    @Override
    public EntityDTO toDTO(Skill model) {

        EntityDTO dto = getInstanceDTO(model, EntityDTO.class);

        // Set id
        dto.setCode(model.getIdSkill());

        return dto;
    }

    @Override
    public Skill toModel(EntityDTO modelDTO) {

        Skill model = getInstanceModel(modelDTO, Skill.class);

        // Set id
        model.setIdSkill(modelDTO.getCode());

        return model;
    }
}
