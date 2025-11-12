<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/includes/_headerHead.jsp" %>
<%@ include file="/WEB-INF/views/includes/_headerNavNotLogin.jsp" %>

<div class="container">
    <div class="page-inner">

        <div class="page-header">
        </div>
        <div class="row">
            <div class="col-md-6 mx-auto w-66">
                <div class="card">
                    <form name="loginForm">
                        <div class="card-header">
                            <div class="card-title">
                                비밀번호 재설정
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="row d-flex justify-content-center">
                                <div class="col-md-12">
                                    <div class="text-center align-content-center">
                                        <small id="forgotPwdMsg" class="form-text text-muted">
                                            새로 변경할 비밀번호를 입력해주세요.
                                        </small>
                                    </div>
                                    <div class="form-group">
                                        <label for="newPwd">비밀번호</label>
                                        <input
                                                type="password"
                                                class="form-control"
                                                name="newPwd"
                                                id="newPwd"
                                                placeholder="변경할 비밀번호 입력"
                                                required
                                        />
                                    </div>
                                    <div class="form-group">
                                        <label for="reenteredPwd">비밀번호 재입력</label>
                                        <input
                                                type="password"
                                                class="form-control"
                                                name="reenteredPwd"
                                                id="reenteredPwd"
                                                placeholder="변경할 비밀번호 확인"
                                                required
                                        />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-action">
                            <div class="d-flex justify-content-evenly mt-0 mb-4 m">
                                <button type="submit" formaction="/auth/forgot-pwd" formmethod="post"  class="btn btn-primary">비밀번호 재설정</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

<%@ include file="/WEB-INF/views/includes/_footer.jsp" %>
