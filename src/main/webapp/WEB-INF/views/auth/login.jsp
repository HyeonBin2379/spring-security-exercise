<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2025-11-02
  Time: 오후 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/includes/_headerHead.jsp" %>
<%@ include file="/WEB-INF/views/includes/_headerNavNotLogin.jsp" %>
        <!-- 여기부터 각 JSP 파일의 메인 컨텐츠가 시작됩니다. -->
        <div class="container">
            <div class="page-inner">

                <div class="page-header">
                </div>
                <div class="row">
                    <div class="col-md-6 mx-auto w-66">
                        <div class="card">
                            <form action="/auth/loginProcess" method="post" name="loginForm">
                                <div class="card-header">
                                    <div class="card-title">회원 로그인</div>
                                </div>
                                <div class="card-body">
                                    <div class="row d-flex justify-content-center">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label for="userId">User ID</label>
                                                <input
                                                        type="text"
                                                        class="form-control"
                                                        name="userId"
                                                        id="userId"
                                                        placeholder="Enter User ID"
                                                />
                                            </div>
                                            <div class="form-group">
                                                <label for="userPwd">Password</label>
                                                <input
                                                        type="password"
                                                        class="form-control"
                                                        name="userPwd"
                                                        id="userPwd"
                                                        placeholder="Password"
                                                />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-action d-flex justify-content-center">
                                    <button type="submit" class="btn btn-primary">로그인</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

<%@ include file="/WEB-INF/views/includes/_footer.jsp" %>