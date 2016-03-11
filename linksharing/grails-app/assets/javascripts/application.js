// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self
//=require bootstrap

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

function ajaxSuccess(result) {

	if (result) {
		var jsonResponseDiv = $(".jsonResponse");

		if (result.message) {

			jsonResponseDiv.text(result.message);
			jsonResponseDiv.addClass("alert alert-success");
		}
		else {
			jsonResponseDiv.text(result.error);
			jsonResponseDiv.addClass("alert alert-danger");
		}
		jsonResponseDiv.css({'display': 'block'})
	}
}

$(document).ready(function () {

    $(".subscription").click(function (e) {

        //console.log($(this).attr('topicId'));

        e.preventDefault();
        $.ajax({
            url: "/subscription/delete",
            data: {topicId: $(this).attr('topicId')},
            success: ajaxSuccess
        });
    });


    $(".seriousness").change(function (e) {
        //alert($(this).attr('id'));
        e.preventDefault();
        $.ajax({
            url: "/subscription/update",
            data: {id: $(this).attr('id'),serious:$(this).val()},
            success: ajaxSuccess
        });
    });

    $(".visibility").change(function (e) {
        //alert($(this).attr('id'));
        e.preventDefault();
        $.ajax({
            url: "/topic/save",
            data: {name: $(this).attr('id'),visibility:$(this).val()},
            success: ajaxSuccess
        });
    });
});