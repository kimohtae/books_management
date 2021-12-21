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
    <link rel="stylesheet" href="/assets/css/adminGoodsList.css">
    <script src="/assets/js/adminGoodsList.js"></script>
    <title>Document</title>
    
</head>
<body>
    <main>
        <div class="admin_goods_container">
            <div class="admin_goods_wrap">
                <div class="admin_goods_upper">
                    <h1>Goods List</h1>
                    <div class="tool_box_wrap">
                        <input type="text" id="search_box">
                        <button id="search_btn"><i class="fas fa-search"></i></button>
                        <button id="popup_btn">Add Goods</button>
                    </div>
                </div>
                <table id="admin_goods_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>이름</th>
                            <th>제작사</th>
                            <th>가격</th>
                            <th>종류</th>
                            <th>재고/추천/판매</th>
                            <th>등록일</th>
                            <th>변경</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data.list}" var="item">
                            <tr>
                                <td>${item.gi_seq}</td>
                                <td>${item.gi_name}</td>
                                <td>${item.gi_account}</td>
                                <td>${item.gi_price}</td>
                                <td>
                                    ${item.gi_catP}/${item.gi_catC}
                                </td>
                                <td>${item.gi_stock}/${item.gi_like}/${item.gi_sell}</td>
                                <td><fmt:formatDate value="${item.gi_reg_dt}" pattern="yyyy년 MM월 dd일 (EE)  HH:mm:ss"/></td>
                                <td>
                                    <button class="goods_modify" goods_seq="${item.gi_seq}">수정</button>
                                    <button class="goods_delete" goods_seq="${item.gi_seq}">삭제</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="admin_goods_pager">
                    <button id="prev"><i class="fas fa-chevron-left"></i></button>
                    <c:forEach begin="1" end="${data.pages}" var="i">
                        <a href="/admin/goodsList?offset=${(i-1)*20}&keyword=${data.keyword}">${i}</a>
                    </c:forEach>
                    <button id="prev"><i class="fas fa-chevron-right"></i></button>
                </div>
            </div>
        </div>
        
    </main>
    <div class="popup_container">
        <div class="popup_wrap">
            <div class="popup_top">Add Goods</div>
            <div class="popup_mid">
                <input type="text" id="input_name" placeholder="Name">
                <input type="number" id="input_price" placeholder="Price">
                <p id="input_accounts">Production</p>
                <select id="input_cat">
                    <option value="0">Category</option>
                    <c:forEach items="${category}" var="item">
                        <option value="${item.gc_seq}">${item.gc_parent_category}/${item.gc_child_category}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="popup_bot">
                <button class="add_btn">생성</button>
                <button class="modify_btn">수정</button>
                <button class="cancel_btn">취소</button>
            </div>
        </div>
    </div>
    <div class="account_list_wrap">
        <div class="account_list_top">Select Production</div>
        <div class="account_list_mid">
            <ul>
            </ul>
        </div>
        <div class="account_list_search">
            <input type="text" id="account_search_box" placeholder="Production">
            <button id="account_search_btn"><i class="fas fa-search"></i></button>
        </div>
        <div class="account_list_cancel"><i class="fas fa-times"></i></div>
    </div>
</body>
</html>