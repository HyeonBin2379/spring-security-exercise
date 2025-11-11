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
                    <div class="col-md-8 mx-auto w-66">
                        <div class="card">
                            <form name="forgotIdForm">
                                <div class="card-header">
                                    <div class="card-title">아이디 찾기</div>
                                </div>
                                <div class="card-body">
                                    <div class="text-center">
                                        <small id="forgotIdMsg" class="form-text text-muted">
                                            찾으시는 아이디는 <i>${foundDTO.userId}</i> 입니다.
                                        </small>
                                    </div>
                                    <div class="col-md-12 mt-4">

                                    </div>
                                </div>
                                <div class="card-action">
                                    <div class="d-flex justify-content-evenly mt-0 mb-4 m">
                                        <button type="submit" formaction="/" formmethod="get"  class="btn btn-primary">메인 메뉴로 돌아가기</button>
                                    </div>
                                    <div class="d-flex justify-content-evenly">
                                        <a href="/auth/login">로그인</a>
                                        <a href="/auth/forgot-pwd">비밀번호 찾기</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

<%@ include file="/WEB-INF/views/includes/_footer.jsp" %>