
var SessionHandler = function() {
	return {
		myVariable: null,

		init: function() {
		  jQuery("#btnLogOut").click(function(){
			  var sessionOp = jQuery("#sessionOp").val();
			  var loginNavPoint = jQuery("#loginNavPoint").val();
			  jQuery.ajax({
				  url: "",
			    data: {
				op: sessionOp
			  }
		  });
			  alert(loginNavPoint);
//        jQuery(document).ready(function(){
        	//navigate to request handler
//        	var sessionOp = jQuery("#sessionOp").val();
//        	var loginOp = jQuery("#loginNavPoint").val();
//        	alert(sessionOp + " " + loginOp);
//        	jQuery.ajax({
//        		url: "",
//        		data: {
//        			op:sessionOp,
//        			loginOp: loginOp
//        		},
//        		success:function(data){
//        		}
//        	});
        });

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".SessionHandler .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("SessionHandler.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(SessionHandler.init()); // Run after page loads