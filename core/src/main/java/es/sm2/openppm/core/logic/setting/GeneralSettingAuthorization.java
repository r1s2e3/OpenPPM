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
 * File: GeneralSetting.java
 * Create User: javier.hernandez
 * Create Date: 15/03/2015 12:52:47
 */

package es.sm2.openppm.core.logic.setting;

import es.sm2.openppm.core.common.GenericSetting;
import es.sm2.openppm.core.logic.setting.common.TypeSetting;

/**
 * SM2 Baleares
 * Created by claudia.beatriz on 19/05/2015.
 */
public enum GeneralSettingAuthorization implements GenericSetting {

    PM_VIEW_OTHER_PROJECTS(Boolean.FALSE.toString()),
    AUTOCOMPLETE_CHECKLIST_ITEM(Boolean.FALSE.toString()),
    ONLY_PMO_CHANGE_STATUS(Boolean.FALSE.toString()),
    LAST_LEVEL_APPROVED_APP1(Boolean.FALSE.toString()),
    ACTIVE_MANAGEMENT_OPERATION(Boolean.FALSE.toString());

    private String defaultValue;
    private TypeSetting typeSetting;

    private GeneralSettingAuthorization(String defaultValue) {
        this.defaultValue 	= defaultValue;
    }

    private GeneralSettingAuthorization(String defaultValue, TypeSetting typeSetting) {
        this.defaultValue 	= defaultValue;
        this.typeSetting    = typeSetting;
    }

    public Enum[] getEnumElements() {
        return null;
    }

    public TypeSetting getTypeSetting() {
        return this.typeSetting == null?TypeSetting.CHECKBOX: this.typeSetting;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name();
    }

    public boolean isVisible() {
        return true;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return the messageInfo
     */
    public String getMessageInfo() {
        return "SETTING."+this.name()+"_INFO";
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return "SETTING."+this.name();
    }
}
