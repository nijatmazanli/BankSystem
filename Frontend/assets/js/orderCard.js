const basicButton = document.getElementById("basicButton");

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
        const message = await response.json();

        // Correctly compare the message
        if (message.message === "Token is invalid" || message.message === "Token has expired." || message.message === "Verification Failed") {
            window.location.href = '/login';
        }

    } catch (error) {
        console.error('Error during token validation:', error);
        // Optionally redirect to login in case of an error
        window.location.href = '/login';
    }
}

checkLogin();

basicButton.addEventListener("click", function (e) {
    e.preventDefault();
    console.log(basicButton);
    body = document.getElementById("body");
    console.log(body);
    body.innerHTML = "";

    divCont = document.createElement("div");
    divCont.className = "form-container";
    const form = document.createElement('form');
    form.id = 'credentialsForm';

    // Add form header
    const header = document.createElement('h3');
    header.classList.add('text-center', 'mb-4');
    header.innerText = 'Enter Your Credentials';
    form.appendChild(header);

    // Create Fin Code input field
    const finCodeDiv = document.createElement('div');
    finCodeDiv.classList.add('mb-3');
    const finCodeLabel = document.createElement('label');
    finCodeLabel.setAttribute('for', 'finCode');
    finCodeLabel.classList.add('form-label');
    finCodeLabel.innerText = 'Fin Code';
    const finCodeInput = document.createElement('input');
    finCodeInput.type = 'text';
    finCodeInput.classList.add('form-control');
    finCodeInput.id = 'finCode';
    finCodeInput.placeholder = 'Enter Fin Code';
    finCodeInput.maxLength = 12;
    finCodeDiv.appendChild(finCodeLabel);
    finCodeDiv.appendChild(finCodeInput);
    form.appendChild(finCodeDiv);

    // Create Password input field


    // Create Card Pin input field
    const cardPinDiv = document.createElement('div');
    cardPinDiv.classList.add('mb-3');
    const cardPinLabel = document.createElement('label');
    cardPinLabel.setAttribute('for', 'cardPin');
    cardPinLabel.classList.add('form-label');
    cardPinLabel.innerText = 'Card Pin';
    const cardPinInput = document.createElement('input');
    cardPinInput.type = 'password';
    cardPinInput.classList.add('form-control');
    cardPinInput.id = 'cardPin';
    cardPinInput.placeholder = 'Enter Card Pin';
    cardPinInput.minLength = 4;
    cardPinInput.maxLength = 4;
    cardPinDiv.appendChild(cardPinLabel);
    cardPinDiv.appendChild(cardPinInput);
    form.appendChild(cardPinDiv);

    // Create submit button
    const submitButtonDiv = document.createElement('div');
    submitButtonDiv.classList.add('d-grid', 'gap-2');
    const submitButton = document.createElement('button');
    submitButton.type = 'submit';
    submitButton.classList.add('btn', 'btn-outline-dark');
    submitButton.innerText = 'Submit';
    submitButton.id = 'submitButton';
    submitButtonDiv.appendChild(submitButton);
    form.appendChild(submitButtonDiv);
    divCont.appendChild(form)
    body.appendChild(divCont)
    submitButton.addEventListener("click", async function (e) {
        e.preventDefault();
        console.log(finCodeInput.value,cardPinInput.value);
        const response = await fetch(`http://localhost:3000/account/orderCard`, {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: {
                finCode: finCodeInput.value,
                pinCode: cardPinInput.value,
            }
        })
        console.log(response);
    })

})



