function sendEmail() {
    var name = document.getElementById('username').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    var message = document.getElementById('message').value;

    Email.send({
        SecureToken: "4b017d86-1655-4cfd-b8bb-485a73a649d4",
        To: 'kaithojusagar@gmail.com',
        From: email,
        Subject: "New Contact Form Submission",
        Body: "Name: " + name + "<br>Email: " + email + "<br>Phone: " + phone + "<br>Message: " + message
    }).then(
        function (message) {
            
            Email.send({
                SecureToken: "4b017d86-1655-4cfd-b8bb-485a73a649d4",
                To: email,
                From: email,
                Subject: "Thank You for Contacting Us",
                Body: "Dear " + name + ",<br><br>Thank you for contacting us! We have received your message and will get back to you as soon as possible.<br><br>Best regards,<br>Microden"
            }).then(
                function (message) {
                   swal("Thank You for Contacting Us","success", "success");
                },
                function (error) {
                    console.error(error);
                   swal("Error","Failed to send email. Please try again later.", "error");
                }
            );

            swal("Thank You for Contacting Us","success", "success");
        },
        function (error) {
            console.error(error);
           swal("Error","Failed to send email. Please try again later.", "error");
        }
    );
}
