
let signup = {
    init:function(){
        $("#btn-save").on("click",()=>{
            this.save();
        });
    },
    save:function(){
        let data={
            userid:$("#userid").val(),
            userpw:$("#userpw").val(),
            userpn:$("#userpn").val(),
            useremail:$("#useremail").val()
        }

        $.ajax({
            type:"POST",
            url:"/Roommate/signupprob",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            console.log(resp)
            location.href="/Roommate/Welcome"
        }).fail(function(error){

        });
    }
}
signup.init();