let valid = {
    username: {
        state: false,
        msg: ""
    },
    password: {
        state: false,
        msg: ""
    }
}

$("#username").focusout(() => {
    usernameSameCheck();
});

$("#password").focusout(() => {
    passwordSameCheck();
});

$("#same-password").focusout(() => {
    passwordSameCheck();
});

function validation() {
    if (valid.username.state && valid.password.state) {
        return true;
    } else {
        let errorMsgs = ``;

        errorMsgs += `${valid.username.msg}<br/>`;
        errorMsgs += `${valid.password.msg}<br/>`;

        $(".my_error_box").html(errorMsgs);
        $(".my_error_box").removeClass("my_hidden");
        return false;
    }
}
