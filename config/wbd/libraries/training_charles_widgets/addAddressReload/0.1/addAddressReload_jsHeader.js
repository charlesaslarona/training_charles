
var AddAddressReload = function() {
	return {
		myVariable: null,

		init: function() {
			alert("AddAddressReload.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".AddAddressReload .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("AddAddressReload.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(AddAddressReload.init()); // Run after page loads