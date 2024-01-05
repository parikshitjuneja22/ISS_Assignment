document.getElementById('form').onsubmit = function(event) {
    var name = document.getElementById('username').value;
    var email = document.getElementById('email').value;

    if(name === '' || email === '') {
        alert('Name and email are required!');
        event.preventDefault();
    }
}