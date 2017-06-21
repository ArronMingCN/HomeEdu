var password_ok=false;
var  CardId_ok=false;
var  Tele_ok=false;

$('.label').click(function(){
  if($(this).text()=="Login")
  	$(this).text("Register");
  else
  	$(this).text("Login");
  $(this).toggleClass ("labelTopLeft");
  $('.form').animate({
    height: "toggle", 	
    opacity: "toggle"
  }, "slow");
});


$('#passwordagain').blur(function(){
	if($(this).val()!=$('#password').val())
	{
		$(this).css("border",'1px solid red');
		$('#password').css("border",'1px solid red');
		password_ok=false;
	}
	else
	{
		$(this).css('border','1px solid #c8c8c8');
		$('#password').css('border','1px solid #c8c8c8');
		password_ok=true;
	}
});

$('#Tele').blur(function(){
	var Tele=/^1\d{10}$/;
	if(!Tele.test($(this).val()))
	{
		$(this).css('border','1px solid red');
		Tele_ok=false;
	}
	else
	{
		$(this).css('border','1px solid #c8c8c8');
		Tele_ok=true;
	}
});


$('#RegisterSubmit').click(function(){
                    if(password_ok&&Tele_ok&& ($('#username').val()!="") &&($('#password').val()!="")&&($('#passwordagain').val()!="")) {
                    	
                        $('form').submit();
                    }
                    else{
                        return false;
                    }
                });

