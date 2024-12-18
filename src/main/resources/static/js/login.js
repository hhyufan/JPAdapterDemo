
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('loginForm').addEventListener('submit', async (event) => {
        event.preventDefault();
        const form = event.target;
        const formData = new FormData(form);
        const loginError = document.getElementById('loginError');
        const loginData = {
            username: formData.get('username'),
            password: formData.get('password'),
            email: formData.get('email')
        };
        try {
            const response = await fetch('http://localhost:8080/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json' // 设置为 JSON
                },
                body: JSON.stringify(loginData)
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            const data = await response.json();
            alert(data.message)
            if (data.error != null) {
                loginError.textContent = data.error;
                return
            }
            console.log('Login response:', data);
            window.location.replace('success');

        } catch (error) {
            console.error('Error during login:', error);
            alert('An error occurred during login. Please try again later.');
        }
    });
});
