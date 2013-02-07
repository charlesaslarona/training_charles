
var EditPage = function() {
	return {
		myVariable: null,

		init: function() {
           jQuery("#btnEdit").click(function (){
        	   var saveOp = jQuery("#saveOp").val();
        	   var personId = jQuery("#personId").val();
        	   var userName = jQuery("#userName").val();
        	   var firstName = jQuery("#firstName").val();
        	   var middleName = jQuery("#middleName").val();
        	   var lastName = jQuery("#lastName").val();
        	   var email = jQuery("#email").val();
        	   
        	   jQuery.ajax({
        		   url:"",
        		   data: {
        			   op: saveOp,
        			   personId: personId,
        			   userName: userName,
        			   firstName: firstName,
        			   lastName: lastName,
        			   middleName: middleName,
        			   email: email
        			    },
        			    
				success:function(data){
					alert("Update successful!!");
					console.log("data",data);
					
				}
        	   });
        	  
           });
           
           var params = {personId: jQuery("#personId").val()};
			ajaxZoneLoad_address(params);
			ajaxZoneLoad_phone(params);
           
		},
		
		myMethod: function() {
			alert("EditPage.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(EditPage.init()); // Run after page loads