let index = {
		init: function(){
			$("#btn-write").on("click", ()=>{
				this.save();
			});
			$("#btn-delete").on("click", ()=>{
				this.deleteById();
			});
			$("#btn-update").on("click", ()=>{
				this.update();
			});
			$("#btn-reply-save").on("click", ()=>{
				this.replySave();
			});
			$("#btn-reply-delete").on("click", ()=>{
            				this.replyDelete();
            			});
		},

		save: function(){
			let data = {
					fbo: $("#fbo").val(),
					fbrcontent: $("#fbrcontent").val()
			};

			$.ajax({
				type: "POST",
				url: "/Roommate/Freeboard/Writeprob",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				location.href = "/Roommate/Freeboard";
			}).fail(function(error){
				alert("로그인이 필요한 기능입니다");
			});
		},

		deleteById: function(){
			let fbn = $("#fbn").val();

			$.ajax({
				type: "DELETE",
				url: "/Roommate/Freeboard/Writeprob/fbn="+fbn,
				dataType: "json"
			}).done(function(resp){
				history.back();
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},

		update: function(){
			let fbn = $("#fbn").val();

			let data = {
					fbo: $("#fbo").val(),
					fbrcontent: $("#fbrcontent").val()
			};

			$.ajax({
				type: "PUT",
				url: "/Roommate/Freeboard/Writeprob/fbn="+fbn,
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				location.href="/Roommate/Freeboard"
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},

		replySave: function(){
		let fbn=$("#fbn").val();
			let data = {
					userid: $("#userid").val(),
					fbn: $("#fbn").val(),
					replycontent: $("#replycontent").val()
			};

			$.ajax({
				type: "POST",
				url: `/Roommate/Freeboard/${data.fbn}/reply`,
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
			        history.back();
			}).fail(function(error){
				console.log(JSON.stringify(error));
			});
		},

		replyDelete : function(fbn, replyId){
			$.ajax({
				type: "DELETE",
				url: `/Roommate/Freeboard/${fbn}/reply/${replyId}`,
				dataType: "json"
			}).done(function(resp){
				alert("댓글삭제 성공");
				location.href = `/Freeboard/${boardId}`;
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},
}

index.init();
