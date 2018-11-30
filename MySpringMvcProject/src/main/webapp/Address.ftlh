<DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



   <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Repeater</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="https://bootswatch.com/3/paper/bootstrap.min.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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




 <div class="container">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <!-- Repeater Html Start -->
                <div id="repeater">
                    <!-- Repeater Heading -->
                    <div class="repeater-heading">
                        <h5 class="pull-left">Repeater</h5>
                        <button class="btn btn-primary pt-5 pull-right repeater-add-btn">
                            Add
                        </button>
                    </div>
                    <div class="clearfix"></div>
                    <!-- Repeater Items -->
                    <div class="items" data-group="test">
                        <!-- Repeater Content -->
                        <div class="item-content">
                            <div class="form-group">
                                <label for="inputEmail" class="col-lg-2 control-label">Name</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputName" placeholder="Name" data-name="name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputEmail" placeholder="Email" data-skip-name="true" data-name="email">
                                </div>
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
                </div>
                <!-- Repeater End -->
            </div>
        </div>
    </div>
    <!-- Import repeater js  -->
    <!-- <script src="JAVASCRIPT/Address.js" type="text/javascript"></script> -->
    <script>
        /* Create Repeater */
        $("#repeater").createRepeater({
            showFirstItemToDefault: true,
        });
    </script>
    
    
    
    


</body>
</html>