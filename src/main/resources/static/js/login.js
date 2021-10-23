$(function () {
    $("#login").submit(function (e) {
        e.preventDefault();

        Swal.showLoading();

        $("#SubmitBtn").prop("disabled", true);

        $.ajax({
            url: '/Login',
            data: {
                    Email: $("#Email").val(),
                Password: $("#Password").val(),
                __RequestVerificationToken: $('[name="__RequestVerificationToken"]').val()
            },
            type: "post"
        })
            // Se ejecuta si todo fue bien.
            .done(function (result) {
                if (result != null) {
                    Swal.close();
                    // Habilitamos el botón de Submit
                    $("#SubmitBtn").prop("disabled", false);

                    window.location.href = "/";
                }
            })

            .fail(function (xhr, status, error) {
                $("#Password").val("");
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Usuario o contraseña erronea!'
                })
                $("#SubmitBtn").prop("disabled", false);
            });
    });
});