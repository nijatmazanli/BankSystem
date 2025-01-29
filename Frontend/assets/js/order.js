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
