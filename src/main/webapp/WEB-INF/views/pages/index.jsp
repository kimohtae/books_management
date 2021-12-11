<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/index.css">
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <%@include file="/WEB-INF/views/includes/side_bar.jsp"%>
    <main>
        <div class="main_container">
            <div class="main_wrap">
               <div class="main_rank_wrap">
                    <div class="rank_box_month">
                        <h1>Month Rank</h1>
                        <a href="#">1.${dayRank[0]}</a>
                        <a href="#">2.${dayRank[1]}</a>
                        <a href="#">3.${dayRank[2]}</a>
                        <a href="#">4.${dayRank[3]}</a>
                        <a href="#">5.${dayRank[4]}</a>
                        <a href="#">6.${dayRank[5]}</a>
                        <a href="#">7.${dayRank[6]}</a>
                        <a href="#">8.${dayRank[7]}</a>
                        <a href="#">9.${dayRank[8]}</a>
                        <a href="#">10.${dayRank[9]}</a>
                    </div>
                    <div class="rank_box_week">
                        <h1>Week Rank</h1>
                        <a href="#">1.${weekRank[0]}</a>
                        <a href="#">2.${weekRank[1]}</a>
                        <a href="#">3.${weekRank[2]}</a>
                        <a href="#">4.${weekRank[3]}</a>
                        <a href="#">5.${weekRank[4]}</a>
                        <a href="#">6.${weekRank[5]}</a>
                        <a href="#">7.${weekRank[6]}</a>
                        <a href="#">8.${weekRank[7]}</a>
                        <a href="#">9.${weekRank[8]}</a>
                        <a href="#">10.${weekRank[9]}</a>
                    </div>
                    <div class="rank_box_day">
                        <h1>Day Rank</h1>
                        <a href="#">1.${monthRank[0]}</a>
                        <a href="#">2.${monthRank[1]}</a>
                        <a href="#">3.${monthRank[2]}</a>
                        <a href="#">4.${monthRank[3]}</a>
                        <a href="#">5.${monthRank[4]}</a>
                        <a href="#">6.${monthRank[5]}</a>
                        <a href="#">7.${monthRank[6]}</a>
                        <a href="#">8.${monthRank[7]}</a>
                        <a href="#">9.${monthRank[8]}</a>
                        <a href="#">10.${monthRank[9]}</a>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>