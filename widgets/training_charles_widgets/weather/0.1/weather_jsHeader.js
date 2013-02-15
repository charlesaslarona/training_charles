
var Weather = function() {
	return {
		myVariable: null,

		init: function() {
			
		jQuery("#btnGo").click(function(){
			var locationOP = jQuery("#locationOP").val();
			var location = jQuery("#mLoc").val();
			alert(locationOP + " " + location);
			jQuery.ajax({
				url: "",
				data: {
					op: locationOP,
					location: location
				},
				contentType: "json",
			success: function(data){
				alert(data.city + " " + data.country + " " + data.temp + " " + data.dates);
				jQuery('.city').text(data.city + ", " + data.region);
				jQuery('.country').text(data.country);
				jQuery('#temp').text(data.temp);
				jQuery('#condition').text(data.text);
				jQuery('#date').text(data.date);
				jQuery('.mDate').text(data.date);
				//jQuery('#imgCondition').attr("src", data.img);
				jQuery("#imgTemp").attr("src", data.img);
				jQuery(".weatherIcon").attr("src", data.img);
				jQuery('.place').text(data.city + ", " + data.region);
				jQuery('.mCountry').text(data.country);
				jQuery(".img1").attr("src", data.icons[0]);
				jQuery(".img2").attr("src", data.icons[1]);
				jQuery(".img3").attr("src", data.icons[2]);
				jQuery(".img4").attr("src", data.icons[3]);
				jQuery(".img5").attr("src", data.icons[4]);		
				jQuery(".temp1").text(data.temps[0]);
				jQuery(".temp2").text(data.temps[1]);
				jQuery(".temp3").text(data.temps[2]);
				jQuery(".temp4").text(data.temps[3]);
				jQuery(".temp5").text(data.temps[4]);
				jQuery(".date1").text(data.dates[0]);
				jQuery(".date2").text(data.dates[1]);
				jQuery(".date3").text(data.dates[2]);
				jQuery(".date4").text(data.dates[3]);
				jQuery(".date5").text(data.dates[4]);

				/*$("#my_image").attr("src","second.jpg");*/
			}
			});
		});

		},
		
		myMethod: function() {
			alert("Weather.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(Weather.init()); // Run after page loads