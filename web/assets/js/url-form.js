let urlForm = document.querySelector('.url-form');
let passwordCheckbox = urlForm.querySelector('#passwordProtected');
let passwordCheckboxLabel = urlForm.querySelector('label[for=passwordProtected]');
let passwordField = urlForm.querySelector('#password');

$(passwordCheckbox).click(function(e) {
    passwordCheckbox.checked ? passwordField.style.display = 'block' : passwordField.style.display = 'none';
});

