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
                console.log(r.list)
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
    $(".account_list_mid ul li").click(function(){
        alert("sss")
        let html = $(this.html())
        console.log(html)
        $("#input_accounts").html($(this).html())
        $("#input_accounts").attr("val",$(this).html())
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
                    $("#input_accounts").attr("val")=seq;
                    
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
                $("#input_accounts").val(r.bi_al_seq)
                $("#input_cat").val(r.bi_bc_seq)
            }
        })
    })

    $(".book_delete").click(function(){
        if(confirm("정말 삭제하시겠습니까?")==false)return;
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
        if(confirm("취소하시겠습니까? \n(내용은 저장되지 않습니다)")==false)return;
        $(".account_list_wrap").css("display","none")
        $("#account_search_box").val("")
        $("#input_accounts").html("Publisher()")
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
        if(confirm("정보를 추가하시겠습니까?")==false)return;
        let data = {
            "bi_title":$("#input_title").val(),
            "bi_author":$("#input_author").val(),
            "bi_page":$("#input_page").val(),
            "bi_price":$("#input_price").val(),
            "bi_al_seq":$("#input_accounts").attr("val"),
            "bi_bc_seq":$("#input_cat").val()
        }
        console.log(data)
        $.ajax({
            url:"/bookList/insert",
            type:"post",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                if(r.status)
                    location.reload()
            }
        })
    })

    $(".modify_btn").click(function(){
        if(confirm("내용을 수정하시겠습니까?")==false)return;
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
        location.href="/admin/bookList?keyword="+$("#search_box").val();
    })
    $(".tool_box_wrap").keydown(function(e){
        if(e.keyCode==13){
            $("#search_btn").trigger("click");
        }
    })

})
