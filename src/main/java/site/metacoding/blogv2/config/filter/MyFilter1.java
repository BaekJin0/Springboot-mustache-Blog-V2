package site.metacoding.blogv2.config.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("MyFilter1");

        // 다운캐스팅!
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getRequestURI();

        if (path.contains("fuck")) {
            resp.setContentType("text/plain;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("욕하지마!!!"); // body 데이터
            out.flush();
        } else {
            chain.doFilter(request, response); // 다음 필터로 이동 혹은 DS로 이동
        }

    }

}
