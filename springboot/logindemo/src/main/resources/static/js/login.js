function login(formId){
    console.log("load login function");
    const form = document.getElementById(formId);
    form.submit();
}

window.onload = function () {
    console.log("on load")
}