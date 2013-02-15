
var AddressInfo = function() {
	return {
		myVariable: null,

		init: function() {

			jQuery(document).ready(function(){
				//alert("address page is ready");

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
			jQuery(".btnUpdate").click(function() {
			//jQuery("[id=btnUpdate]").click(function() {
			//jQuery('#btnUpdate').live('click', function() {

				 var addressId = jQuery(this).parents('tr').find('.addressId').val();
				 var newAddressType = jQuery("option:selected", '.addressType').val();
				 var addressType = jQuery(this).parents('tr').find('.addressType option:selected').html();
				 var address =  jQuery(this).parents('tr').find('.addressLabel').html();
				 var updateOp = jQuery("#updateOp").val();
				 var personId = jQuery(this).parents('tr').find('.personId').val();
				//alert("Address ID is: " +addressId2 + addressType + " " + address);
				
				jQuery.ajax({
					url:"",
					data: {
						op: updateOp,
						addressId: addressId,
						addressType: addressType,
						address: address,
					},
				
				success: function(){
					alert("Update Successful");
					
				}
				
				
				});
			});
			
			
			jQuery(".btnDelete").click(function(){
				var personId = jQuery(".personId").val();
				var addressId = jQuery(this).parents('tr').find('.addressId').val();
				var removeOp = jQuery("#removeOp").val();
				var deleteConfirmed = confirm("Do you want to delete this record?");
				if (deleteConfirmed) {
					jQuery.ajax({
						url: "",
						data: {
						op: removeOp,
						addressId: addressId
						},
					success: function(data){
						alert("Address record was deleted ");
						var params = {personId:personId};
						ajaxZoneLoad_address(params);
					}
				});
				}
				
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
					},
				success: function(data){
					//AJAX ZONE CALL
					alert("new address has been inserted");
					var params = {personId: personId};
					ajaxZoneLoad_address(params);
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

jQuery(document).ready(function() {
	AddressInfo.init();
}); // Run after page loads