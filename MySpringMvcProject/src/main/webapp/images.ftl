
<#import "header.ftl" as h/>
<#import "footer.ftl" as f/>

<@h.page></@h.page>
<!doctype html>
<html class="no-js" lang="en">
<head>

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
                    <div class="col-md-9 col-md-9 col-sm-9 col-xs-12">
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
                            
                            <#if img??>
                                <#list img as images>
                               		<img src="${images}" alt = "my image" style="height:10em; width:10em"> 
    	                        </#list>
    	                   </#if>
                            
                      
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
