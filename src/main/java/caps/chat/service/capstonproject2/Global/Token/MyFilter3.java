package caps.chat.service.capstonproject2.Global.Token;


import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class MyFilter3 extends GenericFilterBean {
    private static final Logger logger = LoggerFactory.getLogger(MyFilter3.class);

    public MyFilter3() {
        // 초기화 작업은 생성자에서 수행합니다.
        logger.info("MyFilter3 initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        logger.info("MyFilter3: Request URL: {}", httpServletRequest.getRequestURL());

        // 추가적인 로직 구현

        chain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {
        logger.info("MyFilter3 destroyed");
    }
}
