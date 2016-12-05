/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.utils;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo
 */
public class SessionUtils implements Serializable {
    
    private static final long SerialVersionUID = 1l;
    
    public static HttpSession getSession(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession sessao = (HttpSession) context.getExternalContext().getSession(false);
        return sessao;
    }
    
    public static void setParam(String key, Object value){
        getSession().setAttribute(key, value);
    }
    
    public static Object getParam(String key){
        return getSession().getAttribute(key);
    }
    
    public static void removeParam(String key){
        getSession().removeAttribute(key);
    }
    
    public static void invalidate(){
        getSession().invalidate();
    }
    
}
