
(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');
    
    /*Validate on Submit time*/
    $('.validate-form').on('submit',function(){
        var check = true;
/*validation for email field */
        if(validate(input[0]) == false){
            showValidate(input[0]);
            check=false;
        }
        /*validation for password field*/
        if(validate(input[1]) == false){
            showValidate(input[1]);
            check=false;
        }
        // for(var i=0; i<input.length; i++) {
        //     if(validate(input[i]) == false){
        //         showValidate(input[i]);
        //         check=false;
        //     }
        // }

        return check;
    });

/*hide validation message at focus*/
    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

/*validate function defination*/
    function validate (input) {
	/*select email field*/
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
	/*check email format*/
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
	/*check password is empty or not*/
            if($(input).val().trim() == ''){
                $("#pass").attr('data-validate', "Password can't be Empty");
                return false;
            }
            /*check password format*/
            else if($(input).val().trim().match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/) == null){
                $("#pass").attr('data-validate', "Password must contain Minimum eight characters, at least one letter, one number and one special character");
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }

})(jQuery);