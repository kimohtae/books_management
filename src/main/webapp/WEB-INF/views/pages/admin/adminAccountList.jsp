<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <link rel="stylesheet" href="/assets/css/adminAccountList.css">
    <script src="/assets/js/adminAccountList.js"></script>
    <title>Document</title>
    
</head>
<body>
    
    <main>
        <div class="admin_account_container">
            <div class="admin_account_wrap">
                <div class="admin_account_upper">
                    <h1>Account List</h1>
                    <div class="tool_box_wrap">
                        <input type="text" id="search_box">
                        <button id="search_btn"><i class="fas fa-search"></i></button>
                        <button id="popup_btn">Add Account</button>
                    </div>
                </div>
                <table id="admin_account_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>거래처</th>
                            <th>담당자</th>
                            <th>전화번호</th>
                            <th>이메일</th>
                            <th>주소</th>
                            <th>상태</th>
                            <th>등록일</th>
                            <th>변경</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data.list}" var="item">
                            <tr>
                                <td>${item.al_seq}</td>
                                <td>${item.al_name}</td>
                                <td>${item.al_charge_person}</td>
                                <td>${item.al_phone}</td>
                                <td>${item.al_email}</td>
                                <td>${item.al_address}</td>
                                <td>
                                    <c:if test="${item.al_status==1}">협의</c:if>
                                    <c:if test="${item.al_status==2}">정상</c:if>
                                    <c:if test="${item.al_status==3}">중단</c:if>
                                </td>
                                <td><fmt:formatDate value="${item.al_reg_dt}" pattern="yyyy-MM-dd (EE) HH:mm:ss"/></td>
                                <td>
                                    <button class="Account_modify" Account_seq="${item.al_seq}">수정</button>
                                    <button class="Account_delete" Account_seq="${item.al_seq}">삭제</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="admin_account_pager">
                    <button id="prev"><i class="fas fa-chevron-left"></i></button>
                    <c:forEach begin="1" end="${data.pages}" var="i">
                        <a href="/admin/accountList?offset=${(i-1)*10}&keyword=${data.keyword}">${i}</a>
                    </c:forEach>
                    <button id="prev"><i class="fas fa-chevron-right"></i></button>
                </div>
            </div>
        </div>
        
    </main>
    <div class="popup_container">
        <div class="popup_wrap">
            <div class="popup_top">Add Account</div>
            <div class="popup_mid">
                <input type="text" id="input_name" placeholder="Company Name">
                <input type="text" id="input_char_per" placeholder="Contact Person Name">
                <input type="text" id="input_phone" placeholder="Phone Number (01012345678)">
                <input type="text" id="input_email" placeholder="Email (mail12@mail.com)">
                <input type="text" id="input_address" placeholder="Address">
                <select id="input_status">
                    <option value="1">협의</option>
                    <option value="2">정상</option>
                    <option value="3">중단</option>
                </select>
            </div>
            <div class="popup_bot">
                <button class="add_btn">생성</button>
                <button class="modify_btn">수정</button>
                <button class="cancel_btn">취소</button>
            </div>
        </div>
    </div>
</body>
</html>