
var Weather = function() {
	return {
		myVariable: null,

		init: function() {
			alert("Weather.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".Weather .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("Weather.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(Weather.init()); // Run after page loads