
var PersonList = function() {
	return {
		myVariable: null,

		init: function() {
			alert("PersonList.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".PersonList .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("PersonList.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(PersonList.init()); // Run after page loads