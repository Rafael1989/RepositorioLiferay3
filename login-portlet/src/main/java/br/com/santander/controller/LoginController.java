package br.com.santander.controller;



import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class LoginController extends MVCPortlet {
	
	@ProcessAction(name="fazerLogin")
	public void fazerLogin(ActionRequest actionRequest, ActionResponse actionResponse){
		String login = actionRequest.getParameter("login");
		String senha = actionRequest.getParameter("senha");
		String authType = CompanyConstants.AUTH_TYPE_EA;
		Long companyId = CompanyThreadLocal.getCompanyId();
		try {
			long retornoLogin = UserLocalServiceUtil.authenticateForBasic(companyId, authType, login, senha);
			if(retornoLogin != Authenticator.DNE && retornoLogin != Authenticator.FAILURE){
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				actionResponse.sendRedirect(PortalUtil.getPathMain() + "/portal/login?login="+ login + "&password=" + senha
						+ "&rememberMe="+ false+"&redirect="+PortalUtil.getPortalURL(themeDisplay)+"/group/guest/teste");
			}else{
				actionRequest.setAttribute("mensagem", "Favor realizar o primeiro acesso.");
			}
			SessionMessages.add(actionRequest, "");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
