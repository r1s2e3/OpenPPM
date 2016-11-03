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
 * File: employee.resource.js
 * Create User: jordi.ripoll
 * Create Date: 06/10/2015 16:17:50
 */

/**
 * Created by Jordi.Ripoll on 06/10/2015.
 */
'use strict';

define(['app'], function(app) {
  'use strict';

  app.factory('Employee', ['$resource', function ($resource) {

    var url = '../rest/employee/:code';

    /**
     * Notification resource
     */
    return $resource(url, { code: '@code'}, { });
  }]);

});