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
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
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
        e.preventDefault();
        $.ajax({
            url: "/subscription/delete",
            data: {topicId: $(this).attr('topicId')},
            success: ajaxSuccess
        });
    });

    $(".subscribe").click(function (e) {
        e.preventDefault();
        $.ajax({
            url: "/subscription/save",
            data: {id: $(this).attr('id')},
            success: ajaxSuccess
        });
    });


    $(".seriousness").change(function (e) {
        //alert($(this).attr('id'));
        e.preventDefault();
        $.ajax({
            url: "/subscription/update",
            data: {id: $(this).attr('id'), serious: $(this).val()},
            success: ajaxSuccess
        });
    });

    $(".visibility").change(function (e) {
        //alert($(this).attr('id'));
        e.preventDefault();
        $.ajax({
            url: "/topic/saving",
            data: {topicId: $(this).attr('id'), visibility: $(this).val()},
            success: ajaxSuccess
        });
    });

    $("#clearSearchPostBox").click(function () {
        $("#searchPostBox").val("")
    });

    $("#findSearchPostBox").click(function () {
        topicId = $(this).attr('topicId');
        //alert("yes")
        $.ajax({
            url: "/resource/search",
            type: 'html',
            method: 'post',
            data: {q: $('#searchPostBox').val(), topicId: topicId},
            success: function (result) {
                alert(result);
                $("#topicPosts").html(result)
            }
        });
    });
    $(function () {
        $('#registrationForm').validate({
            rules: {
                'firstName': {
                    required: true
                },
                'lastName': {
                    required: true
                },
                'password': {
                    required: true,
                    minlength: 5
                },
                'confirmPassword': {
                    required: true,
                    confirm: true,
                    equalTo: "#password"
                },
                'username': {
                    required: true,
                    remote: {
                        url: "/login/validateUserName",
                        type: "post"
                        //required:true
                    }
                },
                'email': {
                    required: true,
                    email: true,
                    remote: {
                        url: "/login/validateEmail",
                        type: "post"
                        //required:true
                    }
                }
            },
            messages: {
                'firstName': {
                    required: "First name can't be blank"
                },
                'lastName': {
                    required: "Last name can't be blank"
                },
                'password': {
                    required: "Password can't be blank",
                    minlength: "Password should be at least 5 character long"
                },
                'confirmPassword': {
                    required: "Confirm password can't be blank"
                    //equalTo:"This should be same as password"
                },
                'email': {
                    required: "Email address can't be blank",
                    remote: "Email address entered is already used"
                },
                'username': {
                    required: "User name can't be blank",
                    remote: "User name entered already exist"
                }
            }
        });
    });


    $(".edit-topic").on('click', function (e) {
        e.preventDefault();
        var topicId = $(this).attr('data-topic-id');
        //alert(topicId)
        $("#editForm" + topicId).css({'display': 'block'});
    });

    $(".cancelTopicNameButton").on('click', function (e) {
        e.preventDefault();
        var topicId = $(".edit-topic").attr('data-topic-id');
        //alert(topicId)
        $("#editForm" + topicId).css({'display': 'none'});
    });

    $(".saveTopicNameButton").on('click', function (e) {
        e.preventDefault();
        //var topicId = $("this")
        var topicId = $(this).attr('topicId');
        $.ajax({
            url: "/topic/titleUpdate",
            data: {topicId: topicId, name: $("#name" + topicId).val()},
            success: ajaxSuccess
        });
    });

    $(".markReadingItem").on('click', function (e) {
        e.preventDefault();
        var isRead = $(this).attr('isRead');
        var resourceId = $(this).attr('resourceId');
        $.ajax({
            url: "/readingItem/changeIsRead",
            data: {isRead: isRead, resourceId: resourceId},
            success: ajaxSuccess
        });
    });

});