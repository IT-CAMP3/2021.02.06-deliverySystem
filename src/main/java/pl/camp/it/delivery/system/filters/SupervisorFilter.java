package pl.camp.it.delivery.system.filters;

import org.springframework.web.context.support.WebApplicationContextUtils;
import pl.camp.it.delivery.system.model.User;
import pl.camp.it.delivery.system.session.SessionObject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SupervisorFilter implements Filter {

    SessionObject sessionObject;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.sessionObject = WebApplicationContextUtils.
                getRequiredWebApplicationContext(filterConfig.getServletContext()).getBean(SessionObject.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (sessionObject.isLogged() && sessionObject.getUser().getRole().equals(User.Role.SUPERVISOR)) {
            chain.doFilter(httpServletRequest, response);
        }
        else if (sessionObject.isLogged() && sessionObject.getUser().getRole().equals(User.Role.STOREKEEPER)) {
            httpServletResponse.sendRedirect("/storekeeper/main");
        } else if (sessionObject.isLogged() && sessionObject.getUser().getRole().equals(User.Role.COURIER)) {
            //TODO
            httpServletResponse.sendRedirect("/login");
        } else {
            httpServletResponse.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
