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
	let response = $("input#response").val();
	if(response != ""){
		if(response == "Fail"){
	        Toast.fire({
				icon: 'error',
				title: 'Email Is Not Send'
			})
    	}
    	else{
			Toast.fire({
				icon: 'error',
				title: response
			})
		}
		$("input#response").val("");
	}
});