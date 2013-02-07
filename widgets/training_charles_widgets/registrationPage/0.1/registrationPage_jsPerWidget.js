
var RegistrationPage = function() {
	return {
		myVariable: null,

		init: function() {


			
			
			
			jQuery("#btnSubmit").click(function(){
				//jQuery("#regForm").submit();

				validateLogin();
				});
			
			function validateLogin() {
				   if (document.getElementById("firstName").value === "" ||
						document.getElementById("lastName").value === "" ||
						document.getElementById("middleName").value === "" ||
						document.getElementById("email").value === "" ||
						document.getElementById("passWord").value === "" ||
						document.getElementById("userName").value === "" ||
						document.getElementById("cPassWord").value === "")
				{	   
					   alert("All Fields Are Required");
				}
				   else {
				 		if (document.getElementById("passWord").value != document.getElementById("cPassWord").value) {
				 			alert("Password must match the confirm password");
				 		}
				 		else {
				 			process();
				 		}
				   }
			};
				function process(){
					var saveOp = jQuery("#saveOp").val();
					var firstName = jQuery("#firstName").val();
					var lastName = jQuery("#lastName").val();
					var middleName = jQuery("#middleName").val();
					var userName = jQuery("#userName").val();
					var email = jQuery("#email").val();
					var passWord = jQuery("#passWord").val();
					var editPage =  jQuery("#editOp").val();
					var cPass = jQuery("#cPassWord").val();
				jQuery.ajax({
					url:"",
					data:{
						op: saveOp,
						firstName: firstName,
						middleName: middleName,
						lastName: lastName,
						userName: userName,
						email: email,
						passWord: passWord
					},
					success:function(data){
						console.log("data",data);
						alert("User successfully created!!");
						redirectPage(editPage);
						//if (data == 'true'){
						//	alert("Person data successfully saved.");
						//}
						//else {
						//	alert("Username already exist!");
					//	}
						console.log("data",data);
						
					}

				
			});
				};
			function redirectPage(editPage)
			{
				window.location.href = editPage;
			}
//				...
//			});
		},
		
		myMethod: function() {
			alert("RegistrationPage.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(RegistrationPage.init()); // Run after page loads