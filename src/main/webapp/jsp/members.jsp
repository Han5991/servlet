<%--
  Created by IntelliJ IDEA.
  User: sang wook Han
  Date: 2021-12-12(012)
  Time: 오후 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        if (!members.isEmpty()) {
            for (Member member : members) {
                out.write(" <tr>");
                out.write(" <td>" + member.getId() + "</td>");
                out.write(" <td>" + member.getUserName() + "</td>");
                out.write(" <td>" + member.getAge() + "</td>");
                out.write(" </tr>");
            }
        } else {
            out.write(" <tr>");
            out.write(" <td colspan=\"3\">" + "회원이 없어요 ㅠㅠ" + "</td>");
            out.write(" </tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>
