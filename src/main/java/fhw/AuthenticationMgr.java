package fhw;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Getter
@Setter
public class AuthenticationMgr
{
    private String username; 
    private String password;
    
    
    
    public String authenticate()
    {
        //"home?faces-redirect-true";
        String nextPage  =  "secure/main.xhtml?faces-redirect-true"; 
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();        
        try
        {
            System.out.println("trying to log in....");  
            request.login(username, username);
        }
        catch(ServletException e)
        {
            System.out.println("oy no loggie inie"); 
            nextPage = "loginFailed.xhtml?faces-redirect-true";
        }        
        return(nextPage); 
    }
}
