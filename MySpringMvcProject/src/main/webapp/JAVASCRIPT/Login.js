function ClearFields() {
	    document.getElementById('textfield').value ="";
	}

function Show() {
    var p = document.getElementById('pwd');
    p.setAttribute('type', 'text');
}

function hide() {
    var p = document.getElementById('pwd');
    p.setAttribute('type', 'password');
}

var pwShown = 0;

//document.getElementById("show").addEventListener("click", function () {
//    if (pwShown == 0) {
//        pwShown = 1;
//        Show();
//    } else {
//        pwShown = 0;
//        hide();
//    }
//}, false);

    $(".pwd-btn").click(function() {
	    var $pwd = $(".pwd");
	    if ($pwd.attr('type') === 'password') {
	        $pwd.attr('type', 'text');
	    } else {		
	        $pwd.attr('type', 'password');
	    }
	});
	(function() {'use strict';
  	window.addEventListener('load', function() {
    var forms = document.getElementsByClassName('needs-validation');
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();