
var NewLogin = function() {
	return {
		myVariable: null,

		init: function() {
			
			jQuery("#btnLogin").click(function(){
				//get the data from login page
				var loginOp = jQuery("#loginOp").val();
				var uName = jQuery("#uName").val();
			    var pWord = jQuery("#pWord").val();
			    var editOp = jQuery("#editOp").val();
			 jQuery.ajax({
				 url: "",
				 data: {
					      op:loginOp,
				          uName:uName,
				          pWord: pWord
				 },
				 
				 success:function(data) {
						console.log("data",data);
						
						if(data=='true'){
							alert("login succesful");
							redirectPage(editOp);
						}
						else {
							alert("username or password is incorrect");
							clearData();
						}
				 },
				 error: function(data){
					 console.log("error", data);
					 
				 }
			 });
			});
			
			function clearData(){
				jQuery("#uName").empty();
				jQuery("#pWord").empty();				
			}
			
			function redirectPage(editPage)
			{
				window.location.href = editPage;
			}
			
		},
		
		myMethod: function() {
			alert("NewLogin.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(NewLogin.init()); // Run after page loads

