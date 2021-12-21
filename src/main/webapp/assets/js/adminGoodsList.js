// adminGoodsList.js
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

    $(".goods_modify").click(function(){
        $(".popup_container").addClass("active")
        $(".modify_btn").css("display","inline-block")
        $(".add_btn").css("display","none")
        $(".popup_top").html("Modify Goods")
        key_seq=$(this).attr("goods_seq");
        $.ajax({
            url:"/goods/bySeq?seq="+key_seq,
            type:"get",
            success:function(r){
                $("#input_name").val(r.gi_name)
                $("#input_price").val(r.gi_price)
                $("#input_accounts").attr("val",r.gi_al_seq)
                $("#input_accounts").html(r.gi_account)
                $("#input_cat").val(r.gi_gc_seq)
            }
        })
    })

    $(".goods_delete").click(function(){
        if(confirm("정말 삭제하시겠습니까?")==false)return;
        let seq = $(this).attr("goods_seq")
        $.ajax({
            url:"/goodsList/delete?seq="+seq,
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
        $("#input_accounts").html("Production")
        $("#input_accounts").attr("val","")
        $(".popup_container").removeClass("active")
        $("#input_name").val("")
        $("#input_price").val("")
        $("#input_accounts").val(0)
        $("#input_cat").val(0)
    })

    $(".add_btn").click(function(){
        if(confirm("정보를 추가하시겠습니까?")==false)return;
        let data = {
            "gi_name":$("#input_name").val(),
            "gi_price":$("#input_price").val(),
            "gi_al_seq":$("#input_accounts").attr("val"),
            "gi_gc_seq":$("#input_cat").val()
        }
        $.ajax({
            url:"/goodsList/insert",
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
            "gi_seq":key_seq,
            "gi_name":$("#input_name").val(),
            "gi_price":$("#input_price").val(),
            "gi_al_seq":$("#input_accounts").attr("val"),
            "gi_gc_seq":$("#input_cat").val()
        }
        $.ajax({
            url:"/goodsList/update",
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
        location.href="/admin/goodsList?keyword="+$(".tool_box_wrap #search_box").val();
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
