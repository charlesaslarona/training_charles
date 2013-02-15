
var SessionHandler = function() {
	return {
		myVariable: null,

		init: function() {
			alert("SessionHandler.init()");

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

//jQuery(SessionHandler.init()); // Run after page loads