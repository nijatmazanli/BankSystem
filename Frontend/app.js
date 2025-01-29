const express = require('express');
const app = express();
const path = require('path');
const jwt = require('jsonwebtoken');
const axios = require('axios');

const port = 3000;

const ejs = require('ejs');
const err = require("jsonwebtoken/lib/JsonWebTokenError");

app.set('view engine', 'ejs');
app.use('/assets', express.static(path.join(__dirname, 'assets')));
app.use(express.static('/views/'));
app.use(express.json())


// Secret key for signing the token
const secretKey = 'SecretKey)';

// Data to be included in the token
const payload = {
    userId: 12345,
    username: 'yourUsername'
};

// Options for the token
const options = {
    expiresIn: '1h' // Token expiration time
};

// Function to create a JWT token
function createToken(payload, secretKey, options) {
    try {
        const token = jwt.sign(payload, secretKey, options);
        console.log('Generated Token:', token);
        return token;
    } catch (error) {
        console.error('Error generating token:', error);
        return null;
    }
}


// Call the function to create a token


app.get("/", (req, res) => {
    res.render('main/index');
    console.log("Dsdsd");
});
app.get("/features", async (req, res) => {
    try {
        // const item = req.body.item || {};
        // Forward the request to the Spring Boot backend
        const response = await axios.post('http://localhost:8080/api/features/onlineBank', {
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const responseCashBack = await axios.post('http://localhost:8080/api/features/cashBackCard', {
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const responseCreditCard = await axios.post('http://localhost:8080/api/features/creditcard', {
            headers: {
                'Content-Type': 'application/json'
            }
        });

        res.render("features/index", {
            names: response.data.names,
            desc: response.data.description,
            cashbackname: responseCashBack.data.names,
            cashbackdescription: responseCashBack.data.description,
            creditcardname: responseCreditCard.data.names,
            creditcarddesc: responseCreditCard.data.description
        }) // Send the response data to the frontend
        console.log(response.data.names, response.data.description);
    } catch (error) {
        console.error(error);
        res.status(500).send('Internal Server Error');
    }

    console.log("Dsdsd");
});
app.get("/pricing", (req, res) => {
    res.render('pricing/index');
})
app.get("/register", async (req, res) => {
    res.render('register/index');
})
app.post("/register", async (req, res) => {
    try {
        // const item = req.body.item || {};
        // Forward the request to the Spring Boot backend
        const response = await axios.post('http://localhost:8080/api/user/register', req.body);

        console.log(response.data);
        res.status(200).json(response.data);
    } catch (error) {
        console.error(error);
        res.status(500).send('Internal Server Error');
    }
    console.log("Dsdsd");

})
app.get("/login", (req, res) => {
    res.render('login/index');
})
app.post("/login", async (req, res) => {
    try {
        // const item = req.body.item || {};
        // Forward the request to the Spring Boot backend
        const response = await axios.post('http://localhost:8080/api/user/login', req.body);

        const payload = {
            email:response.data.email,
            username: response.data.name,
        };

// Options for the token
        const options = {
            expiresIn: '1h' // Token expiration time
        };

        const token = createToken(payload, secretKey, options);

        console.log(token);


        const data = {
            name: response.data.name,
            email: response.data.email,
            password: response.data.password,
            surname: response.data.surname,
            fin_code: response.data.fin_code,
            birthDate: response.data.birthDate,
            token: token
        }
        if (typeof response.data === 'object') {
            console.log(response.data, typeof response.data);

            res.status(200).json(data);
        } else {
            res.status(200).json({message: 'Login failed'});
        }

    } catch (error) {
        console.error(error);
        res.status(500).send('Internal Server Error');
    }
    console.log("Dsdsd");

})
app.post("/validateToken", async (req, res) => {
    try {
        console.log(req.body);
        try {
            if (req.body.token != null) {
                const verifyToken = jwt.verify(req.body.token, secretKey);
                console.log(verifyToken);

                // Ensure that verifyToken has username and email properties before checking
                if (verifyToken.username === req.body.name && verifyToken.email === req.body.email) {
                    res.status(200).json({message: 'Verification Successfully'});

                    // Make sure the axios call is awaited properly
                    const response = await axios.post('http://localhost:8080/api/user/login/addToken', req.body);
                    // You might want to handle the response here if needed

                } else if (!(req.body.name && req.body.email)) {
                    res.status(200).json({message: "Token is valid"});
                    console.log("dsdsdsdssdadasda");
                } else {
                    res.status(401).json({message: 'Verification Failed'});  // Unauthorized
                }
            }
            else{
                res.status(401).json({message: 'Verification Failed'});
            }
        } catch (error) {
            if (error.name === "TokenExpiredError") {
                console.log("Token has expired.");
                res.status(408).json({message: 'Token has expired.'});  // Use 408 for token expiration
            } else {
                console.log("Token is invalid", error.message);
                res.status(401).json({message: 'Token is invalid.'});  // Unauthorized
            }
        }
    } catch (error) {
        console.error(error);
        res.status(500).send('Internal Server Error');  // Internal Server Error for any other issues
    }
})
app.get("/account/dashboard", (req, res) => {
    res.render('account/dashboard');
})
app.get("/account/orderCard", (req, res) => {
    res.render('account/orderCard/index');
})
app.post("/account/orderCard", async (req, res) => {
    try {
        // const item = req.body.item || {};
        // Forward the request to the Spring Boot backend
        console.log(req.body);
        const response = await axios.post('http://localhost:8080/api/user/addAccount', req.body);

        console.log(response.data);
    }
    catch (err){
        console.error(err);
    }
})



app.listen(port, () => {
    console.log(`Server is running on port ${port}`);

})