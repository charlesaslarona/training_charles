
var PhoneInfo = function() {
	return {
		myVariable: null,

		init: function() {
			alert("PhoneInfo.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".PhoneInfo .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("PhoneInfo.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(PhoneInfo.init()); // Run after page loads