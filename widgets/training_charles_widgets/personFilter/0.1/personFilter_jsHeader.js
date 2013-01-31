
var PersonFilter = function() {
	return {
		myVariable: null,

		init: function() {
			jQuery("#txt-filter").keyup(function(){
				
				//call AJAX zone
				
				var params = {
					filter:jQuery("#txt-filter").val()
				};
				
				ajaxZoneLoad_person(params);
				
			});

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".PersonFilter .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("PersonFilter.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(PersonFilter.init()); // Run after page loads