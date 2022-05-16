$(document).ready(function(){
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

	var message = $("input#response").val();
	if(message == null || message == ""){

	}
	else if(message == 'error'){
		Toast.fire({
			icon: 'error',
			title: 'Oops,Something Wrong!!'
	  })
	}
	else if(message == 'updated'){
		Toast.fire({
			icon: 'success',
			title: 'User Upadted'
	  })
	}
	else{
		Toast.fire({
			icon: 'success',
			title: 'User Added'
	  })
	}  
	$("#response").val('');
});