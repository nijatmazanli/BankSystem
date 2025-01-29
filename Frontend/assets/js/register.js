const form = document.querySelector('form');
const nameInput = document.querySelector('#name');
const surnameInput = document.querySelector('#surname');
const emailInput = document.querySelector('#email');
const passwordInput = document.querySelector('#password');
const confirmPasswordInput = document.querySelector('#confirmPassword');
const finCode = document.querySelector('#finCode');
const phoneInput = document.querySelector('#phone');
const birthdayInput = document.querySelector('#birdthday');

async function getResponse(data) {
    const response = await fetch(`http://localhost:3000/register`, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    message = await response.json();
    if (message === "User created.") {
        console.log(message)
        await alert(message + "You will be redirected to login");
        window.location.href = "/login";


    }
}

form.addEventListener('submit', (e) => {
    e.preventDefault();
    if (passwordInput.value === confirmPasswordInput.value) {
        date = new Date();
        birthdayInputDate = new Date(birthdayInput.value);
        console.log(typeof birthdayInputDate, birthdayInputDate, date);
        data = {
            name: nameInput.value,
            surname: surnameInput.value,
            email: emailInput.value,
            password: passwordInput.value,
            fin_code: finCode.value,
            phoneNumber: phoneInput.value,
            birthDate: birthdayInputDate,
            registerDate: date
        }
        console.log(data)
        getResponse(data);
    } else {
        alert("Password not match");
    }
})