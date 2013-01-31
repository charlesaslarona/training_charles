
var NewLogin_[[widgetId]] = function() {
	return {
		myVariable: null,

		init: function() {
			alert("NewLogin_[[widgetId]].init");
			
//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".NewLogin .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("NewLogin.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(NewLogin_[[widgetId]].init()); // Run after page loads