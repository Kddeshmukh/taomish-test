    // Get all the form elements we need to work with
        const loginForm = document.getElementById('loginForm');
        const emailInput = document.getElementById('email');
        const passwordInput = document.getElementById('password');
        const emailError = document.getElementById('emailError');
        const passwordError = document.getElementById('passwordError');
        const togglePassword = document.getElementById('togglePassword');
        const systemAdminBtn = document.getElementById('systemAdminBtn');
        const businessUserBtn = document.getElementById('businessUserBtn');

        // Handle the user type selection buttons
        // When clicked, these buttons toggle between System Admin and Business User
        systemAdminBtn.addEventListener('click', function() {
            systemAdminBtn.classList.add('active');
            businessUserBtn.classList.remove('active');
        });

        businessUserBtn.addEventListener('click', function() {
            businessUserBtn.classList.add('active');
            systemAdminBtn.classList.remove('active');
        });

        // Toggle password visibility when the eye icon is clicked
        // This switches between showing the password as text and hiding it
        togglePassword.addEventListener('click', function() {
            const type = passwordInput.type === 'password' ? 'text' : 'password';
            passwordInput.type = type;
            togglePassword.textContent = type === 'password' ? '👁️‍🗨️' : '👁️';
        });

        // Remove error styling when user starts typing in email field
        // This provides immediate feedback that they're correcting the issue
        emailInput.addEventListener('input', function() {
            if (emailInput.value.trim() !== '') {
                emailInput.classList.remove('error');
                emailError.classList.remove('show');
            }
        });

        // Remove error styling when user starts typing in password field
        passwordInput.addEventListener('input', function() {
            if (passwordInput.value.trim() !== '') {
                passwordInput.classList.remove('error');
                passwordError.classList.remove('show');
            }
        });

        // Main form validation function
        // This is the heart of our validation logic
        function validateForm() {
            let isValid = true;

            // Get the trimmed values to check if they're truly empty
            // trim() removes whitespace from both ends of the string
            const emailValue = emailInput.value.trim();
            const passwordValue = passwordInput.value.trim();

            // Check if email is empty
            // If it is, mark the field as invalid and show the error message
            if (emailValue === '') {
                emailInput.classList.add('error');
                emailError.classList.add('show');
                isValid = false;
            } else {
                // If email has a value, remove any error styling
                emailInput.classList.remove('error');
                emailError.classList.remove('show');
            }

            // Check if password is empty
            // Same logic as email - show error if empty, hide if filled
            if (passwordValue === '') {
                passwordInput.classList.add('error');
                passwordError.classList.add('show');
                isValid = false;
            } else {
                passwordInput.classList.remove('error');
                passwordError.classList.remove('show');
            }

            // Return whether the form is valid or not
            // If both fields have values, isValid will be true
            return isValid;
        }

        // Handle form submission
        // This event fires when the user clicks the Login button
        loginForm.addEventListener('submit', function(event) {
            // Prevent the form from actually submitting to a server
            // This allows us to handle validation first
            event.preventDefault();

            // Run our validation function
            if (validateForm()) {
                // If validation passes, we can proceed with login
                // In a real application, this is where you'd send data to your server
                
                // Get the selected user type
                const userType = systemAdminBtn.classList.contains('active') 
                    ? 'System Admin' 
                    : 'Business User';

                // Show a success message with the login details
                alert(`Login successful!\n\nUser Type: ${userType}\nEmail: ${emailInput.value}\n\nIn a real application, this would authenticate with your server.`);
                
                // Optional: Clear the form after successful validation
                // loginForm.reset();
            } else {
                // If validation fails, the error messages are already shown
                // We could also add a general error message here if needed
                console.log('Validation failed - please check the form fields');
            }
        });

        // Handle the "Forgot password?" link click
        document.querySelector('.forgot-password').addEventListener('click', function(e) {
            e.preventDefault();
            alert('Password recovery functionality would be implemented here.');
        });

        // Handle the "Sign Up" link click
        document.getElementById('signupLink').addEventListener('click', function(e) {
            e.preventDefault();
            alert('Sign up page would be shown here.');
        });

        // Handle the "Login as Guest Account" link click
        document.getElementById('guestLink').addEventListener('click', function(e) {
            e.preventDefault();
            alert('Guest login functionality would be implemented here.');
        });