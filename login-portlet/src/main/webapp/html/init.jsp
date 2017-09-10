<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.PortletPreferences"%>

<portlet:defineObjects />
<theme:defineObjects/> 

<portlet:actionURL name="fazerLogin" var="fazerLoginUrl"></portlet:actionURL>

<script>

function fazerLogin(){
	var login = $('#login').val();
	var senha = $('#senha').val();
	if(login == ''){
		alert('Favor informar o login.');
		return false;
	}
	if(senha == ''){
		alert('Favor informar a senha.');
		return false;
	}
	$('#formLogin').submit();
}

</script>