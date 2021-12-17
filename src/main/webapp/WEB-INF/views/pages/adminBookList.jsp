<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <%@include file="/WEB-INF/views/includes/side_bar.jsp"%>
    <link rel="stylesheet" href="/assets/css/adminBookList.css">
    <script src="/assets/js/adminBookList.js"></script>
    <title>Document</title>
    
</head>
<body>
    
    <main>
        <div class="admin_book_container">
            <div class="admin_book_wrap">
                <div class="admin_book_upper">
                    <h1>Book List</h1>
                    <div class="search_box_wrap">
                        <input type="text" id="search_box">
                        <button id="search_btn">검색</button>
                    </div>
                    <div class="book_cnt">
                        <h2>Book Counts</h2>
                        <h2>${data.counts}</h2>
                    </div>
                    <button id="popup_btn">Add Book</button>
                </div>
                <table id="admin_book_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작가</th>
                            <th>출판사</th>
                            <th>페이지 수</th>
                            <th>가격</th>
                            <th>종류</th>
                            <th>재고</th>
                            <th>추천</th>
                            <th>이미지</th>
                            <th>입력일</th>
                            <th>변경일</th>
                            <th>변경</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data.list}" var="item">
                            <tr>
                                <td>${item.bi_seq}</td>
                                <td>${item.bi_title}</td>
                                <td>${item.bi_author}</td>
                                <td>${item.bi_acounts}</td>
                                <td>${item.bi_page}</td>
                                <td>${item.bi_price}</td>
                                <td>
                                    ${item.bi_catP}/${item.bi_catC}
                                </td>
                                <td>${item.bi_stock}</td>
                                <td>${item.bi_like}</td>
                                <td>${item.bi_image}</td>
                                <td>${item.bi_reg_dt}</td>
                                <td>${item.bi_mod_dt}</td>
                                <td>
                                    <button class="book_modify" book_seq="${item.bi_seq}">수정</button>
                                    <button class="book_delete" book_seq="${item.bi_seq}">삭제</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="admin_book_pager">
                    <button id="prev"><i class="fas fa-chevron-left"></i></button>
                    <c:forEach begin="1" end="${data.pages}" var="i">
                        <a href="/admin/book?offset=${(i-1)*10}&keyword=${data.keyword}">${i}</a>
                    </c:forEach>
                    <button id="prev"><i class="fas fa-chevron-right"></i></button>
                   

                </div>
            </div>
        </div>
        
    </main>
    <div class="popup_container">
        <div class="popup_wrap">
            <div class="popup_top">Add Book</div>
            <div class="popup_mid">
                <input type="text" id="input_title" placeholder="Title">
                <input type="text" id="input_author" placeholder="Author">
                <input type="number" id="input_page" placeholder="Page">
                <input type="number" id="input_price" placeholder="Price">
                <select id="input_accounts">
                    <option value="0">Publisher</option>
                    <c:forEach items="${account}" var="item">
                        <option value="${item.al_seq}">${item.al_name}</option>
                    </c:forEach>
                </select>
                <select id="input_image">
                    <option value="0">Image</option>
                    <c:forEach items="${image}" var="item">
                        <option value="${item.ib_seq}">${item.ib_image}</option>
                    </c:forEach>
                </select>
                <select id="input_cat">
                    <option value="0">Category</option>
                    <c:forEach items="${category}" var="item">
                        <option value="${item.bc_seq}">${item.bc_parent_category}/${item.bc_child_category}</option>
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
</body>
</html>