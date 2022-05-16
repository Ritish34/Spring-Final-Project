$(document).ready(function() {
	const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        didOpen: (toast) => {
          toast.addEventListener('mouseenter', Swal.stopTimer)
          toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
      });
    let userid = $("#userid").val();
	$.ajax({
			type: "post",
			url: "GetOneUserData",
			data : { "UserId": userid },
			datatype: "json",
			success: function(r) {
				$("h6#fname").html(r.data[0].first_name);
				$("h6#lname").html(r.data[0].last_name);
				$("h6#email").html(r.data[0].email);
				$("h6#phone").html(r.data[0].phone);
				$("h6#dob").html(r.data[0].date);
				$("h6#lang").html(r.data[0].checkbox);
				$("h6#gender").html(r.data[0].gender);
				$("img#image").attr("src","data:image/jpg;base64,"+r.data[0].base64Image);
				
				Toast.fire({
		  				icon: 'success',
		  				title: 'User Data Fetched SuccessFully'
				})
			},
			error: function(textStatus) {
				Toast.fire({
					icon: 'error',
					title: 'Oops,Something Wrong!!'
	  			})
			},
	});	
});

