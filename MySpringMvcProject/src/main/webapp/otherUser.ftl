

<#import "header.ftl" as h/>
<#import "footer.ftl" as f/>

<@h.page></@h.page>
<!doctype html>
<html class="no-js" lang="en">
<head>


<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
	
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        
    <!-- Start Welcome area -->
    <div class="all-content-wrapper">
       
        <div class="mailbox-area mg-tb-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12 col-md-12 col-sm-12col-xs-12">
                        <div class="hpanel mg-b-15">
                            <div class="panel-heading hbuilt mailbox-hd">
                                <div class="text-center p-xs font-normal">
                                    <div class="input-group"> 
                                        <span class="input-group-btn"> 
                                            <button type="button" class="btn btn-sm btn-default">Edit</button> 
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-body">
                                
                                <div class="container">

       <h2 style="text-align: center; margin-top: 2em">
        <b>Residential Details</b>
        </h2>
	<table id="example" class="display" text-align:center">
        <thead>
            <tr class="row">
                <th class="col-sm-2">Sr</th>
                <th class="col-sm-2">Name</th>
                <th class="col-sm-2">Email</th>
                <th class="col-sm-2">Contact</th>
                <th class="col-sm-2">Action</th>
                <th class="col-sm-2">Show</th>
              
            </tr>
        </thead>
         <#list UserDetails as details>
    		<tr class="row">

    			<td class="col-sm-2">${details?index}</td>
        		<td class="col-sm-2">${details.firstName}${" "}${details.lastName}</td>
        		<td class="col-sm-2">${details.email}</td> 
        		<td class="col-sm-2">${details.contact}</td>
        		<td class="col-sm-2"><a href="delete?userid=${details.userId}"><button value="Delete">Delete</button></a></td> 
        		<td class="col-sm-2"><a href="show?userid=${details.userId}"><button value="Delete">Details</button></a></td>
    		
    		</tr>
    	</#list>
        </tbody>
        <tfoot>
            <tr class="row">
                 <th class="col-sm-2">Sr</th>
                <th class="col-sm-2">Name</th>
                <th class="col-sm-2">Email</th>
                <th class="col-sm-2">Contact</th>
                <th class="col-sm-2">Action</th>
               <th class="col-sm-2">Show</th>
            </tr>
        </tfoot>
    </table>
    </div>
	<script>
	$(document).ready(function() {
    $('#example').DataTable( {
        "language": {
            "lengthMenu": "Display _MENU_ records per page",
            "zeroRecords": "Nothing found - sorry",
            "info": "Showing page _PAGE_ of _PAGES_",
            "infoEmpty": "No records available",
            "infoFiltered": "(filtered from _MAX_ total records)"
        }
    } );
} );
	</script>
                                
                                
                                
                                
                            </div>
                            <div class="panel-footer">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
        </div>
    </div>
</body>

</html>

<@f.page></@f.page>
