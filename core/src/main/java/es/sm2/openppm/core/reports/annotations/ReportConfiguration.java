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
 * File: ReportConfiguration.java
 * Create User: javier.hernandez
 * Create Date: 21/03/2015 10:26:18
 */

package es.sm2.openppm.core.reports.annotations;

import es.sm2.openppm.utils.StringPool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SM2 Baleares
 * Created by javier.hernandez on 01/10/2014.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReportConfiguration {

    ReportType type();
    ReportExtension extension() default ReportExtension.ODT;
    String fileName() default StringPool.BLANK;
}
