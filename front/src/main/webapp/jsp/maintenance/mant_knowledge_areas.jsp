<%--
  Created by IntelliJ IDEA.
  User: francisco.bisquerra
  Date: 23/07/2015
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@page import="es.sm2.openppm.front.servlets.MaintenanceServlet"%>
<%@page import="es.sm2.openppm.api.model.enums.MaintenanceEnum"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored ="false"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@taglib uri="Utilidades" prefix="tl" %>
<%@taglib uri="Openppm" prefix="op" %>
<%@taglib uri="Visual" prefix="visual" %>

<%--
  ~ Copyright (C) 2009-2015 SM2 SOFTWARE & SERVICES MANAGEMENT
  ~ This program is free software: you can redistribute it and/or modify
  ~ it under the terms of the GNU General Public License as published by
  ~ the Free Software Foundation, either version 3 of the License, or
  ~ (at your option) any later version.
  ~
  ~ This program has been created in the hope that it will be useful.
  ~ It is distributed WITHOUT ANY WARRANTY of any Kind,
  ~ without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  ~ See the GNU General Public License for more details.
  ~
  ~ You should have received a copy of the GNU General Public License
  ~ along with this program. If not, see http://www.gnu.org/licenses/.
  ~
  ~ For more information, please contact SM2 Software & Services Management.
  ~ Mail: info@talaia-openppm.com
  ~ Web: http://www.talaia-openppm.com
  ~
  ~ Module: front
  ~ File: mant_knowledge_areas.jsp
  ~ Create User: francisco.bisquerra
  ~ Create Date: 24/07/2015 12:48:08
  --%>

<%-- Message for Confirmations --%>
<fmt:message key="msg.confirm_delete" var="msg_confirm_delete_knowledge_areas">
  <fmt:param><fmt:message key="KNOWLEDGE_AREA"/></fmt:param>
</fmt:message>
<fmt:message key="msg.title_confirm_delete" var="msg_title_confirm_delete_knowledge_areas">
  <fmt:param><fmt:message key="KNOWLEDGE_AREA"/></fmt:param>
</fmt:message>

<%--
Request Attributes:
	list_maintenance: list
--%>

<script language="javascript" type="text/javascript" >
  // GLOBAL VARS
  var mainAjax = new AjaxCall('<%=MaintenanceServlet.REFERENCE%>','<fmt:message key="error"/>');
  var knowledgeAreaTable;

  // OBJECTS
  var knowledgeArea = {
    createTable: function() {

      return $('#knowledgeAreaTable').dataTable({
        "sPaginationType": "full_numbers",
        "oLanguage": datatable_language,
        "bInfo": false,
        "fnRowCallback": function( nRow, aData) {
          $('td:eq(2)', nRow).html( knowledgeArea.buttons(aData[4]) );
          return nRow;
        },
        "aoColumns": [
          { "bVisible": false },
          { "sClass": "left" },
          { "sClass": "left" },
          { "sClass": "center", "bSortable": false }
        ]
      });
    },
    add: function() {

      knowledgeAreaPopup.formReset(document.knowledgeAreaPopupForm);

      knowledgeAreaPopup.open();
    },
    edit: function(element) {

      var row = knowledgeAreaTable.fnGetData(element.parentNode.parentNode.parentNode);

      var f = document.knowledgeAreaPopupForm;

      knowledgeAreaPopup.formReset(f);

      f.id.value 			= row[0];
      f.name.value        = unEscape(row[1]);
      f.description.value = unEscape(row[2]);

      knowledgeAreaPopup.open();
    },
    save: function() {

      var f = document.knowledgeAreaPopupForm;

      var params = {
        code: f.id.value,
        name: f.name.value,
        description: f.description.value
      };

      $.ajax({
        url: 'rest/maintenance/' + '<%= MaintenanceEnum.KNOWLEDGE_AREA.name() %>',
        type: f.id.value === '' ? 'POST' : 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(params),
        success: function (data) {

          var dataRow = [
            data.code,
            escape(data.name != null != null ? data.name : ''),
            escape(data.description != null != null ? data.description : ''),
            ''
          ];

          if (f.id.value == data.code) {
            knowledgeAreaTable.fnUpdateAndSelect(dataRow);
          }
          else {
            knowledgeAreaTable.fnAddDataAndSelect(dataRow);
          }

          knowledgeAreaPopup.close();
        }
      });
    },
    del: function(element) {
      confirmUI(
              '${msg_title_confirm_delete_knowledge_areas}','${msg_confirm_delete_knowledge_areas}',
              '<fmt:message key="yes"/>', '<fmt:message key="no"/>',
              function() {

                var row = knowledgeAreaTable.fnGetData(element.parentNode.parentNode.parentNode);

                $.ajax({
                  url: 'rest/maintenance/' + '<%= MaintenanceEnum.KNOWLEDGE_AREA.name() %>' + '/' + row[0],
                  type: 'DELETE',
                  dataType: 'json',
                  contentType: 'application/json',
                  data: {},
                  success: function () {
                    knowledgeAreaTable.fnDeleteSelected();
                  },
                  error: function (jqXHR) {

                      if (typeof jqXHR.responseText !== 'undefined' && jqXHR.responseText.length > 0) {
                        alertUI("Error", JSON.parse(jqXHR.responseText).message);
                      }
                  }
                });
              });
    },
    buttons: function(disable) {
      var $buttons = $('<nobr/>');
      $buttons.append($('<img/>', {onclick: 'knowledgeArea.edit(this)', title: '<fmt:message key="view"/>', 'class': 'link', src: 'images/view.png'}))
              .append('&nbsp;&nbsp;&nbsp;')
              .append($('<img/>', {onclick: 'knowledgeArea.del(this)', title: '<fmt:message key="delete"/>', 'class': 'link', src: 'images/delete.jpg'}))
              .append('&nbsp;&nbsp;&nbsp;');
      return $buttons;
    },
    loadList : function() {

      $.ajax({
        url: 'rest/maintenance/' + '<%= MaintenanceEnum.KNOWLEDGE_AREA.name() %>',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        data: {},
        success: function (data) {

          // Clear table
          knowledgeAreaTable.fnClearTable();

          // Add list
          $(data).each(function() {

            var row = [
              this.code,
              escape(this.name != null != null ? this.name : ''),
              escape(this.description != null != null ? this.description : ''),
              ''
            ];

            // Add row
            knowledgeAreaTable.fnAddData(row);
          });
        }
      });
    }
  };

  readyMethods.add(function () {

    // Create table
    knowledgeAreaTable = knowledgeArea.createTable();

    // Events
    $('#knowledgeAreaTable tbody tr').live('click',  function (event) {
      knowledgeAreaTable.fnSetSelectable(this,'selected_internal');
    });

    // Load list
    knowledgeArea.loadList();
  });

</script>

<fieldset>
  <legend><fmt:message key="MAINTENANCE.KNOWLEDGE_AREAS" /></legend>

  <%-- KnowledgeArea table --%>
  <table id="knowledgeAreaTable" class="tabledata" width="100%">
    <thead>
    <tr>
      <th width="0%"></th>
      <th width="20%"><fmt:message key="name" /></th>
      <th width="70%"><fmt:message key="description" /></th>
      <th width="10%">
        <img onclick="knowledgeArea.add()" title="<fmt:message key="new"/>" class="link" src="images/add.png">
      </th>
    </tr>
    </thead>
    <tbody></tbody>
  </table>
</fieldset>

<div class="spacer"></div>

<jsp:include page="popups/knowledge_areas_popup.jsp" flush="true" />
