
var RegistrationPage_[[widgetId]] = function() {
	return {
		myVariable: null,

		init: function() {
			alert("RegistrationPage_[[widgetId]].init");
			
//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".RegistrationPage .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("RegistrationPage.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(RegistrationPage_[[widgetId]].init()); // Run after page loads