<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/reset.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<link rel="stylesheet" href="/assets/css/header.css">
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <Script src="http://code.jquery.com/jquery-3.4.1.min.js"></Script>
    <script>
        $(function(){
            $('#upper_menu_books').click(function(){
                
            })
        
        })
    </script>
</head>
<body>
    <div class="head_container">
        <div class="upper_side">
            <div class="upper_left">
                <a href="/" id="main_mark">
                    <i class="fas fa-lightbulb"></i>
                </a>        
                <div class="search_group">
                    <input type="text" id="header_search_box" placeholder="Search...">
                    <button id="search_btn"><i class="fas fa-search"></i></button>
                </div>
            </div>
            <div class="upper_mid">
                <a href="/" id="upper_menu_users">Users</a>
                <a href="/" id="upper_menu_books">Books</a>
                <a href="#" id="upper_menu_goods">Goods</a>
                <a href="#" id="upper_menu_events">Events</a>
                <a href="#" id="upper_menu_questions">Questions</a>
                <a href="/admin/bookList" id="upper_menu_bookList">Book List</a>
                <a href="/admin/goodsList" id="upper_menu_goodsList">Goods List</a>
                <a href="/admin/accountList" id="upper_menu_accountList">Account List</a>
                <a href="/admin/memberList" id="upper_menu_accountList">Member List</a>
                <a href="/admin/page" id="upper_menu_admin">Administation</a>
            </div>
            <div class="upper_right">
                <a href="#" class="profile"><i class="far fa-user"></i></a>
                <a href="#"><i class="fas fa-shopping-basket"></i></a>
            </div>        
        </div>
    </div>

</body>
</html>