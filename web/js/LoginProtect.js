$.post(
    "GetLoginStatus"
).done((data, status) => {
    if (data === "null") {
        window.location.href = "login.html";
    }
});

const getCurrentUser = async () => {
    var user;
    await $.post(
        "GetLoginStatus"
    ).done((data, status) => {
        user = data;
    });

    return new Promise((res, rej)=>{
        res(JSON.parse(user));
    })
}

