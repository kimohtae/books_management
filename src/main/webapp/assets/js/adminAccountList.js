// accounts_list.js

let key_seq;
$(function(){
    $("#popup_btn").click(function(){
        $(".popup_container").addClass("active")
        $(".modify_btn").css("display","none")
        $(".add_btn").css("display","inline-block")
        $("#input_status").css("display","none")
        $(".popup_top").html("Add Account")
        
    })
    
    $(".Account_modify").click(function(){
        $(".popup_container").addClass("active")
        $(".modify_btn").css("display","inline-block")
        $(".add_btn").css("display","none")
        $("#input_status").css("display","inline-block")
        $(".popup_top").html("Modify Account")
        key_seq=$(this).attr("Account_seq");
        $.ajax({
            url:"/account/bySeq?seq="+key_seq,
            type:"get",
            success:function(r){
                $("#input_name").val(r.al_name)
                $("#input_char_per").val(r.al_charge_person)
                $("#input_phone").val(r.al_phone)
                $("#input_email").val(r.al_email)
                $("#input_address").val(r.al_address)
                $("#input_status").val(r.al_status)
            }
        })
    })

    $(".Account_delete").click(function(){
        if(confirm("정말 삭제하시겠습니까?")==false)return;
        let seq = $(this).attr("Account_seq")
        $.ajax({
            url:"/accountList/delete?seq="+seq,
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
        $(".popup_container").removeClass("active")
        $("#input_name").val("")
        $("#input_char_per").val("")
        $("#input_phone").val("")
        $("#input_email").val("")
        $("#input_address").val("")
        $("#input_status").val(2)
    })

    $(".add_btn").click(function(){
        if(confirm("정보를 추가하시겠습니까?")==false)return;
        let data = {
            "al_name":$("#input_name").val(),
            "al_charge_person":$("#input_char_per").val(),
            "al_phone":$("#input_phone").val(),
            "al_email":$("#input_email").val(),
            "al_address":$("#input_address").val(),
        }
        $.ajax({
            url:"/accountList/insert",
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
            "al_seq":key_seq,
            "al_name":$("#input_name").val(),
            "al_charge_person":$("#input_char_per").val(),
            "al_phone":$("#input_phone").val(),
            "al_email":$("#input_email").val(),
            "al_address":$("#input_address").val(),
            "al_status":$("#input_status").val()
        }
        $.ajax({
            url:"/accountList/update",
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
        location.href="/admin/accountList?keyword="+$(".tool_box_wrap #search_box").val();
    })
    $(".tool_box_wrap #search_box").keydown(function(e){
        if(e.keyCode==13){
            $(".tool_box_wrap #search_btn").trigger("click");
        }
    })

})
