// adminMemberList.js

$(function(){
    $(".mod_del_box").css("display","none")
    $("#popup_btn").click(function(){
        $(".popup_container").addClass("active")
    })
    let selected = new Set();
    $("#admin_member_table tbody tr").click(function(){
        let check = $(this).attr("tr-seq");
        
        if($("#"+check+" input").prop("checked")){
            $("#"+check+" input").prop("checked",false)
        }else{
            $("#"+check+" input").prop("checked",true)
        }
        
        if($("#"+check+" input").prop("checked")){
            $("#"+check).addClass("active")
            selected.add(check)
        }else{
            $("#"+check).removeClass("active")
            selected.delete(check)
        }
        if(selected.size != 0){
            $(".mod_del_box").css("display","block")
        }else{
            $(".mod_del_box").css("display","none")
        }
    })
    
    $(".cancel_btn").click(function(){
        if(confirm("취소하시겠습니까? \n(내용은 저장되지 않습니다)")==false)return;
        $(".popup_container").removeClass("active")
        $("#input_name").val("")
        $("#input_id").val("")
        $("#input_pwd").val("")
        $("#input_pwd_con").val("")
        $("#input_birth").val("")
        $("#input_phone").val("")
        $("#input_email").val("")
        $("#input_address").val("")
        $("#input_status").val(0)
        $("#input_grade").val(0)
    })

    $(".add_btn").click(function(){
        if(confirm("정보를 추가하시겠습니까?")==false)return;
        if($("#input_name").val()==""){
            alert("이름을 입력해주세요.")
            return;
        }
        if($("#input_id").val()==""){
            alert("아이디를 입력해주세요.")
            return;
        }
        if($("#input_pwd").val()==""){
            alert("패스워드를 입력해주세요.")
            return;
        }
        if($("#input_pwd").val()!=$("#input_pwd_con").val()){
            alert("패스워드가 일치하지 않습니다.")
            return;
        }

        let data = {
            "mi_name":$("#input_name").val(),
            "mi_id":$("#input_id").val(),
            "mi_pwd":$("#input_pwd").val(),
            "mi_birth":$("#input_birth").val(),
            "mi_phone":$("#input_phone").val(),
            "mi_email":$("#input_email").val(),
            "mi_address":$("#input_address").val(),
            "mi_status":$("#input_status").val(),
            "mi_grade":$("#input_grade").val()
        }
        $.ajax({
            url:"/member/insert",
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

    $("#status_mod_btn").click(function(){
        if(!confirm("상태를 변경하시겠습니까?"))return;
        for (var seq of selected){
            $.ajax({
                url:"/member/update/status?seq="+seq+"&status="+$("#mod_status").val(),
                type:"patch",
                success:function(r){
                    location.reload()
                }
            })
        }
    })
    $("#grade_mod_btn").click(function(){
        if(!confirm("등급을 변경하시겠습니까?"))return;
        for (var seq of selected){
            if($("#"+seq).attr("grade_check")==9999){
                selected.delete(seq)
                alert("관리자 등급은 변경하실 수 없습니다.")
            }
        }
        for (var seq of selected){
            $.ajax({
                url:"/member/update/grade?seq="+seq+"&grade="+$("#mod_grade").val(),
                type:"patch",
                success:function(r){
                    location.reload()
                }
            })
        }
    })
    $("#delete_btn").click(function(){
        if(!confirm("삭제 하시겠습니까?"))return;
        for (var seq of selected){
            $.ajax({
                url:"/member/delete?seq="+seq,
                type:"delete",
                success:function(r){
                    location.reload()
                }
            })
        }
    })
    $(".mod_del_box #mdb_cancel_btn").click(function(){
        selected = new Set();
        $(".mod_del_box").css("display","none")
        $(".admin_member_table tbody tr").removeClass("active")
    })

    $(".tool_box_wrap #search_btn").click(function(){
        location.href="/admin/memberList?keyword="+$(".tool_box_wrap #search_box").val()+"&type="+$("#search_sel").val();
    })

    $(".tool_box_wrap").keydown(function(e){
        if(e.keyCode==13){
            $(".tool_box_wrap #search_btn").trigger("click");
        }
    })

})
