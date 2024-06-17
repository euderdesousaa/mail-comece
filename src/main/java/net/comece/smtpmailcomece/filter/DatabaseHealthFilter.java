package net.comece.smtpmailcomece.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import net.comece.smtpmailcomece.service.DatabaseHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class DatabaseHealthFilter implements Filter {

    @Autowired
    private DatabaseHealthService databaseHealthService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (databaseHealthService.isDatabaseUp()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
            response.getWriter().write("Database is down");
        }
    }
}
