
var LoginPage_[[widgetId]] = function() {
	return {
		myVariable: null,

		init: function() {
			alert("LoginPage_[[widgetId]].init");
			
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

//jQuery(LoginPage_[[widgetId]].init()); // Run after page loads