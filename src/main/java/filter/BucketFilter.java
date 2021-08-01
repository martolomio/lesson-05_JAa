package filter;

import domain.UserAccess;
import sheard.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/bucket.jsp")
public class BucketFilter implements Filter {

    public FilterService filterService = FilterService.getFilterService();

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        filterService.doFilterValidation(request, response, chain, Arrays.asList(UserAccess.USER));
    }
}
