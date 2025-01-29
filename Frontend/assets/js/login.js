const form = document.querySelector('form');
const passwordInput = document.querySelector('#password');
const finCode = document.querySelector('#finCode');
async function checkLogin() {
    const token = localStorage.getItem('token');
    const name = localStorage.getItem('name');
    const email = localStorage.getItem('email');

    const data = {
        token: token,
        username: name,
        email: email
    };

    try {
        const response = await fetch(`http://localhost:3000/validateToken`, {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(data)
        });

        // Await the response to get the JSON data
        const status = await response.status;
        const message = await response.json();

        // Correctly compare the message
        if (status === 401 || message.message === "Token is invalid" || message.message === "Token has expired.") {
            alert("Login Again");
        }
        else{
            alert("You already logged in!");
        }

    } catch (error) {
        console.error('Error during token validation:', error);
    }
}

async function getResponse(data) {
    const response = await fetch(`http://localhost:3000/login`, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    let message;
    message = await response.json();
    if (message.message === "Login failed") {
        alert(message.message);
    } else {

        localStorage.setItem('name', message.name);
        localStorage.setItem('email', message.email);
        localStorage.setItem('password', message.password);
        localStorage.setItem('surname', message.surname);
        localStorage.setItem('fin_code', message.fin_code);
        localStorage.setItem('birthDate', message.birthDate);
        localStorage.setItem('token', message.token);
        console.log("Login Success");
    }
    const responseToken = await fetch(`http://localhost:3000/validateToken`, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            token: localStorage.getItem('token'),
            type: "JWT",
            fin_code: localStorage.getItem('fin_code'),
            created_at_in_front: new Date(),
            name:localStorage.getItem('name'),
            email: localStorage.getItem('email')
        }),
    })
    message = await responseToken.json();
    if (message.message === "Verification Successfully") {
        window.location.href = "/account/dashboard";

    }

}
checkLogin()
form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const submitButton = e.target.querySelector('input[type="submit"]');
    submitButton.disabled = true;

    let data = {
        password: passwordInput.value,
        fin_code: finCode.value,
        loginDate: new Date()
    };

    await getResponse(data);
    submitButton.disabled = false; // Re-enable after response
});
