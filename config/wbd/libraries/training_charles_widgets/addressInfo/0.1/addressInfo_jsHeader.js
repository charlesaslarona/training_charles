
var AddressInfo = function() {
	return {
		myVariable: null,

		init: function() {
			alert("AddressInfo.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".AddressInfo .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("AddressInfo.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(AddressInfo.init()); // Run after page loads