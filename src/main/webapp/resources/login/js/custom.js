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
    var messge = $("input#response").val();
    if(messge == null || messge == ""){

    }
    else{
		if(messge === 'success'){
			Toast.fire({
            icon: 'success',
            title: 'User Sucessfully Registered'
     		})
		}
		else{
			Toast.fire({
            icon: 'error',
            title: messge
     	 	})
		}
    }
     $("#response").val("");
});