
let key_seq;
$(function(){
    $("#popup_btn").click(function(){
        $(".popup_container").addClass("active")
        $(".modify_btn").css("display","none")
        $(".add_btn").css("display","inline-block")
    })
    $(".book_modify").click(function(){
        $(".popup_container").addClass("active")
        $(".modify_btn").css("display","inline-block")
        $(".add_btn").css("display","none")
        key_seq=$(this).attr("book_seq");
        $.ajax({
            url:"/book/seq?seq="+$(this).attr("book_seq"),
            type:"get",
            success:function(r){
                $("#input_title").val(r.bi_title)
                $("#input_author").val(r.bi_author)
                $("#input_page").val(r.bi_page)
                $("#input_price").val(r.bi_price)
                $("#input_image").val(r.bi_ib_seq)
                $("#input_accounts").val(r.bi_al_seq)
                $("#input_cat").val(r.bi_bc_seq)
            }
        })
    })
    $(".cancel_btn").click(function(){
        if(confirm("취소하시겠습니까? \n(내용은 저장되지 않습니다)")==false)return;
        $(".popup_container").removeClass("active")
        $("#input_title").val("")
        $("#input_author").val("")
        $("#input_page").val("")
        $("#input_price").val("")
        $("#input_image").val(0)
        $("#input_accounts").val(0)
        $("#input_cat").val(0)
    })
    $(".modify_btn").click(function(){
        if(confirm("내용을 수정하시겠습니까?")==false)return;
        let data = {
            "bi_seq":key_seq,
            "bi_title":$("#input_title").val(),
            "bi_author":$("#input_author").val(),
            "bi_page":$("#input_page").val(),
            "bi_price":$("#input_price").val(),
            "bi_ib_seq":$("#input_image").val(),
            "bi_al_seq":$("#input_accounts").val(),
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
    $(".add_btn").click(function(){
        if(confirm("정보를 추가하시겠습니까?")==false)return;
        let data = {
            "bi_title":$("#input_title").val(),
            "bi_author":$("#input_author").val(),
            "bi_page":$("#input_page").val(),
            "bi_price":$("#input_price").val(),
            "bi_ib_seq":$("#input_image").val(),
            "bi_al_seq":$("#input_accounts").val(),
            "bi_bc_seq":$("#input_cat").val()
        }
        $.ajax({
            url:"/bookList/add",
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
    $(".search_box_wrap #search_btn").click(function(){
        location.href="/admin/book?keyword="+$(".search_box_wrap #search_box").val();
    })
    $(".admin_book_upper .search_box_wrap").keydown(function(e){
        if(e.keyCode==13){
            $(".search_box_wrap #search_btn").trigger("click");
        }
    })

})
