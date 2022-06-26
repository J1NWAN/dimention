$().ready(function() {
    $(".close").on('click', function() {
        location.href = "/";
    });
});

function getUserSignUp() {
    location.href = "/user/signup";
}