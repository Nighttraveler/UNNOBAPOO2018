/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * @author jpgm
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.auth;

import ar.edu.unnoba.poo2018.controller.SessionBacking;
import ar.edu.unnoba.poo2018.model.Usuario;
import ar.edu.unnoba.poo2018.utils.URLMap;

import javax.ejb.EJB;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/*
 *
 * @author poo
 */
public class AuthorizationListener implements PhaseListener {

    @EJB
    private URLMap urlMap;

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();

        SessionBacking sessionBacking=null;
        try{
            sessionBacking = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{sessionBacking}", SessionBacking.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        Usuario currentUser = null;
        if(sessionBacking != null){
            currentUser = sessionBacking.getUsuario();
        }
        if(null != currentUser && !currentUser.isAdministrador()){
            if(currentPage.matches(".*(new|edit).xhtml.*")){
                NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                nh.handleNavigation(facesContext, null, urlMap.getWELCOME() + urlMap.getFacesRedirect());
            }
        }

        if(currentUser == null){
            if(!currentPage.equals(urlMap.getINDEX())){
                NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                nh.handleNavigation(facesContext, null, urlMap.getINDEX() + urlMap.getFacesRedirect());
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
