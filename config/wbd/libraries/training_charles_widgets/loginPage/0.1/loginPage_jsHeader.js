
var LoginPage = function() {
	return {
		myVariable: null,

		init: function() {
			//alert("LoginPage.init()");
			alert("page is loaded");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".LoginPage .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("LoginPage.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(LoginPage.init()); // Run after page loads