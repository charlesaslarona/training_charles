
var EditPage = function() {
	return {
		myVariable: null,

		init: function() {
			alert("EditPage.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".EditPage .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("EditPage.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(EditPage.init()); // Run after page loads