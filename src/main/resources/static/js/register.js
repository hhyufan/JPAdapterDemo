// // register.js
// const validatePassword = (password) => {
//
//     const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@!%*#?&])[A-Za-z\d$@!%*#?&']{8,24}$/;
//     return passwordRegex.test(password);
// }

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('registerForm').addEventListener('submit', async (event) => {
        event.preventDefault();
        const form = event.target;
        const formData = new FormData(form);
        const registerError = document.getElementById('registerError');
        const registerData = {
            username: formData.get('username'),
            password: formData.get('password'),
            email: formData.get('email')
        };
        const confirmPassword = formData.get('confirmPassword');
        if (registerData.password !== confirmPassword) {
            registerError.textContent = "密码不一致！";
            return;
        }
        try {
            const response = await fetch('http://localhost:8080/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(registerData)
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            const data = await response.json();
            if (data.message) {
                alert(data.message)
            }
            if (data.error != null) {
                registerError.textContent = data.error;
                return
            }
            form.reset();
            window.location.replace('success');
        } catch (error) {
            console.error('Error during registration:', error);
            alert('An error occurred during registration. Please try again later.');
        }
    });
});
