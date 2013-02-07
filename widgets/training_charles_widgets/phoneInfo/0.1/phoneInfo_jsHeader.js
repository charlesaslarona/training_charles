
var PhoneInfo = function() {
	return {
		myVariable: null,

		init: function() {
			//alert("PhoneInfo.init()");
			jQuery('.editable').live('click', function() {
				var _this = this;
				var labelvalue = jQuery.trim(jQuery(this).html());
				var tempinput = "<input type=\"text\" class=\"edittext\" value=\""+labelvalue+"\" />";
				if(jQuery(this).find(":text").length == 0) {
					jQuery(this).html(tempinput);
					jQuery(this).find(':text').focus().select();
					jQuery(this).find(':text').blur(function() {
						var newtext = jQuery(this).val();
						jQuery(_this).text(newtext);
					});
				}
			});			
			
			jQuery(".btnEditPhone").click(function(){
				 var phoneId = jQuery(this).parents('tr').find('.phoneId').val();
				 var newPhoneType = jQuery("option:selected", '.phoneType').val();
				 var phoneType = jQuery(this).parents('tr').find('.phoneType option:selected').html();
				 var phoneNumber =  jQuery(this).parents('tr').find('.phoneLabel').html();
				 var updateOp = jQuery("#editPhoneOp").val();
				 var personId = jQuery(this).parents('tr').find('.personId').val();
			
			jQuery.ajax({
				url:"",
				data: {
					op: updateOp,
					phoneId: phoneId,
					phoneType: phoneType,
					phoneNumber: phoneNumber
					
				},
				success: function(data){
					alert("Phone record is updated successfully!!!");
				}
			});
			
			
			});
			
			
			jQuery("#btnAddPhone").click(function(){
				var addOp = jQuery("#addPhoneOp").val();
				var personId = jQuery("#personId").val();
				var phoneType = jQuery("#phoneTypeAdd option:selected").val();
				var phoneNumber = jQuery("#phoneAdd").val();

				
				jQuery.ajax({
					url: "",
					data: {
						op: addOp,
						personId: personId,
						phoneType: phoneType,
						phoneNumber: phoneNumber
					},
					success: function(data){
						alert("New phone record is successfully added");
						//AJAX CALL
						var params = {personId: personId};
						ajaxZoneLoad_phone(params);
						//Add AJAX ZONE call
					}
				});
				
			});

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

jQuery(PhoneInfo.init()); // Run after page loads