<html lang="en">
<head>

<title> Registeration </title>

<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta name="keywords" content=" Photography Application form Widget a Flat Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>

<!-- Meta tag Keywords -->
<link rel="stylesheet" href="CSS/registration.css" type="text/css" media="all" /><!-- Style-CSS -->
<link href="//fonts.googleapis.com/css?family=Josefin+Sans:300,400,600,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Josefin+Sans:300,400,600,700" rel="stylesheet">

   <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> 	
   
   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
 
  <link rel="stylesheet" type="text/css" media="screen" href="https://bootswatch.com/3/paper/bootstrap.min.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
      
        <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>

        
</head>
<body>


<script>

jQuery.fn.extend({
    createRepeater: function (options = {}) {
        var hasOption = function (optionKey) {
            return options.hasOwnProperty(optionKey);
        };
        var option = function (optionKey) {
            return options[optionKey];
        };
        var addItem = function (items, key, fresh = true) {
            var itemContent = items;
            var group = itemContent.data("group");
            var item = itemContent;
            var input = item.find('input,select');
            input.each(function (index, el) {
                var attrName = $(el).data('name');
                var skipName = $(el).data('skip-name');
                if (skipName != true) {
                    $(el).attr("name", group + "[" + key + "]" + attrName);
                } else {
                    if (attrName != 'undefined') {
                        $(el).attr("name", attrName);
                    }
                }
                if (fresh == true) {
                    $(el).attr('value', '');
                }
            })
            var itemClone = items;

            /* Handling remove btn */
            var removeButton = itemClone.find('.remove-btn');

            if (key>0) {
//                removeButton.attr('disabled', true);
//            } else {
                removeButton.attr('disabled', false);
            }

            removeButton.attr('onclick', '$(this).parents(\'.items\').remove()');

            $("<div class='items'>" + itemClone.html() + "<div/>").appendTo(repeater);
        };
        /* find elements */
        var repeater = this;
        var items = repeater.find(".items");
        var key = 0;
        var addButton = repeater.find('.repeater-add-btn');

        items.each(function (index, item) {
            items.remove();
            if (hasOption('showFirstItemToDefault') && option('showFirstItemToDefault') == true) {
                addItem($(item), key);
                key++;
            } else {
                if (items.length > 1) {
                    addItem($(item), key);
                    key++;
                }
            }
        });

        /* handle click and add items */
        addButton.on("click", function () {
            addItem($(items[0]), key);
            key++;
        });
    }
});

</script>

	<section class="agile-volt" style="overflow:hidden">
		<div class="agile-voltheader">
			<h1>Registration Form</h1>
		</div>
		<div class="agile-voltsub">
				<form action="updateInfo" method="post" enctype="multipart/form-data">
					
					<div class="agile-name">
						<p>First Name :</p>
						<input type="text" value =${FirstName} name="firstName" placeholder="Enter first name" required autofocus >
					</div>
					
					<div class="agile-name">
						<p>Last name :</p>
						<input type="text" value=${LastName} name="lastName" placeholder="Enter last name" required autofocus>
					</div>
					
					<div class="agile-name">
						<p>Username :</p>
						<input type="text" value=${username} name="userName" placeholder="Enter Username" required autofocus>
					</div>
					
					<div class="agile-email">
						<p>E-mail :</p>
						<input type="email" value=${email} name="email" placeholder="Enter your email id" required autofocus>
					</div>
					
					<div class="agile-email">
						<p>password :</p>
						<input type="password" value = ${password} name="password" placeholder="Enter password" required autofocus>
					</div>
					
					
					<div class="agile-email">
						<p>DOB :</p>
						<input type="text" value=${dob} name="date" id="date"  required autofocus>
						<p id="errorDate" hidden>Incorrect</p>
						<p id="validDate" hidden>correct</p>
						
					</div>
					
					<div class="agile-email">
						<p>Gender :</p>
						<p class="radio-inline"><input type="radio" name="gender" id="Female" value="Female">Female</p>
				 	    <p class="radio-inline"><input type="radio" name="gender" id="Male" value="Male">Male</p>			
						<p id="errorRadio" hidden>Incorrect</p>
						<p id="validRadio" hidden>correct</p>
					</div>
					<br>
					
					<div class="agile-name">
						<p>Contact number :</p>
						<input type="text" value=${contact} name="contact" placeholder="" required autofocus>
					</div>					
					
					
					<div class="agile-name">
						<p>Address :</p>					
											
						 <div class="container">
        					<div class="row">
            					<div class="col-sm-6">
                				<!-- Repeater Html Start -->
                					<div id="repeater">
                    				<!-- Repeater Heading -->
                    					<div class="repeater-heading">
                        					<button class="btn btn-primary pt-5 pull-right repeater-add-btn">
                            					Add
                        					</button>
                    					</div>
                 					
                    					<div class="clearfix"></div>
                    					<!-- Repeater Items -->
                    					<#list addresses as address>
                    						<div class="items" data-group="test">
                    						
                        					<!-- Repeater Content -->
                       							 <div class="item-content">
                                 
                            						<div class="form-group">
                                						<p>
                                							<label for="Address Line 1" class="control-label" >
                                								Address Line 1
                                							</label>
                                						</p>
                               			 				<input type="text"  value=${address.line1} class="form-control" placeholder="Address Line 1" data-name="line1" data-skip-name="true">     
                           							 </div>
                            
                            						<div class="form-group">
                               							<p> 
                               								<label for="Address Line 2" class="control-label">
                               									Address Line 2
                               								</label>
                               							</p>    
                               							<input type="text" value=${address.line2} class="form-control"  placeholder="Address Line 2" data-name="line2" data-skip-name="true">
                            						</div>
                            
                            						<div class="form-group">
                               							<p> 
                               								<label for="City" class="control-label">
                               									City
                               								</label>
                               							</p>    
                               							<input type="text" value=${address.city} class="form-control" placeholder="City" data-name="city" data-skip-name="true">
                            						</div>
                            
                            						<div class="form-group">
                               							<p> 
                               								<label for="State" class="control-label">
                               									State
                               								</label>
                               							</p>    
                               							<input type="text" value=${address.state} class="form-control"  placeholder="State" data-name="state" data-skip-name="true">
                            						</div>
                            
                            						<div class="form-group">
                               							<p> 
                               								<label for="Zipcode" class="control-label">
                               									Zipcode
                               								</label>
                               							</p>    
                               							<input type="text" class="form-control" value=${address.zipcode} placeholder="Zipcode" data-name="zipcode" data-skip-name="true">
                            						</div>
                            						
                        						</div>
                        						<!-- Repeater Remove Btn -->
                        						<div class="pull-right repeater-remove-btn">
                            						<button class="btn btn-danger remove-btn">
                                						Remove
                            						</button>
                        						</div>
                        						<div class="clearfix"></div>
                    						</div>
                    						</#list>
                						</div>
                					<!-- Repeater End -->
            						</div>
        						</div>
    						</div>
    						
    				<!-- Import repeater js  -->
   					 <script src="JAVASCRIPT/Address.js" type="text/javascript"></script>
    					<script>
        				/* Create Repeater */
       		 				$("#repeater").createRepeater({
            				showFirstItemToDefault: true,
        					});
    					</script>						
					</div>	
					
					<div class="clear"></div>
					
					
					
					<div class="agile-name">
						<p>Image :</p>					
											
						 <div class="container">
        					<div class="row">
            					<div class="col-sm-6">
                				<!-- Repeater Html Start -->
                					<div id="imgrepeater">
                    				<!-- Repeater Heading -->
                    					<div class="repeater-heading">
                        					<button class="btn btn-primary pt-5 pull-right repeater-add-btn">
                            					Add
                        					</button>
                    					</div>
                    					<div class="clearfix"></div>
                    					<!-- Repeater Items -->
                    						<#if img??>
                                <#list img as images>
                    						<div class="items" data-group="test">
                        					<!-- Repeater Content -->
                        					
                               		
                       							 <div class="item-content">
                                 
                            						<div class="form-group">
                                						<p>
                                							<label for="Display Image" class="control-label">
                                								Display Image
                                							</label>
                                						</p>
                           							 	<img src="data:image/jpg;base64,${images}" alt = "my image" style="height:10em; width:10em" data-skip-name="true">
                           							 </div>                            
                        						</div>
                        						<!-- Repeater Remove Btn -->
                        						<div class="pull-right repeater-remove-btn">
                            						<button class="btn btn-danger remove-btn">
                                						Remove
                            						</button>
                        						</div> 
    	                      
                        						<div class="clearfix"></div>
                        		
                    						</div>
                								  </#list>
    	                   </#if>
                								</div>
                					<!-- Repeater End -->
            						</div>
        						</div>
    						</div>
    						
    			<!-- 	Import repeater js  -->
   					 <script src="JAVASCRIPT/Address.js" type="text/javascript"></script>
    					<script>
        				/* Create Repeater */
       		 				$("#imgrepeater").createRepeater({
            				showFirstItemToDefault: true,
        					});
    					</script>						
					</div>	
					
					<div class="clear"></div>
					
					
					<div class="agile-work">
						<p>What type of categories do you work ?</p>
							<div class="agile-days">
								<span class="Monday">
									<input type="checkbox" name="agree" value="agree">I agree by <a href="#">terms and condition</a><br>	
								</span>
							</div>
					</div>
					
					<div class="agile-week">
						<p>Description :</p>
						<textarea></textarea>
					</div>
					<div class="clear"></div>
					<a href="clear"><input type="button" value="button"></a>
					<input type="submit" value="Update" />
				</form>
		</div>
	<div class="agile-copyright">
				<footer>&copy; 2018 Photography Application form. All Rights Reserved | Design by SHIVANI KANOJIA</footer>
			</div>
	</section> -->


	
<script>

		$( function() {
		    $( "#date" ).datepicker({
		    	format: 'mm-dd-yyyy'
		    }); 
		  } );

</script>
	
	
	
</body>
</html>
