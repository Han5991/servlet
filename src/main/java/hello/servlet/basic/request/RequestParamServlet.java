package hello.servlet.basic.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?userName=hello&age=20
 */
@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("[전체 파라미터 조회 - start]");
        request.getParameterNames().asIterator().forEachRemaining(parameterName -> System.out.println(parameterName + " = " + request.getParameter(parameterName)));
        System.out.println("[전체 파라미터 조회 - end]");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String userName = request.getParameter("userName");
        String age = request.getParameter("age");
        System.out.println("userName = " + userName);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] userNames = request.getParameterValues("userName");
        for (String username: userNames) {
            System.out.println("username = " + username);
        }

        response.getWriter().write("ok");
    }
}
