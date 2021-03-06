// adminBookList.js
let key_seq;
$(function(){
    $("#popup_btn").click(function(){
        $(".popup_container").addClass("active")
        $(".modify_btn").css("display","none")
        $(".add_btn").css("display","inline-block")
        $(".popup_top").html("Add Book")
    })

    $("#input_accounts").click(function(){
        $(".account_list_wrap").css("display","inline-block")
        $.ajax({
            url:"/accountList/byKeyword?",
            type:"get",
            success:function(r){
                $(".account_list_mid ul").html("");
                
                for(let i=0; i<r.list.length;i++){
                    let seq = r.list[i].al_seq;
                    let data = r.list[i].al_name;
                let tag = '<li val="'+ seq +'">'+ data +'</li>';
                $(".account_list_mid ul").append(tag)
                }

                $(".account_list_mid ul li").click(function(){
                    let html = $(this).html()
                    let seq = $(this).attr("val")
                    $("#input_accounts").html(html)
                    $("#input_accounts").attr("val",seq)
                    
                    $(".account_list_wrap").css("display","none")
                    $("#account_search_box").val("")
                })
            }
        })
    })
    $(".account_list_cancel").click(function(){
        $(".account_list_wrap").css("display","none")
        $("#account_search_box").val("")
    })


    $("#account_search_btn").click(function(){
        let keyword = $("#account_search_box").val()
        $.ajax({
            url:"/accountList/byKeyword?keyword="+keyword,
            type:"get",
            success:function(r){
                $(".account_list_mid ul").html("");
                for(let i=0; i<r.list.length;i++){
                    let seq = r.list[i].al_seq;
                    let data = r.list[i].al_name;
                let tag = '<li val="'+ seq +'">'+ data +'</li>';
                $(".account_list_mid ul").append(tag)
                }

                $(".account_list_mid ul li").click(function(){
                    let html = $(this).html()
                    let seq = $(this).attr("val")

                    $("#input_accounts").html(html)
                    $("#input_accounts").attr("val",seq);
                    
                    $(".account_list_wrap").css("display","none")
                    $("#account_search_box").val("")
                })
            }
        })
    })

    $(".book_modify").click(function(){
        $(".popup_container").addClass("active")
        $(".modify_btn").css("display","inline-block")
        $(".add_btn").css("display","none")
        $(".popup_top").html("Modify Book")
        key_seq=$(this).attr("book_seq");
        $.ajax({
            url:"/book/bySeq?seq="+key_seq,
            type:"get",
            success:function(r){
                $("#input_title").val(r.bi_title)
                $("#input_author").val(r.bi_author)
                $("#input_page").val(r.bi_page)
                $("#input_price").val(r.bi_price)
                $("#input_accounts").attr("val",r.bi_al_seq)
                $("#input_accounts").html(r.bi_account)
                $("#input_cat").val(r.bi_bc_seq)
            }
        })
    })

    $(".book_delete").click(function(){
        if(confirm("?????? ?????????????????????????")==false)return;
        let seq = $(this).attr("book_seq")
        $.ajax({
            url:"/bookList/delete?seq="+seq,
            type:"delete",
            success:function(r){
                alert(r.message)
                if(r.status)
                    location.reload()
            }
        })
    })

    $(".cancel_btn").click(function(){
        if(confirm("????????????????????????? \n(????????? ???????????? ????????????)")==false)return;
        $(".account_list_wrap").css("display","none")
        $("#account_search_box").val("")
        $("#input_accounts").html("Publisher")
        $("#input_accounts").attr("val","")
        $(".popup_container").removeClass("active")
        $("#input_title").val("")
        $("#input_author").val("")
        $("#input_page").val("")
        $("#input_price").val("")
        $("#input_accounts").val(0)
        $("#input_cat").val(0)
    })

    $(".add_btn").click(function(){
        if(confirm("????????? ?????????????????????????")==false)return;
        let data = {
            "bi_title":$("#input_title").val(),
            "bi_author":$("#input_author").val(),
            "bi_page":$("#input_page").val(),
            "bi_price":$("#input_price").val(),
            "bi_al_seq":$("#input_accounts").attr("val"),
            "bi_bc_seq":$("#input_cat").val()
        }
        $.ajax({
            url:"/bookList/insert",
            type:"post",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                if(r.status)
                    location.href="/admin/bookList"
            }
        })
    })

    $(".modify_btn").click(function(){
        if(confirm("????????? ?????????????????????????")==false)return;
        let data = {
            "bi_seq":key_seq,
            "bi_title":$("#input_title").val(),
            "bi_author":$("#input_author").val(),
            "bi_page":$("#input_page").val(),
            "bi_price":$("#input_price").val(),
            "bi_al_seq":$("#input_accounts").attr("val"),
            "bi_bc_seq":$("#input_cat").val()
        }
        $.ajax({
            url:"/bookList/update",
            type:"patch",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                if(r.status)
                    location.reload()
            }
        })
    })

    $(".tool_box_wrap #search_btn").click(function(){
        location.href="/admin/bookList?keyword="+$(".tool_box_wrap #search_box").val();
    })
    $(".tool_box_wrap").keydown(function(e){
        if(e.keyCode==13){
            $(".tool_box_wrap #search_btn").trigger("click");
        }
    })
    $("#account_search_box").keydown(function(e){
        if(e.keyCode==13){
            $("#account_search_btn").trigger("click");
        }
    })
})
