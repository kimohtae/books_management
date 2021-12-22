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
    <link rel="stylesheet" href="/assets/css/adminMemberList.css">
    <script src="/assets/js/adminMemberList.js"></script>
    <title>Document</title>
    
</head>
<body>
    
    <main>
        <div class="admin_member_container">
            <div class="admin_member_wrap">
                <div class="admin_member_upper">
                    <h1>Member List</h1>
                    <div class="tool_box_wrap">
                        <select id="search_sel">
                            <option value="name">이름</option>
                            <option value="id">아이디</option>
                        </select>
                        <input type="text" id="search_box">
                        <button id="search_btn"><i class="fas fa-search"></i></button>
                        <button id="popup_btn">Add Member</button>
                    </div>
                </div>
                <table id="admin_member_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>이름</th>
                            <th>아이디</th>
                            <th>생년월일</th>
                            <th>전화번호</th>
                            <th>이메일</th>
                            <th>주소</th>
                            <th>상태/등급</th>
                            <th>등록일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data.list}" var="item">
                            <tr tr-seq="${item.mi_seq}" id="${item.mi_seq}" grade_check="${item.mi_grade}">
                                <td>${item.mi_seq}</td>
                                <td>${item.mi_name}</td>
                                <td>${item.mi_id}</td>
                                <td>${item.mi_birth}</td>
                                <td>${item.mi_phone}</td>
                                <td>${item.mi_email}</td>
                                <td>${item.mi_address} <input type="checkbox" style="display: none;"></td>
                                <td>
                                        <c:if test="${item.mi_status==1}"><span style="color: rgb(63, 131, 63);">신규</span></c:if>
                                        <c:if test="${item.mi_status==2}"><span style="color: rgb(106, 106, 253);">정상</span></c:if>
                                        <c:if test="${item.mi_status==3}"><span style="color: gray;">휴먼</span></c:if>
                                        <c:if test="${item.mi_status==4}"><span style="color: rgb(252, 124, 124);">정지</span></c:if>
                                    /
                                        <c:if test="${item.mi_grade==1}"><span style="color: rgb(63, 131, 63);">일반</span></c:if>
                                        <c:if test="${item.mi_grade==2}"><span style="color: rgb(106, 106, 253);">우수</span></c:if>
                                        <c:if test="${item.mi_grade==3}"><span style="color: rgb(146, 146, 76);">VIP</span></c:if>
                                        <c:if test="${item.mi_grade==4}"><span style="color: rgb(255, 246, 126);">VVIP</span></c:if>
                                        <c:if test="${item.mi_grade==9999}"><span style="color: rgb(255, 255, 255);">관리자</span</c:if>
                                </td>
                                <td><fmt:formatDate value="${item.mi_reg_dt}" pattern="yyyy-MM-dd (EE) HH:mm:ss"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="admin_member_pager">
                    <button id="prev"><i class="fas fa-chevron-left"></i></button>
                    <c:forEach begin="1" end="${data.pages}" var="i">
                        <a href="/admin/memberList?offset=${(i-1)*20}&keyword=${data.keyword}&type=${data.type}">${i}</a>
                    </c:forEach>
                    <button id="prev"><i class="fas fa-chevron-right"></i></button>
                </div>
            </div>
        </div>
        
    </main>
    <div class="popup_container">
        <div class="popup_wrap">
            <div class="popup_top">Add Member</div>
            <div class="popup_mid">
                <input type="text" id="input_name" placeholder="Name">
                <input type="text" id="input_id" placeholder="Id">
                <input type="password" id="input_pwd" placeholder="Password">
                <input type="password" id="input_pwd_con" placeholder="Password Confirm">
                <input type="text" id="input_birth" placeholder="Brith ex)20210614">
                <input type="text" id="input_phone" placeholder="Phone Number (without '-')">
                <input type="text" id="input_email" placeholder="Email ex)mail12@mail.com">
                <input type="text" id="input_address" placeholder="Address">
                <select id="input_status">
                    <option value="0">Status</option>
                    <option value="1" >신규</option>
                    <option value="2" >정상</option>
                    <option value="3" >휴먼</option>
                    <option value="4" >정지</option>
                </select>
                <select id="input_grade">
                    <option value="0" >Grade</option>
                    <option value="1" >일반</option>
                    <option value="2" >우수</option>
                    <option value="3" >VIP</option>
                    <option value="4">VVIP</option>
                    <option value="9999">관리자</option>
                </select>
            </div>
            <div class="popup_bot">
                <button class="add_btn">생성</button>
                <button class="cancel_btn">취소</button>
            </div>
        </div>
    </div>
    <div class="mod_del_box">
        <button id="delete_btn">삭제</button>
        <button id="mdb_cancel_btn">x</button>
        <div class="mod_box_status">
            <select id="mod_status">
                <option value="1" >신규</option>
                <option value="2" >정상</option>
                <option value="3" >휴먼</option>
                <option value="4" >정지</option>
            </select>
            <button id="status_mod_btn">적용</button>
        </div>
        <div class="mod_box_grade">
            <select id="mod_grade">
                <option value="1">일반</option>
                <option value="2">우수</option>
                <option value="3">VIP</option>
                <option value="4">VVIP</option>
            </select>
            <button id="grade_mod_btn">적용</button>
        </div>
    </div>
</body>
</html>