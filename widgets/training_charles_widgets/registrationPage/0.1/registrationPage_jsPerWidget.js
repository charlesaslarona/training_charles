
var RegistrationPage = function() {
	return {
		myVariable: null,

		init: function() {
			jQuery("#btnSubmit").click(function(){
				
				var saveOp = jQuery("#saveOp").val();
				var firstName = jQuery("#firstName").val();
				var lastName = jQuery("#lastName").val();
				var middleName = jQuery("#middleName").val();
				var userName = jQuery("#userName").val();
				var personId =  jQuery("#personId").val();
				jQuery.ajax({
					url:"",
					data:{
						op: saveOp,
						firstName: firstName,
						middleName: middleName,
						lastName: lastName,
						userName: userName,
						personId: personId
					},
					success:function(data){
						console.log("data",data);
						if (data == 'true'){
							alert("Person data successfully saved.");
						}
						else {
							alert("Username already exist!");
						}
						console.log("data",data);
						
					}
				});
				
			});
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