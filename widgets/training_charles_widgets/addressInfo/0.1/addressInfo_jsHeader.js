
var AddressInfo = function() {
	return {
		myVariable: null,

		init: function() {

			jQuery(document).ready(function(){
				alert("address page is ready");

			});

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
			
			jQuery('#btnUpdate').live('click', function() {
				var updateOp = jQuery("#updateOp").val();
				var address = jQuery("#address").val();
				var addressType = jQuery("#addressType option:selected").html();
                var action = jQuery(".button-action").val();
				
				alert(updateOp);
				alert(addressType);
				alert(address);
				
				jQuery.ajax({
					url:"",
					data: {
						op: updateOp,
						addressType: addressType,
						address: address,
						action: action
					}
				
				
				});
			});
			
			
			jQuery('#btnAdd').click(function(){
				var personId = jQuery("#personId").val();
				var addressAdd = jQuery("#addressAdd").val();
				var addressTypeAdd = jQuery("#addressTypeAdd option:selected").val();
				var addOp = jQuery("#addOp").val();
				
				
				
				jQuery.ajax ({
					url: "",
					data: {
						op: addOp,
						personId: personId,
						addressTypeAdd: addressTypeAdd,
						addressAdd: addressAdd
					}
				});
			});

		},
		
		myMethod: function() {
			alert("AddressInfo.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(AddressInfo.init()); // Run after page loads