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
    <link rel="stylesheet" href="/assets/css/adminMainPage.css">
    <script src="/assets/js/adminMainPage.js"></script>
    <title>Document</title>
    
</head>
<body>
    
    <main>
        <div class="admin_mainpage_container">
            <div class="admin_mainpage_wrap">
                <div class="accounts_info">
                    <h2>Accounts Info</h2>
                    <p>총 거래처 수: ${accountInfo.total}</p>
                    <p>거래 가능한 거래처 수: ${accountInfo.trading}</p>
                    <p>거래 중단된 거래처 수: ${accountInfo.halted}</p>
                    <p>계약 진행중 거래처 수: ${accountInfo.contracting}</p>
                    <p>업데이트 날짜: <fmt:formatDate value="${accountInfo.update}" pattern="yyyy년 MM월 dd일 (EE) HH:mm:ss"/> </p>
                </div>
                <div class="books_info">
                    <h2>Books Info</h2>
                    <p>총 재고량: ${bookInfo.total} </p>
                    <p>총 판매건수: ${bookInfo.sell} </p>
                    <p>일간 판매건수: ${bookInfo.today} </p>
                    <p>주간 판매건수: ${bookInfo.week} </p>
                    <p>월간 판매건수: ${bookInfo.month} </p>
                    <p>업데이트 날짜: <fmt:formatDate value="${bookInfo.update}" pattern="yyyy년 MM월 dd일 (EE) HH:mm:ss"/> </p>
                </div>
                <div class="goods_info">
                    <h2>Goods Info</h2>
                    <p>총 재고량: ${goodsInfo.total} </p>
                    <p>총 판매건수: ${goodsInfo.sell} </p>
                    <p>일간 판매건수: ${goodsInfo.today} </p>
                    <p>주간 판매건수: ${goodsInfo.week} </p>
                    <p>월간 판매건수: ${goodsInfo.month} </p>
                    <p>업데이트 날짜: <fmt:formatDate value="${goodsInfo.update}" pattern="yyyy년 MM월 dd일 (EE) HH:mm:ss"/>  </p>
                </div>
                <div class="member_info">
                    <h2>Member Info</h2>
                    <p>총 회원 수: ${memberInfo.total} </p>
                    <p>정상 회원 수: ${memberInfo.normal} </p>
                    <p>신규 회원 수: ${memberInfo.newm} </p>
                    <p>휴면 회원 수: ${memberInfo.dormant} </p>
                    <p>정지 회원 수: ${memberInfo.halted} </p>
                    <p>업데이트 날짜: <fmt:formatDate value="${memberInfo.update}" pattern="yyyy년 MM월 dd일 (EE) HH:mm:ss"/> </p>
                </div>
            </div>
        </div>
    </main>
</body>
</html>